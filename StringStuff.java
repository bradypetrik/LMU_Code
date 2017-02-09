/* Brady Petrik
   CMSI 186-02
   homework02 - StringStuff
   Last Modified: 2/9/2017
   Purpose: To do anything with strings that you could ever possibly imagine */

import java.util.*; 
  
public class StringStuff {
   
   public static void main(String[] args) {
      test_allMethods();
   }
   
   static void test_allMethods() {
      containsVowels("alphabet soup");
      containsVowels("dkfksjfkF");  
      isPalindrome("racecar");
      isPalindrome("pickles"); 
      evensOnly("REHEARSALS");
      oddsOnly("xylophones");
      evensOnlyNoDupes("REHEARSALS");
      oddsOnlyNoDupes("xylophones");
      reverse("Well would you look at that"); 
   }
   public static boolean containsVowels(String s) {
      for(int i = 1; i <= s.length(); i++) {
         String temp = s.substring(i-1, i);
         if(temp.equalsIgnoreCase("A") || temp.equalsIgnoreCase("E") || temp.equalsIgnoreCase("I") || 
          temp.equalsIgnoreCase("O") || temp.equalsIgnoreCase("U")) {
            return true;

         }
      }
      return false;
   }
   
   public static boolean isPalindrome(String s) {
      String frontHalf = s.substring(0, s.length() / 2);
      String backHalf;
      long trueTally = 0;
      if(s.length() % 2 == 1) {
         backHalf = s.substring(s.length() / 2 + 1, s.length());
      } else {
         backHalf = s.substring(s.length() / 2, s.length());
      } 
      for(int i = 0; i < frontHalf.length(); i++) {
         if(frontHalf.charAt(i) == backHalf.charAt(backHalf.length() - 1 - i)) {
            trueTally++;
         }
      }
      if(trueTally == backHalf.length()) {
         return true;
      } else {
         return false; 
      }
   }
   
   public static String evensOnly(String s) {
      String evenStevens = new String();
      for(int i = 0; i < s.length(); i++) {
         String temp = s.substring(i, i+1);
         switch(temp.toLowerCase()) {
            case "b":
               evenStevens += s.charAt(i);
               break;
            case "d":
               evenStevens += s.charAt(i);
               break;
            case "f":
               evenStevens += s.charAt(i);
               break;
            case "h":
               evenStevens += s.charAt(i);
               break;
            case "j":
               evenStevens += s.charAt(i);
               break;
            case "l":
               evenStevens += s.charAt(i);
               break;
            case "n":
               evenStevens += s.charAt(i);
               break;
            case "p":
               evenStevens += s.charAt(i);
               break;
            case "r":
               evenStevens += s.charAt(i);
               break;           
            case "t":
               evenStevens += s.charAt(i);
               break;
            case "v":
               evenStevens += s.charAt(i);
               break;
            case "x":
               evenStevens += s.charAt(i);
               break;
            case "z":
               evenStevens += s.charAt(i);
               break;
            }
      }
      return evenStevens;
   }
      
   public static String oddsOnly(String s) {
      String oddTodd = new String();
      for(int i = 0; i < s.length(); i++) {
         String temp = s.substring(i, i+1);
         switch(temp.toLowerCase()) {
            case "a":
               oddTodd += s.charAt(i);
               break;
            case "c":
               oddTodd += s.charAt(i);
               break;
            case "e":
               oddTodd += s.charAt(i);
               break;
            case "g":
               oddTodd += s.charAt(i);
               break;
            case "i":
               oddTodd += s.charAt(i);
               break;
            case "k":
               oddTodd += s.charAt(i);
               break;
            case "m":
               oddTodd += s.charAt(i);
               break;
            case "o":
               oddTodd += s.charAt(i);
               break;
            case "q":
               oddTodd += s.charAt(i);
               break;           
            case "s":
               oddTodd += s.charAt(i);
               break;
            case "u":
               oddTodd += s.charAt(i);
               break;
            case "w":
               oddTodd += s.charAt(i);
               break;
            case "y":
               oddTodd += s.charAt(i);
               break;
            }
         }
         return oddTodd;
      }


   public static String evensOnlyNoDupes(String s) {
      String evenStevens = evensOnly(s);
      String tempDupes = new String(); 
      //Checks if a given letter appears more than once in the input word   
      for(int i = 0; i < evenStevens.length(); i++) {
         int truthTally = 0;
         for(int j = 0; j < evenStevens.length(); j++) {
            if(evenStevens.charAt(i) == evenStevens.charAt(j) && i != j) {
               truthTally++;
            }
         }
         if(truthTally < 1) {
            tempDupes += evenStevens.charAt(i);
         }
         //If the letter is a duplicate, checks if it has already been added once to the output
         else {
            int dupesTruth = 0;
            for(int j = 0; j < tempDupes.length(); j++) {
               if(evenStevens.charAt(i) == tempDupes.charAt(j)) {
                  dupesTruth++;
               }
            }
            if(dupesTruth < 1) {
               tempDupes += evenStevens.charAt(i);
            }
         }
      }  
      return tempDupes;
   } 
   
   public static String oddsOnlyNoDupes(String s) {
      String oddTodd = oddsOnly(s);
      String tempDupes = new String();    
      //Checks if a given letter appears more than once in the input word
      for(int i = 0; i < oddTodd.length(); i++) {
         int truthTally = 0;
         for(int j = 0; j < oddTodd.length(); j++) {
            if(oddTodd.charAt(i) == oddTodd.charAt(j) && i != j) {
               truthTally++;
            }
         }
         if(truthTally < 1) {
            tempDupes += oddTodd.charAt(i);
         }
         //If the letter is a duplicate, checks if it has already been added once to the output
         else {
            int dupesTruth = 0;
            for(int j = 0; j < tempDupes.length(); j++) {
               if(oddTodd.charAt(i) == tempDupes.charAt(j)) {
                  dupesTruth++;
               }
            }
            if(dupesTruth < 1) {
               tempDupes += oddTodd.charAt(i);
            }
         }
      }  
      return tempDupes;
   } 
   
   public static String reverse(String s) {
      String reverseWord = new String();
      for(int i = s.length() - 1; i >= 0; i--) {
         reverseWord += s.charAt(i);
      }
      return reverseWord;
   }
}