/**
 *  File name     :  CalendarStuff.java
 *  Purpose       :  Provides a class with supporting methods for CountTheDays.java program
 *  Author        :  B.J. Johnson (prototype)
 *  Date          :  2017-01-02 (prototype)
 *  Author        :  Brady Petrik
 *  Date          :  1/25/17
 *  Description   :  This file provides the supporting methods for the CountTheDays program which will
 *                   calculate the number of days between two dates.  It shows the use of modularization
 *                   when writing Java code, and how the Java compiler can "figure things out" on its
 *                   own at "compile time".  It also provides examples of proper documentation, and uses
 *                   the source file header template as specified in the "Greeter.java" template program
 *                   file for use in CMSI 186, Spring 2017.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-02  B.J. Johnson  Initial writing and release
 */
public class CalendarStuffFull {

  /**
   * A listing of the days of the week, assigning numbers; Note that the week arbitrarily starts on Sunday
   */
   private static final int SUNDAY    = 0;
   private static final int MONDAY    = SUNDAY    + 1;
   private static final int TUESDAY   = MONDAY    + 1;
   private static final int WEDNESDAY = TUESDAY   + 1;
   private static final int THURSDAY  = WEDNESDAY + 1;
   private static final int FRIDAY    = THURSDAY  + 1;
   private static final int SATURDAY  = FRIDAY    + 1;

  /**
   * A listing of the months of the year, assigning numbers; I suppose these could be ENUMs instead, but whatever
   */
   private static final int JANUARY    = 0;
   private static final int FEBRUARY   = JANUARY   + 1;
   private static final int MARCH      = FEBRUARY  + 1;
   private static final int APRIL      = MARCH     + 1;
   private static final int MAY        = APRIL     + 1;
   private static final int JUNE       = MAY       + 1;
   private static final int JULY       = JUNE      + 1;
   private static final int AUGUST     = JULY      + 1;
   private static final int SEPTEMBER  = AUGUST    + 1;
   private static final int OCTOBER    = SEPTEMBER + 1;
   private static final int NOVEMBER   = OCTOBER   + 1;
   private static final int DECEMBER   = NOVEMBER  + 1;

  /**
   * An array containing the number of days in each month
   *  NOTE: this excludes leap years, so those will be handled as special cases
   */
   private static int[]    days        = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

  /**
   * The constructor for the class
   */
   public CalendarStuffEmpty() {
      System.out.println( "Constructor called..." );
   }

  /**
   * A method to determine if the year argument is a leap year or not<br />
   *  Leap years are every four years, except for even-hundred years, except for every 400
   * @param    year  long containing four-digit year
   * @return         boolean which is true if the parameter is a leap year
   */
   public static boolean isLeapYear( long year ) {
      if(year % 4 != 0){
         //System.out.println("Sorry, " + year + " is not a leap year");
         return false;
      } else if(year % 100 != 0) {
         //System.out.println("Heyo, " + year + " is a leap year!");
         return true;
      } else if(year % 400 != 0) {
         //System.out.println("Sorry, " + year + " is not a leap year");
         return false;
      } else {
         //System.out.println("Heyo, " + year + " is a leap year!");
      return true;
      }
   }

  /**
   * A method to calculate the days in a month, including leap years
   * @param    month long containing month number, starting with "1" for "January"
   * @param    year  long containing four-digit year; required to handle Feb 29th
   * @return         long containing number of days in referenced month of the year
   * notes: remember that the month variable is used as an indix, and so must
   *         be decremented to make the appropriate index value
   */
   public static long daysInMonth( long month, long year ) {
      boolean leapYear = isLeapYear(year);
      if(month == 2) {
         if(leapYear == true){
            long numberOfDays = 29;
            //System.out.println(month + ", " + year + " has " + numberOfDays + " days");
            return numberOfDays;
         } else {
            long numberOfDays = 28;
            //System.out.println(month + ", " + year + " has " + numberOfDays + " days");
            return numberOfDays;
         }
      } else if(month == 4 || month ==  5 || month ==  9 || month ==  11) {
         long numberOfDays = 30;
         //System.out.println(month + ", " + year + " has " + numberOfDays + " days");
         return numberOfDays;
      } else {
         long numberOfDays = 31;
         //System.out.println(month + ", " + year + " has " + numberOfDays + " days");
         return numberOfDays;
      }
   }

  /**
   * A method to determine if two dates are exactly equal
   * @param    month1 long    containing month number, starting with "1" for "January"
   * @param    day1   long    containing day number
   * @param    year1  long    containing four-digit year
   * @param    month2 long    containing month number, starting with "1" for "January"
   * @param    day2   long    containing day number
   * @param    year2  long    containing four-digit year
   * @return          boolean which is true if the two dates are exactly the same
   */
   public static boolean dateEquals( long month1, long day1, long year1, long month2, long day2, long year2 ) {
      if(month1==month2 && day1==day2 && year1==year2) {
         return true;
      } else {
         return false;
      }
   }

  /**
   * A method to compare the ordering of two dates
   * @param    month1 long   containing month number, starting with "1" for "January"
   * @param    day1   long   containing day number
   * @param    year1  long   containing four-digit year
   * @param    month2 long   containing month number, starting with "1" for "January"
   * @param    day2   long   containing day number
   * @param    year2  long   containing four-digit year
   * @return          int    -1/0/+1 if first date is less than/equal to/greater than second
   */
   public static int compareDate( long month1, long day1, long year1, long month2, long day2, long year2 ) {
      return 0;
   }

  /**
   * A method to return whether a date is a valid date
   * @param    month long    containing month number, starting with "1" for "January"
   * @param    day   long    containing day number
   * @param    year  long    containing four-digit year
   * @return         boolean which is true if the date is valid
   * notes: remember that the month and day variables are used as indices, and so must
   *         be decremented to make the appropriate index value
   */
   public static boolean isDateValid( long month, long day, long year ) {
       //Eliminates out of range answers immediately before spending time
       //checking in depth solutions
       if(month <= 0 || month >= 13) {
         //System.out.println(month + " " + " " + day + " " + year + " Not a valid date");
         return false;
       } if (day <= 0 || day >= 32) {
         //System.out.println(month + " " + " " + day + " " + year + " Not a valid date");
         return false;
       } if (year < 0) {
         //System.out.println(month + " " + " " + day + " " + year + " Not a valid date");
         return false;
       }
       //February
       if(month == 2) {
         if(isLeapYear(year) == true) {
            if(day <= 29) {
               //System.out.println(month + " " + " " + day + " " + year + " Valid date");
               return true;
            }
         } else if(day <=28) {
            //System.out.println(month + " " + " " + day + " " + year + " Valid date");
            return true;
         }
       }
       //30 day months
        else if(month == 4 || month ==  5 || month ==  9 || month ==  11) {
         if(day <=30) {
            //System.out.println(month + " " + " " + day + " " + year + " Valid date");
            return true;
         }
       }
       //31 day months
       else {
         if(day <= 31) {
            //System.out.println(month + " " + " " + day + " " + year + " Valid date");
            return true;
         }
       }
       //System.out.println(month + " " + " " + day + " " + year + " Not a valid date");
      return false;
   }

  /**
   * A method to return a string version of the month name
   * @param    month long   containing month number, starting with "1" for "January"
   * @return         String containing the string value of the month (no spaces)
   */
   public static String toMonthString( int month ) {
      switch( month - 1 ) {
         default: throw new IllegalArgumentException( "Illegal month value given to 'toMonthString()'." );
      }
   }

  /**
   * A method to return a string version of the day of the week name
   * @param    day int    containing day number, starting with "1" for "Sunday"
   * @return       String containing the string value of the day (no spaces)
   */
   public static String toDayOfWeekString( int day ) {
      switch( day - 1 ) {
         default       : throw new IllegalArgumentException( "Illegal day value given to 'toDayOfWeekString()'." );
      }
   }

  /**
   * A method to return a count of the total number of days between two valid dates
   * @param    month1 long   containing month number, starting with "1" for "January"
   * @param    day1   long   containing day number
   * @param    year1  long   containing four-digit year
   * @param    month2 long   containing month number, starting with "1" for "January"
   * @param    day2   long   containing day number
   * @param    year2  long   containing four-digit year
   * @return          long   count of total number of days
   */
   public static long daysBetween( long month0, long day0, long year0, long month1, long day1, long year1 ) {
      if(isDateValid(month0, day0, year0) == false) {
         //System.out.println("Please input two valid dates");
         return 0;
      }
      if(isDateValid(month1, day1, year1) == false) {
         //System.out.println("Please input two valid dates");
         return 0;
      }
      long numberOfDays = 0;
      long biggerYear = 0;
      long smallerYear = 0;
      long biggerMonth = 0;
      long smallerMonth = 0;
      long monthDays = 0;
      long bonusDays = 0;
      //Determines which year is larger for leap year calculations
      if(year0 > year1) {
         biggerYear = year0;
         smallerYear = year1;
         biggerMonth = month0;
         smallerMonth = month1;
      } else {
         biggerYear = year1;
         smallerYear = year0;
         biggerMonth = month1;
         smallerMonth = month0;
      }
      //Also calculates the number of days in each month and adds them to a tally
      for(long i = smallerYear; i <= biggerYear; i++) {
         if(i == smallerYear) {
            if(year0 == year1 && month0 == month1) {
               monthDays = monthDays + Math.abs(day0-day1);
               System.out.println("There are " + monthDays + " days between " + month0 + "/" + day0 + "/" + year0 + " and " + month1 + "/" + day1 + "/" + year1);
               return monthDays;
            }
            for(long j = smallerMonth + 1; j < 13; j++) {
               monthDays = monthDays + daysInMonth(j,i);
            }
         } else if(i == biggerYear) {
            for(long j = 1; j < smallerMonth; j++) {
               monthDays = monthDays + daysInMonth(j,i);
            }
         } else {
            for(long j = 1; j < 13; j++) {
               monthDays = monthDays + daysInMonth(j,i);
            }
         }
      }
      bonusDays = daysInMonth(month0, year0) - day0 + day1;
      if(year1 == year0 && month1 == month0 && day1 == day0) {
         System.out.println("There are " + numberOfDays + " days between " + month0 + "/" + day0 + "/" + year0 + " and " + month1 + "/" + day1 + "/" + year1);
         return numberOfDays;
      }
      numberOfDays = monthDays + bonusDays;
      System.out.println("There are " + numberOfDays + " days between " + month0 + "/" + day0 + "/" + year0 + " and " + month1 + "/" + day1 + "/" + year1);
      return numberOfDays;
   }

}