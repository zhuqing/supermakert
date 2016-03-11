/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.preferential;

import com.supermarket.preferential.Preferential;
import com.supermarket.preferential.BuyGive;
import com.supermarket.entity.Item;
import com.supermarket.entity.Product;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zhuleqi
 */
public class BuyGiveTest {

    Product product;
    Preferential preferentail;

    public BuyGiveTest() {
        product = new Product();
        product.setPrice(1.0);
        product.setUnit("个");

        this.preferentail = new BuyGive("0002",2, 1);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of countPreferential method, of class BuyGive.
     */
    @Test
    public void testCountPreferential() {
        Item item = new Item();
        item.setProduct(this.product);
        item.setNumber(7);
        item.setTotal(item.getNumber() * this.product.getPrice());
        this.preferentail.countPreferential(item);
        Assert.assertEquals(item.getPayFor(), 5.0);
        Assert.assertEquals(item.getFree(), 2.0);
        Assert.assertEquals(item.getTotal(), 7.0);
    }

}
