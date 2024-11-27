package com.vb.ms.review.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// steps
// create message queue
// create message converter which converts the message to json
// get the rabbitMQ template
@Configuration
public class RabbitMQConfig {
	
	@Bean
	Queue companyRatingQueue() {
		return new Queue("companyRatingQueue");
	}
	
	@Bean
	MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	RabbitTemplate rabbitTemplate(final ConnectionFactory connection) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connection);
		rabbitTemplate.setMessageConverter(messageConverter());
		return rabbitTemplate;
	}
}
