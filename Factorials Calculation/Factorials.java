/*
 * Factorials Calculation
 */
class Rp5_022 {
    static long[] f = new long[30];

    // Recursive method to calculate factorials with memoization
    static long fac(int n) {
        long result;
        if (f[n] != 0) {
            return f[n]; // Return precalculated value if available
        }
        result = n;
        for (int i = n - 1; i >= 1; i--) {
            if (f[i] != 0) {
                // Use precalculated f[i] values for computation
                System.out.println("  result = " + result + " * f(" + i + ")");
                result *= fac(i);
                break;
            } else {
                // Continue calculating using iterative approach until reaching precalculated
                // values
                System.out.println("  result = " + result + " * " + i);
                result *= i;
            }
        }
        f[n] = result; // Store calculated value in the array for reuse
        return result;
    }

    public static void main(String arts[]) {
        int i;
        long r;
        for (i = 1; i <= 15; i++) {
            r = fac(i);
            System.out.println("f(" + i + ") = " + r);
        }
    }
}
