package br.com.project.checkskills.entities.jointables;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.project.checkskills.entities.avaliacao.CicloAvaliacaoEntity;
import br.com.project.checkskills.entities.compositekeys.FuncionarioAvaliacaoKey;
import br.com.project.checkskills.utils.BaseEntity;

@Entity
@Table(name= "ASS_FUNCIONARIO_AVALIACAO")
public class FuncionarioAvaliacaoEntity  extends BaseEntity<FuncionarioAvaliacaoKey>{


	private static final long serialVersionUID = 1L;

	
}
