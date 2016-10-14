package report;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import br.com.project.checkskills.entities.dadosbasicos.CompetenciaEntity;
import br.com.project.checkskills.repositories.dadosbasicos.ICompetenciaRepository;

@SuppressWarnings({ "rawtypes", "unused" })
public class Relatorio {

	private HttpServletResponse response;
	private FacesContext context;
	private ByteArrayOutputStream byteArrayOutputStream;
	private InputStream stream;

	@ManagedProperty(value = "#{competenciaRepository}")
	private ICompetenciaRepository competenciaRepository;

	public List<CompetenciaEntity> competencias;

	public Relatorio() {
		this.context = FacesContext.getCurrentInstance();
		this.response = (HttpServletResponse) context.getExternalContext().getResponse();
	}

	
	
	@SuppressWarnings({ "rawtypes", "unused" })
	private Map getParametros() {
		Map parametros = new HashMap();
		parametros.put("P_ID_CARGO", 1l);
		parametros.put("P_TITULO", "TESTE RODOLFO");
		return parametros;
	}

	public ICompetenciaRepository getCompetenciaRepository() {
		return competenciaRepository;
	}

	public void setCompetenciaRepository(ICompetenciaRepository competenciaRepository) {
		this.competenciaRepository = competenciaRepository;
	}

	public List<CompetenciaEntity> getCompetencias() {
		return competencias;
	}

	public void setCompetencias(List<CompetenciaEntity> competencias) {
		this.competencias = competencias;
	}


}
