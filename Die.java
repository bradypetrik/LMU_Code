import java.util.*;

public class Die {
   
   private int sides = 0;
   private int value = 0;
   private int rollValue = 0;
   
   public static void main(String[] args) {
      Die test1 = new Die(6);
      Die test2 = new Die(2);
      Die test3 = new Die(1000);
      Die test4 = new Die(0);
      Die test5 = new Die(-3);
   }
   
   public Die(int nSides) {
     if(nSides > 2) {
        this.sides = nSides;
     } else {
        throw new IllegalArgumentException(nSides + " is not a valid number of sides");
     }
   }
   
   public void roll() {
      rollValue =(int)(Math.random() * this.sides + 1);
   }
   
   public int getValue() {
      return value;
   }
   
   public int getRollValue() {
      return rollValue;
   }
   
   public void setValue(int kValue) {
      value = kValue;
   }  
}