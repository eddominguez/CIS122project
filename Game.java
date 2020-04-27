import java.util.*;

public class Game {
	
	// Scanner for user input
	static Scanner in = new Scanner(System.in);
	
	// Player Variables
	static int playerActionPts = 50;
	
	// Game Variables
	static boolean running = true;
	static int continuePlaying = 1;
	
	// Array list to store all of the action options
	static List<String> actionOptions = new ArrayList<String>();
	
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
					String[] optionList = {"Cooking", "Exercise", "Cleaning", "Entertainment", "Rest", "I think I'm done for now"};
					
					// Make sure actionOptions list is clear before adding any items
					actionOptions.clear();
					
					// Add cookingLevel1 array to cookingOptions
					for (String options : optionList) {
						actionOptions.add(options);
					}
					
					// Loop to list out the cookingLevel1 array
					for(int i = 0; i < actionOptions.size(); i ++) {
						System.out.println((i + 1) + ". " + actionOptions.get(i));
					}
					
					// Get the player's selection for input
					int input = in.nextInt();
					
					// If the player chooses cooking
					if (input == actionOptions.indexOf("Cooking") + 1) {
						/* Passing two arguments:
						 * 1st argument should be greater than zero so the level checker can execute
						 * 2nd argument should be the player's current cooking level
						*/
						CookingAction.checkExpLevel(1);
						CookingAction.addCookingExp();
						CookingAction.cookingLevelUp();

						// Decrease the player's AP by 10
						playerActionPts -= 10;
						System.out.println("Your AP has decreased to " + playerActionPts + "\n");
					}
					// If the player chooses exercise
					else if (input == actionOptions.indexOf("Exercise") + 1) {
						/* Passing two arguments:
						 * 1st argument should be greater than zero so the level checker can execute
						 * 2nd argument should be the player's current cooking level
						*/
						ExerciseAction.checkExpLevel(1);
						ExerciseAction.addExerciseExp();
						ExerciseAction.exerciseLevelUp();

						// Decrease the player's AP by 10
						playerActionPts -= 10;
						System.out.println("Your AP has decreased to " + playerActionPts + "\n");
					}
					// If the player chooses cleaning
					else if (input == actionOptions.indexOf("Cleaning") + 1) {
						/* Passing two arguments:
						 * 1st argument should be greater than zero so the level checker can execute
						 * 2nd argument should be the player's current cooking level
						*/
						CleaningAction.checkExpLevel(1);
						CleaningAction.addCleaningExp();
						CleaningAction.cleaningLevelUp();

						// Decrease the player's AP by 10
						playerActionPts -= 10;
						System.out.println("Your AP has decreased to " + playerActionPts + "\n");
					}
					// If the player chooses entertainment
					else if (input == actionOptions.indexOf("Entertainment") + 1) {
						/* Passing two arguments:
						 * 1st argument should be greater than zero so the level checker can execute
						 * 2nd argument should be the player's current cooking level
						*/
						CookingAction.checkExpLevel(1);
						CookingAction.addCookingExp();
						CookingAction.cookingLevelUp();

						// Decrease the player's AP by 10
						playerActionPts -= 10;
						System.out.println("Your AP has decreased to " + playerActionPts + "\n");
					}
					else if (input == actionOptions.indexOf("Rest") + 1) {
						takeARest();
					}
					else if (input == actionOptions.indexOf("I think I'm done for now") + 1) {
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
					int actionInput = in.nextInt();
					
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
	
	// Method for taking a rest
	public static void takeARest() {
		
		// Increase the player's AP by 10
		playerActionPts += 10;
		System.out.println("\nYou feel rested and ready to do more activities\n");
		System.out.println("Your AP has increased to " + playerActionPts + "\n");
				
	} // End method takeARest
	
} // End Game class
