import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

class Eschool {
    // Class to represent a school
    // Attributes of the school
    private String name;
    private int zipcode;
    private String address;
    private String tel;
    private double latitude;
    private double longitude;

    // Constructor to initialize the school attributes
    Eschool(String n, int num, String add, String tel, Double lati, Double longi) {
        name = n;
        zipcode = num;
        address = add;
        this.tel = tel;
        latitude = lati;
        longitude = longi;
    }

    // Getter and setter methods for each attribute of the school
    // Getter methods retrieve the value of the attribute
    // Setter methods set the value of the attribute
    public void setName(String n) {
        name = n;
    }
    
    public void setZipcode(int num) {
        zipcode = num;
    }
    
    public void setAddress(String add) {
        address = add;
    }
    
    public void setTelephone(String tel) {
        this.tel = tel;
    }
    
    public void setLatitude(double n) {
        latitude = n;
    }
    
    public void setLongitude(double n) {
        longitude = n;
    }

    public String getName() {
        return name;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return this.tel;
    }

    public double getlatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    // toString method to represent the school details as a string
    @Override
    public String toString() {
        String eslist;
        eslist = name
                + ": 〒"
                + String.valueOf(zipcode) + " "
                + address
                + " TEL:"
                + tel + " "
                + String.valueOf(latitude) + ", "
                + String.valueOf(longitude) + "\n";
        return eslist;
    }
}

class School_Searcher {
    static Eschool[] eslist = new Eschool[100]; // Array to store school objects
    static int[] result = new int[100]; // Array to store comparison results

    public static void main(String[] args) {
        int i = 0;

        try {
            File file = new File("shougakkou-utf.csv"); // Input file name
            Scanner sc = new Scanner(file);
            Scanner input = new Scanner(System.in);

            // Read data from the CSV file and create Eschool objects
            while (sc.hasNextLine()) { // Read a line from the file
                String str = sc.nextLine();
                String[] tmp = str.split(",", 6);
                if (tmp.length == 6) {
                    // Create an Eschool object with data from CSV
                    Eschool es = new Eschool(tmp[0], Integer.parseInt(tmp[1]),
                            tmp[2], tmp[3], Double.parseDouble(tmp[4]), Double.parseDouble(tmp[5]));
                    // Store the Eschool object in the list
                    eslist[i] = es;
                    i++;
                }
            }

            int num = i; // Save the number of data items in the file

            // Get user input for zipcode to search for a school
            System.out.printf("Zipcode: ");
            String zip = input.nextLine();

            // Initialize comparison results array
            for (i = 0; i < num; i++) {
                result[i] = 1;
            }

            // Compare user input zipcode with school zipcodes
            for (i = 0; i < num; i++) {
                String str = String.valueOf(eslist[i].getZipcode());
                result[i] = zip.compareTo(str); // Compare school's Zipcode to input Zipcode

                if (result[i] == 0) { // If it matches, print the school name and end the program
                    System.out.println(eslist[i].getName());
                    break;
                }

                if (i == (num - 1)) { // If it doesn't match with any school
                    System.out.println("not found");
                }
            }

            sc.close();
            input.close();
        } catch (FileNotFoundException e) {
            System.err.print(e);
        }
    }
}
