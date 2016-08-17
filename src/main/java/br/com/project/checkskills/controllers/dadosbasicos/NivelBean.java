package br.com.project.checkskills.controllers.dadosbasicos;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import br.com.project.checkskills.entities.dadosbasicos.NivelEntity;
import br.com.project.checkskills.repositories.dadosbasicos.ICargoRepository;
import br.com.project.checkskills.repositories.dadosbasicos.INivelRepository;
import br.com.project.checkskills.utils.BaseEntity;
@ManagedBean(name="nivelBean")
@ViewScoped
public class NivelBean extends BaseEntity<Long> {

	
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(NivelBean.class);
	

	@ManagedProperty(value="#{nivelRepository}")
	private INivelRepository nivelRepository;
	
	@ManagedProperty(value="#{cargoRepository}")
	private ICargoRepository cargoRepository;
    
    private List<NivelEntity> niveis;
	
	private Long id;
	
	private String codigo;
	
	private String acao;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	

	

}
