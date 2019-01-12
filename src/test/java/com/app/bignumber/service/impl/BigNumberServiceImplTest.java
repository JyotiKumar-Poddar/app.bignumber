package com.app.bignumber.service.impl;

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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

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
    public void setUp() throws Exception {
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
        when(bigNumberService.isValidNumberRange(0l)).thenReturn(true);
        assertEquals(true, bigNumberService.isValidNumberRange(0l));
        when(bigNumberService.isValidNumberRange(-1001l)).thenReturn(false);
        assertEquals(false, bigNumberService.isValidNumberRange(0l));
    }

    @Test
    public void filterInputRequest() {
        when(bigNumberService.filterInputRequest("111")).thenReturn(false);
        assertEquals(false, bigNumberService.filterInputRequest("111"));
        when(bigNumberService.filterInputRequest("1234")).thenReturn(true);
        assertEquals(true, bigNumberService.filterInputRequest("1234"));
    }
}