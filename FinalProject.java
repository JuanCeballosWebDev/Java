/*
You will be designing and creating a GUI-based "Course Administration System".  

Design and create a GUI interface that allows you (think of yourself as a Course Administrator)  to INPUT information for Courses and Students 
taking each course.  You may want to create  Student and Course classes to save this info and then have a way to OUTPUT all this information in 
another section of the GUI window when the user selects a particular course and wants to see the students in the course.

Hints:  Make at least 3 instance variables (student characteristics like name,…), at least 2 constructors (1 should be a no-arg constructor), 
set and get methods. Maybe each course/class has an array of students that are in that class. Make sure to save the information you input into an 
external file or a database (Note: If you are saving to a database, ONLY use built-in Java Apache Derby  database system as demonstrated in book!!).

You can code this project using your own design but make sure to use the grading rubric I have attached as a checklist to guide you to insure that 
you include all the necessary pieces to earn a good grade.

Do your OWN original work.  No teamwork. No Tutoring from the Tutoring Center.  Plagiarism is forbidden and bad for your grade!

Submit your working program .java files here on Blackboard for credit.

You will be graded on how complete and how much work it looks like you put into the project.


1.	(20 POINTS) (Chapter 6 and 8) Use of Classes and Objects 
2.	(10 POINTS) (Chapter 7)  Use of Arrays /ArrayLists
3.	(5 POINTS) (Chapter 9) Use of Text Processing – hint: maybe use String or Character methods to validate input OR let user type in part of a 
   name and you provide a list of everyone that matches that string (page 567); if you have other ideas, that is great as well !
4.	(5 POINTS) (Chapter 10) Use of Inheritance– hint:  maybe “graduate” or ”visiting” student could be a subclass 
5.	(5 POINTS) (Chapter 11)  Use of Exceptions – hint: maybe validate input
6.	(25 POINTS) (Chapter 12, 13, 14) Use of GUI    -- SPECIAL NOTE : (JavaFX only just like book!  -  no Swing and no use of drag and drop editors 
   from Eclipse/Netbeans – no FXML) 
7.	(5 POINTS) (Chapter 15) Use of Recursion– hint: maybe a recursive binary search to find a student in list
8.	 (15 POINTS) (Chapter 11 or Chapter 16) Saving information via Serialization or Databases after you close your application so you can read it 
   back in when you start up your application the next time – we call this “persistent” data: 
9.	(10 POINTS)  Good Design – Does it pass the Usability Test? – hint: I know how to use your application without needing a manual or having to look at the source code!
1.	(20 POINTS) (Chapter 6 and 8) Use of Classes and Objects 
2.	(10 POINTS) (Chapter 7)  Use of Arrays /ArrayLists
3.	(5 POINTS) (Chapter 9) Use of Text Processing – hint: maybe use String or Character methods to validate input OR let user type in part of a name and you provide a list of everyone that matches that string (page 567); if you have other ideas, that is great as well !
4.	(5 POINTS) (Chapter 10) Use of Inheritance– hint:  maybe “graduate” or ”visiting” student could be a subclass 
5.	(5 POINTS) (Chapter 11)  Use of Exceptions – hint: maybe validate input
6.	(25 POINTS) (Chapter 12, 13, 14) Use of GUI    -- SPECIAL NOTE : (JavaFX only just like book!  -  no Swing and no use of drag and drop editors from Eclipse/Netbeans – no FXML) 
7.	(5 POINTS) (Chapter 15) Use of Recursion– hint: maybe a recursive binary search to find a student in list
8.	 (15 POINTS) (Chapter 11 or Chapter 16) Saving information via Serialization or Databases after you close your application so you can read it back in when you start up your application the next time – we call this “persistent” data: 
9.	(10 POINTS)  Good Design – Does it pass the Usability Test? – hint: I know how to use your application without needing a manual or having to look at the source code!


Good Luck!
*/

// To import all that is needed from javaFX to run the program.
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.EventHandler; 
import javafx.event.ActionEvent;



public class FinalProject extends Application
{
   // Private objects to store the information enter by the user and to print out the information
   private TextField amountMeal;
   private TextField amountTipPercent;
   private TextField amountTaxPercent;
   private Label resultLabel;


   public static void main(String[] args)
   {
      // Launch the application.
      launch(args);
   }
   
   @Override
   public void start(Stage primaryStage)
   {
      // Creates the control objects that make reference to the Button, Label and TextField classes.
      Button calculations = new Button ("Calculate tip amount");
      Label messageMeal = new Label("Enter the food charge for the meal, do not include any symbols");
      Label messageTipPercent = new Label("Enter a percent tip without including the percentage symbol");
      Label messageTaxPercent = new Label("Enter a percent sales tax without including the percentage symbol");
      amountMeal = new TextField();
      amountTipPercent = new TextField();
      amountTaxPercent = new TextField();
      Label resultLabel = new Label();

      // Creates an event handler using an anonymous class
      calculations.setOnAction(new EventHandler<ActionEvent>()
      {
         @Override
         public void handle(ActionEvent event)
         {
            // To get all the information entered by the user.
            double mealCost = Double.parseDouble(amountMeal.getText());
            double tipPercent = Double.parseDouble(amountTipPercent.getText());
            double taxPercent = Double.parseDouble(amountTaxPercent.getText());
            
            // To make the calcualtions
            double tipTotal = mealCost * (tipPercent / 100);
            double taxTotal = mealCost * (taxPercen / 100);
            double total = mealCost + taxTotal + tipTotal;
            
            // Displays the results.
            resultLabel.setText("The price for the meal is: " + mealCost + ". Sale taxes is: " + taxTotal + ". The tip amount will be: " +
                                 tipTotal + ". The total is: " + total);
         }
      });
      
      // Create a GridPane.
      GridPane gridpane = new GridPane();
      
      // Adds the Label and TextField's objects to the layuot container GridPane.
      gridpane.add(messageMeal, 0, 0);     // Col 0, Row 0
      gridpane.add(amountMeal, 1, 0);     // Col 1, Row 0
      gridpane.add(messageTipPercent, 0, 1);   // Col 0, Row 1
      gridpane.add(amountTipPercent, 1, 1);   // Col 1, Row 1
      gridpane.add(messageTaxPercent, 0, 2);   // Col 0, Row 2
      gridpane.add(amountTaxPercent, 1, 2);   // Col 1, Row 2
      
      // Set the gap sizes.
      gridpane.setVgap(10);
      gridpane.setHgap(10);
      
      // Set the GridPane's padding.
      gridpane.setPadding(new Insets(30));
      
      // Creates a VBox container as a root node of the GridPane container and the Butoon control
      VBox vbox = new VBox(10, gridpane, resultLabel, calculations);
      
      // Set the VBox's padding.
      vbox.setPadding(new Insets(30));

      // Creates a Scene with VBox container.
      Scene scene = new Scene(vbox);
      
      // Set the scene's alignment to center. 
      vbox.setAlignment(Pos.CENTER);

      // Add the Scene to the Stage.
      primaryStage.setScene(scene);
      
      // Set the stage title.
      primaryStage.setTitle("Restaurant Calculator");
      
      // Show the window.
      primaryStage.show();
   }
}