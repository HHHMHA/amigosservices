package com.amigoscode.amqp;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class RabbitMQConfig {
    private final ConnectionFactory connectionFactory;

    @Bean
    public AmqpTemplate amqpTemplate() {
        RabbitTemplate template = new RabbitTemplate( connectionFactory );
        template.setMessageConverter( jacksonConverter() );
        return template;
    }

    @Bean
    public MessageConverter jacksonConverter() {
        MessageConverter converter = new Jackson2JsonMessageConverter();
        return converter;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory( connectionFactory );
        factory.setMessageConverter( jacksonConverter() );
        return factory;
    }
}
