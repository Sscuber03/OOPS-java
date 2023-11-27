package program1;

class Person {
    String name;
    String address;
    int age;
    String occupation;

    public Person(String name, String address, int age, String occupation) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.occupation = occupation;
    }

    public void displayInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Address: " + this.address);
        System.out.println("Age: " + this.age);
        System.out.println("Occupation: " + this.occupation);
    }
}

public class PersonDemo {
    public static void main(String[] args) {
        Person p1 = new Person("Ishan", "Gorabazar", 22, "Software Engineer");
        Person p2 = new Person("Soham", "Dum Dum", 20, "Student");
        p1.displayInfo();
        p2.displayInfo();
    }
}
