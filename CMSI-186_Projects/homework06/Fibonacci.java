/* Brady Petrik
   CMSI 186-02
   homework06 - Fibonacci
   Last Modified: 4/20/17
   Purpose: Allows you to see a chosen number of values within the Fibonacci sequence */
   
public class Fibonacci {
   
   public static void main(String args[]) {
      fibonacci(30);
      fibonacci(1);
      fibonacci(-8);
      
   }
   
   public static void fibonacci(int input) {
      if(input < 1) {
         throw new IndexOutOfBoundsException("Come on now, use a positive integer with a value greater than 0");
      }
      int num1 = 0;
      int num2 = 1;
      int temp = 0;
      int tally = 0;
      String returnOut = new String();
      for(int i = 0; i < input; i++) {
         if(i == 0) {
            tally = 0;
         } else if(i == 1 || i == 2){
            tally = 1;
         } else {
            tally = num1 + num2;
         }
         returnOut += tally + " ";
         temp = num2;
         num2 = num1 + temp;
         num1 = temp;
      }
      System.out.println(returnOut);
   }
}