import java.util.*;

public class CircularList implements Iterable {

   private int length;
   public int[] list;
   
   public CircularList(int input) {
      this.list = new int[length];
   }
   
   public CircularList() {
      this.list = new int[10];
   }
   
   public int getIndex(int pos) {
      int temp = this.list[pos];
      return temp;
   }
   
   public void setIndex(int pos, int num) {
      this.list[pos] = num;
   }
   
   
   public Iterator<Integer> iterator() {
      Iterator<Integer> it = new Iterator<Integer>() {
         private int currentIndex = 0;
         
         public boolean hasNext() {
            this.loop();
            return currentIndex < length ;
         }

         public Integer next() {
            this.loop();
            int temp = currentIndex;
            currentIndex++;
            return (Integer)temp;
         }

         public void remove() {
            throw new IllegalArgumentException("Please do not remove from the list while it is in use.");
         }
         
         public int getCurrentIndex() {
            return currentIndex;
         }
         
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