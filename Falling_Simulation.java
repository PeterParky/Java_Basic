/*
 * Falling Simulation
 * simulates the motion of an object under gravity
 */
class FallDouble {
     public static void main(String args[]) {
          // Declare variables to store position (x, y) and their respective speeds
          // (x_speed, y_speed)
          double x, y, x_speed, y_speed;
          double g; // Variable to store gravitational acceleration

          // Set gravitational acceleration (approximately Earth's gravity, -10 m/s^2)
          g = -10;

          // Initialize initial values for position and speed
          x = 0; // Initial horizontal position
          y = 100000; // Initial vertical position (starting at a high altitude)
          x_speed = 800; // Initial horizontal speed
          y_speed = 0; // Initial vertical speed

          // Simulation loop to calculate the falling motion until y reaches or goes below
          // 0
          while (y >= 0) {
               // Update vertical speed based on gravity (divided by 100000 for simulation
               // precision)
               y_speed = y_speed + g / 100000;

               // Update horizontal and vertical positions based on their respective speeds
               x = x + x_speed / 100000;
               y = y + y_speed / 100000;
          }

          // Output the estimated horizontal distance reached before landing
          System.out.print("estimated distance = " + x + "\n");
          return;
     }
}
