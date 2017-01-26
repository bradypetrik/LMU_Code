/* Brady Petrik
   CMSI 186-02
   homework01 - CountTheDays
   Last Modified: 1/25/2017
   Purpose: Code is able to return various values when given sets of dates */

import java.util.*;
   
public class CountTheDaysBackup {
   public static void main(String args[]) {
      daysBetween(10, 22, 2014, 1, 26, 2017);
   }
   
   public static boolean isLeapYear(long year) {
      if(year % 4 != 0){
         return false;
      } else if(year % 100 != 0) {
         return true;
      } else if(year % 400 != 0) {
         return false;
      } else {
         return true;
      }
   }
   
   public static long daysInMonth(long month, long year) {
      boolean leapYear = isLeapYear(year);
      if(month == 2) {
         if(leapYear == true){
            long numberOfDays = 29;
            return numberOfDays;
         } else {
            long numberOfDays = 28;
            return numberOfDays;
         }
      } else if(month == 4 || month ==  5 || month ==  9 || month ==  11) {
         long numberOfDays = 30;
         return numberOfDays;
      } else {
         long numberOfDays = 31;
         return numberOfDays; 
      }
   }
   
   public static boolean isDateValid(long month, long day, long year) {
       //Eliminates out of range answers immediately before spending time
       //checking in depth solutions
       if(month <= 0 || month >= 13) {
         return false;
       } if (day <= 0 || day >= 32) {
         return false;
       } if (year < 0) {
         return false;
       }
       //February
       if(month == 2) {
         if(isLeapYear(year) == true) {
            if(day <= 29) {
               return true;
            }
         } else if(day <=28) {
            return true;
         }
       } 
       //30 day months
        else if(month == 4 || month ==  5 || month ==  9 || month ==  11) {
         if(day <=30) {
            return true;
         }
       }
       //31 day months
       else {
         if(day <= 31) {
            return true;
         }
       }
       return false;
    } 
    
   public static long daysBetween (long month0, long day0, long year0, long month1, long day1, long year1) {
      if(isDateValid(month0, day0, year0) == false) {
         return 0;
      }
      if(isDateValid(month1, day1, year1) == false) {
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
            if(year0==year1 && month0 == month1){
               monthDays = monthDays + Math.abs(day0 - day1);
               System.out.println("There are " + monthDays + " days between " + month0 + "/" + day0 + "/" + year0 + " and " + month1 + "/" + day1 + "/" + year1);
               return monthDays;
            } else {
               for(long j = smallerMonth + 1; j < 13; j++) { 
                  monthDays = monthDays + daysInMonth(j,i);
               }
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