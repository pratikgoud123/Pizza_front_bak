/*
 * Author Name: Pratik Goud
 * Date: 12-12-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.RabbitMQConsumer.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {
    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter()    {
        return new  Jackson2JsonMessageConverter();
    }
}
