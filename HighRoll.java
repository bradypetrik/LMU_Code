import java.util.*;

public class HighRoll {

   private static int total = 0;
   public static int highScore = 0;
   static String displayRoll = new String();
   public static final Scanner console = new Scanner(System.in);
   public static int s = 7;
   private static String entry = new String();
   
   public static void main(String[] args) {
      DiceSet playSet = new DiceSet(5,6); 
      rollAll(playSet);
      calculateScore(playSet);
      while(s != 0) {
         System.out.println("Here are your dice rolls");
         displayRoll = playSet.toString();
         System.out.println("Please input what you would like to do next");
         System.out.println("Type 1 to roll all dice");
         System.out.println("Type 2 to roll one specific die");
         System.out.println("Type 3 to calculate your current score");
         System.out.println("Type 4 to save your current score as your high score");
         System.out.println("Type 5 to display your high score");
         System.out.println("Type 0 to exit this program");
         s = console.nextInt();
         if(s == 1) {
            rollAll(playSet);
         }
         else if(s == 2) {
            rollOne(playSet);
         }
         else if(s == 3) {
            calculateScore(playSet);
         }
         else if(s == 4) {
            setHighScore();
         }
         else if(s == 5) {
            showHighScore();
         }
         else if(s!=0){
            System.out.println("Please input valid data");
         }
      }
   }
   
   public static void rollAll(DiceSet playSet) {
      playSet.roll();
      total = playSet.getRollValue();
   }
   
   public static void rollOne(DiceSet playSet) {
      System.out.println("Please indicate which die you would like to reroll");
      int index = console.nextInt();
      //subtract value you are getting rid of then replace it with new rolled value
      playSet.rollIndividual(index-1);
      total = playSet.getRollValue();
   }
   
   public static void calculateScore(DiceSet playSet) {
      System.out.println("Your score is " + playSet.getRollValue());
   }
   
   public static void setHighScore() {
      highScore = total;
      System.out.println("You saved " + total + " as your high score.");
   }
   
   public static void showHighScore() {
      System.out.println("Your current high score is " + highScore + ". Good job! You are good at this chance game!");
   }
}