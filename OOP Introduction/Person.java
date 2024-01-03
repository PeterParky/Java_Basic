class Person {
    String firstName; // firstname
    String lastName; // lastname
    int birthYear; // year of birthdate
    int birthMonth; // month of birthdate
    int birthDay; // day of birthdate
    String phoneNumber; // phone number
    Person[] friends; // friends list
     
    Person(String firstN, String lastN, int year, int month, int day, String phone) {
        this.firstName   = firstN;
        this.lastName    = lastN;
        this.birthYear   = year;
        this.birthMonth  = month;
        this.birthDay   = day;
        this.phoneNumber = phone;
    }
}