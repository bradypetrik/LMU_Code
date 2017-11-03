/** 
*@author Brady Petrik
*CMSI 281
*CircularList
*Last Modified: 11/2/17
*Purpose:  Build a list that starts again from the beginning after the last index is reached
*/

import java.util.*;

public class CircularList implements Iterable {

   private int length;
   private int[] list;
   
/**
*Builds a constructor when given a desired size for the CircularList
*/

   public CircularList(int input) {
      this.list = new int[length];
   }
   
/**
*Default constructor for when no parameters are given
*/

   public CircularList() {
      this.list = new int[10];
   }
   
/**
*Allows user to get the index held at any position within the list
*/
   
   public int getIndex(int pos) {
      int temp = this.list[pos];
      return temp;
   }
   
/**
*Allows user to get the index held at any position within the list
*/
   
   public void setIndex(int pos, int num) {
      this.list[pos] = num;
   }
   
/**
*Redefines iterator methods for use within the context of CircularLists
*/
   public Iterator<Integer> iterator() {
      Iterator<Integer> it = new Iterator<Integer>() {
         private int currentIndex = 0;
         
/**
*Custom build of hasNext() method
*/
         
         public boolean hasNext() {
            this.loop();
            return currentIndex < length ;
         }

/**
*Custom build of next() method
*/

         public Integer next() {
            this.loop();
            int temp = currentIndex;
            currentIndex++;
            return (Integer)temp;
         }
         
/**
*Custom build of remove() method
*/

         public void remove() {
            throw new IllegalArgumentException("Please do not remove from the list while it is in use.");
         }
         
/**
*Returns the current index space of the iterator
*/
         
         public int getCurrentIndex() {
            return currentIndex;
         }

/**
*Custom method that causes list to start at index 0 after the last index is reached
*/

         public void loop() {
            if(currentIndex > length) {
               currentIndex = 0;
            }
         }
      };
      return it;
   }
   
   public static void main(String[] args) {
      
   }

}
