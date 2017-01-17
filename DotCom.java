import java.util.*;

public class DotCom
{	
	//DotCom's instance variables
	private ArrayList<String> locationCells;
	private String name;

	//Random location is provided by GameHelper placeDotCom() method
	public void setLocationCells(ArrayList<String> loc)
	{
		locationCells = loc;
	}
	//Basic setter name
	public void setName(String n)
	{
		name = n;
	}


	public String checkYourself(String userInput)
	{
		String  result = "miss";
		int index = locationCells.indexOf(userInput);
		if(index>=0)
		{
			locationCells.remove(index);
			if(locationCells.isEmpty())
			{
				result = "kill";
				//Tell user when the DotCom has been sunk
				System.out.println("Ouch! You sunk" + kill + " : ()");
			}
			else
			{
				result = "hit";
			}
		}
	return result;
	}
}