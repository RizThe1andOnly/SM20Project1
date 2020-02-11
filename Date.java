import java.util.StringTokenizer;

/**
  
 @author  Tin Fung
 */
public class Date 
{
   private int  day;
   private int  month;
   private int  year;
   
   public Date(String d)
   {
	   StringTokenizer st = new StringTokenizer(d,"/");
			   month=Integer.parseInt(st.nextToken());
			   day=Integer.parseInt(st.nextToken());
			   year=Integer.parseInt(st.nextToken());
	     
      //use StringTokenizer to parse the String and create a Date object     
   }
   
   public Date(Date d)
   {
	   this.day=d.day;
	   this.month=d.month;
	   this.year=d.year;
			   
			 
			 
      //this is a constructor
   }      
   
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
		  if(this.month==Month.FEB) {
			  if(this.day<29) {
				  return true;
			  }if(this.year%4==0&&this.day<=29) {
				  return true;
			  }
			  
		  }
	   
	   
       return false;
   }
   
   @Override
   public String toString()
   {
	   return month+"/"+day+"/"+year;
       //use the format "month/day/year"
   }
   
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


