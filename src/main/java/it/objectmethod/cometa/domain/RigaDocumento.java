package it.objectmethod.cometa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "righe_documento")
public class RigaDocumento {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@Column(name = "id_documento")
	private Long idDocumento;

	@Column(name = "id_articolo")
	private String idArticolo;

	@Column(name = "id_lotto")
	private String idLotto;

	@Column(name = "quantita")
	private Integer quantita;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(Long idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getIdArticolo() {
		return idArticolo;
	}

	public void setIdArticolo(String idArticolo) {
		this.idArticolo = idArticolo;
	}

	public String getIdLotto() {
		return idLotto;
	}

	public void setIdLotto(String idLotto) {
		this.idLotto = idLotto;
	}

	public Integer getQuantita() {
		return quantita;
	}

	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}
	
	
	

}
