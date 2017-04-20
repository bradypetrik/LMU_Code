/* Brady Petrik
   CMSI 186-02
   homework06 - GinormousInt
   Last Modified: 4/20/17
   Purpose: A self-built version of the Big Integer java class */
   
public class GinormousInt {
   
   public String value = new String();
   public static final GinormousInt ZERO = new GinormousInt("0");
   public static final GinormousInt ONE = new GinormousInt("1");
   public static final GinormousInt TEN = new GinormousInt("10");
   
   public static void main(String[] args) {
     GinormousInt tester1 = new GinormousInt("123456789");
     GinormousInt tester2 = new GinormousInt("123456789");
     GinormousInt tester3 = new GinormousInt("1");
     GinormousInt tester4 = new GinormousInt("123920304928723");
     GinormousInt tester5 = new GinormousInt("7");
     GinormousInt tester6 = new GinormousInt("53902");
     tester1.equals("123456");
     tester1.equals("164029");
     tester1.equals("3432");
     tester1.toString();
     tester1.getValueAt(4);
     tester1.reverseString();
     tester1.add(tester1);
     tester1.add(tester2);
     tester1.add(tester4);
     tester1.add(tester5);
     tester1.subtract(tester3);
     tester1.subtract(tester6);
     tester1.divideByTwo();
     tester1.multiply(tester6);
     tester1.isLegit();
     
   }
   
   public GinormousInt(String input) {
      this.value = input;
   }
   
   public GinormousInt() {
      //an alternate blank constructor
      this.value = "";
   }
   
   public static GinormousInt valueOf(long input) {
      String temp = String.valueOf(input);
      GinormousInt output = new GinormousInt(temp);
      return output;
   }
   
   public void isLegit() {
      //a reusable test to make sure input is valid
      for(int i = 0; i < this.getLength(); i++) {
         if(this.getValueAt(i) != 0 && this.getValueAt(i) != 1 && this.getValueAt(i) != 2 && this.getValueAt(i) != 3 &&
               this.getValueAt(i) != 4 && this.getValueAt(i) != 5 && this.getValueAt(i) != 6 && this.getValueAt(i) != 7 &&
               this.getValueAt(i) != 8 && this.getValueAt(i) != 9) {
            throw new IndexOutOfBoundsException("Please only input positive numbers");
         }
      }
   }
   
   //lots of accessibility features to use in later methods
   public int getValue() {
      int returnVal = Integer.parseInt(this.value);
      return returnVal;
   }
   
   public void setValue(String input) { 
      this.value = input;
   }
   
   public String substring(int pos) {
      String output = this.value.substring(pos, value.length()-1);
      return output;
   }
   
   public String substring(int pos, int pos2) {
      String output = this.value.substring(pos, pos2);
      return output;
   }
   
   public int getValueAt(int pos) {
      String indexVal = value.substring(pos, pos+1);
      int output = Integer.parseInt(indexVal);
      if(indexVal == "-") {
         return Integer.parseInt(this.value.substring(pos+1, pos+2));
      }
      if(value.substring(0,1) != "-") {
         return output;
      } else {
         System.out.println("-" + output);
         return (output * -1);
      }
   }
   
   public String getStringAt(int pos) {
      String output = value.substring(pos, pos+1);
      return output;
   }
   
   public int getLength() {
      return this.value.length();
   }
   
   public String toString() {
      String GinormIntString = this.value;
      return GinormIntString;
   }
   
   public String reverseString() {
      String output = new String();
      for(int i = this.getLength()-1; i >= 0; i--) {
         output += this.getStringAt(i);
      }
      return output;
   }
   
   public int compareTo(GinormousInt inputVal) {
      boolean equal = this.equals(inputVal.toString());
      boolean yesOrNo = this.biggerSmaller(inputVal);
      if(equal == true) {
         return 0;
      }
      if(yesOrNo == true) {
         return 1;
      } else {
         return -1;
      }
      
   }
   
   public boolean equals(String input) {
      if(value.length() != input.length()) {
         return false;
      } else {
         for(int i = 0; i < value.length(); i++) {
            if(value.charAt(i) != input.charAt(i)) {
               return false;
            }
         }
      }
      return true;
   }
   
   //eliminates redundant coding, since finding bigger and smaller values is 
   //pretty essential in most of the advanced methods
   public boolean biggerSmaller(GinormousInt inputVal) {
      //returns true if the original is bigger than the inputVal
      //returns false if the inputVal is bigger than the original
      GinormousInt bigger = new GinormousInt();
      GinormousInt smaller = new GinormousInt();
      if(inputVal.getLength() > this.getLength()) {
         return false;
      } else if(this.getLength() > inputVal.getLength()) {
         return true;
      } else {
         for(int i = 0; i < inputVal.getLength(); i++) {
            if(inputVal.getValueAt(i) > this.getValueAt(i)) {
               return false;
            } else if(this.getValueAt(i) > inputVal.getValueAt(i)) {
               return true;
            }
         }
      }
      return true;
   }
      
   
   public GinormousInt add(GinormousInt inputVal) {
      this.isLegit();
      inputVal.isLegit();
      GinormousInt bigger = new GinormousInt();
      GinormousInt smaller = new GinormousInt();
      if(this.biggerSmaller(inputVal) == true) {
         String reverse = this.reverseString();
         bigger.setValue(reverse);
         smaller.setValue(inputVal.reverseString());
      } else {
         String reverse = this.reverseString();
         bigger.setValue(inputVal.reverseString());
         smaller.setValue(reverse);
      }
      String totalSum = new String();
      int tempSum = 0;
      boolean carry = false;
      if(smaller.getLength() < bigger.getLength()) {
         String easyAdd = bigger.reverseString();
         totalSum += easyAdd.substring(0, (bigger.getLength() - smaller.getLength()));
      }
      for(int i = 0; i < smaller.getLength(); i++) {
          tempSum = smaller.getValueAt(i) + bigger.getValueAt(i);
          if(carry == true) {
            tempSum += 1;
          }
          if(tempSum > 9) {
            carry = true;
            totalSum += (tempSum - 10);
          } else {
            carry = false;
            totalSum += tempSum;
          }
          tempSum = 0;
      }
      String finalSum = new String();
      if(carry == true) {
         int carryVar = totalSum.length()-2;
         int valueAtVar = Integer.parseInt(totalSum.substring(carryVar, carryVar+1)) + 1;
         finalSum = totalSum.substring(0, carryVar) + valueAtVar + totalSum.charAt(carryVar+1);
      } else {
         finalSum = totalSum;
      }
      
      if(smaller.getLength() == bigger.getLength()) {
         GinormousInt swapsies = new GinormousInt(finalSum);
         GinormousInt finalReturn = new GinormousInt(swapsies.reverseString());
         return finalReturn;
      } else {
         GinormousInt finalReturn2 = new GinormousInt(finalSum);
         return finalReturn2;
      }
   }
   
   public GinormousInt subtract(GinormousInt inputVal) {
      //a slight inversion of the add method
      this.isLegit();
      inputVal.isLegit();
      GinormousInt bigger = new GinormousInt();
      GinormousInt smaller = new GinormousInt();
      if(this.biggerSmaller(inputVal) == true) {
         String reverse = this.reverseString();
         bigger.setValue(reverse);
         smaller.setValue(inputVal.reverseString());
      } else {
         String reverse = this.reverseString();
         bigger.setValue(inputVal.reverseString());
         smaller.setValue(reverse);
      }
      String totalSum = new String();
      GinormousInt addEnd = new GinormousInt();
      int tempSum = 0;
      boolean carry = false;
      if(smaller.getLength() < bigger.getLength()) {
         String easyAdd = bigger.reverseString();
         addEnd.setValue(easyAdd.substring(0, (bigger.getLength() - smaller.getLength())));
      } 
      for(int i = 0; i < smaller.getLength(); i++) {
          tempSum = bigger.getValueAt(i) - smaller.getValueAt(i);
          if(carry == true) {
            tempSum -= 1;
          }
          if(tempSum < 0) {
            carry = true;
            totalSum += (10 + tempSum);
          } else {
            carry = false;
            totalSum += tempSum;
          }
          tempSum = 0;
      }
      totalSum += addEnd.reverseString();
      GinormousInt temp = new GinormousInt(totalSum);
      String finalSum = temp.reverseString();
      if(carry == true) {
         int carryVar = totalSum.length()-2;
         int valueAtVar = Integer.parseInt(totalSum.substring(carryVar, carryVar+1)) + 1;
         finalSum = totalSum.substring(0, carryVar) + valueAtVar + totalSum.charAt(carryVar+1);
      } else {
         finalSum = totalSum;
      }
         GinormousInt swapsies = new GinormousInt(finalSum);
         GinormousInt finalReturn = new GinormousInt(swapsies.reverseString());
         finalReturn.toString();
         return finalReturn;
   }
   
   public GinormousInt multiply(GinormousInt inputVal) {
      this.isLegit();
      inputVal.isLegit();
      GinormousInt bigger = new GinormousInt();
      GinormousInt smaller = new GinormousInt();
      if(this.biggerSmaller(inputVal) == true) {
         bigger.setValue(this.toString());
         smaller.setValue(inputVal.toString());
      } else {
         bigger.setValue(inputVal.toString());
         smaller.setValue(this.toString());
      }
      int bigVal = bigger.getValue();
      int smallVal = smaller.getValue();
      GinormousInt tallyHo = new GinormousInt();
      String totalSum = new String();
      while(bigger.getValue() > 1) {
         int tester = bigger.getValueAt(bigger.getLength()-1);
         if(tester % 2 == 1) {
            tallyHo.add(smaller);
         }
         GinormousInt temp = new GinormousInt (smaller.toString());
         bigVal = bigger.getValue();
         smaller.multiplyByTwo();
         smallVal = smaller.getValue();
         GinormousInt divided = bigger.divideByTwo();
         bigger.setValue(divided.toString());
      }
      String output = tallyHo.toString();
      System.out.println(output);
      return tallyHo;
   }
      
   public GinormousInt multiplyByTwo() {
      GinormousInt temp = this;
      temp.add(this);
      return temp;
   }
      
   //supplementary methods to assist the multiply method
   public GinormousInt divideByTwo() {
      String returnVal = new String();
      int halfsies = 0;
      String outsideTally = new String();
      boolean carry = false;
      for(int i = 0; i < this.getLength(); i++) {
         if(carry == true) {
            halfsies += 10;
         }
         if(this.getValueAt(i) % 2 == 1) {
            carry = true;
         } else { 
            carry = false;
         }
         halfsies += this.getValueAt(i);
         if((halfsies/2) < 1) {
            halfsies = 0;
         }
         if((halfsies % 2) == 1) {
            halfsies -= 1;
         }
         halfsies = halfsies/2;
         outsideTally += halfsies;
         halfsies = 0;
      }
      GinormousInt finalReturn = new GinormousInt(outsideTally);
      return finalReturn;
   }
   
   public GinormousInt divide(GinormousInt inputVal) {
      //hypothetically this should just be an inverse of the multiply function
      //but since there is a hiccup in the multiply function in which the smaller number does not double
      //it seems silly to attempt to implement it here
      return inputVal;
   }
                
}