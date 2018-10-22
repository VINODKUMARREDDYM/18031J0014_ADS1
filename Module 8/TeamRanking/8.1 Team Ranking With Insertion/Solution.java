import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Team{
	String TeamName;
	int Wins;
	int Draws;
	int Losses;
	Team(String TeamName,int Wins,int Losses,int Draws)
	{
		this.TeamName=TeamName;
		this.Wins=Wins;
		this.Losses=Losses;
		this.Draws=Draws;
	}
}
public class Solution {
public static void main(String args[])
	{
	Scanner scan =new Scanner(System.in);
	ArrayList<Team> t=new ArrayList<Team>();
	while(scan.hasNext()) {
	String a =scan.nextLine();
		String b[]=a.split(",");
		t.add(new Team(b[0],Integer.parseInt(b[1]),Integer.parseInt(b[2]),Integer.parseInt(b[3])));
	}
	for(int i=0;i<t.size()-1;i++)
	{
		int min=i;
		for(int j=i+1;j<t.size();j++)
			if(compare(t.get(j),t.get(min)))
				min=j;
		Team temp=t.get(i);
		t.set(i,t.get(min));
		t.set(min, temp);
		
				
	}
	for(int i=0;i<t.size()-2;i++)
	{
		Team T2=t.get(i);
		System.out.print(T2.TeamName+",");
	}
	Team t1=t.get(t.size()-1);
	System.out.print(t1.TeamName);
			
}
	
		public static boolean compare(Team team,Team team2) {
			if(team.Wins==team2.Wins)
			{
				if(team.Losses==team2.Losses)
				{
					
					 if(team2.Draws<team2.Draws)
						return true;
					else 
						return false;
				}
				else if(team.Losses>team2.Losses)
				return true;
				else 
					return false;
			}
			else if(team.Wins>team2.Wins)
				return true;
			else
				return false;
		}
}



