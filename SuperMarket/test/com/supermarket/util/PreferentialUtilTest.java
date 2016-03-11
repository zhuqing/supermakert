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
public class PreferentialUtilTest {
      static String data = "["
            + "    'ITEM000001',"
            + "    'ITEM000001',"
            + "    'ITEM000001',"
            + "    'ITEM000001',"
            + "    'ITEM000001',"
            + "    'ITEM000003-2',"
            + "    'ITEM000005',"
            + "    'ITEM000005',"
            + "    'ITEM000005'"
            + "]";

    public PreferentialUtilTest() {
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
     * Test of preferential method, of class PreferentialUtil.
     */
    @Test
    public void testPreferential() {
        System.out.println("preferential");
        List<Item> items = ScanUtil.scan(data);
       
        List<Item> result = PreferentialUtil.preferential(items);
        for (Item item : result) {
            switch (item.getId()) {
                case "ITEM000001":
                    assertEquals("ITEM000001", item.getProduct().getId());
                    assertEquals(Double.valueOf(1.0), item.getFree());
                    break;
                case "ITEM000003":
                    assertEquals("ITEM000003", item.getProduct().getId());
                    assertEquals(Double.valueOf(0.55), item.getFree());
                    break;
                case "ITEM000005":
                    assertEquals("ITEM000005", item.getProduct().getId());
                    assertEquals(Double.valueOf(3.0), item.getFree());
                    break;

            }
        }
    }
    
}
