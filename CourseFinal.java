/*
Class to create courses and that gives the option to the user to include more students in each course. It also returns several ArrayLists with all 
the details for each of the participants.
*/

import java.util.ArrayList;

public class CourseFinal
{
   // Variables
   private String courseName;
   private StudentsDetailsFinal students;
   private String country;
   private String age;
   private ArrayList<String> namesCSS;
   private String name;

   
   // Constructor
   public CourseFinal(StudentsDetailsFinal s)
   {
      students = s;
      country = "";
      age = "";
      name = "";
      namesCSS = new ArrayList<String>();
   }
   
   // Setters
   public void setNames(String n)
   {
         name = n;
         namesCSS.add(name);
   }
   
   public void setCountrys(String c)
   {
      country = c;
      students.getCountries().add(country);
   }
   
   public void setAges(String a)
   {
      age = a;
      students.getAge().add(age);
   }

   
   // Getters
   public ArrayList<String> getNames()
   {
      return students.getStudentNames();
   }
   
   public ArrayList<String> getCount()
   {
      return students.getCountries();
   }
   
   public  ArrayList<String> getAges()
   {
      return students.getAge();
   }
   
   public  ArrayList<String> getNam()
   {
      return namesCSS;
   }
}