
package br.com.project.checkskills.entities.dadosbasicos;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import br.com.project.checkskills.utils.BaseEntity;


@Entity
@Table(name = "TB_FEEDBACK")
@AttributeOverride(name = "id", column = @Column(name = "ID_FEEDBACK"))
@Component(value="feedbackEntity")
public class FeedbackEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

    @Lob
    @Column(name = "Observacao")
    private byte[] observacao;
    
    @Basic(optional = false)
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;


	public byte[] getObservacao() {
		return observacao;
	}

	public void setObservacao(byte[] observacao) {
		this.observacao = observacao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	
    
    
}
