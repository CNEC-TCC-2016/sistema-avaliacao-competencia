
package br.com.project.checkskills.entities.dadosbasicos;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import br.com.project.checkskills.entities.avaliacao.AvaliacaoEntity;
import br.com.project.checkskills.utils.BaseEntity;


@Entity
@Table(name = "TB_FEEDBACK")
@AttributeOverride(name = "id", column = @Column(name = "ID_FEEDBACK"))
@Component(value="feedbackEntity")
public class FeedbackEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Column(name = "titulo")
	private String titulo;
	
    @Lob
    @Column(name = "Observacao")
    private String observacao;
    
    @Basic(optional = false)
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;

	@ManyToOne(fetch = FetchType.EAGER )
	@JoinColumn(name="ID_AVALIACAO", referencedColumnName="ID_AVALIACAO")
    private AvaliacaoEntity avaliacaoEntity;
    

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public AvaliacaoEntity getAvaliacaoEntity() {
		return avaliacaoEntity;
	}

	public void setAvaliacaoEntity(AvaliacaoEntity avaliacaoEntity) {
		this.avaliacaoEntity = avaliacaoEntity;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	
    
    
}
