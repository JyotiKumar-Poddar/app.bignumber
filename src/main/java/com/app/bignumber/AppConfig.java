package com.app.bignumber;


import com.app.bignumber.util.BigNumberConverterUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public BigNumberConverterUtil bigNumberConverterUtil() {
        return new BigNumberConverterUtil();
    }
}
