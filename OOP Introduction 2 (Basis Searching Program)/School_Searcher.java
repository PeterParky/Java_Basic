import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

class Eschool {
    private String name;
    private int zipcode;
    private String address;
    private String tel;
    private double latitude;
    private double longitude;

    Eschool(String n, int num, String add, String tel, Double lati, Double longi) {
        name = n;
        zipcode = num;
        address = add;
        this.tel = tel;
        latitude = lati;
        longitude = longi;
    }

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

class Rp7_2 {
    static Eschool[] eslist = new Eschool[100];
    static int[] result = new int[100];

    public static void main(String[] args) {
        int i = 0;

        try {
            File file = new File("shougakkou-utf.csv"); // input the csv file name
            Scanner sc = new Scanner(file);
            Scanner input = new Scanner(System.in);

            while (sc.hasNextLine()) { // read a line from the file
                String str = sc.nextLine();
                String[] tmp = str.split(",", 6);
                if (tmp.length == 6) {
                    // create instance object
                    Eschool es = new Eschool(tmp[0], Integer.parseInt(tmp[1]),
                            tmp[2], tmp[3], Double.parseDouble(tmp[4]), Double.parseDouble(tmp[5]));
                    // store the instance to the list
                    eslist[i] = es; 
                    // System.out.println(eslist[i]);
                    i++;
                }
            }

            int num = i; //Save the number of data items in the file

            System.out.printf("Zipcode: ");
            String zip = input.nextLine();

            for (i = 0; i < num; i++) {
                result[i] = 1;
            }

            for (i = 0; i < num; i++) {
                String str = String.valueOf(eslist[i].getZipcode());
                result[i] = zip.compareTo(str); //Compare schools Zipcode to Input Zipcode

                if (result[i] == 0) { //If it matches, print the school name and end the program
                    System.out.println(eslist[i].getName());
                    break;
                }

                if (i == (num - 1)) { //If it doesnt match with any school
                    System.out.println("not found");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.print(e);
        }
    }
}
