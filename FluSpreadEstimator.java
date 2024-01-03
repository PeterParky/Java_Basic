/*
 * Models flu spread across locations using historical data and growth rates, estimating total flu cases for a specified day
 */
class Flu_rp614 {
    static final int INITIAL = 10;

    // Arrays to store flu history in different locations
    static int fluInHamamatsuHistory[] = new int[300];
    static int fluInIwataHistory[] = new int[300];
    static int fluInTokyoHistory[] = new int[300];

    public static void main(String args[]) {
        int i, n, d;
        d = 299;

        // Initialize flu history arrays
        for (i = 0; i <= d; i++) {
            fluInHamamatsuHistory[i] = 0;
            fluInIwataHistory[i] = 0;
            fluInTokyoHistory[i] = 0;
        }

        // Calculate estimated total flu cases in Hamamatsu for a specific day
        n = fluInHamamatsu(d);

        System.out.print("Total " + n + " people may have flu in day " + d +"\n");

        return;
    }

    // Calculate estimated flu cases in Hamamatsu based on historical data
    static int fluInHamamatsu(int day) {
        int r;

        if (day == 0) {
            return INITIAL;
        } else if (fluInHamamatsuHistory[day] != 0) {
            return fluInHamamatsuHistory[day];
        } else {
            r = fluInHamamatsu(day - 1);
            r += fluInIwata(day - 1) * 0.01;
            r += fluInTokyo(day - 1) * 0.01;
            r *= 1.01;
            if (r < 100 && day % 10 == 0) {
                r += 1;
            }
            fluInHamamatsuHistory[day] = r;
        }

        return r;
    }

    // Calculate estimated flu cases in Iwata based on historical data
    static int fluInIwata(int day) {
        int r;

        if (day == 0) {
            return INITIAL;
        } else if (fluInIwataHistory[day] != 0) {
            return fluInIwataHistory[day];
        } else {
            r = fluInIwata(day - 1);
            r *= 1.01;
            if (r < 100 && day % 10 == 0) {
                r += 1;
            }
            fluInIwataHistory[day] = r;
        }

        return r;
    }

    // Calculate estimated flu cases in Tokyo based on historical data
    static int fluInTokyo(int day) {
        int r;

        if (day == 0) {
            return INITIAL;
        } else if (fluInTokyoHistory[day] != 0) {
            return fluInTokyoHistory[day];
        } else {
            r = fluInTokyo(day - 1);
            r *= 1.10;
            if (r < 10 && day % 10 == 0) {
                r += 1;
            }
            fluInTokyoHistory[day] = r;
        }
        
        return r;
    }
}
