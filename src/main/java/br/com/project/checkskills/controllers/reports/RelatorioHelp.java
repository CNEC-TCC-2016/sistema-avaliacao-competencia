package br.com.project.checkskills.controllers.reports;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class RelatorioHelp {
	
	@SuppressWarnings("deprecation")
	public void gerarRelatorio(List<? extends Object> dados) throws JRException, IOException{
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
		
        externalContext.responseReset();
        externalContext.setResponseContentType("application/pdf");
        
		Map parametros = getParametros();
		
		InputStream stream =  this.getClass().getResourceAsStream("/report/competencia.jrxml");
		
		JasperReport jr = JasperCompileManager.compileReport(stream);
		JRBeanCollectionDataSource dataSource = new  JRBeanCollectionDataSource(dados);
		JasperPrint printer = JasperFillManager.fillReport(jr,parametros, dataSource);
		
		JRPdfExporter exporter = new JRPdfExporter();
	       
        exporter.setExporterInput(new SimpleExporterInput(printer));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
        exporter.exportReport();
        
        
        response.getOutputStream().flush();
        response.getOutputStream().close();
		
	
		
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Map getParametros() {
		Map parametros = new HashMap();
		parametros.put("P_ID_CARGO", 1l);
		parametros.put("P_TITULO", "TESTE RODOLFO");
		
		return parametros;
	}
	
}
