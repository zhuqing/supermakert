/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.util;

import com.supermarket.data.ProductData;
import com.supermarket.entity.Item;
import com.supermarket.entity.Product;
import com.supermarket.util.log.LogUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhuleqi
 */
public class ItemUtil {

    /**
     * 通过产品ID和数量,创建item
     *
     * @param productId
     * @param number
     * @return
     */
    public static Item create(String productId, Integer number) {
        Product product = ProductData.getInstance().getData(productId);
        if (product == null) {
            LogUtil.logErr("can't find product by productId=" + productId);
            return null;
        }

        Item item = new Item();
        item.setId(productId);
        item.setNumber(number);
        item.setProduct(product);
        item.setTotal(product.getPrice() * number);

        return item;
    }

    /**
     * 相同的Item,合并成一个
     *
     * @param items
     * @return
     */
    public static List<Item> mergeItems(List<Item> items) {
        List<Item> list = new ArrayList<>();
        for (Item item : items) {
            int index = list.indexOf(item);
            if (index >= 0) {
                Item sItem = list.get(index);
                sItem.setNumber(sItem.getNumber() + item.getNumber());
                sItem.setTotal(sItem.getTotal() + item.getTotal());
            } else {
                list.add(item);
            }
        }

        return list;
    }

  
   

}
