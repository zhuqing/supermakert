/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.preferential;

import com.supermarket.entity.Item;

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
       
        double free = this.getFreeNumber(item)*item.getProduct().getPrice();
        double payFor = item.getTotal()-free;
        item.setPayFor(payFor);
        item.setFree(free);
    }
    
    /**
     * 获取免费的数量
     * @param item
     * @return 
     */
    public Integer getFreeNumber(Item item){
        Integer times = item.getNumber()/(this.getBuyNumber()+this.getGiveNumber());
        return times*this.getGiveNumber();
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
