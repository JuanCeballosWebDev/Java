/*
Super Class to create and ArrayList of names and return it.
*/
import java.util.ArrayList;

public class StudentFinal 
{
   // ArrayList
   private ArrayList<String> names;
   
   // Constructor
   public StudentFinal(ArrayList<String> arrayL)
   {
      names = arrayL;
   }
   
   // Getter
   public ArrayList<String> getStudentNames()
   {
      return names;
   }
}