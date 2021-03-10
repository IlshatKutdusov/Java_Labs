package Lab2;
/*
Вариант:
 - 7. 000010110
Проверить:
 - 2. В строке отсутствует какой-то символ
 - 3. Больше, чем некоторое число
 - 5. Меньше, чем некоторое число
 */

import java.util.ArrayList;

interface Base {
    public void ConsoleReadArgument(String[] args) throws MyExceptions;

    public void ListChecking();
}

interface Options {
    final String SourceChar = "-2";
    final String Exception2 = "В строке отсутствует какой-то символ (" + SourceChar + ")";
    final int MinNumber = 10;
    final String Exception3 = "Больше, чем некоторое число";
    final int MaxNumber = 10;
    final String Exception5 = "Меньше, чем некоторое число";
}

class MyExceptions extends Exception {
    public String ExceptionMessage;

    public MyExceptions(String message) {
        this.ExceptionMessage = message;
    }

    public String toString() {
        return ExceptionMessage;
    }
}

class MyClass implements Base, Options {

    ArrayList<String> Even = new ArrayList<String>(); //четный
    ArrayList<String> Uneven = new ArrayList<String>(); //нечетный

    @Override
    public void ConsoleReadArgument(String[] args) throws MyExceptions {
        boolean CharFounded = false;
        for (String x : args) {
            if (Integer.parseInt(x) < 0) {
                if (Integer.parseInt(x) > MinNumber) {
                    throw new MyExceptions(Exception3);
                } else {
                    if (Integer.parseInt(x) < MaxNumber) {
                        throw new MyExceptions(Exception5);
                    } else {
                        if (Integer.parseInt(x) == Integer.parseInt(SourceChar))
                            CharFounded = true;
                        if (Integer.parseInt(x) % 2 == 0) {
                            Even.add(x);
                        } else {
                            Uneven.add(x);
                        }
                    }
                }
            }
        }
        if (!CharFounded)
            throw new MyExceptions(Exception2);
    }


    @Override
    public void ListChecking() {
        if (Even.size() == Uneven.size()) {
            System.out.println("Колчество тех и других равно");
        } else {
            if (Even.size() > Uneven.size()) {
                System.out.println("Больше «чётных и отрицательных»");
            } else {
                System.out.println("Больше «нечётных и отрицательных»");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws MyExceptions {
        try {
            MyClass MyClass1 = new MyClass();
            MyClass1.ConsoleReadArgument(args);
            MyClass1.ListChecking();
        } catch (MyExceptions ex) {
            System.out.println("Error! Message: " + ex);
        }

    }
}
