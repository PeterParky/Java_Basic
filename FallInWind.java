/*
 * Simulates falling with gravity and wind
 */

import java.util.Scanner;

public class FallInWind {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Declare and initialize variables
        double x, y, x_speed, y_speed, x_initial_speed;
        double x_wind_speed;
        double r;
        double g;
        int x_approximate;

        // Set constants and initial values
        g = -9.80665; // Gravitational acceleration (m/s²)
        x = 0; // Initial horizontal position
        y = 100000; // Initial vertical position

        // Input wind speed until a valid positive value is provided
        do {
            System.out.printf("x_wind_speed: ");
            x_wind_speed = sc.nextDouble();
            if (x_wind_speed <= 0) {
                System.out.printf("Wind speed must be greater than 0.\n");
                continue;
            } else
                break;
        } while (true);

        x_initial_speed = 800; // Initial horizontal speed
        x_speed = x_initial_speed; // Set initial horizontal speed
        y_speed = 0; // Initial vertical speed
        r = 100000; // Precision factor for simulation

        // Simulate falling motion considering wind effects until the object hits the ground (y < 0)
        while (y >= 0) {
            // Calculate vertical speed considering gravity
            y_speed += g / r;

            // Check altitude and adjust horizontal speed accordingly
            if (y > 8000) {
                x_speed = x_initial_speed + x_wind_speed; // Apply additional wind-induced speed
            } else {
                x_speed = x_initial_speed; // Maintain initial horizontal speed
            }

            // Update positions based on respective speeds
            x += x_speed / r;
            y += y_speed / r;
        }

        // Approximate the horizontal distance to the nearest hundred meters
        x_approximate = (int) (x + 50) / 100;
        x_approximate *= 100;

        // Output the estimated horizontal distance covered before landing
        System.out.print("estimated distance = " + x + "\n");
        System.out.print("estimated distance is approximately = " + x_approximate + "[m]\n");
        sc.close();
        return;
    }
}
