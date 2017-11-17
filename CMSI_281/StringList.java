/**Brady Petrik
   CMSI 281
   FromDecimal
   Last Modified: 10/12/17 
   Purpose:  Convert a number to any base from base 10 */

/** An object of this class represents a StringList, i.e., an alphabetically-ordered Collection
    of Java Strings, with duplicates permitted. Be sure to read the Java documentation on
    <a href="http://docs.oracle.com/javase/7/docs/api/java/util/Collection.html">interface java.util.Collection</a>.
*/

import java.util.*;

public class StringList implements java.util.Collection {
    
    /** Used an ArrayList of Strings as the base because of robust functionality
        and included methods. Eliminates minutia coding and improves runtime. */
        
    /** Calculations are typically brute force due to the relatively small anticipated size
        of StringLists and the ease of calculation that brute force provides in these
        instances. */
        
    public ArrayList<String> list;
    
    /** Constructs an empty StringList. */
    public StringList(){
        list = new ArrayList<String>(0);
    }


    /** Constructs a StringList from an array of Strings. */
    public StringList( String[] strings ){
      list = new ArrayList<String>(strings.length);
      for(int i = 0; i < strings.length; i++) {
         list.add(strings[i]);
      }
        
    }
    
    /** Increases by one the number of instances of obj.toString() in this collection. */
    public boolean add ( Object obj ) {
      if(obj instanceof String) {
         list.add(obj.toString());
         return true;
      } else {
         return false;
      }
         
    }
    

    /** Adds all of the elements of the given StringList to this one. */
    /** Brute force - allows for quick, straightforward processing of relatively small StringLists */
    public boolean addAll ( java.util.Collection c  ) {
      Iterator it = c.iterator();
      if(c instanceof StringList) {
         int i = 0;
         while(i < c.size()) {
            list.add((String)it.next());
            i++;
         }
         return true;
      } else {
         return false;
      }
            
    }
 

    /** Removes all of the elements from this collection. */
    public void clear () {
      for(int i = list.size()-1; i >=0; i--) {
         list.remove(i);
      }
    }
 

    /** Returns true if this StringList contains at least one instance of obj.toString(). */
    /** Brute force - allows for quick, straightforward processing of relatively small StringLists */
    public boolean contains ( Object obj ) {
      if(obj instanceof String) {
         for(int i = 0; i < list.size(); i++) {
            if(list.get(i)==obj.toString()) {
               return true;
            }
         }
      }
      return false;    
    }
 

    /** Returns true if this StringList contains at least one instance of each element's toString()
        value in the specified list. Multiple copies of some element in the argument do not
        require multiple copies in this StringList. */
    /** Brute force - allows for quick, straightforward processing of relatively small StringLists */
    public boolean containsAll ( java.util.Collection c ) {
      Iterator it = c.iterator();
      int tally = 0;
      for(int i = 0; i < list.size(); i++) {
         for(int j = 0; j < c.size(); j++) {
            if(list.get(i)==it.next()) {
               tally++;
               break;
            }
         }
      }
      return tally == c.size();
    }


    /** Compares the specified object with this Collection for equality, duplicates included. */
    /** Brute force - allows for quick, straightforward processing of relatively small StringLists */
    public boolean equals ( java.util.Collection obj ) {
      Iterator it = obj.iterator();
      int tally = 0;
      for(int i = 0; i < list.size(); i++) {
         if(list.get(i)==it.next()) {
            tally++;
         }
      }
      return (tally==list.size());
   }
 

    /** This method is inherited intact from the superclass. */
    public int hashCode () {
        /* YOU SHOULD NOT CHANGE THIS METHOD. */
        return super.hashCode();
    }

    /** Returns true if this collection contains no elements. */
    public boolean isEmpty () {
      if(list.size()==0) {
         return true;
      } else {
         return false;
      }
    }


    /** Returns an iterator over the strings in this collection. Repeated elements should
        be returned just once. */
    public java.util.Iterator iterator () {
      
      Iterator<String> it = new Iterator<String>() {
      
         public int currentIndex = 0;
         
         public boolean hasNext() {
            return list.size() > currentIndex;
         }
         
         public String next() {
            if(this.hasNext()==true) {
               int temp = currentIndex;
               currentIndex++;
               return list.get(temp);
            }
            return null;
         }
         
         public void remove() {
            list.remove(currentIndex);
         }
         
     };
     return it;
    }


    /** Removes all copies of the specified string from this collection, if present. */
    public boolean remove ( Object obj ) {
      boolean tally = false;
      if(obj instanceof String) { 
         for(int i = 0; i < list.size(); i++) {
            if(list.get(i)==obj.toString()) {
             list.remove(i);
             tally = true;
             i = 0;
            }
         }
      }
      return tally;
    }


    /** Removes all of this collection's strings that are also contained
        in the specified collection. */
    /** Brute force - allows for quick, straightforward processing of relatively small StringLists */
    public boolean removeAll ( java.util.Collection c ) {
      Iterator it = c.iterator();
      boolean tally = false;
      for(int i = 0; i < c.size(); i++) {
         for(int j = list.size()-1; j >= 0; j--) {
            if(list.get(j)==it.next()) {
               list.remove(j);
               tally = true;
            }
         }
         it.next();
      }
      return tally;
    }


	/** Retains only the strings in this collection that are contained in the specified collection.
		 In other words, removes from this collection all of its elements that are NOT contained
		 in the specified collection. */
   /** Brute force - allows for quick, straightforward processing of relatively small StringLists */
	public boolean retainAll ( java.util.Collection c ) {
      Iterator it = c.iterator();
      boolean tally = false;
      int count = 0;
      for(int i = list.size()-1; i >= 0; i--) {
         for(int j = 0; j <= c.size(); j++) {
            if(list.get(i)==it.next()) {
               count++;
               tally = true;
            }
         }
         it.next();
         if(count < 1) {
            list.remove(i); 
         }
         count = 0;
      }
      return tally;
         
	}
 

    /** Returns a String[], that is, an array of Strings, containing all of the elements in this 
        collection, NOT including duplicates. */
    /** Brute force - allows for quick, straightforward processing of relatively small StringLists */
    public String[] toArray () {
      int tally = 0;
      int trueTally = 0;
      for(int i = 0; i < list.size(); i++) {
         for(int j = i+1; j < list.size(); j++) {
            if(list.get(i)==list.get(j)) {
               tally++;
            }
         }
         if(tally > 0) {
            trueTally++;
         }
         tally = 0;
      }
      String[] output = new String[(list.size() - trueTally)];
      int newTally = 0;
      int index = 0;
      for(int k = 0; k < list.size(); k++) {
         for(int n = k+1; n < list.size(); n++) {
            if(list.get(k)==list.get(n)) {
               newTally++;
            }
         }
         if(newTally == 0) {
            output[index] = list.get(k);
            index++;
         }
         newTally = 0;
      }
      return output;
    }


    /** Not supported for this class. */
    public Object[] toArray ( Object[] obj ) {
        /* DO NOT IMPLEMENT THIS METHOD. */
        throw new UnsupportedOperationException();
    }


    /** Returns a count of the strings in this list, NOT including duplicates. */
    /** Brute force - allows for quick, straightforward processing of relatively small StringLists */
    public int size () {
      int tally = 0;
      for(int i = 0; i < list.size(); i++) {
         for(int j = i+1; j < list.size(); j++) {
            if(list.get(i)==list.get(j)) {
               tally++;
            }
         }
      }
      return (list.size() - tally);
    }


    /** Returns a count of the strings in this list, INCLUDING duplicates. */
    public int sizeWithDuplicates () {
        return list.size();
    }
    

    /** Returns a count of the number of copies of obj.toString() in this list. */
    /** Brute force - allows for quick, straightforward processing of relatively small StringLists */
    public int count ( Object obj ) {
      int tally = 0;
      for(int i = 0; i < list.size(); i++) {
         if(list.get(i)==obj.toString()) {
            tally++;
         }
      }
      return tally;
    }
    
    
    /** This method is inherited intact from the superclass. */
    public String toString () {
        /* YOU SHOULD NOT CHANGE THIS METHOD. */
        return super.toString();
    }
    
    /** This methods tests both constructors along with the sizeWithDuplicates method */
    public static void testConstructors() {
      System.out.println("testConstructors: 3 tests");
      String[] alfa = new String[5];
      String[] bravo = new String[0];
      StringList test1 = new StringList();
      if(test1.sizeWithDuplicates()==0) {
         System.out.println("Yes");
      }
      StringList test2 = new StringList(alfa);
      if(test2.sizeWithDuplicates()==5) {
         System.out.println("Yes");
      }
      StringList test3 = new StringList(bravo);
      if(test3.sizeWithDuplicates()==0) {
         System.out.println("Yes");
      }
      System.out.println();
   }
   
   /** This method tests the add method */
   public static void testAdd() {
      System.out.println("testAdd: 3 tests");
      String[] alfa = new String[5];
      StringList test1 = new StringList(alfa);
      test1.add("Word");
      if(test1.sizeWithDuplicates()==6) {
         System.out.println("Yes");
      }
      String[] bravo = new String[5];
      StringList test2 = new StringList(bravo);
      test2.add(12);
      if(test2.sizeWithDuplicates()==5) {
         System.out.println("Yes");
      }
      StringList test3 = new StringList();
      test3.add("Word");
      if(test3.sizeWithDuplicates()==1) {
         System.out.println("Yes");
      }
      System.out.println();
   }
   
   /** This method tests the addAll method */
   public static void testAddAll() {
      System.out.println("testAddAll: 3 tests");
      String[] alfa = {"a","b","c"};
      String[] bravo = new String[3];
      StringList test1 = new StringList(alfa);
      StringList test2 = new StringList(bravo);
      test2.addAll(test1);
      if(test2.sizeWithDuplicates()==6) {
         System.out.println("Yes");
      }
      String[] charlie = new String[0];
      StringList test3 = new StringList(charlie);
      StringList test4 = new StringList(charlie);
      test3.addAll(test4);
      if(test3.sizeWithDuplicates()==0) {
         System.out.println("Yes");
      }
      StringList test5 = new StringList(bravo);
      StringList test6 = new StringList(charlie);
      test5.addAll(test6);
      if(test5.sizeWithDuplicates()==3) {
         System.out.println("Yes");
      }
      System.out.println();
   }
   
   /** This method tests the clear method */
   public static void testClear() {
      System.out.println("testClear: 4 tests");
      String[] alfa = {"a","b","c"};
      StringList test1 = new StringList(alfa);
      test1.clear();
      if(test1.sizeWithDuplicates()==0) {
         System.out.println("Yes");
      }
      String[] bravo = new String[0];
      StringList test2 = new StringList(bravo);
      test2.clear();
      if(test2.sizeWithDuplicates()==0) {
         System.out.println("Yes");
      }
      StringList test3 = new StringList();
      test3.clear();
      if(test3.sizeWithDuplicates()==0) {
         System.out.println("Yes");
      }
      String[] charlie = new String[1000];
      StringList test4 = new StringList(charlie);
      test4.clear();
      if(test4.sizeWithDuplicates()==0) {
         System.out.println("Yes");
      }
      System.out.println();
   }
   
   /** This method tests the contains method */
   public static void testContains() {
      System.out.println("testContains: 3 tests");
      StringList test1 = new StringList();
      if(test1.contains("a")==false) {
         System.out.println("Yes");
      }
      String[] alfa = {"a","b","c"};
      StringList test2 = new StringList(alfa);
      if(test2.contains("a")==true) {
         System.out.println("Yes");
      }
      if(test2.contains("d")==false) {
         System.out.println("Yes");
      }
      System.out.println();
   }
   
   /** This method tests the containsAll method along with the iterator method via containsAll*/
   public static void testContainsAll() {
      System.out.println("testContainsAll: 5 tests");
      String[] alfa = {"a","b","c"};
      StringList test1 = new StringList(alfa);
      StringList test2 = new StringList(alfa);
      if(test1.containsAll(test2)==true) {
         System.out.println("Yes");
      }
      StringList test3 = new StringList();
      if(test3.containsAll(test2)==false) {
         System.out.println("Yes");
      }
      if(test2.containsAll(test3)==true) {
         System.out.println("Yes");
      }
      String[] bravo = {"d","e","f"};
      StringList test4 = new StringList(bravo);
      if(test1.containsAll(test4)==false) {
         System.out.println("Yes");
      }
      String[] charlie = {"a","a","b","b","c","c"};
      StringList test5 = new StringList(charlie);
      if(test1.containsAll(test5)==true) {
         System.out.println("Yes");
      }
      System.out.println();
   }
   
   /** This method tests the equals method */
   public static void testEquals() {
      System.out.println("testEquals: 7 tests");
      String[] alfa = {"a","b","c"};
      StringList test1 = new StringList(alfa);
      if(test1.equals(test1)==true) {
         System.out.println("Yes");
      }
      StringList test2 = new StringList(alfa);
      if(test1.equals(test2)==true) {
         System.out.println("Yes");
      }
      String[] bravo = new String[3];
      StringList test3 = new StringList(bravo);
      if(test1.equals(test3)==false) {
         System.out.println("Yes");
      }
      StringList test4 = new StringList();
      if(test1.equals(test4)==false) {
         System.out.println("Yes");
      }
      StringList test5 = new StringList();
      if(test4.equals(test5)==true) {
         System.out.println("Yes");
      }
      String[] charlie = {"a","b","c"};
      StringList test6 = new StringList(charlie);
      if(test1.equals(test6)==true) {
         System.out.println("Yes");
      }
      String[] delta = {"d","e","f"};
      StringList test7 = new StringList(delta);
      if(test1.equals(test7)==false) {
         System.out.println("Yes");
      }
      System.out.println();
   }
   
   /** This method tests the isEmpty method */
   public static void testIsEmpty() {
      System.out.println("testIsEmpty: 3 tests");
      StringList test1 = new StringList();
      if(test1.isEmpty()==true) {
         System.out.println("Yes");
      }
      String[] alfa = new String[5];
      StringList test2 = new StringList(alfa);
      if(test2.isEmpty()==false) {
         System.out.println("Yes");
      }
      String[] bravo = new String[0];
      StringList test3 = new StringList(bravo);
      if(test3.isEmpty()==true) {
         System.out.println("Yes");
      }
      System.out.println();
   }
   
   /** This method tests the remove method */
   public static void testRemove() {
      System.out.println("testRemove: 5 tests");
      String[] alfa = {"a","b","c"};
      StringList test1 = new StringList(alfa);
      if(test1.remove("a")==true) {
         System.out.println("Yes");
      }
      if(test1.remove("v")==false) {
         System.out.println("Yes");
      }
      if(test1.remove(" ")==false) {
         System.out.println("Yes");
      }
      StringList test2 = new StringList();
      if(test2.remove("a")==false) {
         System.out.println("Yes");
      }
      if(test2.remove(" ")==false) {
         System.out.println("Yes");
      }
      System.out.println();
   }
   
   /** This method tests the removeAll method */
   public static void testRemoveAll() {
      System.out.println("testRemoveAll: 4 tests");
      String[] alfa = {"a","b","c"};
      StringList test1 = new StringList(alfa);
      StringList test2 = new StringList(alfa);
      if(test1.removeAll(test2)==true) {
         System.out.println("Yes");
      }
      String[] bravo = {"d","e","f"};
      StringList test3 = new StringList(bravo);
      if(test1.removeAll(test3)==false) {
         System.out.println("Yes");
      }
      String[] charlie = {"a", "c", "d"};
      StringList test4 = new StringList(charlie);
      StringList test5 = new StringList();
      if(test1.removeAll(test5)==false) {
         System.out.println("Yes");
      }
      if(test4.removeAll(test3)==true) {
         System.out.println("Yes");
      }
      System.out.println();
   }
   
   /** This method tests the retainAll method */
   public static void testRetainAll() {
      System.out.println("testRetainAll: 4 tests");
      String[] alfa = {"a","b","c","d","e","f"};
      StringList test1 = new StringList(alfa);
      String[] bravo = {"a","b","c"};
      StringList test2 = new StringList(bravo);
      if(test2.retainAll(test1)==true) {
         System.out.println("Yes");
      }
      StringList test3 = new StringList(alfa);
      StringList test4 = new StringList();
      if(test3.retainAll(test4)==false) {
         System.out.println("Yes");
      }
      StringList test5 = new StringList(alfa);
      String[] charlie = {"f"};
      StringList test6 = new StringList(charlie);
      if(test5.retainAll(test6)==true) {
         System.out.println("Yes");
      }
      StringList test7 = new StringList(alfa);
      String[] delta = {"v"};
      StringList test8 = new StringList(delta);
      if(test7.retainAll(test8)==false) {
         System.out.println("Yes");
      }
      System.out.println();
   }
   
   /** This method tests the toArray method */ 
   public static void testToArray() {
      System.out.println("testToArray: 5 tests");
      String[] alfa = {"a","b","c"};
      StringList test1 = new StringList(alfa);
      String[] bravo = test1.toArray();
      if(Arrays.equals(alfa, bravo)) {
         System.out.println("Yes");
      }
      String[] charlie = {"d","e","f"};
      if(!(Arrays.equals(bravo, charlie))) {
         System.out.println("Yes");
      }
      String[] delta = new String[0];
      if(!(Arrays.equals(bravo, delta))) {
         System.out.println("Yes");
      }
      String[] echo = {"a","a","b","b","c","c"};
      if(!(Arrays.equals(bravo, echo))) {
         System.out.println("Yes");
      }
      StringList test2 = new StringList(echo);
      String[] foxtrot = test2.toArray();
      if(Arrays.equals(foxtrot, alfa)) {
         System.out.println("Yes");
      }
      System.out.println();
   }
   
   /** This method tests the size method */
   public static void testSize() {
      System.out.println("testSize: 3 tests");
      String[] alfa = {"a","b","c"};
      StringList test1 = new StringList(alfa);
      if(test1.size()==3) {
         System.out.println("Yes");
      }
      String[] bravo = {"a","a","b","b","c","c"};
      StringList test2 = new StringList(bravo);
      if(test2.size()==3) {
         System.out.println("Yes");
      }
      StringList test3 = new StringList();
      if(test3.size()==0) {
         System.out.println("Yes");
      }
      System.out.println();
   }
   
   /** This method tests the sizeWithDuplicates method */
   public static void testSizeWithDuplicates() {
      System.out.println("testSizeWithDuplicates: 3 tests");
      String[] alfa = {"a","b","c"};
      StringList test1 = new StringList(alfa);
      if(test1.sizeWithDuplicates()==3) {
         System.out.println("Yes");
      }
      String[] bravo = {"a","a","b","b","c","c"};
      StringList test2 = new StringList(bravo);
      if(test2.sizeWithDuplicates()==6) {
         System.out.println("Yes");
      }
      StringList test3 = new StringList();
      if(test3.sizeWithDuplicates()==0) {
         System.out.println("Yes");
      }
      System.out.println();
   }
   
   /** This method tests the count method */
   public static void testCount() {
      System.out.println("testCount: 3 tests");
      String[] alfa = {"a","b","c"};
      StringList test1 = new StringList(alfa);
      if(test1.count("a")==1) {
         System.out.println("Yes");
      }
      String[] bravo = {"a","a","b","b","c","c"};
      StringList test2 = new StringList(bravo);
      if(test2.count("b")==2) {
         System.out.println("Yes");
      }
      StringList test3 = new StringList();
      if(test3.count("a")==0) {
         System.out.println("Yes");
      }
   }
   
   /** This main method is YOUR comprehensive test program for class StringList. */
    public static void main ( String[] args ) {
      testConstructors();
      testAdd();
      testAddAll();
      testClear();
      testContains();
      testContainsAll();
      testEquals();
      testIsEmpty();
      testRemove();
      testRemoveAll();
      testRetainAll();
      testToArray();
      testSize();
      testSizeWithDuplicates();
      testCount();
    }
}
