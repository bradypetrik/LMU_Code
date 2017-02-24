import java.util.*;

public class DiceSet {
   
   private int sum = 0;
   private int rollValue = 0;
   ArrayList<Die> list = new ArrayList<Die>();
   private int numberOfDice = 0;
   
   public static void main(String[] args) {
      DiceSet tester = new DiceSet(3,4);
      tester.sum();
      tester.roll();
      tester.toString();
      tester.rollIndividual(2);
      tester.rollIndividual(-1);
      tester.getIndividual(1);
      tester.getIndividual(6);
      tester.setIndividual(1, 3);
      tester.toString();
      tester.isIdentical(new DiceSet(3,4));
      tester.isIdentical(new DiceSet(3,6));
      tester.isIdentical(new DiceSet(5,4));
      DiceSet tester2 = new DiceSet(0,3);
      DiceSet tester3 = new DiceSet(400,28);
      
   }
   
   public DiceSet(int k, int n) {
      if(k < 1) {
         throw new IllegalArgumentException("You must have more than one die");
      }
      if(n < 4) {
         throw new IllegalArgumentException("Your dice must have 4 or more sides");
      }
      numberOfDice = k;
      for(int i = 0; i < k; i++) {
         list.add(new Die(n));
      }
   }
   
   public int sum() {
      for(Die eachDie : list) {
         sum += eachDie.getValue();
      }
      return sum;
   }
   
   public void roll() {
      rollValue = 0;
      for(Die eachDie : list) {
         eachDie.roll();
         eachDie.setValue(eachDie.getRollValue());
         rollValue += eachDie.getRollValue();
      }
   }
   
   public void rollIndividual(int i) {
      if(i < 0 || i > list.size()) {
         throw new IllegalArgumentException(i + " is not a valid index");
      }
      Die tempDie = list.get(i);
      rollValue -= tempDie.getValue();
      tempDie.roll();
      tempDie.setValue(tempDie.getRollValue());
      rollValue += tempDie.getValue();
   }
   
   public int getIndividual(int i) {
      if(i < 0 || i > list.size()) {
         throw new IllegalArgumentException(i + " is not a valid index");
      }
      Die tempDie = list.get(i);
      int value = tempDie.getValue();
      return value;
   }
   
   public void setIndividual(int i, int jValue) {
      Die tempDie = list.get(i);
      tempDie.setValue(jValue);  
   }
   
   public String toString() {
      String dieString = new String();
      for(Die eachDie : list) {
         int tempValue = eachDie.getValue();
         dieString += "[" + tempValue + "]";
      }
      System.out.println(dieString);
      return dieString;
   }
   
   public static String toString(DiceSet passedList) {
      String returnString = passedList.toString();
      return returnString;
   }
   
   public int size() {
      return numberOfDice;
   }
   
   public boolean isIdentical(DiceSet passedSet) {
      int truthTally = 0;
      if(this.size() != passedSet.size()) {
         System.out.println("These dice sets do not have the same number of dice");
         return false;
      } else {
         System.out.println("This dice set has the same number of dice as your dice set");
         return true;
      }
   } 
   
   public int getRollValue() {
      return rollValue;
   }  
}
      