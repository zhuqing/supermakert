/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.data.relationship;

import com.supermarket.data.DataFactory;
import com.supermarket.data.PreferentialData;
import com.supermarket.data.ProductData;
import com.supermarket.entity.Product;
import com.supermarket.entity.ProductPreferential;
import com.supermarket.preferential.BuyGive;
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

    protected ProductPreferentialData() {

    }

    @Override
    public void initData() {
        this.getDatas().clear();
    }

    protected T createData(String id, String productId, String preferentialId) {
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
                if (t.getPreferntial() instanceof BuyGive) {
                    return t;
                }
                target = t;
            }

        }

        return target;
    }

}
