/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg3.jasper.statics;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import org.eclipse.persistence.internal.databaseaccess.DatasourcePlatform;

/**
 *
 * @author Florian
 */
public class GenerateReports {

    private static Connection connection = null;
    private static Statement statement = null;

    public static boolean generateReport(String name, HashMap<String, Object> map) {
        try {
            connection = Database.getConnection();
            statement = connection.createStatement();
            HashMap parameterMap = new HashMap();
            parameterMap.put("TITLE", "Flo Biblio");//sending the report title as a parameter.
            JasperFillManager.fillReportToFile(name".jasper" , parameterMap, null);
            
            return true;          
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return true;
    }
}
