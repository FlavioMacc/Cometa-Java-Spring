package it.objectmethod.cometa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documenti")
public class Documento {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;

	@Column(name = "progressivo")
	private int progressivo;

	@Column(name = "id_profilo_documento")
	private long idProfiloDocumento;

	@Column(name = "data")
	private String data;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getProgressivo() {
		return progressivo;
	}

	public void setProgresivo(int progressivo) {
		this.progressivo = progressivo;
	}

	public long getIdProfiloDocumento() {
		return idProfiloDocumento;
	}

	public void setIdProfiloDocumento(long idProfiloDocumento) {
		this.idProfiloDocumento = idProfiloDocumento;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
