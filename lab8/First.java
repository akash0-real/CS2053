import java.util.ArrayList;
import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arr arr = new Arr();

        while (true) {
            System.out.println("\n1. Input Students");
            System.out.println("2. Insert Student at Index");
            System.out.println("3. Remove Student by Name");
            System.out.println("4. Display All");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int ch = scanner.nextInt();
            scanner.nextLine(); 

            switch (ch) {
                case 1 -> arr.input(scanner);
                case 2 -> arr.insert(scanner);
                case 3 -> arr.remove(scanner);
                case 4 -> arr.display();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}

class Student {
    private String name;
    private int year;
    private String course;
    private int age;

    public Student(String name, int year, String course, int age) {
        this.name = name;
        this.year = year;
        this.course = course;
        this.age = age;
    }

    public String getName() { return name; }
    public int getYear() { return year; }
    public String getCourse() { return course; }
    public int getAge() { return age; }

    public void setName(String name) { this.name = name; }
    public void setYear(int year) { this.year = year; }
    public void setCourse(String course) { this.course = course; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return name + " | Year: " + year + " | Course: " + course + " | Age: " + age;
    }
}

class Arr {
    ArrayList<Student> one = new ArrayList<>();

    void input(Scanner scanner) {
        System.out.print("Enter how many students you want to add: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < choice; i++) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter year: ");
            int year = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter course: ");
            String course = scanner.nextLine();
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            one.add(new Student(name, year, course, age));
        }
    }

    void insert(Scanner scanner) {
        System.out.print("Enter index where you want to insert: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 0 || index > one.size()) {
            System.out.println("Invalid index!");
            return;
        }

        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter course: ");
        String course = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        one.add(index, new Student(name, year, course, age));
        System.out.println("Student inserted successfully!");
    }

    void remove(Scanner scanner) {
        System.out.print("Enter name to remove: ");
        String remove = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < one.size(); i++) {
            if (one.get(i).getName().equalsIgnoreCase(remove)) {
                one.remove(i);
                System.out.println("Removed student: " + remove);
                found = true;
                break;
            }
        }

        if (!found)
            System.out.println("No student found with name: " + remove);
    }

    void display() {
        if (one.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        System.out.println("\n--- Student List ---");
        for (Student s : one) {
            System.out.println(s);
        }
    }
}
