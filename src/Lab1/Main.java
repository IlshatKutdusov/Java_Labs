package Lab1;

/*
Вариант 7:
 - 7. Дана последовательность целых чисел. Программа должна сообщить каких чисел
встретилось больше: «чётных и отрицательных», «нечётных и отрицательных», либо их
поровну
 */

import java.util.ArrayList;

public class Main {
    public static void main (String[] args){
        ArrayList<String> Even = new ArrayList<String>(); //четный
        ArrayList<String> Uneven = new ArrayList<String>(); //нечетный

        for (String x : args) {
            if (Integer.parseInt(x) < 0) {
                if (Integer.parseInt(x) % 2 == 0) {
                    Even.add(x);
                } else {
                    Uneven.add(x);
                }
            }
        }

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
