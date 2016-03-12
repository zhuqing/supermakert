/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.data.relationship;

import com.supermarket.entity.ProductPreferential;

/**
 * 只有折扣
 *
 * @author zhuleqi
 */
public class DBProductPreferentialData<T extends ProductPreferential> extends ProductPreferentialData<T> {

    private static DBProductPreferentialData productPreferentialData;

    public static DBProductPreferentialData getInstance() {
        if (productPreferentialData == null) {
            synchronized (DBProductPreferentialData.class) {
                productPreferentialData = new DBProductPreferentialData();
            }
        }

        return productPreferentialData;
    }

    private DBProductPreferentialData() {

    }

    @Override
    public void initData() {
         this.getDatas().clear();
        this.getDatas().add(createData("pp0001", "ITEM000005", "pre00001"));
        this.getDatas().add(createData("pp0002", "ITEM000001", "pre00001"));
        this.getDatas().add(createData("pp0003", "ITEM000003", "pre00002"));
    }

}
