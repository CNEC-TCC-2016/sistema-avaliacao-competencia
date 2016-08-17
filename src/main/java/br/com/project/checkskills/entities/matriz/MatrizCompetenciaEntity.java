package br.com.project.checkskills.entities.matriz;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import br.com.project.checkskills.utils.BaseEntity;

@Table
@Entity(name = "TB_MATRIZ_COMPETENCIA")
@AttributeOverride(name = "id", column = @Column(name = "ID_MATRIZ_COMPETENCIA"))
@Component(value = "matrizCompetenciaEntity")
public class MatrizCompetenciaEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

}
