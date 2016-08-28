package br.com.project.checkskills.entities.compositekeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import br.com.project.checkskills.utils.BaseKey;

@Embeddable
public class CargoCompetenciaKey extends BaseKey {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Column(name = "ID_COMPETENCIA")
	private Long competenciaId;

	@Column(name = "ID_CARGO")
	private Long carogId;


	public CargoCompetenciaKey() {

	}
	
	
	public CargoCompetenciaKey(Long competenciaId, Long carogId, Long cicloId) {
		super();
		this.competenciaId = competenciaId;
		this.carogId = carogId;
	}

	
	public Long getCompetenciaId() {
		return competenciaId;
	}

	
	public void setCompetenciaId(Long competenciaId) {
		this.competenciaId = competenciaId;
	}

	
	public Long getCarogId() {
		return carogId;
	}

	
	public void setCarogId(Long carogId) {
		this.carogId = carogId;
	}
	

}
