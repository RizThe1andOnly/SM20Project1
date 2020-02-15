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

   
   
   /**
  	Method to help with testing cases that have to do with true/false; will accept
  	the result from test and the expected outcome and print "pass" if match
  	else will print fail.
  	@param testResult The result returned by method being tested
  	@param expected The expected return value, provided by programmer
      */
     private void booleanTest(boolean testResult, boolean expected ){

  		System.out.print("testResult: " + testResult + ", expected: " + expected + ", status: ");
  		if(testResult == expected){
  			System.out.println("pass");
  		}
  		else{
  			System.out.println("fail");
  		}
     }


     /**
  	Method to help with testing cases that have to do with Strings; will accept
  	the result from test and the expected outcome and print "pass" if match
  	else will print fail.
  	@param testResult
  	@param expected
      */
     private void stringTest(String testResult, String expected){
  	System.out.print("testResult: " + testResult + ", expected: " + expected + ", status: ");
  	   if(testResult.equals(expected)){
  		   System.out.println("pass");
  	   }
  	   else{
  		   System.out.println("fail");
  	   }
     }


   
   
   
   /**
    Testbed main for TeamMember class; will be used to test each method and constructor.
    @param args Of type of String[]
    */
   public static void main(String [] args)
   {
      //testbed main; you must include test cases that exercise 
      //the constructor and all methods in this class.
	   
	   //object for the use of booleanTest() and stringTest()
	   TeamMember resultVerifier = new TeamMember("",null);
	
	   //test booleanTest(). 
	   //Input: true and true, expected output: pass
	   resultVerifier.booleanTest(true, true);

	   //Input: false and true. expected output: fail
	   resultVerifier.booleanTest(false,true);

	  
	  //test the constructor and toString() methods:
	  //input: new TeamMember object with name Riz and date 2/13/2020
	  TeamMember testMember = new TeamMember("Riz",new Date("2/13/2020"));
	  resultVerifier.stringTest(testMember.toString(), "Riz 2/13/2020");
	  
	  
	  //test toString() method:
	  //input: "Tin 2/10/2020" as a TeamMember object. Expected output: Tin 2/10/2020
	  TeamMember testToString = new TeamMember("Tin", new Date("2/10/2020"));
	  resultVerifier.stringTest(testToString.toString(), "Tin 2/10/2020");
	  
	  
	  //Test equals()
	  //input: Two TeamMember objects, with different object addresses, but with same details. Expected output: true
	  TeamMember sameMemberTest  = new TeamMember("Riz",new Date("10/29/1998"));
	  TeamMember sameMemberTest2 = new TeamMember("Riz",new Date("10/29/1998"));
	  resultVerifier.booleanTest(sameMemberTest.equals(sameMemberTest2),true);
	  
	  //input: two different TeamMember objects. Riz 2/18/2020 and Tin 2/19/2020. Expected output: false
	  TeamMember differentMemberTest = new TeamMember("Riz", new Date("2/18/2020"));
	  TeamMember differentMemberTest2 = new TeamMember("Tin", new Date("2/19/2020"));
	  resultVerifier.booleanTest(differentMemberTest.equals(differentMemberTest2), false);
	  
	  //input: two TeamMember object with same name attribute but different dates. Expected output: false
	  TeamMember sameNameDiffDateTest = new TeamMember("Riz", new Date("2/18/2020"));
	  TeamMember sameNameDiffDateTest2 = new TeamMember("Riz", new Date("2/19/2020"));
	  resultVerifier.booleanTest(sameNameDiffDateTest.equals(sameNameDiffDateTest2),false);
	   
	  //input: two TeamMember objects with different name and same date. Expected output: false
	  TeamMember sameDateDiffName = new TeamMember("Riz", new Date("1/1/2011"));
	  TeamMember sameDateDiffName2 = new TeamMember("Tin", new Date("1/1/2011"));
	  resultVerifier.booleanTest(sameDateDiffName.equals(sameDateDiffName2), false);
	  
	  //input: one TeamMember object and one non-TeamMemeber object. Expected output: false
	  TeamMember tmObject = new TeamMember("Riz", new Date("2/2/2002"));
	  String stringObject = new String("Riz 2/2/2002");
	  resultVerifier.booleanTest(tmObject.equals(stringObject),false);
	  
	  //input: one TeamMember object and a null pointer. Expected output: false
	  TeamMember teamMemberObj = new TeamMember("Tin", new Date("2/2/2020"));
	  TeamMember nullMember = null;
	  resultVerifier.booleanTest(teamMemberObj.equals(nullMember),false);
	  
	  
	  //test getStartDate()
	  // input: Riz 1/3/2003. expected output: 1/3/2003
	  TeamMember testGetDate = new TeamMember("Riz",new Date("1/3/2003"));
	  Date testDate = testGetDate.getStartDate();
	  resultVerifier.stringTest(testDate.toString(),"1/3/2003");
	  
   }
}