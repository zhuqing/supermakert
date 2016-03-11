/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.preferential;

import com.supermarket.entity.Item;
import com.supermarket.entity.Product;

/**
 *买赠
 * @author zhuleqi
 */
public class BuyGive extends Preferential{

    /**
     * 购买的数量
     */
    private Integer buyNumber;
    /**
     * 赠送的数量
     */
    private Integer giveNumber;
   
    public BuyGive(String id , Integer buyNumber , Integer giveNumber){
        this.setId(id);
        this.buyNumber = buyNumber;
        this.giveNumber = giveNumber;
        
    }
    
    
    @Override
    public void countPreferential(Item item) {
        Integer times = item.getNumber()/(this.getBuyNumber()+this.getGiveNumber());
        Integer more = item.getNumber()%(this.getBuyNumber()+this.getGiveNumber());
        
        double payFor = (getBuyNumber()*times+more)*item.getProduct().getPrice();
        item.setPayFor(payFor);
        item.setFree(item.getTotal()-item.getPayFor());
    }

    /**
     * @return the buyNumber
     */
    public Integer getBuyNumber() {
        return buyNumber;
    }

    /**
     * @param buyNumber the buyNumber to set
     */
    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }

    /**
     * @return the giveNumber
     */
    public Integer getGiveNumber() {
        return giveNumber;
    }

    /**
     * @param giveNumber the giveNumber to set
     */
    public void setGiveNumber(Integer giveNumber) {
        this.giveNumber = giveNumber;
    }
    
}
