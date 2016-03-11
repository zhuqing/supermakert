/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.entity;

import com.supermarket.preferential.Discount;
import com.supermarket.preferential.Preferential;
import java.util.Objects;

/**
 *
 * @author zhuleqi
 */
public class Item extends Entity{
    private Product product;
    private Integer number;
    private Double total;
    private Double payFor;
    private Double free = 0.0;

    private Preferential perferential;
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
     * @return the number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * @return the total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * @return the payFor
     */
    public Double getPayFor() {
        return payFor;
    }

    /**
     * @param payFor the payFor to set
     */
    public void setPayFor(Double payFor) {
        this.payFor = payFor;
    }

    /**
     * @return the free
     */
    public Double getFree() {
       
        return free;
    }

    /**
     * @param free the free to set
     */
    public void setFree(Double free) {
        this.free = free;
    }

    /**
     * @return the perferential
     */
    public Preferential getPerferential() {
        return perferential;
    }

    /**
     * @param perferential the perferential to set
     */
    public void setPerferential(Preferential perferential) {
        this.perferential = perferential;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        return true;
    }

  
}
