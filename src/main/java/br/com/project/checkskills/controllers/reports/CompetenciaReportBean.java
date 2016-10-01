package br.com.project.checkskills.controllers.reports;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.project.checkskills.entities.dadosbasicos.CompetenciaEntity;
import br.com.project.checkskills.repositories.dadosbasicos.ICompetenciaRepository;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean(name = "cargoBean")
@ViewScoped
public class CompetenciaReportBean {

	@ManagedProperty(value = "#{competenciaRepository}")
	private ICompetenciaRepository competenciaRepository;

	public List<CompetenciaEntity> competencias;

	public String relatorio() {
		try {
			this.competencias = competenciaRepository.findAll();

			this.competencias.forEach(c -> System.out.println(c));

			FacesContext fc = FacesContext.getCurrentInstance();
			ExternalContext ec = fc.getExternalContext();

			ec.responseReset();

			ec.setResponseContentType("application/pdf");
			ec.setResponseContentLength(200);

			ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + competencias + "\"");
			OutputStream output = ec.getResponseOutputStream();

			// GERAR O RELATORIO E PEGAR O OUTPUSTREAM
			JRBeanCollectionDataSource jrds = new JRBeanCollectionDataSource(competencias);

			JasperPrint printer = JasperFillManager.fillReport(
					"C:\\Users\\luana\\JaspersoftWorkspace\\MyReports\\competencia.jasper", getParametros(), jrds);

			JasperExportManager.exportReportToPdfStream(printer, output);

			fc.responseComplete();

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		return null;// "/pages/cargo/cargoList.xhtml?faces-redirect=true";
	}

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

}
