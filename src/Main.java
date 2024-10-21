import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static StudentsList list;

    public static void main(String[] args) {
        list = new StudentsList();
        boolean exit = false;

        do {
            exit = !input();
        } while (!exit);
    }

    private static boolean input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1) Добавить студента\n" +
                "2) Удалить студента\n" +
                "3) Показать список\n" +
                "4) Очистить список\n" +
                "5) Считать из файла\n" +
                "6) Записать в файл\n" +
                "7) Выход");
        if (!sc.hasNextInt()) {
            System.out.println("Введите номер команды:");
            return true;
        }
        switch (sc.nextInt())
        {
            case 1:
                Student student = new Student();
                student.Input();
                list.AddElement(student);
                break;
            case 2:
                System.out.println("Введите номер студента:");
                if (!sc.hasNextInt()) {
                    System.out.println("Ошибка. Введено не число");
                    return true;
                }
                list.RemoveElement(sc.nextInt());
                break;
            case 3:
                for (int i = 0; i < list.getLength(); i++)
                {
                    list.printElement(i);
                }
                break;
            case 4:
                list.Clear();
                break;
            case 5:
                System.out.println("Введите путь к файлу:");
                sc.nextLine();
                list.ReadFromFile(sc.nextLine());
                break;
            case 6:
                System.out.println("Введите путь к файлу:");
                sc.nextLine();
                list.WriteToFile(sc.nextLine());
                break;
            case 7:
                return false;
        }
        return true;
    }
}