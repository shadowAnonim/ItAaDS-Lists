import java.util.Scanner;

public class Student {
    private String name;
    private int age;

    public Student() {}

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void Input()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите данные студента.\nИмя:");
        name = sc.nextLine();
        System.out.println("Возраст:");
        age = sc.nextInt();
    }

    public void Print()
    {
        System.out.println(name + " " + age);
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}
