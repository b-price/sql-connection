/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqltest2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.time.Clock;
import java.time.ZoneId;



/**
 *
 * @author qwang12
 */
public class MySQLTest2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch (ClassNotFoundException e){
            System.out.println(e);
        }

        final String ID = "root";
        final String PW = "iloveTotoro76%";
        final String SERVER = "jdbc:mysql://localhost:3306/?serverTimezone=EST#/company?useSSL=false";
        String querys;

        try {
            Connection con = DriverManager.getConnection(SERVER, ID, PW);
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM company.Branch");
            PreparedStatement updateStaff = null;

            while (rs.next()){
                String bNo = rs.getString("branchNo");
                String street = rs.getString("street");
                String city = rs.getString("city");
                String postcode = rs.getString("postcode");
                System.out.println(bNo+", "+street+", "+city+", "+ postcode);

            }
            querys = "UPDATE benprice12db.Branch SET city = 'Baltimore' WHERE branchNo = 'B002';";
            updateStaff = con.prepareStatement(querys);
            updateStaff.executeUpdate();
        }catch (SQLException e){
            System.err.println(e);
        }
    }//Main

}
