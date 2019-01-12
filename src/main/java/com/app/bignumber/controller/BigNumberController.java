package com.app.bignumber.controller;

import com.app.bignumber.service.BigNumberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@Slf4j
@RequestMapping("/api")
public class BigNumberController {


    @Value("${api.no-response}")
    private String noResponse;

    private final BigNumberService bigNumberService;

    @Autowired
    public BigNumberController(final BigNumberService bigNumberService) {
        this.bigNumberService = bigNumberService;
    }

    @GetMapping(path = "/nextbignumber/{number}")
    public ResponseEntity<?> getNextBigNumber(@PathVariable("number") final Long number) {
        log.info(" The path variable  is:[{}]", number);
        ResponseEntity response = null;
        final long bigNumberModal;
        final String numberAsString = String.valueOf(number);
        // pass only valid request
        if (bigNumberService.filterInputRequest(numberAsString)) {
            response = ResponseEntity.ok(noResponse);
        } else if (bigNumberService.isValidNumberRange(number)) {
            bigNumberModal = bigNumberService.getNextBigNumber(numberAsString);
            response = ResponseEntity.ok(bigNumberModal);
        }

        return response;
    }
}
