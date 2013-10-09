/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg3.jasper.statics;

import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;

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
            parameterMap.put("rtitle", "Report Title Here");//sending the report title as a parameter.
            Report rpt = new Report(parameterMap, connection);
            rpt.setReportName("productlist"); //productlist is the name of my jasper file.
            rpt.callReport();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }
}
