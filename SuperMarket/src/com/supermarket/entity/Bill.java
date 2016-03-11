/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.entity;

import java.util.List;

/**
 * 结账小票
 *
 * @author zhuleqi
 */
public class Bill extends Entity {

    /**
     * 计费项目
     */
    private List<Item> items;
    /**
     * 花费总金额
     */
    private Double totle;
    /**
     * 节省费用
     */
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
