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
import com.supermarket.util.print.PrintUtil;
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

    /**
     * 创建小票
     * @param info
     * @return 
     */
    public static Bill create(String info) {
        List<Item> items = ScanUtil.scan(info);
        return create(items);
    }

    private static Bill create(List<Item> items) {
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
