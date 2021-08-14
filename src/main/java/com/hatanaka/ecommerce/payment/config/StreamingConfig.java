package com.hatanaka.ecommerce.payment.config;

import com.hatanaka.ecommerce.payment.streaming.CheckoutProcessor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration // a classe precisa de um ou mais @Bean
@EnableBinding(CheckoutProcessor.class)
public class StreamingConfig {
}
