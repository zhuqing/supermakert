/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.data;

import com.supermarket.entity.Product;
import com.supermarket.entity.ProductPreferential;
import com.supermarket.preferential.Discount;
import com.supermarket.preferential.Preferential;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhuleqi
 */
public class ProductPreferentialData<T extends ProductPreferential> extends DataFactory<T> {

    private static ProductPreferentialData productPreferentialData;

    public static ProductPreferentialData getInstance() {
        if (productPreferentialData == null) {
            synchronized (ProductPreferentialData.class) {
                productPreferentialData = new ProductPreferentialData();
            }
        }

        return productPreferentialData;
    }

    private ProductPreferentialData() {

    }

    @Override
    public void initData() {
        this.getDatas().add(this.createData("pp0001", "ITEM000005", "pre00001"));
        this.getDatas().add(this.createData("pp0002", "ITEM000003", "pre00002"));
        this.getDatas().add(this.createData("pp0003", "ITEM000001", "pre00003"));
    }

    private T createData(String id, String productId, String preferentialId) {
        Product product = ProductData.getInstance().getData(productId);
        Preferential preferential = (Preferential) PreferentialData.getInstance().getData(preferentialId);
        ProductPreferential p = new ProductPreferential();
        p.setId(id);
        p.setProduct(product);
        p.setPreferntial(preferential);
        return (T) p;
    }

    public T getT(Product product) {
        T target = null;
        for (T t : this.getDatas()) {
            if (t.getProduct().equals(product)) {
                if (t.getPreferntial() instanceof Discount) {
                    return t;
                }
                target = t;
            }

        }

        return target;
    }

}
