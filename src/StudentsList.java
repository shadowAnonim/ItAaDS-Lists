import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class StudentsList {
    StudentsListNode first;

    public void AddElement(Student student)
    {
        if (IsEmpty())
            first = new StudentsListNode(student);
        else
        {
            StudentsListNode last = getLastNode();
            last.next = new StudentsListNode(student);
        }
    }

    public void RemoveElement(int index)
    {
        if (index >= getLength())
        {
            System.out.println("Ошибка. Индекс элемента больше длины массива");
            return;
        }
        if (index == 0)
            first = first.next;
        else
        {
            StudentsListNode cur, prev;
            cur = first.next;
            prev = first;
            for (int i = 1; i < index; i++)
            {
                prev = cur;
                cur = cur.next;
            }
            prev.next = cur.next;
        }
    }

    public void printElement(int index)
    {
        if (index >= getLength())
        {
            System.out.println("Ошибка. Индекс элемента больше длины массива");
            return;
        }
        StudentsListNode cur = first;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.student.Print();
    }

    public void Clear()
    {
        first = null;
    }

    public boolean IsEmpty()
    {
        return first == null;
    }

    private StudentsListNode getLastNode()
    {
        if (IsEmpty())
            return null;
        StudentsListNode cur = first;
        while (cur.next != null)
        {
            cur = cur.next;
        }
        return cur;
    }

    public Student getElement(int index)
    {
        if (index >= getLength())
        {
            System.out.println("Ошибка. Индекс элемента больше длины массива");
            return null;
        }
        StudentsListNode cur = first;
        for (int i = 0; i < index; i++)
        {
            cur = cur.next;
        }
        return cur.student;
    }

    public int getLength()
    {
        if (IsEmpty())
            return 0;
        int cnt = 1;
        StudentsListNode cur = first;
        while (cur.next != null)
        {
            cnt += 1;
            cur = cur.next;
        }
        return cnt;
    }

    public void WriteToFile(String uri)
    {
        Path path = Path.of(uri);
        if (!Files.exists(path))
            try{
                Files.createFile(path);
            }
            catch (IOException ex){
                System.out.println("Ошибка при создании файла");
                return;
            }

        StudentsListNode cur = first;
        String content = "";
        while (cur != null)
        {
            content += cur.student.toString() + "\n";
            cur = cur.next;
        }
        try {
            Files.write(path, content.getBytes());
        }
        catch (IOException ex)
        {
            System.out.println("Ошибка при записи в файл");
            return;
        }
    }

    public void ReadFromFile(String uri)
    {
        Path path = Path.of(uri);
        if (!Files.exists(path))
        {
            System.out.println("Файл не существует");
            return;
        }
        try
        {
            Scanner sc = new Scanner(new File(uri));
            while (sc.hasNextLine())
            {
                AddElement(new Student(sc.next(), sc.nextInt()));
            }
        }
        catch (IOException ex)
        {
            System.out.println("Ошибка при чтении файла");
            return;
        }

    }
}
