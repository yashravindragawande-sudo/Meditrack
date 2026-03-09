package entity;

public class Person {

    protected int id;
    protected String name;
    protected int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Getter for Name
    public String getName() {
        return name;
    }

    // Getter for Age
    public int getAge() {
        return age;
    }

    public void displayDetails() {
        System.out.println("ID: " + id + " Name: " + name + " Age: " + age);
    }
}