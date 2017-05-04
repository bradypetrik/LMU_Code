/* Brady Petrik
   CMSI 186-02
   homework07 - Tuple
   Last Modified: 
   Purpose: "You make change." 
            "...oh my god." 
            "Yeah. Welcome to the party, pal" */

import java.util.Arrays;
           
public class Tuple {
   
   //this class checks if the change can be made at all
   
   public static final Tuple IMPOSSIBLE = new Tuple(new int[0]);
   private int[] data;
    
    
   public static void main(String[] args) {
      
   }
   
   public Tuple( int n ) {
      if( n < 0 ) {
         throw new IllegalArgumentException();
      }

      data = new int[n];
      for( int i = 0; i < n; i++ ) {
         data[i] = 0;
      }
   }
   
   public Tuple( int[] data ) {
      if( data == null ) {
         throw new IllegalArgumentException();
      }

      this.data = new int[data.length];
      for( int i = 0; i < data.length; i++ ) {
         this.data[i] = data[i];
      }
   }
   
   public void setElement( int i, int j ) {
      checkIndex(i);
      data[i] = j;
   }
   
   public int getElement( int i ) {
      checkIndex(i);
      return data[i];
   }
   
   public int length() {
      return data.length;
   }
   
   public int total() {
      int sum = 0;
      for( int i = 0; i < length(); i++ ) {
         sum = sum + getElement(i);
      }

      return sum;
   }
   
   public Tuple add( Tuple t ) {

      if( length() != t.length()) {
         throw new IllegalArgumentException();
      }

      Tuple sum = new Tuple(length());
      for( int i = 0; i < length(); i++ ) {
         sum.setElement(i, getElement(i) + t.getElement(i));
      }

      return sum;
   }


   @Override
   public boolean equals(Object t) {
      if( (t == null) || !(t instanceof Tuple) || (length() != ((Tuple)t).length()) ) {
         return false;
      }

      for( int i = 0; i < length(); i++ ) {
         if( getElement(i) != ((Tuple)t).getElement(i) ) {
            return false;
         }
      }

      return true;
   }
   
   @Override
   public int hashCode() {
      int product = 0;
      for( int i = 0; i < length(); i++ ) {
         product = product * getElement(i);
      }
      return (product >= 0) ? product : -product;
   }
   
   @Override
   public String toString() {
      if( isImpossible()) {
         return "Impossible tuple";
      }

      String result = "<";
      for( int i = 0; i < length(); i++ ) {
         result += (i > 0 ? "," : "") + data[i];
      }
      return result + ">";
   }
   
   public boolean isImpossible() {
      return this == IMPOSSIBLE;
   }

   private void checkIndex(int i) {
      if( i < 0) {
         throw new IllegalArgumentException();
      }

      if( i >= length()) {
         throw new IllegalArgumentException();
      }
   }
   
   //create a table with the dimensions provided
   //populate the table with desired values
   
   //dissect given code and figure out where to stick everything   
}