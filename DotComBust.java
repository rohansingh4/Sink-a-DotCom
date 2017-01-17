import java.util.*;

public class DotComBust
{
	private GameHelper helper = new GameHelper();
	//ArrayList of DotCom objects.
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	private int numOfGuesses = 0;

	private void setUpGame();
	{	
		//Declaring three DotCom objects and assigning them a name
		DotCom one = new DotCom();
		one.setName("Ram.com");
		DotCom two = new DotCom();
		two.setName("Sita.com");
		DotCom three = new DotCom();
		three.setName("Laxman.com");

		//Adding them to ArrayList dotComsList
		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);

		System.out.println("Youe goal is to sink three dot coms.");
		System.out.println("Ram.com, Sita.com, Laxman.com are the three Dot Coms");
		System.out.println("Try to sink them all in fewest number of guesses.");
		
		for(DotCom dotComToSet : dotComsList) //repeat with each Dot Com in the list
		{	//Helper to tell location for DotCom in ArrayList
			ArrayList<String> newLocation = helper.placeDotCom(3);
			//To give the location got from helper
			dotComToSet.setLocationCells(newLocation);
		}		
	}
	
	private void startPlaying()
	{
		while(!dotComsList.isEmpty())
		{
			String userGuess = helper.getUserInput("Enter a guess");
			checkUserGuess(userGuess);
		}
		finishGame();
	}

	private void checkUserGuess(String userGuess)
	{
		numOfGuesses++;    //increments from 0
		String result = "miss";  //assumes it's a 'miss', unless told otherwise
		for (DotCom dotComToTest : dotComsList)
		{	
			//Looking for hit or kill
			result = dotComToTest.checkYourself(userGuess);
			if(result.equals("hit"))
			{
				break;
			}
			if(result.equals("kill"))
			{
				dotComsList.remove(dotComToTest);
				break;
			}
		}
		System.out.println(result);
	}
		//Tells user how he performed in the game.
		private void finishGame()
		{
			System.out.println("All Dot Coms are dead! Your stock is now worthless.");
			if(numOfGuesses<=18)
			{
				System.out.println("It only took you" + numOfGuesses + "guesses.");
				System.out.println("You got out before your options sank.");
			}
			else
			{
				System.out.println("Took you long enough" + numOfGuesses + "guesses.");
				System.out.println("Fish are dancing with your options");
			}
		}
		public static void main(String[] args)
		{
			DotComBust game = new DotComBust(); //create the game object
			game.setUpGame();    //game object to set up the game
			game.startPlaying);   //game object to start play loop and keep playing
		}
}