// Class to store detailed information in ArrayLists about students and return them.

import java.util.ArrayList;


// (5 POINTS) (Chapter 10) Use of Inheritance
public class StudentsDetailsFinal extends StudentFinal
{
   private String name;
   private ArrayList<String> newAge;
   private String age;
   private String country;
   private ArrayList<String> ageList;
   private ArrayList<String> countries;
   private ArrayList<String> nameList;
   
   
   // (20 POINTS) (Chapter 6 and 8) Use of Classes and Objects, Use two constructors.
   // Constructors 
   public StudentsDetailsFinal (ArrayList<String> ag, ArrayList<String> coun, ArrayList<String> nam)
   {
     super(nam);
     ageList = ag;
     countries = coun;
   }
   
   public StudentsDetailsFinal (ArrayList<String> nam)
   {
     super(nam);
     name = "";
     country = "";
     age = "";
     countries = new ArrayList<String>();
     ageList = new ArrayList<String>();
   }
   
   
   
   // Setters
   public void setName(String n)
   {
      name = n;
      getStudentNames().add(name);
   }
   
   
   public void setCountry(String c)
   {
      country = c;
      countries.add(country);
   }
   
   public void setAge(String a)
   {
      age = a;
      ageList.add(age);
   } 
   
   
   
   // Getters
   public ArrayList<String> getCountries()
   {
      return countries;
   }
  
   public ArrayList<String> getAge()
   {
      return ageList;  
   }
}