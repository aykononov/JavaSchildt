package Chapter13.Package02;
/*
Отображение содержимого текстового файла.
Чтобы воспользоваться этой программой, укажите
имя файла, который требуется просмотреть.
Например, чтобы просмотреть файл TEST.TXT,
введите в командной строке следующую команду:

java ShowFile TEST.TXT

В этом варианте программы код, открывающий и получающий
доступ к файлу, заключен в один блок оператора try.
Файл закрывается в блоке оператора finally.
 */
import java.io.*;

class ShowFile2 {
    public static void main(String[] args) {
        int i;
        FileInputStream fin = null;

        // Проверяем, что указано имя файла
        if (args.length != 1) {
            System.out.println("Не указано: имя_файла");
            return;
        }

        // В следующем фрагменте кода сначала открывается файл,
        // а затем из него читаются символы до тех пор, пока
        // не встретится признак конца файла
        try {
            fin = new FileInputStream(args[0]);

            do {
                i = fin.read();
                if (i != -1) System.out.print((char) i);
            } while (i != -1);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");

        } catch (IOException e) {
            System.out.println("Пpoизoшлa ошибка ввода-вывода");

        } finally {
            // закрыть файл в любом случае
            try {
                if (fin != null) fin.close();
            } catch (IOException e) {
                System.out.println("Oшибкa закрытия файла");
            }
        }
    }
}
/*
При таком подходе объект fis инициализируется пустым значением null.
А в блоке оператора finally файл закрывается только в том случае,
если объект fis не содержит пустое значение null. Такой подход оказывается работоспособным потому,
что объект fis не будет содержать пустое значение null только в том случае, если файл успешно открыт.
Таким образом, метод close() не вызывается, если при открытии файла возникает исключение.
 */