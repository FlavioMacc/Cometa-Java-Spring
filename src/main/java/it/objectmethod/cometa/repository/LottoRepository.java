package it.objectmethod.cometa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.objectmethod.cometa.domain.Lotto;

@Repository
public interface LottoRepository extends JpaRepository<Lotto, Long> {
	
	@Query(value="select a from Lotto a where a.codiceLotto = ?1")
	public Lotto findLottoForCode(String code);

}
