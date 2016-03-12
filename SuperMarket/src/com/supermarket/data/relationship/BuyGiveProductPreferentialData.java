/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.data.relationship;

import com.supermarket.entity.ProductPreferential;

/**
 * 只有买二赠一
 * @author zhuleqi
 */
public class BuyGiveProductPreferentialData<T extends ProductPreferential> extends ProductPreferentialData<T> {

    private static BuyGiveProductPreferentialData productPreferentialData;

    public static BuyGiveProductPreferentialData getInstance() {
        if (productPreferentialData == null) {
            synchronized (BuyGiveProductPreferentialData.class) {
                productPreferentialData = new BuyGiveProductPreferentialData();
            }
        }

        return productPreferentialData;
    }

    private BuyGiveProductPreferentialData() {

    }

    @Override
    public void initData() {
         this.getDatas().clear();
        this.getDatas().add(createData("pp0001", "ITEM000005", "pre00001"));
        this.getDatas().add(createData("pp0003", "ITEM000001", "pre00001"));
    }

   
}
