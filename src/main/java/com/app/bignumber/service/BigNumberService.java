package com.app.bignumber.service;

public interface BigNumberService {

    /**
     * Method to return the next big number using the digits of existing number
     *
     * @param number of type {@link String }
     * @return nextBigNumber of type  {@link Long }
     */
    Long getNextBigNumber(String number);

    /**
     * Method to valid the number is in expected range
     *
     * @param number
     * @return true else  throw  exception {@link com.app.bignumber.exception.InvalidRangeException}
     */
    boolean isValidNumberRange(Long number);

    /**
     *
     * @param number number to find the pivot {@link Integer}
     * @return  false incase
     */
    boolean filterInputRequest(String number);

}
