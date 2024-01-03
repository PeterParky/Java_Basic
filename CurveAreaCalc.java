/*
 * Calculates curve area via user-defined parameters and rectangles
 */
import java.util.Scanner;

class CurveAreaCalc {
    public static void main(String args[]) {
        double width, a, x; // Width, height
        double y; // Variable to store calculated height for each rectangle
        double area = 0.0; // Variable to accumulate the total estimated area
        double d = 0.0001; // Resolution for dividing the curve into rectangles
        int r = 1; // Counter for rectangles
        int lastR; // Last rectangle to cover the entire width
        Scanner sc = new Scanner(System.in);

        // Input the width of the base
        System.err.print("width: ");
        width = sc.nextDouble();

        // Calculate the number of rectangles needed based on the width and resolution
        lastR = (int) (width / d);

        // Input the coefficient 'a' in the equation y = a * x^2 for the curve
        System.err.print("a: ");
        a = sc.nextDouble();

        // Loop to calculate the area using rectangles under the curve
        while (r <= lastR) { // Loop runs for 'lastR' iterations (width / resolution)
            x = d * r; // Calculate the width of the current small rectangle
            y = a * x * x; // Calculate the height of the current small rectangle (based on the curve
                           // equation)
            area = area + (d * y); // Accumulate the area of the rectangle under the curve
            r++;
        }

        // Output the estimated area calculated using rectangles under the curve
        System.out.println("estimated area: " + area);

        // Calculate the actual area under the curve (using the integral formula for the
        // given curve)
        System.out.println("          area: " + a * width * width * width / 3);

        sc.close();
        return;
    }
}