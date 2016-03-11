/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.data;

import com.supermarket.entity.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhuleqi
 */
public abstract class DataFactory<T extends Entity> {

    private List<T> datas;

    protected List<T> getDatas() {
        if (datas == null) {
            this.datas = new ArrayList<>();
        }
        return this.datas;
    }

    public abstract void initData();

    public T getData(String id) {
        for (T t : this.getDatas()) {
            if (t.getId().equals(id)) {
                return t;
            }
        }

        return null;
    }
}
