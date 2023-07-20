import java.util.*;

public class Trebuchet {
   
   // Private variables for array elements
   private int[] speedElements;
   private int[] angleElements;
   private double[][] traj;
   
   // Trebuchet Constructor
   public Trebuchet( int[] speedElements, int[] angleElements ) {
   
   this.speedElements = Arrays.copyOf(speedElements, speedElements.length);
   this.angleElements = Arrays.copyOf(angleElements, angleElements.length);
   this.traj = new double[this.speedElements.length][this.angleElements.length];
   
   // Include Traj Calculation
   calculateTraj();
   
   }
   
   // Get Traj values of Trebuchet
   
   private double getTraj(int trajSpeed, int trajAngle) {

      double trajDistance;
      trajDistance = Math.pow(trajSpeed,2) * Math.sin(2 * Math.toRadians(trajAngle)) / 9.8;
      return trajDistance;
   }
   
   // Calculate Traj of Trebuchet
   
   private void calculateTraj() {
   
      for (int col = 0; col < this.speedElements.length; col++) {
         for (int row = 0; row < this.angleElements.length; row++) {
            this.traj[col][row] = getTraj(this.speedElements[col], this.angleElements[row]);
         }
      }
      
   }
   
   // Print the Trebuchet Table
   
   public void trebuchetTable() {
   
   int angleNumbers = this.angleElements.length;

   System.out.print("\n");
   System.out.print("Projectile Table");

   System.out.print("\n");
   System.out.println("------------------------------");

   System.out.print(String.format("\n%-10s", "Speed"));
   for (int i = 0; i < angleNumbers; i++) {
   System.out.print(String.format("%16d deg", this.angleElements[i]));
   }

   for (int i = 0; i < this.speedElements.length; i++) {
   System.out.print(String.format("\n%10d", this.speedElements[i]));
   
   for (int j = 0; j < angleNumbers; j++) {
   System.out.print(String.format("%20.3f", this.traj[i][j]));
   } 
  }  
 }   
 
   // Get List of Trebuchet Values
   
   public List<String> getTrajValues(double min, double max) {
   List<String> pairs = new ArrayList<String>();

   for (int i = 0; i < this.speedElements.length; i++) {
   for (int j = 0; j < this.angleElements.length; j++) {

   if ((min <= this.traj[i][j]) && (this.traj[i][j] <= max))
   pairs.add(this.speedElements[i] + " " + this.angleElements[j]);
   
   }
  }
   
   System.out.println("------------------------------");

   if (!pairs.isEmpty()) {
   return pairs;
   } else {
   return pairs;   
   }
   
   }
 }