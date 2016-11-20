//Ali Elsaadi; G4
//COSC 3380 Fall 2016; Lab 9
//This is my work
//I will not disseminate

package connecttooracledbms;

import java.sql.*;
 

public class Main 
{

     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Connection connection = null;
    try 
    {
        String driverName = "oracle.jdbc.driver.OracleDriver"; // Oracle JDBC driver
        String url = "jdbc:oracle:thin:@//129.7.242.225:1521/orcl";
  
        // Load the JDBC driver
        Class.forName(driverName);
    
        // Create a connection to the database
        connection = DriverManager.getConnection(url, "elsaadia", "ea1286957");
        System.out.println(connection);
        
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("CREATE TABLE SELLS"+"(bar VARCHAR2(40), beer VARCHAR2(40), price REAL)");
        stmt.executeUpdate("INSERT INTO SELLS VALUES " + " ('Bar Of Foo', 'BudLite',2.00)");
        
        ResultSet rs = stmt.executeQuery("SELECT * FROM SELLS");
        
        while(rs.next())
        {
        	System.out.println(rs.getString(1)+"  "+rs.getString(2)+"\n");        		
        }
    } catch (ClassNotFoundException e) 
    {
        // Could not find the database driver
    	System.err.println(e);
    } catch (SQLException e) 
    {
        // Could not connect to the database
    	System.err.println(e);
    } catch (Exception e)
    {
    	
    }
    }

}
