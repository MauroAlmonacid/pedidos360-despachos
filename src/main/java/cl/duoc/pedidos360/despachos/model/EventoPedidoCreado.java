package cl.duoc.pedidos360.despachos.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventoPedidoCreado {

	private Long idOrden;
	private String clienteEmail;
	private Double total;
	private List<Object> items;

	public EventoPedidoCreado() {
	}

	public EventoPedidoCreado(Long idOrden, String clienteEmail, Double total, List<Object> items) {
		this.idOrden = idOrden;
		this.clienteEmail = clienteEmail;
		this.total = total;
		this.items = items;
	}

	public Long getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(Long idOrden) {
		this.idOrden = idOrden;
	}

	public String getClienteEmail() {
		return clienteEmail;
	}

	public void setClienteEmail(String clienteEmail) {
		this.clienteEmail = clienteEmail;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<Object> getItems() {
		return items;
	}

	public void setItems(List<Object> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "EventoPedidoCreado{idOrden=" + idOrden + ", clienteEmail='" + clienteEmail + "', total=" + total
				+ ", items=" + items + '}';
	}
}
