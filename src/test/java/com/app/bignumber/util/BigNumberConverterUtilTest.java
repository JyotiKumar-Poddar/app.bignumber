package com.app.bignumber.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BigNumberConverterUtilTest {

    private  BigNumberConverterUtil bigNumberConverterUtil;

    @Before
    public void setUp() {
        bigNumberConverterUtil = new BigNumberConverterUtil();
    }

    @Test
    public void nextBigNumber() {
        // find the next big number
        long nextBingNumber = bigNumberConverterUtil.nextBigNumber("1234");
        assertEquals(1243, nextBingNumber);
        assertNotEquals(1234, nextBingNumber);
        nextBingNumber = bigNumberConverterUtil.nextBigNumber("43622");
        assertEquals(46223, nextBingNumber);
    }

    @Test
    public void findPivot() {
        int pivot = bigNumberConverterUtil.findPivot("4321");
        assertEquals(-1, pivot);
        pivot = bigNumberConverterUtil.findPivot("777");
        assertEquals(-1, pivot);
        pivot = bigNumberConverterUtil.findPivot("010");
        assertNotEquals(-1, pivot);
        pivot = bigNumberConverterUtil.findPivot("321");
        assertEquals(-1, pivot);
        pivot = bigNumberConverterUtil.findPivot("9");
        assertEquals(-1, pivot);
        pivot = bigNumberConverterUtil.findPivot("1234");
        assertNotEquals(-1, pivot);
    }
}