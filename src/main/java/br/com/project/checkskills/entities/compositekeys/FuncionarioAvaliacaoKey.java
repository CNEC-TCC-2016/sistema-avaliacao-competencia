package br.com.project.checkskills.entities.compositekeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import br.com.project.checkskills.utils.BaseKey;

@Embeddable
public class FuncionarioAvaliacaoKey extends BaseKey {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Column(name = "ID_AVALIACAO")
	private Long avaliacaoId;

	@Column(name = "ID_FUNCIONARIO")
	private Long funcionarioId;



	public FuncionarioAvaliacaoKey() {
		
	}
	
	
	
	public FuncionarioAvaliacaoKey(Long avaliacaoId, Long funcionarioId) {
		super();
		this.avaliacaoId = avaliacaoId;
		this.funcionarioId = funcionarioId;
	}



	public Long getAvaliacaoId() {
		return avaliacaoId;
	}

	public void setAvaliacaoId(Long avaliacaoId) {
		this.avaliacaoId = avaliacaoId;
	}

	public Long getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	
	

}
