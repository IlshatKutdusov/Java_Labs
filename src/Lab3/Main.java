package Lab3;

/*
Вариант:
 - 7. 000010110 0 1
События:
 - 2. Обращение к указанному массиву
 - 3. Равенство указанного объекта некоторому значению
 - 5. Изменение указанной переменной
Путь к файлу "Журнал":
 - Задать с консоли
Способ реализации событий:
 - Использовать класс Observable и интерфейс Observer
 */

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

//Обозреватель
class Watcher implements Observer {
    public String LogFilePath = "DefaultLogFile.txt";
    public void update(Observable obs, Object arg) {

    }
}

//Наблюдаемый объект
class MyClassLab3 extends Observable {
    public String SourceFilePath = "DefaultSourceFile.txt", LogFilePath = "DefaultLogFile.txt";
    public ArrayList<String> Even = new ArrayList<String>(); //четный
    public ArrayList<String> Uneven = new ArrayList<String>(); //нечетный

    public void notifyObs() {
        setChanged();
        notifyObservers();
    }

    public void ConsoleReadPath() {
        Scanner ConsoleReadPath = new Scanner(System.in);

        System.out.println("Source file:");
        if (ConsoleReadPath.hasNextLine()) {
            SourceFilePath = ConsoleReadPath.nextLine();
        } else {
            System.out.println("Error!");
        }

        System.out.println("Log file:");
        if (ConsoleReadPath.hasNextLine()) {
            LogFilePath = ConsoleReadPath.nextLine();
        } else {
            System.out.println("Error!");
        }

        ConsoleReadPath.close();
    }

    public void ReadLinesFromSourceFile() {
        try {
            File SourceFile = new File(SourceFilePath);
            if (!SourceFile.exists()) {
                SourceFile.createNewFile();
            }
            else {
                BufferedReader SourceFileReader = new BufferedReader(new FileReader(SourceFile.getAbsoluteFile()));
                String x;
                while ((x = SourceFileReader.readLine()) != null) {
                    if (Integer.parseInt(x) < 0) {
                        if (Integer.parseInt(x) % 2 == 0) {
                            Even.add(x);
                        } else {
                            Uneven.add(x);
                        }
                    }
                }
                SourceFileReader.close();
            }
        } catch (Exception ex) {
            System.out.println("Error! Message: " + ex);
        }
    }

    public void WriteResultToLogFile() {
        try {
            File LogFile = new File(LogFilePath);
            if (!LogFile.exists()) {
                LogFile.createNewFile();
            }
            else {
                FileWriter LogFileWriter = new FileWriter(LogFile.getAbsoluteFile(), true);
                if (Even.size() == Uneven.size()) {
                    LogFileWriter.write(LocalDateTime.now() + " Колчество тех и других равно\n");
                } else {
                    if (Even.size() > Uneven.size()) {
                        LogFileWriter.write(LocalDateTime.now() + " Больше «чётных и отрицательных»\n");
                    } else {
                        LogFileWriter.write(LocalDateTime.now() + " Больше «нечётных и отрицательных»\n");
                    }
                }
                LogFileWriter.close();
            }
        } catch (Exception ex) {
            System.out.println("Error! Message: " + ex);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Watcher Watcher1 = new Watcher();
        MyClassLab3 MyClass = new MyClassLab3();
        MyClass.addObserver(Watcher1);

        MyClass.ConsoleReadPath();
        MyClass.ReadLinesFromSourceFile();
        MyClass.WriteResultToLogFile();

        MyClass.notifyObs();
    }
}
