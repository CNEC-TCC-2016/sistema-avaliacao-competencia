package br.com.project.checkskills.entities.dadosbasicos;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import br.com.project.checkskills.utils.BaseEntity;

@Entity
@Table(name="TB_AVALIACAO")
@AttributeOverride(name = "id", column = @Column(name = "ID_AVALIACAO"))
@Component(value="avaliacaoEntity")
public class AvaliacaoEntity extends BaseEntity<Long> {

	
	private static final long serialVersionUID = 1L;

	
	@JoinTable(name = "ass_funcionario_avaliacao", joinColumns = {
	        @JoinColumn(name = "ID_AVALIACAO", referencedColumnName = "ID_AVALIACAO")}, 
			inverseJoinColumns = {
	        @JoinColumn(name = "ID_FUNCIONARIO", referencedColumnName = "ID_FUNCIONARIO")})
	    @ManyToMany
	    private List<FuncionarioEntity> funcionarioList;
	    
	    @JoinColumn(name = "ID_CICLO_AVALIACAO", referencedColumnName = "ID_CICLO_AVALIACAO")
	    @ManyToOne(optional = false)
	    private CicloAvaliacaoEntity cicloAvaliacao;
	    
	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "avaliacao")
	    private List<FeedbackEntity> feedbackList;
	    
	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "avaliacao")
	    private List<MatrizCompetenciaEntity> matrizCompetenciaList;

		public List<FuncionarioEntity> getFuncionarioList() {
			return funcionarioList;
		}

		public void setFuncionarioList(List<FuncionarioEntity> funcionarioList) {
			this.funcionarioList = funcionarioList;
		}

		public CicloAvaliacaoEntity getCicloAvaliacao() {
			return cicloAvaliacao;
		}

		public void setCicloAvaliacao(CicloAvaliacaoEntity cicloAvaliacao) {
			this.cicloAvaliacao = cicloAvaliacao;
		}

		public List<FeedbackEntity> getFeedbackList() {
			return feedbackList;
		}

		public void setFeedbackList(List<FeedbackEntity> feedbackList) {
			this.feedbackList = feedbackList;
		}

		public List<MatrizCompetenciaEntity> getMatrizCompetenciaList() {
			return matrizCompetenciaList;
		}

		public void setMatrizCompetenciaList(List<MatrizCompetenciaEntity> matrizCompetenciaList) {
			this.matrizCompetenciaList = matrizCompetenciaList;
		}

	
	    
}
