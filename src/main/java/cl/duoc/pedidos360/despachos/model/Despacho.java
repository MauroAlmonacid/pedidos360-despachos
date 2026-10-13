package cl.duoc.pedidos360.despachos.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "despachos")
public class Despacho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "id_orden", nullable = false)
	private Long idOrden;

	@Column(name = "cliente_email")
	private String clienteEmail;

	@Column(name = "codigo_seguimiento", unique = true)
	private String codigoSeguimiento;

	@Column(name = "estado")
	private String estado;

	@Column(name = "fecha_creacion")
	private LocalDateTime fechaCreacion;

	public Despacho() {
	}

	public Despacho(Long idOrden, String clienteEmail, String codigoSeguimiento, String estado,
			LocalDateTime fechaCreacion) {
		this.idOrden = idOrden;
		this.clienteEmail = clienteEmail;
		this.codigoSeguimiento = codigoSeguimiento;
		this.estado = estado;
		this.fechaCreacion = fechaCreacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCodigoSeguimiento() {
		return codigoSeguimiento;
	}

	public void setCodigoSeguimiento(String codigoSeguimiento) {
		this.codigoSeguimiento = codigoSeguimiento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
}
