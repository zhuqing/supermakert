/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.util;

import com.supermarket.data.relationship.ProductPreferentialData;
import com.supermarket.entity.Item;
import com.supermarket.entity.ProductPreferential;
import com.supermarket.preferential.BuyGive;
import com.supermarket.preferential.NoPreferential;
import com.supermarket.preferential.Preferential;
import java.util.List;

/**
 *
 * @author zhuleqi
 */
public class PreferentialUtil {
    
    public static ProductPreferentialData currentProductPreferentialData;

    /**
     * 计算所有item的优惠
     *
     * @param items
     */
    public static List<Item> preferential(List<Item> items) {
        for (Item item : items) {
            ProductPreferential p = currentProductPreferentialData.getT(item.getProduct());
            Preferential preferential = null;
            if (p != null) {
                preferential = p.getPreferntial();
            } else {
                preferential = new NoPreferential();

            }
            preferential.countPreferential(item);
            item.setPerferential(preferential);
        }

        return items;
    }
    
     public static Integer getFreeNumber(Item item){
         if(!(item.getPerferential() instanceof BuyGive)){
             return 0;
         }
         
         BuyGive buyGive = (BuyGive) item.getPerferential();
         return buyGive.getFreeNumber(item);
    }
     
     
     public static void initProductPreferentialData(ProductPreferentialData productPreferentialData){
         if(productPreferentialData == null){
             productPreferentialData = ProductPreferentialData.getInstance();
         }
         currentProductPreferentialData = productPreferentialData;
         currentProductPreferentialData.initData();
     }
}
