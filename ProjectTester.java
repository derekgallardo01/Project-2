//***********************************************************************************************************************************************
//
//  Name: Derek Gallardo
//  Date: July 3rd, 2022
//  Version: 1.0.0
//  Programming Language: Java
//  Java Version: 17
//  Description: Calculate the trajectory of a projectile based on launch angles and launch velocities. 
//               It will create a matrix of all of the possible trajectories as well as the trajectories to help a team hit the target range. 
//
//***********************************************************************************************************************************************

import java.util.*;
import java.io.*;

public class ProjectTester {

   private static String inputFile = "input.txt";
  
   private static int[] getArrayInt(int number, Scanner input) {
   
   int[] array = new int[number];
  
   for (int i = 0; i < number; i++)
        array[i] = input.nextInt();
        
   return array;
}

   public static void main (String[] args) throws Exception {
      
        
      Scanner input = new Scanner(new File(inputFile));
      int setList = input.nextInt();
      
      for (int i = 0; i < setList; i++) {

      int[] speed = getArrayInt(input.nextInt(), input);
      
      int[] angles = getArrayInt(input.nextInt(), input);
      
      Trebuchet trebuchet = new Trebuchet(speed, angles);
      
      trebuchet.trebuchetTable();

      double minTraj = input.nextFloat();
      
      double maxTraj = input.nextFloat();
      
      // List Best Traj Values
      System.out.println(" ");
      System.out.println("Best Trajectory values: ");
      List<String> bestTrajValues = trebuchet.getTrajValues(minTraj, maxTraj);
      
      for (String value : bestTrajValues) {
      System.out.print(value + " ");
      }
      System.out.println(" ");
      
    

    //  input.close();      
  
     }    

}

}