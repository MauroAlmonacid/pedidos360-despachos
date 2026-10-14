package cl.duoc.pedidos360.despachos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.pedidos360.despachos.dto.ActualizarEstadoDespachoRequest;
import cl.duoc.pedidos360.despachos.model.Despacho;
import cl.duoc.pedidos360.despachos.repository.DespachoRepository;

@RestController
@RequestMapping("/api/despachos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DespachoController {

	private final DespachoRepository despachoRepository;

	public DespachoController(DespachoRepository despachoRepository) {
		this.despachoRepository = despachoRepository;
	}

	@GetMapping
	public List<Despacho> listarDespachos() {
		return despachoRepository.findAll();
	}

	@GetMapping("/orden/{idOrden}")
	public ResponseEntity<Despacho> consultarPorOrden(@PathVariable Long idOrden) {
		return despachoRepository.findFirstByIdOrdenOrderByFechaCreacionDesc(idOrden)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}/estado")
	public ResponseEntity<Despacho> actualizarEstado(@PathVariable Long id,
			@RequestBody ActualizarEstadoDespachoRequest request) {
		return despachoRepository.findById(id)
				.map(despacho -> {
					despacho.setEstado(request.getEstado());
					return ResponseEntity.ok(despachoRepository.save(despacho));
				})
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
}
