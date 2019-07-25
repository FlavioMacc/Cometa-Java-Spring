package it.objectmethod.cometa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.objectmethod.cometa.domain.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {
	
	@Query(value="select max(d.progressivo) from Documento d")
	public Long findLastProgressNumberDocument();
}
