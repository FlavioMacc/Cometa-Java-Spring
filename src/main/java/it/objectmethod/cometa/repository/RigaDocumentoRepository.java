package it.objectmethod.cometa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.cometa.domain.RigaDocumento;

@Repository
public interface RigaDocumentoRepository extends JpaRepository<RigaDocumento, Long> {

}
