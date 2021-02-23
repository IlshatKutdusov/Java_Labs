package Lab1;

import java.util.ArrayList;

public class Main {
    public static void main (String[] args){
        ArrayList Even = new ArrayList(); //четный
        ArrayList Uneven = new ArrayList(); //нечетный

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
