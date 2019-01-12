package com.app.bignumber.service.impl;

import com.app.bignumber.exception.InvalidRangeException;
import com.app.bignumber.service.BigNumberService;
import com.app.bignumber.util.BigNumberConverterUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.hamcrest.MockitoHamcrest.intThat;

@SpringBootTest(classes = {TestConfiguration.class})
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class BigNumberServiceImplTest {

    @Value("${api.input-number.min-range}")
    private Long min_range;
    @Value("${api.input-number.max-range}")
    private Long max_range;

    @MockBean
    private BigNumberConverterUtil bigNumberConverterUtil;
    private BigNumberService bigNumberService;


    @Before
    public void setUp()  {
        bigNumberService =
                new BigNumberServiceImpl(bigNumberConverterUtil, min_range, max_range);
    }

    @Test
    public void getNextBigNumber() {
        when(bigNumberService.getNextBigNumber("1234")).thenReturn(1243L);
        final long nextBigNumber = bigNumberService.getNextBigNumber("1234");
        assertEquals(nextBigNumber, 1243);

    }

    @Test
    public void isValidNumberRange() {
        assertTrue( bigNumberService.isValidNumberRange(1L));
    }

    @Test(expected = InvalidRangeException.class)
    public void isValidNumberRangeException() {
        bigNumberService.isValidNumberRange(-1L);
    }

    @Test
    public void filterInputRequest() {
        when(bigNumberConverterUtil.findPivot("111")).thenReturn(-1);
        assertTrue(bigNumberService.filterInputRequest("111"));
        when(bigNumberConverterUtil.findPivot("123")).thenReturn(intThat(greaterThan(0)));
        assertFalse( bigNumberService.filterInputRequest("123"));
    }
}