import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
     Bank b1=new Bank(100);
        try {
            b1.withdraw(9);
        } catch (InsufficientFundsException e) {
            throw new RuntimeException(e);
        } finally {
        }
    }
}
