package it.objectmethod.cometa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profilo_documento")
public class ProfiloDocumento {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;

	@Column(name = "codice")
	private String codice;

	@Column(name = "movimento_merce")
	private char movimentoMerce;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public char getMovimentoMerce() {
		return movimentoMerce;
	}

	public void setMovimentoMerce(char movimentoMerce) {
		this.movimentoMerce = movimentoMerce;
	}

}
