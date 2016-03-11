/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.preferential;

import com.supermarket.entity.Entity;
import com.supermarket.entity.Item;
import com.supermarket.entity.Product;

/**
 *
 * @author zhuleqi
 */
public abstract class Preferential extends Entity{
    private String name;
    /**
     *计算优惠
     * @param item 
     */
    public abstract void countPreferential(Item item);

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
