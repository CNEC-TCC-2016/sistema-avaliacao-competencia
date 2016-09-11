package br.com.project.checkskills.entities.avaliacao;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import br.com.project.checkskills.entities.dadosbasicos.EscalaEntity;
import br.com.project.checkskills.entities.jointables.CargoCompetenciaEntity;
import br.com.project.checkskills.utils.BaseEntity;

@Entity
@Table(name="TB_AVALIACAO_COMPETENCIA")
@AttributeOverride(name = "id", column = @Column(name = "ID_AVALIACAO_COMPETENCIA"))
@Component(value="avaliacaoCompetenciaEntity")
public class AvaliacaoCompetenciaEntity extends BaseEntity<Long> {

	
	private static final long serialVersionUID = 1L;
	
	
//	@ManyToOne(fetch=FetchType.EAGER, optional=false)
//	@JoinColumn(name="ID_COMPETENCIA",nullable=false)
//	private CompetenciaEntity competencia;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="ID_ESCALA",nullable=false)
	private EscalaEntity escala;

	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumns({
		@JoinColumn(name="ID_COMPETENCIA",referencedColumnName = "ID_COMPETENCIA"),
		@JoinColumn(name="ID_CARGO", referencedColumnName="ID_CARGO"),
	})
	private CargoCompetenciaEntity cargoCompetencia;

//	
//		public CompetenciaEntity getCompetencia() {
//		return competencia;
//	}
//
//	public void setCompetencia(CompetenciaEntity competencia) {
//		this.competencia = competencia;
//	}

	public EscalaEntity getEscala() {
		return escala;
	}

	public void setEscala(EscalaEntity escala) {
		this.escala = escala;
	}


	public CargoCompetenciaEntity getCargoCompetencia() {
		return cargoCompetencia;
	}

	public void setCargoCompetencia(CargoCompetenciaEntity cargoCompetencia) {
		this.cargoCompetencia = cargoCompetencia;
	}


	
	
	public AvaliacaoCompetenciaEntity(EscalaEntity escala, CargoCompetenciaEntity cargoCompetencia) {
		super();
		this.escala = escala;
		this.cargoCompetencia = cargoCompetencia;
	}

	public AvaliacaoCompetenciaEntity() {
		
	}
	
	
}
