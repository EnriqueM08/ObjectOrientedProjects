package hw2;

import warInterface.War;

/**
 * This class WarGame is the main method were the game will be ran and played.
 * Checks arguments to ensure they are entered properly.
 */
public class WarGame 
{
	private static War myWar;
	
	/**
	* Main method were the game will be ran and played.
	*/
    public static void main( String[] args )
    {	
    	int round = 0, totalRounds = 52;
    	if(checkArguments(args) == -1)
    		return;
    	
    	if(Integer.parseInt(args[0]) == 1) {
    		myWar = new WarVersionOne(2, Integer.parseInt(args[1]), 1);
    		totalRounds = Integer.parseInt(args[2]);
    	}
    	else if(Integer.parseInt(args[0]) == 2)
    		myWar = new WarVersionTwoAndThree(2, Integer.parseInt(args[1]), 2);
    	else if(Integer.parseInt(args[0]) == 3)
    		myWar = new WarVersionTwoAndThree(3, Integer.parseInt(args[1]), 3);
    	
        System.out.println("Hello let's play War!");
        boolean winner = false;
        
        while(winner != true && round < totalRounds) {
        	winner = myWar.playRound();
        	round++;
        }
        
        myWar.findWinner();
    }
    
    /**
	* Ensure arguments are properly input
	* @return int that is either -1 if invalid input or 0 if valid.
	*/
    public static int checkArguments(String args[]) {
       	if(args.length < 2) {
       		System.err.println("Not Enough Command Line Arguments");
       		return -1;
       	}
       	
       	try {
    		Integer.parseInt(args[0]);
    	}
    	catch (NumberFormatException e){
    		System.err.println("Argument 1 is not a valid number!");
    		return -1;
    	}
    	try {
    		Integer.parseInt(args[1]);
    	}
    	catch (NumberFormatException e){
    		System.err.println("Argument 2 is not a valid number!");
    		return -1;
    	}
    	
    	return 0;
    }
}
