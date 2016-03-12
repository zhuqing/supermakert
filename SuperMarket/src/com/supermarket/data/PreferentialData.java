/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.data;

import com.supermarket.preferential.BuyGive;
import com.supermarket.preferential.Discount;
import com.supermarket.preferential.NoPreferential;
import com.supermarket.preferential.Preferential;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhuleqi
 */
public class PreferentialData<T extends Preferential> extends DataFactory<T> {

    private static PreferentialData preferentialData;

    public static PreferentialData getInstance() {
        if (preferentialData == null) {
            synchronized (ProductData.class) {
                preferentialData = new PreferentialData();
            }
        }

        return preferentialData;
    }

    private PreferentialData() {

    }

    @Override
    public void initData() {
        this.getDatas().clear();
        this.getDatas().add(this.createBuyGive("pre00001", "买二赠一", 2, 1));
        this.getDatas().add(this.createButDiscount("pre00002", "九五折", 0.95));
        this.getDatas().add(this.createBuyGive("pre00003", "买四赠一", 4, 1));
    }

    private T createBuyGive(String id, String name, Integer buyNumber, Integer giveNumber) {
        BuyGive b = new BuyGive(id, buyNumber, giveNumber);
        b.setName(name);
        return (T) b;
    }

    private T createButDiscount(String id, String name, Double discount) {
        Discount d = new Discount(id, discount);
        d.setName(name);
        return (T) d;
    }

    @Override
    public T getData(String id) {
        T t = super.getData(id);
        if (t == null) {
            t = (T) new NoPreferential();
        }
        return t; //To change body of generated methods, choose Tools | Templates.
    }

}
