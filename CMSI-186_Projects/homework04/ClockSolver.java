/* Brady Petrik
   CMSI 186-02
   homework04 - ClockSolver
   Last Modified: 3/15/17
   Purpose: Creates a discrete simulation of a clock and outputs that times
            at which two clock hands form a given angle */
   
import java.lang.Math;
import java.util.Scanner;
   
public class ClockSolver {

   public static int hours = 12;
   public static int minutes = 0;
   public static double angle = 45.0;
   public static double timeSlice = 60.0;
   public static Clock testClock = new Clock();
   public static int totalTime = 43200;
   public static final Scanner console = new Scanner(System.in);
   
   public static void main(String[] args) {
      double s = 0.0;
      System.out.println("Please input an angle to run the Clock Solver (in degrees)");
      s = console.nextDouble();
      angle = s;
      System.out.println("Now input a time slice to run the Clock Solver (in seconds)");
      s = console.nextDouble();
      timeSlice = s;
      timeMoves();
   }

   public static void timeMoves() {
      System.out.println("The hands of the clock are at an approximately " + angle + " degree angle at the following times:");
      double hoursAngle = 0.0;
      double minutesAngle = 0.0;
      double totalAngle = 0.0;
      for(int i = 0; i < totalTime; i++) {
         testClock.tick();
         if(testClock.getHours() == 12) {
            break;
         }
         //this if statement ensures that any value greater than 1 will not automatically
         //change constants or give an output unless the correct time slice has passed
         if(timeSlice >= 1 && (i*60) % timeSlice == 0) {
            for(double j = 0.0; j < 60; j+=timeSlice) {
               hoursAngle = testClock.getHoursAngle();
               minutesAngle = testClock.getMinutesAngle();
               totalAngle = minutesAngle - hoursAngle;
               //this if statement accounts for reverse angles, not just dependent on the hour hand as the base line for the angle
               //it also solves the issue of continuing output once minutes pass 59
               if(minutesAngle < hoursAngle) {
                  totalAngle = hoursAngle - minutesAngle;
               }
               if(Math.abs(totalAngle - angle) <= 5) {
                  System.out.println(testClock.toString());
               }
            }
         }
         //this else statement ensures that, if a time slice is less than one, it will run
         //the appropriate number of times
         else {
            for(double j = 0.0; j < 60; j+=timeSlice) {
               hoursAngle = testClock.getHoursAngle();
               minutesAngle = testClock.getMinutesAngle();
               totalAngle = minutesAngle - hoursAngle;
               //accounts for reverse angles, not just dependent on the hour hand as the base line for the angle
               //also solves issue of continuing output once minutes pass 60
               if(minutesAngle < hoursAngle) {
                  totalAngle = hoursAngle - minutesAngle;
               }
               if(Math.abs(totalAngle - angle) <= 5) {
                  System.out.println(testClock.toString());
               }
            }
         }
      }     
   }
}