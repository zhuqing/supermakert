/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.util;

import com.supermarket.data.ProductData;
import com.supermarket.data.ProductPreferentialData;
import com.supermarket.entity.Item;
import com.supermarket.entity.Product;
import com.supermarket.entity.ProductPreferential;
import com.supermarket.preferential.Discount;
import com.supermarket.preferential.NoPreferential;
import com.supermarket.preferential.Preferential;
import com.supermarket.util.log.LogUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhuleqi
 */
public class ItemUtil {

    public static String toString(Item item) {
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

    public static String toSimpleString(Item item) {
        StringBuffer itemStr = new StringBuffer();
        itemStr.append("名称:" + item.getProduct().getName());
        itemStr.append(", 数量:" + item.getNumber() + item.getProduct().getUnit());
        return itemStr.toString();
    }

    public static Item create(String productId, Integer number) {
        Product product = ProductData.getInstance().getData(productId);
        if (product == null) {
            LogUtil.logErr("can't find product by productId=" + productId);
            return null;
        }

        Item item = new Item();
        item.setNumber(number);
        item.setProduct(product);
        item.setTotal(product.getPrice() * number);

        return item;
    }

    public static List<Item> getherItems(List<Item> items) {
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

    public static void preferential(List<Item> items) {
        for (Item item : items) {
            ProductPreferential p = ProductPreferentialData.getInstance().getT(item.getProduct());
            Preferential preferential = null;
            if (p != null) {
                preferential = p.getPreferntial();
            } else {
                preferential = new NoPreferential();

            }
            preferential.countPreferential(item);
            item.setPerferential(preferential);
        }
    }

}
