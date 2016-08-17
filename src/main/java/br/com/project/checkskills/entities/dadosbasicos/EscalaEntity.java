package br.com.project.checkskills.entities.dadosbasicos;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import br.com.project.checkskills.utils.BaseEntity;


@Entity
@Table(name = "TB_ESCALA")
@AttributeOverride(name = "id", column = @Column(name = "ID_ESCALA"))
@Component(value="escalaEntity")
public class EscalaEntity extends BaseEntity<Long>{


	private static final long serialVersionUID = 1L;

	  	@Basic(optional = false)
	    @Column(name = "NOME")
	    private String nome;
	    
	  	@Basic(optional = false)
	    @Column(name = "VALOR")
	    private int valor;
	    

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public int getValor() {
			return valor;
		}

		public void setValor(int valor) {
			this.valor = valor;
		}


	    
	
}
