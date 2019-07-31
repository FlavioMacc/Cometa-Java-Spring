package it.objectmethod.cometa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "articoli")
public class Articolo {

	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	//@Column(name = "id")
	private Long id;

	@Column(name = "codice")
	private String codice;

	@Column(name = "descrizione")
	private String descrizione;
	
	/*@ManyToOne
	private Lotto lotto;*/
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	/*public Lotto getLotto() {
		return lotto;
	}

	public void setLotto(Lotto lotto) {
		this.lotto = lotto;
	}*/
}
