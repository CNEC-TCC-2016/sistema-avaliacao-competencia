
/**
 * @author LUAN LUCAS
 *
 */
package br.com.project.checkskills.entities.jointables;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.project.checkskills.entities.avaliacao.CicloAvaliacaoEntity;
import br.com.project.checkskills.entities.compositekeys.CargoCompetenciaKey;
import br.com.project.checkskills.utils.BaseEntity;

@Entity
@Table(name= "ASS_CARGO_COMPETENCIA")
public class CargoCompetenciaEntity extends  BaseEntity<CargoCompetenciaKey>{

	private static final long serialVersionUID = 1L;


	

}