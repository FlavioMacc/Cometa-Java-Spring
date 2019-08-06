package it.objectmethod.cometa.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.objectmethod.cometa.domain.Articolo;

@Repository
public interface ArticoloRepository extends JpaRepository<Articolo, Long> {
	
	//@Query(value="insert into articoli (id,codice,descrizione values ( ?1 , ?2 , ?3 ))")
	//public void insertDataToDB(Long id,String codice,String descrizione);
	
	@Query(value="select a from Articolo a where a.codice = ?1")
	public Articolo findArticleForCode(String code);
	
	@Query(value="select a from Articolo a where a.codice LIKE CONCAT(?1,'%')")
	public List<Articolo> findAllArticleForCode(String code,Pageable pageable);
	
}
