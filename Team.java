/**
 Team class holds all of the TeamMembers in a team and provides functionalities for the team. This class
 keeps track of how many member are in each instance at all times. Team class allows for addition of new members and as 
 many members as wanted (as much as device storage allows). Also allows for removal of members.
 @author  Tin Fung
 @author Rizwan Chowdhury
 */
public class Team 
{
   private final int NOT_FOUND = -1;
   private final int GROW_SIZE = 4; //initial and grow size
   private TeamMember [] team;
   private int numMembers;
   
   
   /**
    Default constructor for Team object. Creates Team object initialized with means of holding TeamMember objects and 0 as
    the number of initial members.
    @author Tin Fung
    */
   public Team()
   {
	   this.team= new TeamMember[0];
	   int numMembers=0;
	   
      //this is the default constructor
   }
   
   
   /**
    Accepts a TeamMember object as argument and finds its index in the TeamMember array.
    @param m TeamMember object that is to be searched in the TeamMember array
    @return Index of the TeamMember object passed in as argument, -1 if is not in array.
    @author Tin Fung
    */
   private int find(TeamMember m)
   {
	   for(int i=0;i<team.length;i++) {
		   if(m.equals(team[i])) {
			   return i;
		   }
	   }
	   
       return NOT_FOUND;
   }
   
   
   /**
    Increases the size of team array when all empty slots have been filled. Increases size based on
    GROW_SIZE.
    @author Tin Fung
    */
   private void grow()
   {
	   TeamMember [] temp=new TeamMember[this.numMembers+GROW_SIZE];
	   for(int i=0;i<this.numMembers;i++) {
		   temp[i]=this.team[i];
	   }
	   this.team=temp;
       
   }
   
   
   /**
    Checks to see if the team array in Team object is empty; team is empty when there are no TeamMembers in team.
    @return true is team array is empty, false otherwise
    @author Tin Fung
    */
   public boolean isEmpty()
   {if(this.numMembers==0||this.team==null) {
	   return true;
   }
       return false;
   }
   
   
   /**
    Adds a new TeamMember to the team.
    Appends new TeamMember object to the end of the team array in the Team object calling this method.
    @param m TeamMember object to be added to the team (team array in Team object).
    @author Tin Fung
    */
   public void add(TeamMember m)
   {
	   if(this.numMembers==this.team.length||this.numMembers==0) {
		   this.grow();
	   }
	   this.team[this.numMembers]=m;
		   
            this.numMembers++;
   }
   
   
   /**
    Accepts a TeamMember as an argument and removes that member from the team, also reduces number of member by 1.
    Finds the TeamMember in the team array and removes it. 
    @param m TeamMember object to be removed from the team.
    @return true if the removal was successful, false if member was not in the team.
    @author Tin Fung
    @author Rizwan Chowdhury
    */
   public boolean remove(TeamMember m)
   {
	  int memberIndex = this.find(m);
	  if(memberIndex!=-1) {
		   this.team[memberIndex]=this.team[this.numMembers-1];
		   this.team[this.numMembers]=null;
		   this.numMembers--;
		   return true;   
	  }

	   
       return false;
   } 
   
   /**
    Checks to see if designated TeamMember is in the team, only checks if see if the member is in the team not where
    in the team array the member is.
    * @param m TeamMember obj
    * @return true if the TeamMember is in the team, false if not
    * @author Tin Fung
    */
   public boolean contains(TeamMember m)
   {
	   if(find(m)!=-1) {
		   return true;
	   }
	   return false;
      
   } 
   
   /**
    Prints all the team members in the team, one per line. Uses the TeamMember objects' toString method.
    @author Tin Fung
    */
   public void print()
   {
	   for(int i=0;i<this.numMembers;i++) {
		   System.out.println(this.team[i].toString());
	   }
      //set up a for loop and call the toString() method
   } 
}
