/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fantasycricket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Sunildev Birbal
 * @registration number 12/0719/2653
 */
public class MySQL {

    Connection conn = null;
    private final String user = "root";
    private final String pass = "";
    // private String url = "jdbc:odbc:fantasycricket64";
    private final String dburl = "jdbc:mysql://localhost";
//    private final String url = "com.mysql.jdbc.Driver";
//    private final String updates = null;
    private String results = null;
    private ResultSet result;
    private String statement;
    private Statement sqlStatement;

    public void Connect() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(dburl, user, pass);
            this.sqlStatement = conn.createStatement();
            this.sqlStatement.executeQuery("USE fantasycricket");

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    private void UpdateDB() throws SQLException {


        sqlStatement.executeUpdate(statement);
     

    }

    public void CloseConn() throws SQLException {
        conn.close();
    }

    private void Results() throws SQLException {
    

        result = sqlStatement.executeQuery(results);
      
    }

    public void setStatement(String statement) throws SQLException {
        this.statement = statement;

        UpdateDB();

    }

    public ResultSet getResult() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //Connect();
        return result;
        
    }

    public void setResults(String results) throws SQLException {
        this.results = results;

        Results();

    }

}
