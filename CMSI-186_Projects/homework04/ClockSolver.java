/* Brady Petrik
   CMSI 186-02
   homework04 - ClockSolver
   Last Modified: 3/15/17
   Purpose: Creates a discrete simulation of a clock and outputs that times
            at which two clock hands form a given angle */
   
import java.lang.Math;
import java.util.Scanner;
   
public class ClockSolver {

   public static double angle = 45.0;
   public static double timeSlice = 60.0;
   public static Clock testClock = new Clock();
   public static final int TOTAL_TIME = 43200;
   public static final Scanner console = new Scanner(System.in);
   
   public static void main(String[] args) {
      double s = 0.0;
      System.out.println("Please input an angle to run the Clock Solver (in degrees)");
      s = console.nextDouble();
      angle = s;
      while(s <= 0 || s > 360) {
         System.out.println("Please input a valid angle (greater than 0 and less than 360 degrees)");
         s = console.nextDouble();
         angle = s;
      }
      System.out.println("Now input a time slice to run the Clock Solver (in seconds)");
      s = console.nextDouble();
      timeSlice = s;
      while(s <= 0 || s > TOTAL_TIME) {
         System.out.println("Please input a valid time slice (greater than 0 and less than 43200)");
         s = console.nextDouble();
         timeSlice = s;
      }
      timeMoves();
   }

   public static void timeMoves() {
      System.out.println("The hands of the clock are at an approximately " + angle + " degree angle at the following times:");
      double hoursAngle = 0.0;
      double minutesAngle = 0.0;
      double totalAngle = 0.0;
      for(int i = 0; i < TOTAL_TIME; i++) {
         if(testClock.getHours() == 12) {
            break;
         }
         if((timeSlice >= 1 && (i*60) % timeSlice == 0) || timeSlice < 1) {
            for(double j = 0.0; j < 60; j+=timeSlice) {
               hoursAngle = testClock.getHoursAngle();
               minutesAngle = testClock.getMinutesAngle();
               totalAngle = minutesAngle - hoursAngle;
               if(minutesAngle < hoursAngle) {
                  totalAngle = hoursAngle - minutesAngle;
               }
               if(Math.abs(totalAngle - angle) <= 5) {
                  System.out.println(testClock.toString());
               }
            }
         }
         testClock.tick();
      }     
   }
}
