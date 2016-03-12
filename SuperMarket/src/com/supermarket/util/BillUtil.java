/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.util;

import com.supermarket.entity.Bill;
import com.supermarket.entity.Item;
import java.util.List;

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
