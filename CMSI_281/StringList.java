/** An object of this class represents a StringList, i.e., an alphabetically-ordered Collection
    of Java Strings, with duplicates permitted. Be sure to read the Java documentation on
    <a href="http://docs.oracle.com/javase/7/docs/api/java/util/Collection.html">interface java.util.Collection</a>.
*/

import java.util.*;

public class StringList implements java.util.Collection {
    
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
      for(int i = 0; i < list.size(); i++) {
         list.remove(i);
      }
             
    }
 

    /** Returns true if this StringList contains at least one instance of obj.toString(). */
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
    public boolean containsAll ( java.util.Collection c ) {
      Iterator it = c.iterator();
      int tally = 0;
      for(int i = 0; i < list.size(); i++) {
         for(int j = 0; j < c.size(); j++) {
            if(list.get(i).equals(it.next())) {
               tally++;
               break;
            }
         }
      }
      return tally == c.size();
    }


    /** Compares the specified object with this Collection for equality, duplicates included. */
    public boolean equals ( Object obj ) {
      if(obj instanceof String) {
         for(int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(obj.toString())) {
               return true;
            }
         }
      }
      return false;
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
            return list.size() < currentIndex;
         }
         
         public String next() {
            int temp = currentIndex;
            currentIndex++;
            return list.get(temp);
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
            if(list.get(i).equals(obj.toString())) {
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
    public boolean removeAll ( java.util.Collection c ) {
      Object[] index = c.toArray();
      boolean tally = false;
      for(int i = 0; i < c.size(); i++) {
         for(int j = 0; j < list.size(); j++) {
            if(list.get(j).equals(index[i].toString())) {
               list.remove(j);
               tally = true;
               j = 0;
            }
         }
      }
      return tally;
    }


	/** Retains only the strings in this collection that are contained in the specified collection.
		 In other words, removes from this collection all of its elements that are NOT contained
		 in the specified collection. */
	public boolean retainAll ( java.util.Collection c ) {
      Object[] index = c.toArray();
      boolean tally = false;
      int count = 0;
      for(int i = 0; i < list.size(); i++) {
         for(int j = 0; j < c.size(); j++) {
            if(list.get(i).equals(index[j].toString())) {
               count++;
            }
         }
         if(count > 0) {
            list.remove(i);
            count = 0;
            i = 0;
            tally = true;
         }
      }
      return tally;
         
	}
 

    /** Returns a String[], that is, an array of Strings, containing all of the elements in this 
        collection, NOT including duplicates. */
    public String[] toArray () {
      int tally = 0;
      int trueTally = 0;
      for(int i = 0; i < list.size(); i++) {
         for(int j = i+1; j < list.size(); j++) {
            if(list.get(i).equals(list.get(j))) {
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
            if(list.get(k).equals(list.get(n))) {
               newTally++;
            }
         }
         if(newTally == 0) {
            output[index] = list.get(k);
            index++;
         }
      }
      return output;
    }


    /** Not supported for this class. */
    public Object[] toArray ( Object[] obj ) {
        /* DO NOT IMPLEMENT THIS METHOD. */
        throw new UnsupportedOperationException();
    }


    /** Returns a count of the strings in this list, NOT including duplicates. */
    public int size () {
      int tally = 0;
      for(int i = 0; i < list.size(); i++) {
         for(int j = i+1; j < list.size(); j++) {
            if(list.get(i).equals(list.get(j))) {
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
    public int count ( Object obj ) {
      int tally = 0;
      for(int i = 0; i < list.size(); i++) {
         if(list.get(i).equals(obj.toString())) {
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

    
    /** This main method is YOUR comprehensive test program for class StringList. */
    public static void main ( String[] args ) {
        /* REPLACE THIS COMMENT AND THE FOLLOWING LINE WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }
    
}
