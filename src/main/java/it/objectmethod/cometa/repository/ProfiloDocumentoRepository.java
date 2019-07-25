package it.objectmethod.cometa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.cometa.domain.ProfiloDocumento;



@Repository
public interface ProfiloDocumentoRepository extends JpaRepository<ProfiloDocumento, Long> {

}
