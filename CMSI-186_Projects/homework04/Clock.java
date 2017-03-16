/* Brady Petrik
   CMSI 186-02
   homework04 - ClockSolver
   Last Modified: 3/15/17
   Purpose: Creates a Clock object */
            
public class Clock {
   
   private int hours = 0;
   private int minutes = 0;
   private double minutesAngle = 0.0;
   private double hoursAngle = 0.0; 
   
   public static void main(String[] args) {
      Clock testClock = new Clock();
      testClock.toString();
      testClock.tick();
      testClock.toString();
      Clock testClock2 = new Clock(3,59);
      testClock2.toString();
      testClock2.tick();
      testClock2.toString();
      Clock testClock3 = new Clock(11,59);
      testClock3.toString();
      testClock3.tick();
      testClock3.toString();
   }
   
   public Clock() {
      hours = 0;
      minutes = 0;
   }
   
   public Clock(int inputHours, int inputMinutes) {
      hours = inputHours;
      minutes = inputMinutes;
   }
   
   public void tick() {
      minutes++;
      minutesAngle += 6.0;
      hoursAngle += 0.5;
      if(minutes == 60) {
         hours++;
         minutes = 0;
         minutesAngle = 0;
      }       
   }
   
   
   public int getMinutes() {
      return minutes;
   }
   
   public int getHours() {
      return hours;
   }
   
   public double getMinutesAngle() {
      return minutesAngle;
   }
   
   public double getHoursAngle() {
      return hoursAngle;
   }
   
   public String toString() {
      String whatTime = new String();
      if(hours == 0) {
         if(minutes < 10) {
            whatTime = "12:0" + minutes;
         } else {
            whatTime = "12:" + minutes;
         }
      } else if(minutes < 10) {
         whatTime = hours + ":0" + minutes;
      } else {
         whatTime = hours + ":" + minutes;
      }
      return whatTime;
   }
}
      