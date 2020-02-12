/**
 Class representing each member of the Team, each member is defined by their name and day of joining team.
 TeamMember class contains methods to return the date of joining, checking if two TeamMember are the same, and 
 returning string representation of each member.
 
 @author Rizwan Chowdhury  
 */
public class TeamMember 
{
   private String name;
   private Date   startDate;
   
   /**
    Class constructor for the TeamMember object, requires both a name and a date.
    @author Rizwan Chowdhury
    @param nm    Name of the team member in String form
    @param date  Date when the team member joined, must be a Date object 
    */
   public TeamMember(String nm, Date date)
   {
       this.name = nm;
       this.startDate = date;
   }
   
   
   /**
    Returns the start date of the team member, more specifically of the TeamMember object calling this method.
    Returns a clone of the Date object held in this class.
    @return Date Date object representing the date the team member joined the team.
    */
   public Date getStartDate()
   {
      Date clonedDate = new Date(this.startDate); //cloning the date object
      return clonedDate;
   }
   
   
   /**
    Checks to see if two TeamMember objects represent the same person.
    Same person is defined by having the same name and start date.
    Comparison is done by checking the equality of string type name field and the.
    Date type date field of each TeamMember of object.
    
    @author Rizwan Chowdhury
    @param obj TeamMember object to be compared to the object calling this method
    @return true if two objects are equal, false otherwise
    */
   @Override
   public boolean equals(Object obj)
   {
      //name and startDate must be the same
	   
	   //checks if null
	   if(obj == null) {
		   return false;
	   }
	  
	  //check if obj is of type TeamMember
	  if(!(obj instanceof TeamMember)) {
		  return false;
	  }
	  
	  //checks if this is the same object with the same reference
	  if(obj == this) {
		  return true;
	  }
	  
	  //create TeamMember obj for target member (member passed in through argument)
	  TeamMember targetMember = (TeamMember) obj;
	  
	  //check for name equality through string.equals():
	  if(!(this.name.equals(targetMember.name))) {
		  return false;
	  }
	  
	  //check for date equality
	  if(!(this.startDate.equals(targetMember.startDate))) {
		  return false;
	  }
	  
	  //at this point target member's name and date equals calling member's so they are equal
	  return true;
   }  
   
   /**
    Returns string representation of the TeamMember object, including member's name and start date.
    Has format name + " " + startDate
    @author Rizwan Chowdhury
    @return String string representation of the TeamMember object
    */
   @Override
   public String toString()
   {
       //name + " " + startDate;
	   
	   String name = this.name;
	   String date = this.startDate.toString();
	   String stringRepOfMember = name + " " + date;
	   return stringRepOfMember;
   }

   public static void main(String [] args)
   {
      //testbed main; you must include test cases that exercise 
      //the constructor and all methods in this class.
	   
	   
   }
}