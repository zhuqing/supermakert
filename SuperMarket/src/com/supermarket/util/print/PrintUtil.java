/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.util.print;

import com.supermarket.entity.Bill;
import com.supermarket.entity.Item;
import com.supermarket.preferential.BuyGive;
import com.supermarket.preferential.Discount;
import com.supermarket.preferential.NoPreferential;
import com.supermarket.preferential.Preferential;
import com.supermarket.util.PreferentialUtil;
import com.supermarket.util.log.LogUtil;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author zhuleqi
 */
public class PrintUtil {

    public static String print(Item item) {
        StringBuffer itemStr = new StringBuffer();
        itemStr.append("名称:" + item.getProduct().getName());
        itemStr.append(", 数量:" + item.getNumber() + item.getProduct().getUnit());
        itemStr.append(", 单价:" + item.getProduct().getPrice() + "(元)");
        itemStr.append(", 小记:" + item.getPayFor() + "(元)");
        if (item.getPerferential() instanceof Discount) {
            itemStr.append(", 节省:" + item.getFree() + "(元)");
        }
        return itemStr.toString();
    }

    public static String printBuyGive(Item item) {
        StringBuffer itemStr = new StringBuffer();
        itemStr.append("名称:" + item.getProduct().getName());
        itemStr.append(", 数量:" + PreferentialUtil.getFreeNumber(item) + item.getProduct().getUnit());
        return itemStr.toString();
    }

    public static void print(Bill bill) {
        LogUtil.logInfo("***<没钱赚商店>购物清单***");
        for (Item item : bill.getItems()) {
            LogUtil.logInfo(PrintUtil.print(item));
        }

        Map<Preferential, List<Item>> itemsMap = groupByPreferential(bill.getItems());

        for (Preferential p : itemsMap.keySet()) {
            if (!(p instanceof BuyGive)) {
                continue;
            }
            
            LogUtil.logInfo("----------------------");
            LogUtil.logInfo(p.getName() + "商品");
            for (Item item : itemsMap.get(p)) {
                LogUtil.logInfo(PrintUtil.printBuyGive(item));
            }
        }

        LogUtil.logInfo("----------------------");
        LogUtil.logInfo("总计:" + bill.getTotle()+"(元)");
        if (bill.getFree() > 0) {
            LogUtil.logInfo("节省:" + bill.getFree()+"(元)");
        }
        
         LogUtil.logInfo("*********************");

    }

    private static Map<Preferential, List<Item>> groupByPreferential(List<Item> items) {
        return items.stream().collect(Collectors.groupingBy(new Function<Item, Preferential>() {
            @Override
            public Preferential apply(Item t) {
                return t.getPerferential();
            }
        }));
    }

}
