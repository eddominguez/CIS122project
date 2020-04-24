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
					// If the player chooses quit
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
					// If adding actions to the list, resting and quitting should always be in the final two slots
					String[] actionOptions = {"1. Cooking", "2. Exercise", "3. Cleaning", "4. Entertainment", "5. Rest", "6. I think I'm done for now"};
					
					// Print out the actionOptions string
					for (String action : actionOptions) {
						System.out.println(action);
					}
					
					// Get the player's selection for input
					int actionInput = in.nextInt();
					
					// If the player chooses anything but resting or quitting
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
					
					if(actionInput == 1) {
						continuePlaying = 1;
						System.out.println();
					}
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
		
		System.out.println("\n!!!!!! Method executeAction is running !!!!!!\n");
		
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
	public static int expLevelUp (int expLevel) {
		int levelUp = 0;
		if(expLevel == 50) {
			levelUp++;
			return levelUp;
		}
		else {
			return 0;
		}	
	} // End expLevelUp method
	
	// Method for tracking points
	public static void pointTracker () {
		
	}
  
  	// Method for doing the cooking action
	public static void doCookingAction () {
		
		int activityCooking = 1;
		
		// Player Variables
		int cookingExperiencePts = 0;
		int playerCookingExpLevel = 2;
		
		// Level 1 cooking actions/skills
		String[] cookingLevel1 = {"Toast", "Cereal", "Fruit"};
		int[] cookingLevel1ExpEarned = {10, 8, 5};
		
		// Level 2 cooking actions/skills
		String[] cookingLevel2 = {"Sandwich", "Grilled Cheese", "Salad"};
		int sandwichExpEarned = 11;
		int grilledcheeseExpEarned = 20;
		int saladExpEarned = 15;
		
		// Level 3 cooking actions/skills
		String[] cookingLevel3 = {"Omelette", "Lasagna", "Pasta"};
		int omeletteExpEarned = 22;
		int lasagnaExpEarned = 30;
		int pastaExpEarned = 24;
		
		// Level 4 cooking actions/skills
		String[] cookingLevel4 = {"BBQ", "Meatloaf", "Beef Vegetable Stew"};
		int bbqExpEarned = 40;
		int meatloafExpEarned = 36;
		int beefvegetablestewExpEarned = 32;
		
		while (activityCooking > 0) {
			
			if(playerCookingExpLevel == 1) {
				// Prompt the player to choose what to cook
				System.out.println("\nChoose something to cook: ");
				
				// Loop to list out the cookingLevel1 array
				for(int i = 0; i < cookingLevel1.length; i ++) {
					System.out.println((i + 1) + ". " + cookingLevel1[i]);
				}
			}
		}
		
		/*
		while (activityCooking > 0) {
			
			// Check the player's cooking experience level
			if(playerCookingExpLevel == 1) {
				
				// Prompt the player to choose what to cook
				System.out.println("\nChoose something to cook: ");
				
				// Loop to list out the cookingLevel1 array
				for(int i = 0; i < cookingLevel1.length; i ++) {
					System.out.println((i + 1) + ". " + cookingLevel1[i]);
				}
			}
			else if(playerCookingExpLevel == 2) {
				
				// Prompt the player to choose what to cook
				System.out.println("\nChoose something to cook: ");
				
				// Loop to list out the cookingLevel2 array
				for(int i = 0; i < cookingLevel2.length; i ++) {
					System.out.println((i + 1) + ". " + cookingLevel2[i]);
				}
			}
			else if(playerCookingExpLevel <= 3) {
				
				// Prompt the player to choose what to cook
				System.out.println("\nChoose something to cook: ");
				
				// Loop to list out the cookingLevel3 array
				for(int i = 0; i < cookingLevel3.length; i ++) {
					System.out.println((i + 1) + ". " + cookingLevel3[i]);
				}
			}
			else if(playerCookingExpLevel == 4) {
				
				// Prompt the player to choose what to cook
				System.out.println("\nChoose something to cook: ");
				
				// Loop to list out the cookingLevel4 array
				for(int i = 0; i < cookingLevel4.length; i ++) {
					System.out.println((i + 1) + ". " + cookingLevel4[i]);
				}
			}
			
			// Get the player's selection for input
			String input = in.nextLine();
			
			// If the player chooses option 1
			if(input.equals("1")) {
				System.out.println("\nYou decide to cook toast\n");
				
				// Subtract AP from player
				playerActionPts -= 10;
				System.out.println("Your AP has decreased to " + playerActionPts + "\n");
				
				// Add toast experience to total cooking experience
				cookingExperiencePts += toastExpEarned;
				System.out.println("Your cooking experience has increased to " + cookingExperiencePts + "\n");
				activityCooking = 0;
			}
			// If the player chooses option 2
			else if(input.equals("2")) {
				System.out.println("\nYou decide to cook cereal\n");
				
				// Subtract AP from player
				playerActionPts -= 10;
				System.out.println("Your AP has decreased to " + playerActionPts + "\n");
				
				// Add cereal experience to total cooking experience
				cookingExperiencePts += cerealExpEarned;
				System.out.println("Your cooking experience has increased to " + cookingExperiencePts + "\n");
				activityCooking = 0;
			}
			// If the player chooses option 3
			else if(input.equals("3")) {
				System.out.println("\nYou decide to cook fruit\n");
				
				// Subtract AP from player
				playerActionPts -= 10;
				System.out.println("Your AP has decreased to " + playerActionPts + "\n");
				
				// Add fruit experience to total cooking experience
				cookingExperiencePts += fruitExpEarned;
				System.out.println("Your cooking experience has increased to " + cookingExperiencePts + "\n");
				activityCooking = 0;
			}
			// If the player enters an option not on the list
			else {
				System.out.println("\nInvalid Input");
				activityCooking = 1;
			}
		} // Loop ends when player is done cooking something
		*/
	}// End method doCookingAction
	
	// Method for doing the exercise action
		public static void doExerciseAction () {
			
			int activityExercise = 1;
			
			// Player Variables
			int exerciseExperiencePts = 0;
			int playerExerciseExpLevel = 1;
			
			// Level 1 exercise actions/skills
			String[] exerciseLevel1 = {"Full-Body Stretching", "Walking", "Jogging"};
			int fullbodystretchingExpEarned = 10;
			int walkingExpEarned = 8;
			int joggingExpEarned = 5;
			
			// Level 2 exercise actions/skills
			String[] exerciseLevel2 = {"Bicycling", "Dancing", "Light-Weight Training"};
			int bicyclingExpEarned = 11;
			int dancingExpEarned = 20;
			int lightweighttrainingExpEarned = 15;
			
			// Level 3 exercise actions/skills
			String[] exerciseLevel3 = {"Plank", "Aerobic", "Squat"};
			int plankExpEarned = 22;
			int aerobicExpEarned = 30;
			int squatExpEarned = 24;
			
			// Level 4 exercise actions/skills
			String[] exerciseLevel4 = {"Push-up", "Squat With Dumbbell", "Dumbbell Curles and Presses"};
			int pushupExpEarned = 40;
			int squatwithdumbbellExpEarned = 36;
			int dumbbellcurlspressesExpEarned = 32;
			
			/*
			while (activityExercise > 0) {
				
				// Check the player's exercise experience level
				if(playerExerciseExpLevel == 1) {
					
					// Prompt the player to choose an exercise
					System.out.println("\nChoose how you want to exercise: ");
					
					// Loop to list out the exerciseLevel1 array
					for(int i = 0; i < exerciseLevel1.length; i ++) {
						System.out.println((i + 1) + ". " + exerciseLevel1[i]);
					}
				}
				else if(playerExerciseExpLevel == 2) {
					
					// Prompt the player to choose an exercise
					System.out.println("\nChoose how you want to exercise: ");
					
					// Loop to list out the exerciseLevel2 array
					for(int i = 0; i < exerciseLevel2.length; i ++) {
						System.out.println((i + 1) + ". " + exerciseLevel2[i]);
					}
				}
				else if(playerExerciseExpLevel <= 3) {
					
					// Prompt the player to choose an exercise
					System.out.println("\nChoose how you want to exercise: ");
					
					// Loop to list out the exerciseLevel3 array
					for(int i = 0; i < exerciseLevel3.length; i ++) {
						System.out.println((i + 1) + ". " + exerciseLevel3[i]);
					}
				}
				else if(playerExerciseExpLevel == 4) {
					
					// Prompt the player to choose an exercise
					System.out.println("\nChoose how you want to exercise: ");
					
					// Loop to list out the exerciseLevel4 array
					for(int i = 0; i < exerciseLevel4.length; i ++) {
						System.out.println((i + 1) + ". " + exerciseLevel4[i]);
					}
				}
				
				// Get the player's selection for input
				String input = in.nextLine();
				
				if(input.equals("1")) {
					System.out.println("\nYou decide to do push-ups\n");
					
					// Subtract AP from player
					playerActionPts -= 10;
					System.out.println("Your AP has decreased to " + playerActionPts + "\n");
					
					// Add push-ups experience earned to total exercise experience
					exerciseExperiencePts += joggingExpEarned;
					System.out.println("Your exercise experience has increased to " + exerciseExperiencePts + "\n");
					activityExercise = 0;
				}
				else if(input.equals("2")) {
					System.out.println("\nYou decide to go running\n");
					
					// Subtract AP from player
					playerActionPts -= 10;
					System.out.println("Your AP has decreased to " + playerActionPts + "\n");
					
					// Add running experience earned to total exercise experience
					exerciseExperiencePts += joggingExpEarned;
					System.out.println("Your exercise experience has increased to " + exerciseExperiencePts + "\n");
					activityExercise = 0;
				}
				else if(input.equals("3")) {
					System.out.println("\nYou decide to do jumping jacks\n");
					
					// Subtract AP from player
					playerActionPts -= 10;
					System.out.println("Your AP has decreased to " + playerActionPts + "\n");
					
					// Add jumping jacks experience earned to total exercise experience
					exerciseExperiencePts += joggingExpEarned;
					System.out.println("Your exercise experience has increased to " + exerciseExperiencePts + "\n");
					activityExercise = 0;
				}
				else {
					System.out.println("\nInvalid Input");
					activityExercise = 1;
				}
			} // Loop ends when player is done exercising
			*/
	}// End method doExcerciseAction
} // End Game class
