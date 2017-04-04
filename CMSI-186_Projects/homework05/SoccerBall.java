/* Brady Petrik
   CMSI 186-02
   homework05 - SoccerSim
   Last Modified: 4/3/17 
   Purpose:  Constructor of Soccer Ball object for use in SoccerSim*/
   
public class SoccerBall {
   
   private double xValue = 0;
   private double yValue = 0;
   private double xAdd = 0;
   private double yAdd = 0;
   private int weight = 1;
   
   public static void main(String[] args) {
     SoccerBall test = new SoccerBall(3,4); 
   }
   
   public SoccerBall(double x, double y) {
      this.xValue = x;
      this.yValue = y;
   }
   
   public double getXValue() {
      return xValue;
   }
   
   public double getYValue() {
      return yValue;
   }
   
   public double getXAdd() {
      return xAdd;
   }
   
   public double getYAdd() {
      return yAdd;
   }
   
   public void setXAdd(double setValue) {
      xAdd = setValue;
   }
   
   public void setYAdd(double setValue) {
      yAdd = setValue;
   }
   
   public double getRadius() {
      return 0.375;
   }
   
   public String toString() {
      String output = "[" + xValue + ", " + yValue + "]";
      return output;
   }
   
   public void tick() {
      xValue += xAdd;
      yValue += yAdd;
   }
}