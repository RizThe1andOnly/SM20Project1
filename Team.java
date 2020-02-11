/**
  
 @author  Tin Fung
 */
public class Team 
{
   private final int NOT_FOUND = -1;
   private final int GROW_SIZE = 4; //initial and grow size
   private TeamMember [] team;
   private int numMembers;
   
   public Team()
   {
	   this.team= new TeamMember[4];
	   int numMembers=0;
	   
      //this is the default constructor
   }
   
   private int find(TeamMember m)
   {
	   for(int i=0;i<team.length;i++) {
		   if(m.equals(team[i])) {
			   return i;
		   }
	   }
	   
       return NOT_FOUND;
   }
   
   private void grow()
   {
	   TeamMember [] temp=new TeamMember[this.numMembers+GROW_SIZE];
	   for(int i=0;i<this.numMembers;i++) {
		   temp[i]=this.team[i];
	   }
	   this.team=temp;
       
   }
   
   public boolean isEmpty()
   {if(this.numMembers==0||this.team==null) {
	   return true;
   }
       return false;
   }
   
   public void add(TeamMember m)
   {
	   if(numMembers==this.team.length) {
		   this.grow();
	   }
	   this.team[this.numMembers]=m;
		   
            this.numMembers++;
   }
   
   public boolean remove(TeamMember m)
   {
	  int temp= this.find(m);
	   if(temp!=-1) {
		   this.team[temp]=this.team[this.numMembers-1];
		   this.team[this.numMembers]=null;
		   this.numMembers--;
		   return true;
		   
	   }

	   
       return false;
   } 
   
   public boolean contains(TeamMember m)
   {
	   if(find(m)!=-1) {
		   return true;
	   }
	   return false;
      
   } 
   
   public void print()
   {
	   for(int i=0;i<this.numMembers;i++) {
		   System.out.println(this.team[i].toString());
	   }
      //set up a for loop and call the toString() method
   } 
}
