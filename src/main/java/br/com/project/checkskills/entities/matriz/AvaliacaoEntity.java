package br.com.project.checkskills.entities.matriz;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import br.com.project.checkskills.utils.BaseEntity;

@Entity
@Table(name="TB_AVALIACAO")
@AttributeOverride(name = "id", column = @Column(name = "ID_AVALIACAO"))
@Component(value="avaliacaoEntity")
public class AvaliacaoEntity extends BaseEntity<Long> {

	
	private static final long serialVersionUID = 1L;

	
}
