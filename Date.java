import java.util.StringTokenizer;

/**
 Date class responsible for holding date of when members join. Holds the month, day, and year. Provides 
 functionality to validate the date, compare if two dates are the same, and print date as string.
 @author  Tin Fung
 @author Rizwan Chowdhury
 */
public class Date 
{
   private int  day;
   private int  month;
   private int  year;
   
   /**
    Constructor for the date object, converts string date into a Date object.
    Will parse the string, using '/' as delimiter to split input string into month, day, and year.
    @param d String containing the date, in form "mm/dd/yyyy"
    @author Tin Fung 
    */
   public Date(String d)
   {
	   StringTokenizer st = new StringTokenizer(d,"/");
			   month=Integer.parseInt(st.nextToken());
			   day=Integer.parseInt(st.nextToken());
			   year=Integer.parseInt(st.nextToken());
	     
      //use StringTokenizer to parse the String and create a Date object     
   }
   
   
   /**
    Constructor for date object, takes in another date object and creates new date object with equal attributes.
    Will set new objects attributes equal to the corresponding attributes in the argument object. 
    @param d Date object
    @author Tin Fung
    */
   public Date(Date d)
   {
	   this.day=d.day;
	   this.month=d.month;
	   this.year=d.year;
			   
			 
			 
      //this is a constructor
   }      
   
   
   /**
    Checks to see Date object contains a valid date
    @param none
    @return true if valid date else false
    @author Rizwan Chowdhury
    @author Tin Fung
    */
   public boolean isValid()
   {
	   if(this.month>=13||this.month<=0||this.day>31||this.day<=0||this.year<0||this.year>10000) {
		   return false;
	   }
	   if((this.month==Month.APR||this.month==Month.JUN||this.month==Month.SEP||this.month==Month.NOV)&&this.day<31) {
		  return true; 
	   }
		   
		  if((this.month==Month.JAN||this.month==Month.MAR||this.month==Month.MAY||this.month==Month.JUL||this.month==Month.AUG||this.month==Month.OCT||this.month==Month.DEC)&&this.day<=31) {
		   return true;
	   }
		  
		  boolean isThisALeapYear = isLeapYear(this.year);
		  if(this.month==Month.FEB) {
			  if(this.day<29) {
				  return true;
			  }if((isThisALeapYear==true)&&(this.day==29)) {
				  return true;
			  }
			  
		  }
	   
	   
       return false;
   }
   
   
   /**
    Method to determine whether year is a leap year.
    Will use the rules of leap years to determine if leap year or not.
    Rules are as follows:<br>
    Step 1. If the year is evenly divisible by 4, go to step 2. Otherwise, go to step 5.<br>
	Step 2. If the year is evenly divisible by 100, go to step 3. Otherwise, go to step 4.<br>
	Step 3. If the year is evenly divisible by 400, go to step 4. Otherwise, go to step 5.<br>
	Step 4. The year is a leap year.<br>
	Step 5. The year is not a leap year.
	
	@author Rizwan Chowdhury
	@param year Integer representing the year
	@return true if year is a leap year , false otherwise
    */
   private boolean isLeapYear(int year) {
	   
	   if((year % 4) == 0) {
		   if((year % 100) == 0) {
			   if((year % 400) == 0) {
				   return true;
			   }
			   else {
				   return false;
			   }
		   }
		   else {
			   return true;
		   }
	   }
	   else {
		   return false;
	   }
   }
   
   
   /**
    Returns string representation of the Date object, in format "month/day/year"
    @author Tin Fung
    @param none
    @return String string representation of the date object
    */
   @Override
   public String toString()
   {
	   return month+"/"+day+"/"+year;
       //use the format "month/day/year"
   }
   
   
   /**
    Checks if two date objects are equal, equality is based on having the same day, month, and year.
    @author Tin Fung
    @param obj object passed in, Date object is expected
    @return true is the object caling this method and the argument are equal, otherwise returns false
    */
   @Override
   public boolean equals(Object obj)
   { if (this == obj) {
       return true;
   } else if (obj == null) {
       return false;
   } else if (obj instanceof Date) {
	   Date d=(Date)obj;
	   return d.day==this.day&&d.month==this.month&&d.year==this.year;
	   
   }
   return false;
   }  
}


