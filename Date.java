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
//	   if(this.month>=13||this.month<=0||this.day>Month.DAYS_ODD||this.day<=0||this.year<0||this.year>10000) {
//		   return false;
//	   }
	   
	   if((this.month==Month.APR||this.month==Month.JUN||this.month==Month.SEP||this.month==Month.NOV)&&this.day<=Month.DAYS_EVEN) {
		  return true; 
	   }
		   
		  if((this.month==Month.JAN||this.month==Month.MAR||this.month==Month.MAY||this.month==Month.JUL||this.month==Month.AUG||this.month==Month.OCT||this.month==Month.DEC)&&this.day<=Month.DAYS_ODD) {
		   return true;
	   }
		  
		  boolean isALeapYear = isLeapYear(this.year);
		  if(this.month==Month.FEB) {
			  if(this.day<=Month.DAYS_FEB) {
				  return true;
			  }if((isALeapYear==true)&&(this.day==(Month.DAYS_FEB + 1))) {
				  return true;
			  }
			  
		  }
	   
	   
       return false;
   }
   
   
   /**
    Method to determine whether year is a leap year.
    Will use the rules of leap years to determine if leap year or not.
	@author Rizwan Chowdhury
	@param year Integer representing the year
	@return true if year is a leap year , false otherwise
    */
   private boolean isLeapYear(int year) {
	   
	   if((year % Month.QUADRENNIAL) == 0) {
		   if((year % Month.CENTENNIAL) == 0) {
			   if((year % Month.QUATERCENTENNIAL) == 0) {
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
   
   
   /**
    Testbed main for class Date, will test each method with test cases. 
    @param args Arguments passed into main of type String[]
    */
   public static void main(String[] args) {
	   
	   //test constructor using tostring, also tests toString()
	   Date dateTest = new Date("10/29/1998");
	   System.out.println(dateTest.toString()); //pass
	   
//	   //test constructor which takes a Date object as an argument; the cloning constructor
//	   //input: Date object created above. expected output: 10/29/1998
//	   Date dateTest2 = new Date(dateTest);
//	   System.out.println(dateTest2.toString()); //pass
//	   
//	   
//	   //test equals()
//	   //test equals method by passing two different object but same date, will use above two test cases
//	   //input: constructorTest 1 and 2. Expected output: true
//	   System.out.println(dateTest.equals(dateTest2)); //pass
//	   
//	   //test equals with with different type of object than date.
//	   //input: one Date object and one String object. output: false
//	   String testString = "10/29/1998";
//	   System.out.println(dateTest.equals(testString)); //pass
//	   
//	   //test equals with null object
//	   //input: one Date object and a null pointer. output:false
//	   System.out.println(dateTest.equals(null)); //pass
//	   
//	   //test equals() with null object of type Date
//	   //input: one Date object and one Date object that is null. expected output: false;
//	   Date nullDate = null;
//	   System.out.println(dateTest.equals(nullDate)); //pass
//	   
//	   // test equals() with two different dates
//	   // input: two different Date objects with different dates. expected output: false
//	   Date dateTestDifferentDate = new Date("10/15/1998");
//	   System.out.println(dateTest.equals(dateTestDifferentDate)); //pass
	   
	   
	   //test isValid()
	   // input: valid date, expected output: true. Will use already created dateTest since its a valid date
	   System.out.println(dateTest.isValid()); //pass
	   
	   //input: invalid date with month greater than 12 (13). expected output: false
	   Date invalidMonthDate = new Date("13/21/1999");
	   System.out.println(invalidMonthDate.isValid()); //pass
	   
	   //input: invalid date with day that is 31 for month with 30 days. expected output: false
	   Date invalidEvenMonthDate = new Date("4/31/2021");
	   System.out.println(invalidEvenMonthDate.isValid()); //pass
	   
	   //input: invalid leap year date, day 29 but year 2019. expected output: false
	   Date invalidLeapYearDate = new Date("2/29/2019");
	   System.out.println(invalidLeapYearDate.isValid()); //pass
	   
	   //input: valid leap year date. expected output: true
	   Date validLeapYearDate = new Date("2/29/2020");
	   System.out.println(validLeapYearDate.isValid()); //pass
	   
	   
	   //test isLeapYear()
	   // input: not a leap year. expected output: false
	   Date notALeapYear = new Date("1/1/1900");
	   System.out.println(notALeapYear.isLeapYear(1900)); //pass
	   
	   //input: a leap year. expected output: true
	   Date aLeapYear = new Date("1/1/2020");
	   System.out.println(aLeapYear.isLeapYear(2020)); //pass
	   
	   //test toString():
	   //input: date object with date 2/10/2020. Expected output: 2/20/2020
	   Date testToString = new Date("2/10/2020");
	   System.out.println(testToString.toString());
	   
	   
   }
   
}


