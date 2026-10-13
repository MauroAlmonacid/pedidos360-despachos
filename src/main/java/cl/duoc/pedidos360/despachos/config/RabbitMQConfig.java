package cl.duoc.pedidos360.despachos.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Value("${app.rabbitmq.queue}")
	private String queueName;

	@Value("${app.rabbitmq.exchange}")
	private String exchangeName;

	@Value("${app.rabbitmq.routingkey}")
	private String routingKey;

	@Bean
	public Queue despachosQueue() {
		return new Queue(queueName, true);
	}

	@Bean
	public TopicExchange pedidosExchange() {
		return new TopicExchange(exchangeName, true, false);
	}

	@Bean
	public Binding despachosBinding(Queue despachosQueue, TopicExchange pedidosExchange) {
		return BindingBuilder.bind(despachosQueue).to(pedidosExchange).with(routingKey);
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
}
