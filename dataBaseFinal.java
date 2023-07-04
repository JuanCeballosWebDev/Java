import java.sql.*;   // Needed for JDBC classes

/**
 * This program demonstrates how to issue an SQL
 * SELECT statement to a database using JDBC.
 */
public class DataBaseFinal
{
   public static void main(String[] args)
   {
      // Create a named constant for the URL.
      // NOTE: This value is specific for Java DB.
      final String DB_URL = "jdbc:derby:NewStudents";
      
      try
      {
         // Create a connection to the database.
         Connection conn = DriverManager.getConnection(DB_URL);
         
         // Create a Statement object.
         Statement stmt = conn.createStatement();
         
         // Create a string with a SELECT statement.
         String sqlStatement = 
            "SELECT * FROM tableCSS WHERE StudentID = '1'";
         
         // Send the statement to the DBMS.
         ResultSet result = stmt.executeQuery(sqlStatement);
         
         // Display a header for the listing.
         System.out.println("Coffees costing more than $10.00");
         System.out.println("--------------------------------");
         
         // Display the contents of the result set.
         // The result set will have three columns.
         while (result.next())
         {
            System.out.println(result.getString("Description") + result.getString("StudentID") + result.getString("Price"));
         }
         
         // Close the connection.
         conn.close();
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }// End of main
}
/*
      // Create a named constant for the URL.
            // NOTE: This value is specific for Java DB.
            final String DB_URL = "jdbc:derby:NewStudents";
               
               try
               {
                  // Create a connection to the database.
                  Connection conn = DriverManager.getConnection(DB_URL);
                  
                  // Create a Statement object.
                  Statement stmt = conn.createStatement();
                  
                  
                     // Create a string with a SELECT statement.
                     String sqlStatement = 
                        "SELECT * FROM tableCSS WHERE StudentID = '1'";
                        // + newStudents.getText();
                     
                     // Send the statement to the DBMS.
                     ResultSet result = stmt.executeQuery(sqlStatement);
                     
                     System.out.println(result.getString("Name") + 
                                           result.getString("StudentID") + 
                                           result.getString("Country") + 
                                           result.getString("Age"));
                     /*
                     outputLabelStuID.setText(result.getString("Name") + 
                                           result.getString("StudentID") + 
                                           result.getString("Country") + 
                                           result.getString("Age"));*/
                     // Display a header for the listing.
                     //System.out.println("CSS course\n");
                     //System.out.println("--------------------------------");
                     
                     // Display the contents of the result set.
                     // The result set will have three columns.
                    // while (result.next())
                     /*{
                        System.out.println(result.getString("Name") + 
                                           result.getString("StudentID") + 
                                           result.getString("Country") + 
                                           result.getString("Age"));
                                           
                                           Name CHAR(50)," +
                                              "StudentID CHAR(10) NOT NULL PRIMARY KEY," +
                                              "Country CHAR(30)," +
                                              "Age CHAR(10)" +
                     }*/
                     
                     
                     
                     // Close the connection.
                  /*   conn.close();
                     
               }// End of try
               
               catch(Exception ex)
               {
                  System.out.println("ERROR: " + ex.getMessage());
               }*/