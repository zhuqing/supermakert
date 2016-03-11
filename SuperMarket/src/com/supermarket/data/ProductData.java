/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.data;

import com.supermarket.entity.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhuleqi
 */
public class ProductData<T extends Product> extends DataFactory<T>{
  
    
    private static ProductData productData;
    
    public static ProductData getInstance(){
        if(productData==null){
            synchronized(ProductData.class){
                productData = new ProductData();
            }
        }
        
        return productData;
    }
    
    private ProductData(){
        
    }
    
    @Override 
    public void initData() {
      
        this.getDatas().add(this.createProduct("ITEM000001", "羽毛球", 1.0, "个"));
        this.getDatas().add(this.createProduct("ITEM000003", "苹果", 5.5, "斤"));
        this.getDatas().add(this.createProduct("ITEM000005", "可口可乐", 3.0, "瓶"));
    }

    @Override
    public T getData(String id) {
        for(T t : this.getDatas()){
            if(t.getId().equals(id)){
                return t;
            }
        }
        
        return null;
    }
    
    
    private T createProduct(String id , String name , double price , String unit){
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setUnit(unit);
        return (T) product;
    }
}
