/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.util;

import com.supermarket.entity.Item;
import com.supermarket.util.log.LogUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhuleqi
 */
public class ScanUtil {

    /**
     * 扫描输入信息
     *
     * @param info
     * @return
     */
    public static List<Item> scan(String info) {

        List<Item> items = new ArrayList<>();
        List<String> productIds = analyze(info);
        for (String productId : productIds) {
            items.add(ScanUtil.createItem(productId));
        }

        items = ItemUtil.mergeItems(items);
        items = PreferentialUtil.preferential(items);

        return items;
    }

    /**
     * 分析输入数据
     *
     * @param data
     * @return
     */
    private static List<String> analyze(String data) {
        data = data.trim();
        data = data.substring(1, data.length() - 1);
        String[] strArr = data.split(",");
        List<String> items = new ArrayList<>();
        for (String item : strArr) {
            item = item.trim();

            items.add(item.substring(1, item.length() - 1));
        }

        return items;
    }

    /**
     * 生产Item
     *
     * @param productId
     * @return
     */
    private static Item createItem(String productId) {
        if (!productId.contains("-")) {
            return ItemUtil.create(productId, 1);
        } else {
            String[] productIdArr = productId.split("-");
            if (productIdArr.length == 2) {
                Integer number = Integer.valueOf(productIdArr[1]);
                return ItemUtil.create(productIdArr[0], number);
            }
        }
        LogUtil.logErr(productId + " has problem!!");
        return null;
    }

}
