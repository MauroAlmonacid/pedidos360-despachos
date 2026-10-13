package cl.duoc.pedidos360.despachos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.pedidos360.despachos.model.Despacho;

@Repository
public interface DespachoRepository extends JpaRepository<Despacho, Long> {

	Optional<Despacho> findFirstByIdOrdenOrderByFechaCreacionDesc(Long idOrden);
}
