package com.app.bignumber.controller;


import com.app.bignumber.exception.InvalidRangeException;
import com.app.bignumber.service.BigNumberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BigNumberController.class)
public class BigNumberControllerTest {

    private static final String URI_STRING = "/api/nextbignumber/{number}";
    private static final String URI_CONTENT_TYPE = "application/json";
    @Autowired
    private MockMvc mvc;

    @MockBean
    private BigNumberService bigNumberService;

    @Test
    public void shouldAcceptValidRequest() throws Exception {
        final long pathVariable = 1234;
        mvc.perform(get(URI_STRING, pathVariable)
                .contentType(URI_CONTENT_TYPE)
        ).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnBadRequest() throws Exception {
        final String pathVariable = "test";
        mvc.perform(get(URI_STRING, pathVariable)
                .contentType(URI_CONTENT_TYPE)
        ).andExpect(status().isBadRequest());

    }

    @Test
    public void shouldReturnBadRequestForInvalidRange() throws Exception {
        final String pathVariable = "-111";
        when(bigNumberService.isValidNumberRange(Long.valueOf(pathVariable))).thenThrow(InvalidRangeException.class);
        mvc.perform(get(URI_STRING, pathVariable)
                .contentType(URI_CONTENT_TYPE)
        ).andExpect(status().isBadRequest());
    }
}