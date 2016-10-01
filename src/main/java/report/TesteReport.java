package report;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class TesteReport {

	public static void main(String[] args) throws JRException, ClassNotFoundException, SQLException {
		Connection conn = getConecction();
		
		Map parametros = getParametros();

		JasperPrint printer = JasperFillManager.fillReport("C:\\Users\\luana\\JaspersoftWorkspace\\MyReports\\competencia.jasper", 
				parametros, conn);
    	//abre visualizador
    	JasperViewer jv = new JasperViewer(printer, false);
    	jv.setTitle("Título da janela do visualizador");  
        jv.setVisible(true);
    	System.out.println("Finalizado");
	}

	public static Map getParametros() {
		Map parametros = new HashMap();
		parametros.put("P_ID_CARGO", 1l);
		parametros.put("P_TITULO", "TESTE RODOLFO");
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
