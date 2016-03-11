/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.entity;

import com.supermarket.preferential.Preferential;

/**
 *
 * @author zhuleqi
 */
public class ProductPreferential extends Entity{
    private Product product;
    private Preferential preferntial;

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the preferntial
     */
    public Preferential getPreferntial() {
        return preferntial;
    }

    /**
     * @param preferntial the preferntial to set
     */
    public void setPreferntial(Preferential preferntial) {
        this.preferntial = preferntial;
    }
}
