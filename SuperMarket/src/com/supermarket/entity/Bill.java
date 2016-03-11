/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.entity;

import com.supermarket.util.ItemUtil;
import com.supermarket.util.log.LogUtil;
import java.util.List;

/**
 *
 * @author zhuleqi
 */
public class Bill extends Entity{
    private List<Item> items;
    private Double totle;
    private Double free;
    
   
   

    /**
     * @return the items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * @return the totle
     */
    public Double getTotle() {
        return totle;
    }

    /**
     * @param totle the totle to set
     */
    public void setTotle(Double totle) {
        this.totle = totle;
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
    
}
