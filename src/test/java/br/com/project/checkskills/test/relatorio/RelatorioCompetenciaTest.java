package br.com.project.checkskills.test.relatorio;

import static java.lang.System.out;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.project.checkskills.entities.dadosbasicos.CompetenciaEntity;
import br.com.project.checkskills.repositories.dadosbasicos.ICompetenciaRepository;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext-test.xml" })
public class RelatorioCompetenciaTest {

	@Inject
	private ICompetenciaRepository competenciaRepository;
	
	private static final Logger LOGGER = Logger
			.getLogger(RelatorioCompetenciaTest.class);
	
	
	public List<CompetenciaEntity> pupularDados(){
		return this.competenciaRepository.findAll();
	}
	@Test
	@Ignore
	public void test(){
		this.pupularDados();
	}
	
	@Test
	public void getResource(){
		InputStream stream = this.getClass().getResourceAsStream("/report/competencia.jasper");
		out.println(stream);
	}
	
	
	@Test
	public void exibirRelatorio(){
		try {
			

			Map parametros = getParametros();

			
			InputStream stream =  this.getClass().getResourceAsStream("/report/competencia.jrxml");
						
			JRBeanCollectionDataSource dataSource = new  JRBeanCollectionDataSource(this.pupularDados());
			
			JasperReport jr = JasperCompileManager.compileReport(stream);
			
			
			
			JasperPrint printer = JasperFillManager.fillReport(jr,parametros, dataSource);
			JasperViewer jv = new JasperViewer(printer, false);
	    	jv.setTitle("Título da janela do visualizador");  
	        jv.setVisible(true);
	    	System.out.println("Finalizado");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	@SuppressWarnings("rawtypes")
	private Map getParametros() {
		Map parametros = new HashMap();
		parametros.put("P_ID_CARGO", 2l);
		parametros.put("P_TITULO", "TESTE RODOLFO");
		
		return parametros;
	}
	
	

	
	
}
