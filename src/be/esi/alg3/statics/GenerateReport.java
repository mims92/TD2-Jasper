package be.esi.alg3.statics;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.*;

/**
 *
 * @author G35099
 */
public class GenerateReport {

    public static void connection() throws NamingException {
        try {
            Class.forName("ca.edbc.jdbc.EdbcDriver");

            //Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/eBiblioDB", "app", "app");
            Context initContext = new InitialContext();
            DataSource dataSource = (DataSource) initContext.lookup("jdbc:derby://localhost:1527/eBiblioDB");
           Connection conn = dataSource.getConnection();
           
        } catch (SQLException ex) {
            Logger.getLogger(GenerateReport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GenerateReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean generate(String name, HashMap<String, String> map) throws JRException {
        JasperReport jasperReport;
        JasperPrint jasperPrint;

        connection();
        
        if (map == null) {
            jasperPrint = JasperFillManager.fillReport("report.jasper", new HashMap<String, Object>(),
                    );
            JasperExportManager.exportReportToPdfFile(jasperPrint, "sample.pdf");
        }

        return false;
    }
}
