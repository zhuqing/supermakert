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
public class ScanUtilTest {

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

    public ScanUtilTest() {
        DataUtil.initData();
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
     * Test of scan method, of class ScanUtil.
     */
    @Test
    public void testScan() {

        List<Item> items = ScanUtil.scan(data);
        assertEquals(3, items.size());
        for (Item item : items) {
            switch (item.getId()) {
                case "ITEM000001":
                    assertEquals("ITEM000001", item.getProduct().getId());
                    assertEquals(5, item.getNumber().intValue());
                    break;
                case "ITEM000003":
                    assertEquals("ITEM000003", item.getProduct().getId());
                    assertEquals(2, item.getNumber().intValue());
                    break;
                case "ITEM000005":
                    assertEquals("ITEM000005", item.getProduct().getId());
                    assertEquals(3, item.getNumber().intValue());
                    break;

            }
        }

    }

}
