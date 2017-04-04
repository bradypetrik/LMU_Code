/* Brady Petrik
   CMSI 186-02
   homework05 - SoccerSim
   Last Modified: 4/3/17
   Purpose: Detects whether or not balls collide  */

import java.lang.Math;
import java.util.Scanner;
import java.util.*;

public class SoccerSim {
   
   private static double seconds = 0;
   private static double endSeconds = 0;
   private static int ballNumber = 0;
   private static int collideSeconds = 0;
   private static String listDisplay = new String();
   public static final Scanner console = new Scanner(System.in);
   public static final SoccerBall[] list = new SoccerBall[100];

   
   public static void main(String[] args) {
      input();
      listFiller();
      ballMoves();
   }
   
   public static void input() {
      while(ballNumber == 0) {
         System.out.println("How many balls would you like to test today?");
         ballNumber = console.nextInt();
      }
      for(int i = 0; i < ballNumber; i++) {
         double varX = 0.0;
         double varY = 0.0;
         System.out.println("What is the x-coordinate of your number " + (i+1) + " ball's position?");
         varX = console.nextDouble();
         System.out.println("What is the y-coordinate of your number " + (i+1) + " ball's position?");
         varY = console.nextDouble();
         list[i] = new SoccerBall(varX, varY);
         listDisplay += list[i].toString();
      }
      System.out.println("Your ball coordinates are: " + listDisplay);
      for(int i = 0; i < ballNumber; i++) {
         double speedX = 0.0;
         double speedY = 0.0;
         System.out.println("What is the x-coordinate change per second of your number " + (i+1) + " ball's position?");
         speedX = console.nextDouble();
         list[i].setXAdd(speedX);
         System.out.println("What is the y-coordinate change per second of your number " + (i+1) + " ball's position?");
         speedY = console.nextDouble();
         list[i].setYAdd(speedY);   
      } 
      System.out.println("For how many seconds would you like to check for ball collisions?");
      endSeconds = console.nextDouble(); 
   }
   
   public static void listFiller() {
      for(int i = ballNumber; i < 100; i++) {
         list[i] = new SoccerBall(457.3, 457.3);
         //Random number I made up to test for empty locations in the list
      }
   }
   
   public static void ballMoves() {
      boolean findCollision = false;
      if(ballNumber == 1) {
         System.out.println("You have only entered information for one ball. It will not collide with anything.");
      }
      for(int i = 0; i < endSeconds; i++) {
         if(findCollision == true) {
            break;
         }
         collideSeconds += 1;
            for(int j = 0; j < ballNumber; j++) {
               list[j].tick();
               double newX = list[j].getXAdd() - (.1*collideSeconds);
               double newY = list[j].getYAdd() - (.1*collideSeconds);
               list[j].setXAdd(newX);
               list[j].setYAdd(newY);
            }
         findCollision = collisionTest();
      }
      if(findCollision == false) {
         System.out.println("No collision detected between the balls during the timespan provided.");
      }
   }
   
   public static boolean collisionTest() {
      for(int i = 0; i < 1; i++) {
         double xVal1 = list[i].getXValue();
         double yVal1 = list[i].getYValue();
         for(int j = i+1; j < ballNumber; j++) {
            double xVal2 = list[j].getXValue();
            double yVal2 = list[j].getYValue();
            if((Math.abs(xVal1 - xVal2) <= 0.75) && (Math.abs(yVal1 - yVal2) <= 0.75)) {
               System.out.println("Balls " + (i+1) + " and " + (j+1) + " collide after " + collideSeconds
                                     + " seconds. They collide near position " + list[i].toString());
               return true;
            }
         }
      }
      return false;                      
   }  

}