package Lab2;

public class Example4 {
    static void Func() {
        int m = 10, n = 0;
        n = m / n;
    }

    public static void main(String[] args) {
        try {
            Func();
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException happened");
        } catch (Exception e) {
            System.out.println("Exception happened");
        } finally {
            System.out.println("finally");
        }
    }
}

/*
Result:
ArithmeticException happened
finally
*/