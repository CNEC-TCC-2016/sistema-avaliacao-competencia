package br.com.project.checkskills.entities.avaliacao;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import br.com.project.checkskills.entities.dadosbasicos.CompetenciaEntity;
import br.com.project.checkskills.entities.dadosbasicos.EscalaEntity;
import br.com.project.checkskills.utils.BaseEntity;

@Entity
@Table(name="TB_AVALIACAO_COMPETENCIA")
@AttributeOverride(name = "id", column = @Column(name = "ID_AVALIACAO_COMPETENCIA"))
@Component(value="avaliacaoCompetenciaEntity")
public class AvaliacaoCompetenciaEntity extends BaseEntity<Long> {

	
	private static final long serialVersionUID = 1L;
	
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	@JoinColumn(name="ID_COMPETENCIA",nullable=false)
	private CompetenciaEntity competencia;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="ID_ESCALA",nullable=false)
	private EscalaEntity escala;

	public CompetenciaEntity getCompetencia() {
		return competencia;
	}

	public void setCompetencia(CompetenciaEntity competencia) {
		this.competencia = competencia;
	}

	public EscalaEntity getEscala() {
		return escala;
	}

	public void setEscala(EscalaEntity escala) {
		this.escala = escala;
	}

	public AvaliacaoCompetenciaEntity(CompetenciaEntity competencia, EscalaEntity escala) {
		super();
		this.competencia = competencia;
		this.escala = escala;
	}

	public AvaliacaoCompetenciaEntity() {
		
	}
	
	
}
