/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.util;

import com.supermarket.entity.Item;
import com.supermarket.util.data.DataUtil;
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

    public ScanUtilTest() {
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
     * Test of scan method, of class ScanUtil.
     */
    @Test
    public void testScan() {

        Item result = ScanUtil.scan("ITEM000001");
        assertEquals("ITEM000001", result.getProduct().getId());
        assertEquals(1, result.getNumber().intValue());

    }

    @Test
    public void testScanNumber() {

        Item result = ScanUtil.scan("ITEM000001-2");
        assertEquals("ITEM000001", result.getProduct().getId());
        assertEquals(2, result.getNumber().intValue());

    }

    @Test
    public void testScanBG() {

        Item result = ScanUtil.scan("ITEM000005-3");
        assertEquals("ITEM000005", result.getProduct().getId());
        assertEquals(3, result.getNumber().intValue());
        assertEquals(3, result.getFree().intValue());
    }

    @Test
    public void testScanDiscount() {

        Item result = ScanUtil.scan("ITEM000003-2");
        assertEquals("ITEM000003", result.getProduct().getId());
        assertEquals(2, result.getNumber().intValue());
        assertEquals(Double.valueOf(0.55), result.getFree());
    }

}
