package it.objectmethod.cometa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lotti")
public class Lotto {

	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;

	@Column(name = "codice_lotto")
	private String codiceLotto;

	@Column(name = "id_articolo")
	private long idArticolo;

	@Column(name = "quantita")
	private int quantita;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodiceLotto() {
		return codiceLotto;
	}

	public void setCodiceLotto(String codiceLotto) {
		this.codiceLotto = codiceLotto;
	}

	public long getIdArticolo() {
		return idArticolo;
	}

	public void setIdArticolo(long idArticolo) {
		this.idArticolo = idArticolo;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

}
