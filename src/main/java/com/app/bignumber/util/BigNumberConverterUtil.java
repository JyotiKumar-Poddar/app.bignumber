package com.app.bignumber.util;

/**
 * Util class is responsible  to get he next big number
 * using the give number and having the same digits
 * Eg: input number 1234 and the next big number is  1243
 */
public class BigNumberConverterUtil {

    public long  nextBigNumber(final String number) {
        final char[] digits = number.toCharArray();
        int m = findPivot(number);
        int n = -1;
        int numberLength = digits.length;
        int pivotDigit = digits[m];
        for (int i = numberLength - 1; i > m; i--) {
            if (digits[i] > pivotDigit) {
                n = i;
                break;
            }
        }
        swapDigits(digits, m, n);
        reverseSubArray(digits, m + 1, numberLength - 1);
        return Long.valueOf(String.valueOf(digits));
    }


    /**
     * The base condition is to  test  whether the next big number generation is possible or not
     *
     * @param number input as string {@link String}
     * @return piovt  {@link Integer}value which identifier  the sub part
     * that can be used to find the next big number.
     */
    public int findPivot(final String number) {
        final StringBuilder numberAsBuilder = new StringBuilder(number);
        int pivot = -1;
        if (new StringBuilder(number) != numberAsBuilder.reverse()) {
            final char[] digits = number.toCharArray();
            final int numberLength = number.length();
            for (int i = numberLength - 1; i >= 0; i--) {
                if (i - 1 >= 0 && digits[i] > digits[i - 1]) {
                    pivot = i - 1;
                    break;
                }
            }
        }
        return pivot;
    }

    private void reverseSubArray(char[] nums, int start, int end) {
        while (start < end) {
            swapDigits(nums, start, end);
            start++;
            end--;
        }
    }

    private void swapDigits(final char[] digits, final int i, final int j) {
        char tempDigit = digits[i];
        digits[i] = digits[j];
        digits[j] = tempDigit;
    }

}
