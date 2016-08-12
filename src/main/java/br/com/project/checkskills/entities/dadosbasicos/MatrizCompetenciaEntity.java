package br.com.project.checkskills.entities.dadosbasicos;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import br.com.project.checkskills.utils.BaseEntity;

@Table
@Entity(name="TB_MATRIZ_COMPETENCIA")
@AttributeOverride(name = "id", column = @Column(name = "ID_MATRIZ_COMPETENCIA"))
@Component(value="matrizCompetenciaEntity")
public class MatrizCompetenciaEntity extends BaseEntity<Serializable> {

	private static final long serialVersionUID = 1L;

	 @JoinColumn(name = "ID_COMPETENCIA", referencedColumnName = "ID_COMPETENCIA")
	    @ManyToOne(optional = false)
	    private CompetenciaEntity competencia;
	    
	 @JoinColumn(name = "ID_AVALIACAO", referencedColumnName = "ID_AVALIACAO")
	    @ManyToOne(optional = false) 
	    private AvaliacaoEntity avaliacao;
	    
	    @JoinColumn(name = "ID_ESCALA", referencedColumnName = "ID_ESCALA")
	    @ManyToOne(optional = false)
	    private EscalaEntity escala;

		public CompetenciaEntity getCompetencia() {
			return competencia;
		}

		public void setCompetencia(CompetenciaEntity competencia) {
			this.competencia = competencia;
		}

		public AvaliacaoEntity getAvaliacao() {
			return avaliacao;
		}

		public void setAvaliacao(AvaliacaoEntity avaliacao) {
			this.avaliacao = avaliacao;
		}

		public EscalaEntity getEscala() {
			return escala;
		}

		public void setEscala(EscalaEntity escala) {
			this.escala = escala;
		}
	    
	    
	
}
