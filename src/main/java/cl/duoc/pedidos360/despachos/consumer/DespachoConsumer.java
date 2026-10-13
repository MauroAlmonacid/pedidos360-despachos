package cl.duoc.pedidos360.despachos.consumer;

import java.time.LocalDateTime;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cl.duoc.pedidos360.despachos.model.Despacho;
import cl.duoc.pedidos360.despachos.model.EventoPedidoCreado;
import cl.duoc.pedidos360.despachos.repository.DespachoRepository;

@Component
public class DespachoConsumer {

	private final DespachoRepository despachoRepository;

	@Value("${app.rabbitmq.queue}")
	private String queueName;

	public DespachoConsumer(DespachoRepository despachoRepository) {
		this.despachoRepository = despachoRepository;
	}

	@RabbitListener(queues = "${app.rabbitmq.queue}")
	public void recibirPedidoCreado(EventoPedidoCreado evento) {
		System.out.println(">>> [DESPACHOS] Evento recibido de " + queueName + ": " + evento);

		String codigoSeguimiento = "DESP-" + System.currentTimeMillis();

		Despacho despacho = new Despacho();
		despacho.setIdOrden(evento.getIdOrden());
		despacho.setClienteEmail(evento.getClienteEmail());
		despacho.setCodigoSeguimiento(codigoSeguimiento);
		despacho.setEstado("EN_PREPARACION");
		despacho.setFechaCreacion(LocalDateTime.now());

		despachoRepository.save(despacho);

		System.out.println(">>> [DESPACHOS] Guía de envío generada: " + codigoSeguimiento
				+ " para la orden #" + evento.getIdOrden());
	}
}
