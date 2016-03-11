/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.data;

import com.supermarket.preferential.BuyGive;
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
public class PreferentialDataTest {
    
    private PreferentialData preferentialData;
    
    public PreferentialDataTest() {
        this.preferentialData = PreferentialData.getInstance();
        this.preferentialData.initData();
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
     * Test of getInstance method, of class PreferentialData.
     */
    @Test
    public void testGetDataNull() {
        BuyGive buy = (BuyGive) this.preferentialData.getData("pre000010001");
        Assert.assertNull(buy);
        
    }

    /**
     * Test of initData method, of class PreferentialData.
     */
    @Test
    public void testGetData() {
        BuyGive buy = (BuyGive) this.preferentialData.getData("pre00001");
        Assert.assertEquals(buy.getId(), "pre00001");
        Assert.assertEquals(buy.getBuyNumber().intValue(), 2);
        Assert.assertEquals(buy.getGiveNumber().intValue(), 1);
    }
    
}
