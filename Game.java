import java.util.*;

public class Game {
	
	// Scanner for user input
	static Scanner in = new Scanner(System.in);
	
	// Player Variables
	static int playerActionPts = 50;
	
	// Game Variables
	static boolean running = true;
	static int continuePlaying = 1;
	
	public static void main(String[] args) {
		
		// Welcome message
		System.out.println("HOW ARE YOU TODAY? ARE YOU READY TO PLAY?\n");
		
		START:

		// Loop to keep game running
		while (running) {
			
			// Loop to allow player to continue to play the game or quit
			while (continuePlaying > 0) {
				
				// Check to make sure player has enough AP to complete actions
				if (playerActionPts < 1) {
					System.out.println("You need more AP to do another action!\nWould you like to rest?\n");
					System.out.println("1. Yes.");
					System.out.println("2. No, I think I'm done for now.");
					
					// Get the player's selection for input
					int input = in.nextInt();
					
					// If the player chooses to rest
					if(input == 1) {
						takeARest();
					}
					// If the player chooses to quit
					else if(input == 2) {
						System.out.println("\nGREAT JOB TODAY!!!\nSEE YOU NEXT TIME!!!");
						continuePlaying = 0;
						running = false;
						break;
					}
					// If the player chooses an option that is not on the list
					else {
						System.out.println("\n### Invalid Input! ###\n");
						continue START;
					}
				}
				// If the player has enough AP, they can start doing actions
				else {	
					//Game prompts the player to choose an action
					System.out.println("Choose an activity or task to do: ");
					
					// List of actions for the player to choose from
					// If adding actions to the list, resting and quitting should always be in the final two slots of the string
					String[] actionOptions = {"1. Cooking", "2. Exercise", "3. Cleaning", "4. Entertainment", "5. Rest", "6. I think I'm done for now"};
					
					// Print out the actionOptions string
					for (String action : actionOptions) {
						System.out.println(action);
					}
					
					// Get the player's selection for input
					int actionInput = in.nextInt();
					
					// If the player chooses anything except resting or quitting
					if (actionInput < actionOptions.length - 1) {
						executeAction();
					}
					// If the player chooses to rest
					else if (actionInput < actionOptions.length) {
						takeARest();
					}
					// If the player chooses to quit
					else if (actionInput == actionOptions.length) {
						System.out.println("\nGREAT JOB TODAY!!!\nSEE YOU NEXT TIME!!!");
						continuePlaying = 0;
						running = false;
						break;
					}
					else {
						System.out.println("\n### Invalid Input! ###\n");
						continue START;
					}
					
					// Prompt the player to see if they want to continue
					System.out.println("Would you like to do another activity or task?\n");
					System.out.println("1. Yes!");
					System.out.println("2. I think I'm done for now.");

					// Get the player's selection for input
					actionInput = in.nextInt();
					
					// If the player chooses to continue
					if(actionInput == 1) {
						continuePlaying = 1;
						System.out.println();
					}
					// If the player chooses to quit
					else if(actionInput == 2) {
						System.out.println("\nGREAT JOB TODAY!!!\nSEE YOU NEXT TIME!!!");
						continuePlaying = 0;
						running = false;
					}
					else {
						System.out.println("\n### Invalid Input! ###\n");
					}
				}
				
				continue START;
				
			} // End continue playing loop
		} // The game stops running
	} // End main method
	
	// Method for executing an action
	public static void executeAction () {
		
		/* Passing two arguments:
		 * 1st argument should be greater than zero so the level checker can execute
		 * 2nd argument should be the player's current cooking level
		*/
		CookingAction.checkExpLevel(1, 1);
		
		// Decrease the player's AP by 10
		playerActionPts -= 10;
		System.out.println("Your AP has decreased to " + playerActionPts + "\n");

	} // End method executeAction
	
	// Method for taking a rest
	public static void takeARest() {
		
		// Increase the player's AP by 10
		playerActionPts += 10;
		System.out.println("\nYou feel rested and ready to do more activities\n");
		System.out.println("Your AP has increased to " + playerActionPts + "\n");
				
	} // End method takeARest
	
	// Method for leveling up skills
	public static void expLevelUp () {
		int curXP = 0;
		int level = 0;
		int reqXP = 0;
		int[] currentLevel = { 1, 2, 3, 4, 5, 6, 7};
		int[] requiredXP = { 0, 5, 10, 25, 50, 75, 100};
		public void levelUp() {
   			if (curXP == requiredXP[0]) {
    				level = currentLevel[0];
   			} else if (curXP == requiredXP[1]) {
        			level = currentLevel[1];
    			} else if (curXP == requiredXP[2]) {
        			level = currentLevel[2];
    			} else if (curXP == requiredXP[3]) {
        			level = currentLevel[3];
    			} else if (curXP == requiredXP[4]) {
        			level = currentLevel[4];
    			} else if (curXP == requiredXP[5]) {
        			level = currentLevel[5];
    			} else if (curXP == requiredXP[6]) {
        			level = currentLevel[6];
    			} else if (curXP == requiredXP[7]) {
        			level = currentLevel[7];
		}
		public void levelUpXp() {
   			if (level == currentLevel[0]) {
       				reqXP = requiredXP[0];
   			} else if (level == currentLevel[1]) {
        			reqXP = requiredXP[1];
   			} else if (level == currentLevel[2]) {
        			reqXP = requiredXP[2];
    			} else if (level == currentLevel[3]) {
    				reqXP = requiredXP[3];
    			} else if (level == currentLevel[4]) {
        			reqXP = requiredXP[4];
    			} else if (level == currentLevel[5]) {
        			reqXP = requiredXP[5];
    			} else if (level == currentLevel[6]) {
       				reqXP = requiredXP[6];
   			} else if (level == currentLevel[7]) {
        			reqXP = requiredXP[7];
		}

	} // End expLevelUp method
	
	// Method for tracking points
	public static void pointTracker () {
		
	} // End pointTracker method
} // End Game class
