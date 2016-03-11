/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.preferential;

import com.supermarket.entity.Item;
import java.text.DecimalFormat;

/**
 * 折扣
 *
 * @author zhuleqi
 */
public class Discount extends Preferential {

    /**
     * 折扣
     */
    private Double discount = 1.0;
    DecimalFormat df = new DecimalFormat("#.00");

    public Discount(String id, Double discount) {
        this.setId(id);
        this.discount = discount;
    }

    @Override
    public void countPreferential(Item item) {
        double payFor = item.getTotal() * this.discount;
        item.setPayFor(convertData(payFor));

        double free = convertData(item.getTotal() - payFor);
        item.setFree(free);
    }

    private Double convertData(Double d) {
        return Double.valueOf(df.format(d));
    }

}
