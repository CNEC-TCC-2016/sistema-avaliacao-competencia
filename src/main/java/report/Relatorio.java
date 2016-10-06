package report;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import br.com.project.checkskills.entities.dadosbasicos.CompetenciaEntity;
import br.com.project.checkskills.repositories.dadosbasicos.ICompetenciaRepository;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

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


		@SuppressWarnings({ "rawtypes", "unchecked" })
		public void create(List<CompetenciaEntity> dados) throws Exception {
			
			FacesContext facesContext = FacesContext.getCurrentInstance();
			
			HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
			
			InputStream reportStream =this.getClass().getClassLoader().getResourceAsStream("competencia.jasper");
			
			JRDataSource jrds = new JRBeanCollectionDataSource(dados);
			try {

				ServletOutputStream servletOutputStream = response.getOutputStream();

				response.setContentType("application/pdf");

				
				try {

					JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream, getParametros(), jrds);

				} catch (JRException e) {

					throw new Exception(e.getMessage());

				}
				facesContext.responseComplete();
				servletOutputStream.flush();

				servletOutputStream.close();
			} catch (IOException e) {

				throw new Exception(e.getMessage());
			} catch (Exception e) {

				throw new Exception(e.getMessage());
			}
		}

		public void executarRelatorio(List<CompetenciaEntity> lista) {
			stream = this.getClass().getClassLoader().getResourceAsStream("competencia.jasper");

			try {
				JasperReport report = (JasperReport) JRLoader.loadObject(stream);
				JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(lista);

				JasperPrint printer = JasperFillManager.fillReport(report, getParametros(), source);
				JasperExportManager.exportReportToPdfStream(printer, byteArrayOutputStream);

				response.reset();
				response.setContentType("application/pdf");
				response.setContentLength(byteArrayOutputStream.size());
				response.setHeader("Content-Disposition", "inline: filename=relatorio.pdf");
				response.getOutputStream().write(byteArrayOutputStream.toByteArray());
				response.getOutputStream().flush();
				response.getOutputStream().close();

				context.responseComplete();

			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		public void criarRelatorio(List<CompetenciaEntity> dados){
			JRDataSource jrds = new JRBeanCollectionDataSource(dados);
		    try{
                FacesContext context = FacesContext.getCurrentInstance();    
                ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();    
                String caminhoRelatorio = servletContext.getRealPath("report/competencia.jasper");    
                System.out.println("caminhoRelatorio :"+caminhoRelatorio);
                HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();    
                response.setContentType("application/pdf");    
                response.addHeader("Content-disposition", "inline; filename=\"competencia.pdf\"");    
                JasperPrint impressao = JasperFillManager.fillReport(caminhoRelatorio, getParametros(), jrds);    
                System.out.println("impressao :"+impressao);
                JasperExportManager.exportReportToPdfStream(impressao, response.getOutputStream());                        
                context.getApplication().getStateManager().saveView(context);    
                context.renderResponse();
                context.responseComplete();                                                            
            }catch(Exception e){
            }
			
		}
		
		private Map getParametros() {
			Map parametros = new HashMap();
			parametros.put("P_ID_CARGO", 1l);
			parametros.put("P_TITULO", "TESTE RODOLFO");
			return parametros;
		}

	}

