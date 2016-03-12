/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.data.relationship;

import com.supermarket.entity.ProductPreferential;

/**
 * 只有折扣
 * @author zhuleqi
 */
public class DiscountProductPreferentialData<T extends ProductPreferential> extends ProductPreferentialData<T> {

    private static DiscountProductPreferentialData productPreferentialData;

    public static DiscountProductPreferentialData getInstance() {
        if (productPreferentialData == null) {
            synchronized (DiscountProductPreferentialData.class) {
                productPreferentialData = new DiscountProductPreferentialData();
            }
        }

        return productPreferentialData;
    }

    private DiscountProductPreferentialData() {

    }

    @Override
    public void initData() {
         this.getDatas().clear();
        this.getDatas().add(createData("pp0003", "ITEM000003", "pre00002"));
    }

   
}
