package cl.duoc.pedidos360.despachos.dto;

public class ActualizarEstadoDespachoRequest {

	private String estado;

	public ActualizarEstadoDespachoRequest() {
	}

	public ActualizarEstadoDespachoRequest(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
