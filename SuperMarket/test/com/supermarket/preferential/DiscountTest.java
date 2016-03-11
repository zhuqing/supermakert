/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.preferential;

import com.supermarket.preferential.Discount;
import com.supermarket.preferential.Preferential;
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
public class DiscountTest {

    Product product;
    Preferential preferentail;

    public DiscountTest() {
        product = new Product();
        product.setPrice(1.0);
        product.setUnit("KG");

        this.preferentail = new Discount("001",0.95);
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
     * Test of countPreferential method, of class Discount.
     */
    @Test
    public void testCountPreferential() {
        Item item = new Item();
        item.setProduct(this.product);
        item.setNumber(10);
        item.setTotal(item.getNumber() * this.product.getPrice());
        this.preferentail.countPreferential(item);
        Assert.assertEquals(item.getPayFor(), 9.5);
        Assert.assertEquals(item.getFree(), 0.5);
        Assert.assertEquals(item.getTotal(), 10.0);
    }

}
