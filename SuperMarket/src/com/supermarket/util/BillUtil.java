/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.util;

import com.supermarket.entity.Bill;
import com.supermarket.entity.Item;
import com.supermarket.preferential.NoPreferential;
import com.supermarket.preferential.Preferential;
import com.supermarket.util.log.LogUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import net.sf.json.JSONArray;

/**
 *
 * @author zhuleqi
 */
public class BillUtil {

    public static Bill create(String info) {
        JSONArray array = JSONArray.fromObject(info);

        List<Item> items = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            String id = array.getString(i);
            items.add(ScanUtil.scan(id));
        }

        items = ItemUtil.getherItems(items);
        ItemUtil.preferential(items);

        return createBill(items);
    }

    public static void printBill(Bill bill) {
        LogUtil.logInfo("***<没钱赚商店>购物清单***");
        for (Item item : bill.getItems()) {
            LogUtil.logInfo(ItemUtil.toString(item));
        }

        Map<Preferential, List<Item>> itemsMap = groupByPreferential(bill.getItems());

        for (Preferential p : itemsMap.keySet()) {
            if (p instanceof NoPreferential) {
                continue;
            }
            LogUtil.logInfo("----------------------");
            LogUtil.logInfo(p.getName() + "商品");
            for (Item item : itemsMap.get(p)) {
                LogUtil.logInfo(ItemUtil.toSimpleString(item));
            }
        }

        LogUtil.logInfo("----------------------");
        LogUtil.logInfo("总计:" + bill.getTotle());
        if (bill.getFree() > 0) {
            LogUtil.logInfo("小记:" + bill.getFree());
        }

    }

    private static Map<Preferential, List<Item>> groupByPreferential(List<Item> items) {
        return items.stream().collect(Collectors.groupingBy(new Function<Item, Preferential>() {
            @Override
            public Preferential apply(Item t) {
                return t.getPerferential();
            }
        }));
    }

    private static Bill createBill(List<Item> items) {
        Bill bill = new Bill();
        bill.setItems(items);

        Double totalPayFor = 0.0;
        Double totalFree = 0.0;
        for (Item item : items) {
            totalPayFor += item.getPayFor();
            totalFree += item.getFree();
        }

        bill.setTotle(totalPayFor);
        bill.setFree(totalFree);

        return bill;

    }

}
