package br.com.project.checkskills.entities.avaliacao;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import br.com.project.checkskills.entities.autenticacao.PermissaoEntity;
import br.com.project.checkskills.entities.dadosbasicos.FuncionarioEntity;
import br.com.project.checkskills.utils.BaseEntity;

@Table
@Entity(name = "TB_MATRIZ")
@AttributeOverride(name = "id", column = @Column(name = "ID_MATRIZ"))
@Component(value = "matrizCompetenciaEntity")
public class MatrizEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;


}
