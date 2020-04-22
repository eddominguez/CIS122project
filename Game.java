import java.util.*;

public class Game {
  public static void main(String[] args) {
    
    Scanner in = new Scanner(System.in);
    
    // Action Variables
    int activityCooking = 1;
    String[] cooking = {"Toast", "Cereal", "Fruit"};
    int toastExpEarned = 10;
    int cerealExpEarned = 8;
    int fruitExpEarned = 5;
    
    int activityExercise = 1;
    String[] exercise = {"Push-ups", "Running", "Jumping Jacks"};
    int pushupsExpEarned = 15;
    int runningExpEarned = 20;
    int jumpingjacksExpEarned =7;
    
    // Player Variables
    int cookingExperiencePts = 0;
    int playerCookingExpLevel = 1;
    int exerciseExperiencePts = 0;
    int playerExercise = 1;
    
    boolean running = true;
    int continuePlaying = 1;
    
    // Loop to keep game running
    while (running) {
      
      // Loop to allow player to continue to play the game or quit
      while (continuePlaying > 0) {
        
        //Game starts by prompting the player to choose an action
        System.out.println("Choose an activity or task to do: ");
        System.out.println("1. Cooking");
        System.out.println("2. Exercise");
        
        // Get the player's selection for input
        String input = in.nextLine();
        
        // If the player chooses "cooking"
        if(input.equals("1")) {
          activityCooking = 1;
          
          while (activityCooking > 0) {
            
            // Prompt the player to choose what to cook
            System.out.println("\nChoose something to cook: ");
            
            // Loop to list out the cooking array
            for(int i = 0; i < cooking.length; i ++) {
              System.out.println((i + 1) + ". " + cooking[i]);
            }
            
            // Get the players selection for input
            input = in.nextLine():
            
            // If the player chooses option 1
            if(input.equals("1")) {
              System.out.println("\nYou decide to cook toast\n");
              
              // Add toast experience to total cooking experience
              cookingExperiencePts += toastExpEarned;
              System.out.println("Your cooking experience has increased to " + cookingExperiencePts + "\n";
              activityCooking = 0;
            }
            // If the player chooses option 2
            else if(input.equals("2")) {
              System.out.println("\nYou decide to cook cereal\n");
              
              // Add cereal experience to total cooking experience
              cookingExperiencePts += cerealExpEarned;
              System.out.println("Your cooking experience has increased to " + cookingExperiencePts + "\n";
              activityCooking = 0;
            }
            // If the player chooses option 3
            else if(input.equals("3")) {
              System.out.println("\nYou decide to cook fruit\n");
              
              // Add fruit experience to total cooking experience
              cookingExperiencePts += fruitExpEarned;
              System.out.println("Your cooking experience has increased to " + cookingExperiencePts + "\n";
              activityCooking = 0;
            }
            // If the player enters an option not on the list
            else {
              System.out.println("\nInvalid Input");
              activityCooking = 1;
            }
          } // Loop ends when player is done cooking something
        } // End cooking
        
        // If the player chooses "exercise"
        else if(input.equals("2")) {
          activityExercise = 1;
          
          while (activityExercise > 0) {
            
            // Prompt the player to choose how to exercise
            System.out.println("\nChoose how you want to exercise: ");
            
            // Loop to list out the exercise array
            for(int i = 0; i < exercise.length; i++) {
              System.out.println((i + 1) + ". " + exercise[i]);
            }
            
            // Get the player's selection for input
            input = in.nextLine();
            
            if(input.equals("1")) {
              System.out.println("\nYou decide to do push-ups\n");
              
              // Add push-ups experience earned to total exercise experience
              exerciseExperiencePts += pushupsExpEarned;
              System.out.println("Your exercise experience has increased to " + exerciseExperiencePts + "\n");
              activityExercise = 0;
            }
            else if(input.equals("2")) {
              System.out.println("\nYou decide to go running\n");
              
              // Add running experience earned to total exercise experience
              exerciseExperiencePts += runningExpEarned;
              System.out.println("Your exercise experience has increased to " + exerciseExperiencePts + "\n");
              activityExercise = 0;
            }
            else if(input.equals("2")) {
              System.out.println("\nYou decide to do jumping jacks\n");
              
              // Add jumping jacks experience earned to total exercise experience
              exerciseExperiencePts += jumpingjacksExpEarned;
              System.out.println("Your exercise experience has increased to " + exerciseExperiencePts + "\n");
              activityExercise = 0;
            }
            else {
              System.out.println("\nInvalid Input");
              activityExercise = 1;
            }
          } // Loop ends when player is done exercising
        } // End exercise
        
        // Prompt the player to see if they want to continue
        System.out.println("Would you like to do another activity or task?\n");
        System.out.println("1. Yes!");
        System.out.println("2. I think I'm done for now.");
                                 
        // Get the player's selection for input
        input = in.nextLine();
                                 
        if(input.equals("1")) {
          continuePlaying = 1;
          System.out.println();
        }
        else if(input.equals("2")) {
          continuePlaying = 0;
          running = false;
        }
        else {
          System.out.println("\nIvalid Input");
      }
    } // End Game
    
    System.out.println("\nGREAT JOB TODAY!!!\nSEE YOU NEXT TIME!!!");
                                 
  } // End main method
  
  // method for leveling up skills
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
} // End Game class
