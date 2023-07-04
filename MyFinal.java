/*
Program that shows two courses with details about its students, like for example their names, countries and ages. It also allows the user to 
include new students, for both courses, with all the details and later save the information in a database that can be accessed later. 
*/

import java.util.ArrayList; // (10 POINTS) (Chapter 7)  Use of Arrays /ArrayLists

// (25 POINTS) (Chapter 12, 13, 14) Use of GUI    
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.sql.*;   // Needed for JDBC classes (15 POINTS) (Chapter 11 or Chapter 16) Saving information via Serialization or Databases 

public class MyFinal extends Application
{
   // Variables. (10 POINTS) (Chapter 7)  Use of Arrays /ArrayLists
   ArrayList<String> nameS; 
   ArrayList<String> countryS; 
   ArrayList<String> age;
   
   
   
   // (5 POINTS) (Chapter 9) Use of Text Processing 
   TextField studentNam; 
   TextField studentNam2; 
   TextField studentCountry; 
   TextField studentCountry2; 
   TextField studentAge; 
   TextField studentAge2; 
   
   TextField studentNamMath; 
   TextField studentNam2Math; 
   TextField studentCountryMath; 
   TextField studentCountry2Math; 
   TextField studentAgeMath; 
   TextField studentAge2Math; 
   
   
   
   // (25 POINTS) (Chapter 12, 13, 14) Use of GUI    
   private Label outputLabel;
   private Label outputLabel2;
   private Label outputLabel3;
   private Label outputLabel4;
   private Label outputLabel5;
   private Label outputLabel6;
   private Label outputLabel8;
   private Label outputLabelNew;
   private Label outputLabelNew1;
   private Label outputLabelNew2;
   
   private Label outputLabelMath;
   private Label outputLabel2Math;
   private Label outputLabel3Math;
   private Label outputLabel4Math;
   private Label outputLabel5Math;
   private Label outputLabel6Math;
   private Label outputLabel8Math;
   private Label outputLabelNewMath;
   private Label outputLabelNew1Math;
   private Label outputLabelNew2Math;
   
   ComboBox course3;
   ComboBox courses4;
   
   
   
   String country = "";
   String country2 = "";
   String name = " ";
   String nameOne = "";
   String name2 = "";
   String ageS = "";
   String ageS2 = "";
   String courseSelect = "CSS";
   
   
   
   // (15 POINTS) (Chapter 11 or Chapter 16) Saving information via Serialization or Databases 
   final String DB_URL = "jdbc:derby:NewStudents;create=true";
   final String DB_URL2 = "jdbc:derby:NewStudents";
   
   
   
   // (20 POINTS) (Chapter 6 and 8) Use of Classes and Objects 
   CourseFinal courseOne;
   CourseFinal courseTwo;
   
   CourseFinal courseOneNew;
   CourseFinal courseTwoNew;
   
   
   
   
   // (25 POINTS) (Chapter 12, 13, 14) Use of GUI     
   public static void main(String[] args)
   {
      // Launch the application.
      launch(args);
   }
   
  @Override
   public void start(Stage primaryStage)
   {
      
      // (25 POINTS) (Chapter 12, 13, 14) Use of GUI    
      // Constants for the starting values to form the logo
      final int X = 225;
      final int Y = 10;
      final int X_MATH = 250;
      final int Y_MATH = 10;
      final double RECTAN_WIDTH = 50.0;
      final double RECTAN_WIDTH_MATH = 30.0;
      final double RECTAN_HEIGHT = 30.0;
      final double ROTATION = 10.0;
      final double SCALE_X = 0.90;
      final double SCALE_Y = 0.90;

      // Create empty Panes.
      Pane pane = new Pane();
      Pane paneMath = new Pane();

      
      
      // (5 POINTS) (Chapter 15) Use of Recursion
      // Recursively it creates new rectangles, scales them, and rotate them
      drawRectangles(pane, X, Y, RECTAN_WIDTH, RECTAN_HEIGHT,ROTATION, SCALE_X, SCALE_Y);
      drawRectanglesMath(paneMath, X_MATH, Y_MATH, RECTAN_WIDTH_MATH, RECTAN_HEIGHT,ROTATION, SCALE_X, SCALE_Y);
      
      
      
      
      // (10 POINTS) (Chapter 7)  Use of Arrays /ArrayLists
      // Creates all the countries and ages for each student and store them in ArrayLists
      ArrayList<String> countriesCSS = new ArrayList<String>();
      countriesCSS.add("Colombia");
      countriesCSS.add("Colombia");
      countriesCSS.add("India");
      ArrayList<String> agesCSS = new ArrayList<String>();
      agesCSS.add("22");
      agesCSS.add("35");
      agesCSS.add("27");
      
      ArrayList<String> countriesMath = new ArrayList<String>();
      countriesMath.add("United States");
      countriesMath.add("Puerto Rico");
      countriesMath.add("Cuba");
      ArrayList<String> agesMath = new ArrayList<String>();
      agesMath.add("45");
      agesMath.add("35");
      agesMath.add("34");
      
      // Creates all the names and store them in ArrayLists
      ArrayList<String> studentCSS = new ArrayList<String>();
      studentCSS.add("Juan P. Ceballos");
      studentCSS.add("Carlos Velez");
      studentCSS.add("Mansi Bhagwate");
      
      ArrayList<String> studentMath = new ArrayList<String>();
      studentMath.add("James Padilla");
      studentMath.add("Luz M. Gutierrez");
      studentMath.add("Juan A. Escobar");
      
      
     
     
     
      
      // (20 POINTS) (Chapter 6 and 8) Use of Classes and Objects. Use TWO constructors 
      // Creates objects to include students in each course
      courseOne = new CourseFinal (new StudentsDetailsFinal(agesCSS, countriesCSS, studentCSS));
      courseTwo = new CourseFinal (new StudentsDetailsFinal(agesMath, countriesMath, studentMath));
      
      // Creates objects to include new students in each course
      courseOneNew = new CourseFinal (new StudentsDetailsFinal(studentCSS));
      courseTwoNew = new CourseFinal (new StudentsDetailsFinal(studentMath));
      
      
      
      
      
      
      // (25 POINTS) (Chapter 12, 13, 14) Use of GUI    
      // Creates a Labels.
      outputLabel = new Label(" ");
      outputLabel2 = new Label(" ");
      outputLabel3 = new Label(" ");
      outputLabel4 = new Label();
      outputLabelNew = new Label(" ");
      outputLabelNew1 = new Label(" ");
      outputLabelNew2 = new Label();
      outputLabel5 = new Label();
      outputLabel6 = new Label("Find information in the database by student ID. BE SURE the file exit.");
      outputLabel8 = new Label("If you want to enter new students, enter the information BEFORE submiting and saving.\n" +
                                     "\t\t\tEnter the NAME first, second the country, and third the age");
      outputLabelMath = new Label(" ");
      outputLabel2Math = new Label(" ");
      outputLabel3Math = new Label(" ");
      outputLabel4Math = new Label();
      outputLabelNewMath = new Label(" ");
      outputLabelNew1Math = new Label(" ");
      outputLabelNew2Math = new Label();
      outputLabel5Math = new Label();
      outputLabel6Math = new Label("Find information in the database by student ID. BE SURE the file exit.");
      outputLabel8Math = new Label("If you want to enter new students, enter the information BEFORE submiting and saving.\n" +
                                     "\t\t\tEnter the NAME first, second the country, and third the age"); ;
      
      
      
      
      
      
      
      
      // (25 POINTS) (Chapter 12, 13, 14) Use of GUI 
      // Creates all the buttons
      Button students = new Button("CSS course and Students. SUBMIT information about new students first if you want to \n" +
                              "\t\t\t\t\t\t include new participants");
      Button studentsMath = new Button("Math course and Students. SUBMIT information about new students first if you want to \n" +
                              "\t\t\t\t\t\t include new participants");
      Button submitNewMath = new Button("Submit the information entered before saving");Button submitNew = new Button("Submit the information entered before saving");
      Button save = new Button("Save the new information in a File Called NewStudents (Close this window once you press the button).\n" 
                               + "\t\t\t\tBe SURE to submit the new information for BOTH courses first.");
      
      //Creates combo boxes.
      course3 = new ComboBox<>();
      course3.getItems().addAll("New CSS Student ID 1", "New CSS Student ID 2");
      courses4= new ComboBox<>();
      courses4.getItems().addAll("New Math Student ID 1", "New Math Student ID 2");
      
      
      
      
      
      
      
      // (5 POINTS) (Chapter 9) Use of Text Processing 
      // Creates all the TextFields 
      studentNam = new TextField();
      studentCountry = new TextField("Enter the country");
      studentAge = new TextField("Enter the age");
      studentNam2 = new TextField();
      studentCountry2 = new TextField("Enter the country");
      studentAge2 = new TextField("Enter the age");
      
      studentNamMath = new TextField();
      studentCountryMath = new TextField("Enter the country");
      studentAgeMath = new TextField("Enter the age");   
      studentNam2Math  = new TextField(); 
      studentCountry2Math = new TextField("Enter the country"); 
      studentAge2Math = new TextField("Enter the age");
         
      
      
      
      
      
      // Event Handlers
      // (15 POINTS) (Chapter 11 or Chapter 16) Saving information via Serialization or Databases 
      save.setOnAction(new SaveButtonHandler());
      course3.setOnAction(new OpenCSSButtonHandler());
      courses4.setOnAction(new OpenMathButtonHandler());
      
      
      
      
      
      
      
      // (25 POINTS) (Chapter 12, 13, 14) Use of GUI 
      // Register event handlers for the all the buttons.    
      students.setOnAction(event ->
      {
      
         // (20 POINTS) (Chapter 6 and 8) Use of Classes and Objects. Use TWO constructors 
         // Prints all the infromation of each student according to the course

               
               courseOneNew.setNames(" ");
               courseOneNew.setCountrys(" ");
               courseOneNew.setAges(" ");
               courseOneNew.setNames(" ");
               courseOneNew.setCountrys(" ");
               courseOneNew.setAges(" "); 
               
               outputLabel.setText(courseOne.getNames().get(0) + "        " + courseOne.getCount().get(0) + "        " + 
                                   courseOne.getAges().get(0) + "\n");
               outputLabel2.setText(courseOne.getNames().get(1) + "        " + courseOne.getCount().get(1) + "        " + 
                                    courseOne.getAges().get(1) + "\n");
               outputLabel3.setText(courseOne.getNames().get(2) + "        " + courseOne.getCount().get(2) + "        " + 
                                    courseOne.getAges().get(2) + "\n");
               outputLabelNew.setText(courseOneNew.getNam().get(0) + "        " + courseOneNew.getCount().get(0) + "        " + 
                                    courseOneNew.getAges().get(0) + "\n");
               outputLabelNew1.setText(courseOneNew.getNam().get(1) + "        " + courseOneNew.getCount().get(1) + "        " + 
                                    courseOneNew.getAges().get(1) + "\n");
               
               outputLabel4.setText("--------------------------------------------------\n");
               outputLabel5.setText("Name                Country                Age\n");
      
      }); // End student event
      
      
       studentsMath.setOnAction(event ->
      {
      
         // (20 POINTS) (Chapter 6 and 8) Use of Classes and Objects. Use TWO constructors 
         // Prints all the infromation of each student according to the course
         courseTwoNew.setNames(" ");
         courseTwoNew.setCountrys(" ");
         courseTwoNew.setAges(" ");
         courseTwoNew.setNames(" ");
         courseTwoNew.setCountrys(" ");
         courseTwoNew.setAges(" "); 
      
         outputLabelMath.setText(courseTwo.getNames().get(0) + "        " + courseTwo.getCount().get(0) + "        " + 
                             courseTwo.getAges().get(0) + "\n");
         outputLabel2Math.setText(courseTwo.getNames().get(1) + "        " + courseTwo.getCount().get(1) + "        " + 
                              courseTwo.getAges().get(1) + "\n");
         outputLabel3Math.setText(courseTwo.getNames().get(2) + "        " + courseTwo.getCount().get(2) + "        " + 
                              courseTwo.getAges().get(2) + "\n");
         outputLabelNewMath.setText(courseTwoNew.getNam().get(0) + "        " + courseTwoNew.getCount().get(0) + "        " + 
                              courseTwoNew.getAges().get(0) + "\n");
         outputLabelNew1Math.setText(courseTwoNew.getNam().get(1) + "        " + courseTwoNew.getCount().get(1) + "        " + 
                              courseTwoNew.getAges().get(1) + "\n");
         outputLabel4Math.setText("--------------------------------------------------\n");
         outputLabel5Math.setText("Name                Country                Age\n");

      
      }); // End student event
      

      submitNew.setOnAction(event ->
      {
            // Gather information from user. (5 POINTS) (Chapter 9) Use of Text Processing 
            name = studentNam.getText();
            country = studentCountry.getText();
            ageS = studentAge.getText();
            name2 = studentNam2.getText();
            country2 = studentCountry2.getText();
            ageS2 = studentAge2.getText();
            
            // Sets all the values.(20 POINTS) (Chapter 6 and 8) Use of Classes and Objects 
            courseOneNew.setNames(name);
            courseOneNew.setCountrys(country);
            courseOneNew.setAges(ageS);
            courseOneNew.setNames(name2);
            courseOneNew.setCountrys(country2);
            courseOneNew.setAges(ageS2);
       
       }); // End of submit handler
       
       
      submitNewMath.setOnAction(event ->
      {
         // Gather information from user. (5 POINTS) (Chapter 9) Use of Text Processing 
         nameOne = studentNamMath.getText();
         String countryOne = studentCountryMath.getText();
         String ageSone = studentAgeMath.getText();
         String name2one = studentNam2Math.getText();
         String country2one = studentCountry2Math.getText();
         String ageS2one = studentAge2Math.getText();
         
         // Sets all the values. (20 POINTS) (Chapter 6 and 8) Use of Classes and Objects 
         courseTwoNew.setNames(nameOne);
         courseTwoNew.setCountrys(countryOne);
         courseTwoNew.setAges(ageSone);
         courseTwoNew.setNames(name2one);
         courseTwoNew.setCountrys(country2one);
         courseTwoNew.setAges(ageS2one);
            
       }); // End of submit handler
       
       
       
      
      
      
      
      
      
      // (25 POINTS) (Chapter 12, 13, 14) Use of GUI     
      // Add the controls to VBox and HBox.
      VBox vbox = new VBox(12, pane, outputLabel8, studentNam, studentCountry, studentAge, studentNam2, studentCountry2, studentAge2, submitNew, 
                           students, outputLabel5, outputLabel4 , outputLabel, outputLabel2, outputLabel3, outputLabelNew,  outputLabelNew1, 
                           outputLabelNew2, outputLabel6, course3);
      vbox.setPadding(new Insets(10));
      vbox.setAlignment(Pos.CENTER);
      
      VBox vboxMath = new VBox(12, paneMath, outputLabel8Math, studentNamMath, studentCountryMath, studentAgeMath, studentNam2Math, 
                               studentCountry2Math, studentAge2Math, submitNewMath,studentsMath, outputLabel5Math, outputLabel4Math , 
                               outputLabelMath, outputLabel2Math, outputLabel3Math, outputLabelNewMath,  outputLabelNew1Math, outputLabelNew2Math,
                               outputLabel6Math, courses4);
      vboxMath.setPadding(new Insets(10));
      vboxMath.setAlignment(Pos.CENTER);
      
      HBox hboxCourses = new HBox(15, vbox, vboxMath);
      hboxCourses.setPadding(new Insets(10));
      hboxCourses.setAlignment(Pos.CENTER);
      
      VBox vboxCourses = new VBox(hboxCourses, save);
      vboxCourses.setPadding(new Insets(10));
      vboxCourses.setAlignment(Pos.CENTER);
      
               
      // Create a Scene and display it.
      Scene scene = new Scene(vboxCourses);
      primaryStage.setScene(scene);
      primaryStage.show();
      
   }// End of start method
   
  
  
  
  
  
  
  
  
  
  
  // METHOD
  // (5 POINTS) (Chapter 15) Use of Recursion
  // Recursive method to drow a logo.
  public void drawRectangles(Pane p, int x, int y, double width, double height, double rot, double scaleX, double scaleY)
   {
       Rectangle rectangle = new Rectangle(x, y, width, height);
       rectangle.setFill(null);  // Outlines
       rectangle.setStroke(Color.RED);
       
       p.getChildren().addAll(rectangle); // Adds new rectangle to pane
     
        // Recursiveness stops once the rectangles have rotated 360 degress  
        if(rot <= 90) {
            rectangle.setRotate(rot);
            rectangle.setScaleX(scaleX);
            rectangle.setScaleY(scaleY);
            drawRectangles(p, x, y, width, height, rot + 10, scaleX - 0.10, scaleY - 0.10);}
   }
   
  // Recursive method to drow a logo.
  public void drawRectanglesMath(Pane p, int x, int y, double width, double height, double rot, double scaleX, double scaleY)
   {
       Rectangle rectangle = new Rectangle(x, y, width, height);
       rectangle.setFill(null);  // Outlines
       rectangle.setStroke(Color.YELLOW);
       
       p.getChildren().addAll(rectangle); // Adds new rectangle to pane
     
        // Recursiveness stops once the rectangles have rotated 360 degress  
        if(rot <= 90) {
            rectangle.setRotate(rot);
            rectangle.setScaleX(scaleX);
            rectangle.setScaleY(scaleY);
            drawRectangles(p, x, y, width, height, rot + 10, scaleX - 0.10, scaleY - 0.10);}
   }
   
   
   
   
   
   
   
   // (15 POINTS) (Chapter 11 or Chapter 16) Saving information via Serialization or Databases 
   /*
    * Event handler class for save button
    */
    
   class SaveButtonHandler implements EventHandler<ActionEvent>
   {
      @Override
      public void handle(ActionEvent event)
      {
                  
                  try
                  { 
                     
                     // Create a connection to the database.
                     Connection conn =
                            DriverManager.getConnection(DB_URL);
                     
                     // If the DB already exists, drop the tables.       
                     dropTable(conn);
            					 
            			// Build the tableCSS table.
            			courseCSS(conn);
            			
            			// Build the tableMath table.
            			courseMath(conn);
                     
                     conn.close();
                  }
                  
                  
                  
                  
                  // (5 POINTS) (Chapter 11)  Use of Exceptions 
                  catch (Exception ex)
                  {
                     System.out.println("ERROR: " + ex.getMessage());
                  } 
      }// End of Handle
               
                  
            	
            	 // The dropTables method drops any existing
            	 // in case the database already exists.
            	 
                  
               	public void dropTable(Connection conn)
               	{
               		
               		try
               		{
               			// Get a Statement object.
               			Statement stmt  = conn.createStatement();
                        
                        try
               			{
               	         // Drop the tableCSS table.
               	         stmt.execute("DROP TABLE tableCSS");
               			}
               			catch(SQLException ex)
               			{
               				// No need to report an error.
               				// The table simply did not exist.
               			}
                        
                        
               			try
               			{
               	         // Drop the tableMath table.
               	         stmt.execute("DROP TABLE tableMath");
               			}
               			catch(SQLException ex)
               			{
               				// No need to report an error.
               				// The table simply did not exist.
               			} 
                        
               		}// End of main try
                     
                     
                     
                     
                     // (5 POINTS) (Chapter 11)  Use of Exceptions 
                     // End of main try method
                 		catch(SQLException ex)
               		{
               	      System.out.println("ERROR: " + ex.getMessage());
               			ex.printStackTrace();
               		}
               	}// End of drop method
                  
                  
	public void courseCSS(Connection conn)
	{
		try
		{
         
         // Get a Statement object.
         Statement stmt = conn.createStatement();
         
			// Create the table.
			stmt.execute("CREATE TABLE tableCSS (" +
   				       "Name CHAR(40), " +
                      "StudentID CHAR(14) NOT NULL PRIMARY KEY, " +
                      "Country CHAR(25)," +
                      "Age CHAR(15)" +
                      ")");
							 
			// Insert row #1.
			stmt.execute("INSERT INTO tableCSS VALUES ('" +
                      courseOneNew.getNam().get(0) + "'," +
                      "'1', '" +
                      courseOneNew.getCount().get(0) + "','" + 
                      courseOneNew.getAges().get(0) + "')");
                      
                      
         // Insert row #2.
			stmt.execute("INSERT INTO tableCSS VALUES ('" +
                      courseOneNew.getNam().get(1) + "'," +
                      "'2', '" +
                      courseOneNew.getCount().get(1) + "','" + 
                      courseOneNew.getAges().get(1) + "')");
		}
      
      
      
      // (5 POINTS) (Chapter 11)  Use of Exceptions 
		catch (SQLException ex)
      {
         System.out.println("You need click on the button to SUBMIT before you save" + ex.getMessage());
      }
      
	}// End of courseCSS method
   
   
   
   public void courseMath(Connection conn)
	{
		try
		{
         
         // Get a Statement object.
         Statement stmt = conn.createStatement();
         
			// Create the table.
			stmt.execute("CREATE TABLE tableMath (" +
   				       "Name CHAR(40), " +
                      "StudentID CHAR(14) NOT NULL PRIMARY KEY, " +
                      "Country CHAR(25)," +
                      "Age CHAR(15)" +
                      ")");
							 
			// Insert row #1.
			stmt.execute("INSERT INTO tableMath VALUES ('" +
                      courseTwoNew.getNam().get(0) + "'," +
                      "'1', '" +
                      courseTwoNew.getCount().get(0) + "','" + 
                      courseTwoNew.getAges().get(0) + "')");
                      
         // Insert row #2.
			stmt.execute("INSERT INTO tableMath VALUES ('" +
                      courseTwoNew.getNam().get(1) + "'," +
                      "'2', '" +
                      courseTwoNew.getCount().get(1) + "','" + 
                      courseTwoNew.getAges().get(1) + "')");

          
         			System.out.println("All tables were created.");
		}
		catch (SQLException ex)
      {
         System.out.println("You need click on the button to SUBMIT before you save" + ex.getMessage());
      }
	}// End of courseMath method */
   } //End of save Button
   
      
    
    
   
    /**
    * Event handler class for open button
    **/
    
   class OpenCSSButtonHandler implements EventHandler<ActionEvent>
   {
      @Override
      public void handle(ActionEvent event)
      { 
         if (course3.getValue().equals("New CSS Student ID 1"))
         { 
            try
            {
               // Create a connection to the database.
               Connection conn = DriverManager.getConnection(DB_URL2);
               
               // Create a Statement object.
               Statement stmt = conn.createStatement();
               
               // Create a string with a SELECT statement.
               String sqlStatement = 
                  "SELECT * FROM tableCSS WHERE StudentID = '1'";
               
               // Send the statement to the DBMS.
               ResultSet result = stmt.executeQuery(sqlStatement);
               
               // Display a header for the listing.
               System.out.println("CSS course ");
               System.out.println("Name                                    StudentID     Country                  Age ");
               System.out.println("---------------------------------------------------------------------------------------------");
               
               // Display the contents of the result set.
               // The result set will have three columns.
               while (result.next())
               {
                  System.out.println(result.getString("Name") + result.getString("StudentID") + result.getString("Country") + 
                                    result.getString("Age"));
               }
               
               // Close the connection.
               conn.close();
            }
            
            
            
            
            // (5 POINTS) (Chapter 11)  Use of Exceptions 
            catch(Exception ex)
            {
               System.out.println("ERROR: " + ex.getMessage());
            }
         }// End of if CSS 
         
         
         if (course3.getValue().equals("New CSS Student ID 2"))
         { 
            try
            {
               // Create a connection to the database.
               Connection conn = DriverManager.getConnection(DB_URL2);
               
               // Create a Statement object.
               Statement stmt = conn.createStatement();
               
               // Create a string with a SELECT statement.
               String sqlStatement = 
                  "SELECT * FROM tableCSS WHERE StudentID = '2'";
               
               // Send the statement to the DBMS.
               ResultSet result = stmt.executeQuery(sqlStatement);
               
               // Display a header for the listing.
               System.out.println("Name                                    StudentID     Country                  Age ");
               System.out.println("---------------------------------------------------------------------------------------------");
               
               // Display the contents of the result set.
               // The result set will have three columns.
               while (result.next())
               {
                  System.out.println(result.getString("Name") + result.getString("StudentID") + result.getString("Country") + 
                                    result.getString("Age"));
               }
               
               // Close the connection.
               conn.close();
            }
            
            
            
            // (5 POINTS) (Chapter 11)  Use of Exceptions 
            catch(Exception ex)
            {
               System.out.println("ERROR: " + ex.getMessage());
            }
         }// End of if 2 CSS 
      }// End of the method handle
   }// End of open button 
   
   
   class OpenMathButtonHandler implements EventHandler<ActionEvent>
   {
      @Override
      public void handle(ActionEvent event)
      { 
         if (courses4.getValue().equals("New Math Student ID 1"))
         { 
            try
            {
               // Create a connection to the database.
               Connection conn = DriverManager.getConnection(DB_URL2);
               
               // Create a Statement object.
               Statement stmtMath = conn.createStatement();
               
               // Create a string with a SELECT statement.
               String sqlStatementMath = 
                  "SELECT * FROM tableMath WHERE StudentID = '1'";
               
               // Send the statement to the DBMS.
               ResultSet resultMath = stmtMath.executeQuery(sqlStatementMath);
               
               // Display a header for the listing.
               System.out.println(" ");
               System.out.println("Math course ");
               System.out.println("Name                                    StudentID     Country                  Age ");
               System.out.println("---------------------------------------------------------------------------------------------");
               
               // Display the contents of the result set.
               // The result set will have three columns.
               while (resultMath.next())
               {
                  System.out.println(resultMath.getString("Name") + resultMath.getString("StudentID") + resultMath.getString("Country") + 
                                    resultMath.getString("Age"));
               }
               
               // Close the connection.
               conn.close();
            }
            catch(Exception ex)
            {
               System.out.println("ERROR: " + ex.getMessage());
            }
         }// End of if Math 
         
         if (courses4.getValue().equals("New Math Student ID 2"))
         { 
            try
            {
               // Create a connection to the database.
               Connection conn = DriverManager.getConnection(DB_URL2);
               
               // Create a Statement object.
               Statement stmtMath = conn.createStatement();
               
               // Create a string with a SELECT statement.
               String sqlStatementMath = 
                  "SELECT * FROM tableMath WHERE StudentID = '2'";
               
               // Send the statement to the DBMS.
               ResultSet resultMath = stmtMath.executeQuery(sqlStatementMath);
               
               // Display a header for the listing.
               System.out.println("Name                                    StudentID     Country                  Age ");
               System.out.println("---------------------------------------------------------------------------------------------");
               
               // Display the contents of the result set.
               // The result set will have three columns.
               while (resultMath.next())
               {
                  System.out.println(resultMath.getString("Name") + resultMath.getString("StudentID") + resultMath.getString("Country") + 
                                    resultMath.getString("Age"));
               }
               
               // Close the connection.
               conn.close();
            }
            catch(Exception ex)
            {
               System.out.println("ERROR: " + ex.getMessage());
            }
         }// End of if 2 Math 
      }// End of the method handle
   }// End of open MAth button */  
 
}
