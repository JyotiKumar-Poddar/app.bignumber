package com.app.bignumber.service.impl;

import com.app.bignumber.exception.InvalidRangeException;
import com.app.bignumber.service.BigNumberService;
import com.app.bignumber.util.BigNumberConverterUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Service that help in filting
 */
@Service
@Slf4j
public class BigNumberServiceImpl implements BigNumberService {

    private final long min_range;
    private final long max_range;
    private final BigNumberConverterUtil bigNumberConverterUtil;

    @Autowired
    public BigNumberServiceImpl(final BigNumberConverterUtil bigNumberConverterUtil,
                                @Value("${api.input-number.min-range}") final long min_range,
                                @Value("${api.input-number.max-range}") final long max_range) {
        this.bigNumberConverterUtil = bigNumberConverterUtil;
        this.min_range = min_range;
        this.max_range = max_range;
    }

    @Override
    public Long getNextBigNumber(final String number) {
        return bigNumberConverterUtil.nextBigNumber(number);
    }


    @Override
    public boolean isValidNumberRange(final Long number) {
        // check for valid range
        if (number < min_range || number > max_range) {
            throw new InvalidRangeException("Invalid range exception");
        }
        return true;
    }

    @Override
    public boolean filterInputRequest(final String number) {
        // check for palindrome
        boolean isNextBigNumberNotPossible = false;
        final int pivot = bigNumberConverterUtil.findPivot(number);
        if (pivot == -1) {
            isNextBigNumberNotPossible = true;
        }
        return isNextBigNumberNotPossible;
    }
}
