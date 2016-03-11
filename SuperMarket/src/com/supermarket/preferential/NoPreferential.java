/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.preferential;

import com.supermarket.entity.Item;

/**
 *
 * @author zhuleqi
 */
public class NoPreferential extends Preferential{

    @Override
    public void countPreferential(Item item) {
        item.setFree(0.0);
        item.setPayFor(item.getTotal());
    }
    
}
