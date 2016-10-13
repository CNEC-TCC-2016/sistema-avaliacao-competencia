package br.com.project.checkskills.controllers.reports;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class AvaliacaoReport {
	
	
	public void gerarRelatorio(Long cargo, Long funcionario) throws JRException, SQLException, IOException{

		FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
		
        externalContext.responseReset();
        externalContext.setResponseContentType("application/pdf");
		
        Map parametros = getParametros(cargo, funcionario);
        
		InputStream stream =  this.getClass().getResourceAsStream("/report/relatorio_avaliacao.jasper");

		JasperReport jr = (JasperReport) JRLoader.loadObject(stream);
		
		JasperPrint printer = JasperFillManager.fillReport(jr,parametros, getConecction());
		
		JRPdfExporter exporter = new JRPdfExporter();
	       
        exporter.setExporterInput(new SimpleExporterInput(printer));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
        exporter.exportReport();
        
        
        response.getOutputStream().flush();
        response.getOutputStream().close();
		
		
	}
	
	public void gerarRelatorio(Long cargo) throws JRException, SQLException, IOException{

		FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
		
        externalContext.responseReset();
        externalContext.setResponseContentType("application/pdf");
		
        Map parametros = getParametros(cargo);
        
		InputStream stream =  this.getClass().getResourceAsStream("/report/relatorio_avaliacao_setor.jasper");
		JasperReport jr = (JasperReport) JRLoader.loadObject(stream);

		JasperPrint printer = JasperFillManager.fillReport(jr,parametros, getConecction());
		
		JRPdfExporter exporter = new JRPdfExporter();
	       
        exporter.setExporterInput(new SimpleExporterInput(printer));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
        exporter.exportReport();
        
        
        response.getOutputStream().flush();
        response.getOutputStream().close();
		
		
	}
	
	
	
	
	
	
	public static Map getParametros(Long cargo, Long funcionario) {
		Map parametros = new HashMap();
		parametros.put("P_ID_CARGO", cargo);
		parametros.put("P_ID_FUNCIONARIO", funcionario);
		return parametros;
	}
	
	public static Map getParametros(Long cargo) {
		Map parametros = new HashMap();
		parametros.put("P_ID_CARGO", cargo);
		return parametros;
	}

	public static Connection getConecction() throws SQLException {
		String URL = "jdbc:mysql://localhost:3306/db_projeto";
		String USER = "root";
		String PASS = "root";
		Connection conn = DriverManager.getConnection(URL, USER, PASS);
		return conn;
	}
	
}
