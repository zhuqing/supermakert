/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.util;

import com.supermarket.entity.Item;
import com.supermarket.util.data.DataUtil;
import java.util.List;
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
public class ItemUtilTest {
    
    public ItemUtilTest() {
          DataUtil.initAllData();
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
     * Test of create method, of class ItemUtil.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        String productId = "ITEM000005";
        Integer number = 2;
        Item result = ItemUtil.create(productId, number);
        assertEquals(productId, result.getProduct().getId());
        assertEquals(number, result.getNumber());
        // TODO review the generated test code and remove the default call to fail.
      
    }

}
