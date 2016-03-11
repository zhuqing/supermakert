/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.util.data;

import com.supermarket.data.PreferentialData;
import com.supermarket.data.ProductData;
import com.supermarket.data.ProductPreferentialData;

/**
 *
 * @author zhuleqi
 */
public class DataUtil {
    public static void initAllData(){
        PreferentialData.getInstance().initData();
        ProductData.getInstance().initData();
        ProductPreferentialData.getInstance().initData();
    }
}
