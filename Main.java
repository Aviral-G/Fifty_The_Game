import java.util.*;
import java.util.Scanner;
import java.lang.Math;
import java.text.*;
import java.util.Arrays;
class Main {
  public static void main(String[] args) {
    Scanner myScan = new Scanner(System.in);
    //creating the scanner
    welcomeMessage();
    // displaying the welcome message

    int[] diceRolledArrMain = new int [2];
    int humanScore=0;
    int computerScore=0;
    boolean humanTurn=true;
    boolean computerTurn=false;
    String userContinue = "yes";
    //creating the variables and the array

    while(humanScore < 50 && computerScore < 50 && userContinue.equals("yes")){
      while(humanTurn == true && computerTurn == false){
        // coding for when it is the human turn and while both scores are less than 50

        diceRolledArrMain = userRoll();
        // A dice rolling method

        humanScore = updateScore(humanScore, diceRolledArrMain);
        boolean[] turnCalc = rollAgain(humanScore, computerScore, humanTurn, computerTurn, diceRolledArrMain);
        //calculating whether the player gets to roll again or not

        humanTurn = turnCalc[0];
        computerTurn = turnCalc[1];
        //calculating whos turn it is

        System.out.println("Your score is: " + humanScore); 
        //printing out the human score
      }
      while(humanTurn == false && computerTurn == true){
        diceRolledArrMain = userRoll();
        computerScore = updateScoreComp(computerScore, diceRolledArrMain);
        boolean[] turnCalc = rollAgainComp(humanScore, computerScore, humanTurn, computerTurn, diceRolledArrMain);
        // coding the game for the computer

        humanTurn = turnCalc[0];
        computerTurn = turnCalc[1];
        // calculating if the computer gets another turn or not

        System.out.println("Computer score is: " + computerScore);
        //printing out the computer score

        System.out.println("Would you like to continue on the the game?");
        userContinue = myScan.nextLine();
        //asking user if they still want to play the game
      }
    }
    if(humanScore > computerScore){
      System.out.println("Human Wins!");
      System.exit(0);
    }
    else if(humanScore == computerScore){
      System.out.println("It's a tie!");
      System.exit(0);
    }
    else if(humanScore < computerScore){
      System.out.println("Terminator Wins!");
      System.exit(0);
    }
    else{
      System.out.println("Game ended. Please come back again soon.");
    }
    System.exit(0);

  }
  // determining who wins the game and exiting

  public static void welcomeMessage(){
    System.out.println("Let's play Fifty the Game!");
    System.out.println("The objective is simple: The first player to reach 50 by rolling doubles wins!");
    System.out.println("Points are scored as such:");
    System.out.println("Rolling double 1 is scored as 5 points and you get to roll again");
    System.out.println("Rolling double 2 is scored as 5 points and you get to roll again");
    System.out.println("Rolling double 3 resets your score to 0 and you do not get to roll again!");
    System.out.println("Rolling double 4 is scored as 5 points and you get to roll again");
    System.out.println("Rolling double 5 is scored as 5 points and you get to roll again");
    System.out.println("Rolling double 6 is scored as 25 points! However, you may not roll again");
    System.out.println("If no doubles are rolled, you get 0 points and you may not roll again");
    //displaying the rules and instructions about how the game works
  }

  public static int[] userRoll(){
    int dice1 = (int)(Math.random()*6+1);
    int dice2 = (int)(Math.random()*6+1);
    

    int[] diceRolledArr = {dice1 , dice2};

    return diceRolledArr;   
    //rolling 2 dice at once and then returning them as an array to the main method. One of the dice is for the human and the other is for the computer
  }

  public static int updateScore(int userScore, int[]diceRolled){
    int dice1 = diceRolled[0];
    int dice2 = diceRolled[1];
    if(dice1 == dice2 && dice1 != 3 && dice1 != 6){
      System.out.println("You rolled: " + dice1 + " and " + dice2);
      userScore = userScore + 5;  
    }
    else if(dice1 == 6 && dice2 == 6){
      System.out.println("You rolled: " + dice1 + " and " + dice2);
      userScore = userScore + 25;
    }
    else if(dice1 == 3 && dice2 == 3){
      System.out.println("You rolled: " + dice1 + " and " + dice2);
      userScore = 0;
    }
    else{
      System.out.println("You rolled: " + dice1 + " and " + dice2);
      userScore = userScore;
    }
    return userScore;
    // calculating the score for the human
  }

  public static boolean[] rollAgain(int humanScore, int computerScore, boolean humanTurn, boolean compTurn, int[] diceRolled){
    int dice1 = diceRolled[0];
    int dice2 = diceRolled[1];
    if(dice1 == dice2 && dice1 != 3 && dice1 != 6){
      humanTurn = true;
      compTurn = false;
    }
    else if(dice1 == 6 && dice2 == 6){
      humanTurn = false;
      compTurn = true;
    }
    else if(dice1 == 3 && dice2 == 3){
      humanTurn = false;
      compTurn = true;
    }
    else{
      humanTurn = false;
      compTurn = true;
    }
    boolean[] turnDecider = {humanTurn, compTurn};
    return turnDecider;
    // calculating if the human can roll again
  }

  public static int updateScoreComp(int userScore, int[]diceRolled){
    int dice1 = diceRolled[0];
    int dice2 = diceRolled[1];
    if(dice1 == dice2 && dice1 != 3 && dice1 != 6){
      System.out.println("Computer rolled: " + dice1 + " and " + dice2);
      userScore = userScore + 5;  
    }
    else if(dice1 == 6 && dice2 == 6){
      System.out.println("Computer rolled: " + dice1 + " and " + dice2);
      userScore = userScore + 25;
    }
    else if(dice1 == 3 && dice2 == 3){
      System.out.println("Computer rolled: " + dice1 + " and " + dice2);
      userScore = 0;
    }
    else{
      System.out.println("Computer rolled: " + dice1 + " and " + dice2);
      userScore = userScore;
    }
    return userScore;
    // calculating the score of the computer
  }

  public static boolean[] rollAgainComp(int humanScore, int computerScore, boolean humanTurn, boolean compTurn, int[] diceRolled){
    int dice1 = diceRolled[0];
    int dice2 = diceRolled[1];
    if(dice1 == dice2 && dice1 != 3 && dice1 != 6){
      humanTurn = true;
      compTurn = false;
    }
    else if(dice1 == 6 && dice2 == 6){
      humanTurn = false;
      compTurn = true;
    }
    else if(dice1 == 3 && dice2 == 3){
      humanTurn = false;
      compTurn = true;
    }
    else{
      humanTurn = false;
      compTurn = true;
    }
    boolean[] turnDecider = {compTurn, humanTurn};
    return turnDecider;

    //checking if the computer can roll again
  }
  
}