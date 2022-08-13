package com.samuliak.test.config;

import com.samuliak.test.utils.AesCryptUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CryptConfig {

    @Value("${aes.key}")
    private String secretKey;
    @Value("${aes.salt}")
    private String salt;

    @Bean
    public AesCryptUtils getEncryptUtils() throws Exception {
        return new AesCryptUtils(secretKey, salt);
    }
}
