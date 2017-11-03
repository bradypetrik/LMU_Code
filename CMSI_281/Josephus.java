import java.util.*;

public class Josephus extends CircularList {
   
   public static final Scanner console = new Scanner(System.in);
   
   public static void main(String[] args) {
      int skip = Integer.parseInt(console.next());
      int length = Integer.parseInt(console.next());
      checkValid(skip, length);
      CircularList list = new CircularList(length);
      playGame(skip, length, list);
   }
   
   public static void playGame(int skip, int length, CircularList list) {
      Iterator it = list.iterator();
      int tally = length;
      int index = 0;
      while(tally != 1) {
         for(int i = 0; i < skip; i++) {
            index = (Integer)it.next();
         }
         list.setIndex(index, 7);
         tally = tally(skip, length, list);
      }
      int which = which(skip, length, list); 
      System.out.println(which);
   }
   
   public static int tally(int skip, int length, CircularList list) {
      int tally = 0;
      int index = 0;
      Iterator it = list.iterator();
      for(int i = 0; i < length; i++) {
         index = (Integer)it.next();
         if(index != 7) {
            tally++;
         }
      }
      return tally;
   }
   
   public static int which(int skip, int length, CircularList list) {
      int which = 0;
      int index = 0;
      Iterator it = list.iterator();
      for(int i = 0; i < length; i++) {
         index = (Integer)it.next();
         if(index != 7) {
            return i;
         }
      }
      return 0;
   }
   
   public static void checkValid(int skip, int length) {
      if(skip <= 0) {
         throw new IllegalArgumentException("Please input a valid skip value.");
      }
      if(length <= 0) {
         throw new IllegalArgumentException("Please input a valid number of folks.");
      }
   }
}