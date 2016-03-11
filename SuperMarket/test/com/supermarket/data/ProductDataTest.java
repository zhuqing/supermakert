/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.data;

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
public class ProductDataTest {
    private ProductData<Product> productData;
    
    public ProductDataTest() {
        this.productData = ProductData.getInstance();
        productData.initData();
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
     * Test of initData method, of class ProductData.
     */
    @Test
    public void testInitData() {
       
    }

    /**
     * Test of getData method, of class ProductData.
     */
    @Test
    public void testGetData() {
       Product t = this.productData.getData("ITEM000001");
       Assert.assertEquals(t.getId(), "ITEM000001");
       Assert.assertEquals(t.getName(), "羽毛球");
    }
    
}
