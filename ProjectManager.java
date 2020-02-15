import java.util.Scanner;

/**
 Takes user input regarding the team and carries out team operations.
 Accepts inputs A-add, R-remove, P-print, Q-quit. Contains methods to carry out
 functionalities of each of the above commands. 
 @author  Rizwan Chowdhury
 @author  Tin Fung
 */
public class ProjectManager
{
   Scanner stdin;
   Team cs213;
   
   /**
    Scans the text input and either calls the input command's method or if bad command says so.
    @author Tin Fung
    @author Rizwan Chowdhury
    @param none
    @return void
 * @throws FileNotFoundException 
    */
   public void run()
   {
	  this.cs213 = new Team();
      stdin = new Scanner(System.in);
      boolean done = false;
      while ( !done )
      {
         String command = stdin.next();
         switch (command.charAt(0))  
         {   
            case 'A': add();
		      break; 
            case 'R': remove();
              break;
            case 'P': print();
              break;
            case 'Q': print();
                      System.out.println("The team is ready to go!");
                      done = true;
              break;
            default: if(command.length() > 1) {
            			
            	     }
            		 else {
            			 System.out.println("Command "+ "'" +command+ "'"+ " not supported!");
            		 }
                     
         }  
      }
      //write java code before you terminate the program
   } //run()
   
   
   /**
    Adds a new team member to team cs213 if said member is not already a part of cs213.
    @author Rizwan Chowdhury
    @author Tin Fung
    @param none
    @return void
    */
   private void add()
   {
      	//must check if the date is valid
	//must call the contains() method to check if a given 
	//team member is in the team already
	   
	   String newMemberName = stdin.next();
	   Date dateWhenJoin = new Date(stdin.next());
	   if(dateWhenJoin.isValid()) {
		   TeamMember newMember = new TeamMember(newMemberName,dateWhenJoin);
		   if(cs213.contains(newMember)) {
			   System.out.println(newMember.toString() + " is already in the team.");
			   return;
		   }
		   cs213.add(newMember);
		   System.out.println(newMemberName + " " + dateWhenJoin+ " has joined the team.");
	   }
	   else {
		   System.out.println(dateWhenJoin.toString() + " is not a valid date!");
	   }
   }
   
   
   /**
    Removes team member from team cs213 if said member is a part of cs213.
    @author Rizwan Chowdhury
    @author Tin Fung
    @param none
    @return void
    */
   private void remove()
   {
      //must check if the date is valid
	   String memberName = stdin.next();
	   Date date = new Date(stdin.next());
	   if(date.isValid()) {
		   TeamMember memberToBeRemoved = new TeamMember(memberName,date);
		   if(this.cs213.remove(memberToBeRemoved)==false) {
			   System.out.println(memberName+" "+ date +" is not a team member.");
		   }
		   else {
			   System.out.println(memberName + " " + date + " " + " has left the team.");
		   }
		   
	   }
	   
   }
   
   /**
    Prints all of the team members and the dates they joined. If there are no team members,
    prints a message saying so.
    @author Rizwan Chowhdury
    */
   private void print()
   {
      //must check if the team has 0 members.
	  // if there are no member in the team
	  if(this.cs213.isEmpty()) {
		  System.out.println("We have 0 team members!");
		  return;
	  }
	  
	  //if there are members in the team:
	  System.out.println("We have the following team members: ");
	  this.cs213.print();
	  System.out.println("-- end of the list --");
	   
   }
   
} //ProjectManager
