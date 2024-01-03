class MyName {

    String firstName;

    String lastName;

    MyName(String name) {

        String[] list = name.split(" ", 2);

        this.firstName = list[0];

        this.lastName = list[1];

    }

    MyName(String firstName, String lastName) {

        this.firstName = firstName;

        this.lastName = lastName;

    }

    @Override

    public String toString() {
        return lastName + " " + firstName;
    }

}

class MyDate {

    int year;

    int month;

    int day;

    MyDate(int y, int m, int d) {

        this.year = y;

        this.month = m;

        this.day = d;

    }

    MyDate(String str) {
        String[] daylist = str.split("/", 3);
        this.year = Integer.parseInt(daylist[0]);

        this.month = Integer.parseInt(daylist[1]);

        this.day = Integer.parseInt(daylist[2]);
        
    }
    @Override

    public String toString() {
        String str = " (Date of Birth: "

                        + this.year

                        + "/"

                        + this.month

                        + "/"

                        + this.day

                        + ")\n";

        return str;
    }

}

class Person {

    MyName name;

    MyDate birthday;

    String phoneNumber;

    Person[] friends;

    Person(String name, MyDate birthday, String phone) {

        this.name = new MyName(name);

        this.birthday = birthday;

        this.phoneNumber = phone;

    }

    Person(String name, int year, int month, int day, String phone) {

        this.name = new MyName(name);

        this.birthday = new MyDate(year, month, day);

        this.phoneNumber = phone;

    }

    Person(MyName name, int year, int month, int day, String phone) {

        this.name = name;

        this.birthday = new MyDate(year, month, day);

        this.phoneNumber = phone;

    }

    Person(MyName name, MyDate birthday, String phone) {

        this.name = name;

        this.birthday = birthday;

        this.phoneNumber = phone;

    }

    @Override

    public String toString() {

        int i;

        String str;

        str = "NAME: "

                + this.name

                + this.birthday

                + " Phone Number: "

                + phoneNumber

                + "\n"

                + " Number of friends = "

                + this.friends.length

                + "\n";

        for (i = 0; i < this.friends.length; i++) {

            str = str

                    + " Name of friend "

                    + (i + 1)

                    + ": "

                    + this.friends[i].name
                    
                    + this.friends[i].birthday;

        }

        return str;

    }

}

class Person_Generator {

    public static void main(String args[]) {

        // create objects

        Person person1 = new Person("Taro Tokyo", 1985, 9, 20, "080-1234-5678");

        Person person2 = new Person(new MyName("Jiro", "Osaka"), 1981, 6, 18, "090-8765-4321");

        Person person3 = new Person(new MyName("Saburo Aichi"), new MyDate(1981, 12, 23), "090-3333-5555");

        Person person4 = new Person("Shiro Gifu", new MyDate("1974/02/03"), "090-2222-1111");

        Person person5 = new Person("Kuro Gunma", new MyDate(1964, 11, 30), "080-2222-8254");

        Person person6 = new Person(new MyName("Kotaro", "Saitama"), new MyDate("1988/06/06"), "080-2342-1405");

        // register friends of each person

        // Taro's friends

        Person[] person1Friends = new Person[3];

        person1Friends[0] = person2; // Jiro

        person1Friends[1] = person3; // Saburo

        person1Friends[2] = person5; // Kuro

        // Jiro's friends

        Person[] person2Friends = new Person[4];

        person2Friends[0] = person1; // Taro

        person2Friends[1] = person3; // Saburo

        person2Friends[2] = person4; // Shiro

        person2Friends[3] = person6; // Kotaro

        // Saburo's friends

        Person[] person3Friends = new Person[1];

        person3Friends[0] = person4; // Shiro

        // Shiro's friends

        Person[] person4Friends = new Person[3];

        person4Friends[0] = person2; // Jiro

        person4Friends[1] = person3; // Saburo

        person4Friends[2] = person5; // Kuro

        // Kuro's friends

        Person[] person5Friends = new Person[2];

        person5Friends[0] = person1; // Taro

        person5Friends[1] = person4; // Shiro

        // Kotato's friends

        Person[] person6Friends = new Person[1];

        person6Friends[0] = person2; // Jiro

        // set values to each object

        person1.friends = person1Friends;

        person2.friends = person2Friends;

        person3.friends = person3Friends;

        person4.friends = person4Friends;

        person5.friends = person5Friends;

        person6.friends = person6Friends;

        // print each person's data

        System.out.print(person1 + "\n");

        System.out.print(person2 + "\n");

        System.out.print(person3 + "\n");

        System.out.print(person4 + "\n");

        System.out.print(person5 + "\n");

        System.out.print(person6);

    }

}
