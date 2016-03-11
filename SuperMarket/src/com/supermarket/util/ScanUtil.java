/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.util;

import com.supermarket.entity.Bill;
import com.supermarket.entity.Item;
import com.supermarket.util.log.LogUtil;
import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;


/**
 *
 * @author zhuleqi
 */
public class ScanUtil {
    
    
     public static List<Item> scan(String info) {
        JSONArray array = JSONArray.fromObject(info);

        List<Item> items = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            String id = array.getString(i);
            items.add(ScanUtil.scanItem(id));
        }

        items = ItemUtil.mergeItems(items);
        items = PreferentialUtil.preferential(items);

        return items;
    }
     
    private static Item scanItem(String productId){
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
