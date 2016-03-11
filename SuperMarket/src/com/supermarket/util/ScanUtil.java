/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.util;

import com.supermarket.entity.Bill;
import com.supermarket.entity.Item;
import com.supermarket.util.log.LogUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 *
 * @author zhuleqi
 */
public class ScanUtil {
    
    public static Item scan(String productId){
        if(!productId.contains("-")){
            return ItemUtil.create(productId, 1);
        }else{
            String[] productIdArr= productId.split("-");
            if(productIdArr.length==2){
                Integer number = Integer.valueOf(productIdArr[1]);
                return ItemUtil.create(productIdArr[0], number);
            }
        }
        LogUtil.logErr(productId+" has problem!!");
        return null;
    }

}
