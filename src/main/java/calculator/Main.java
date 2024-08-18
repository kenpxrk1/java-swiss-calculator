package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalculatorManager manager = new CalculatorManager();
        System.out.println("Для завершения программы введите пробел");
        while (true) {
            String operation = sc.nextLine();
            if (operation.equals(" ")) {
                System.out.println("Программа завершена");
                break;
            }
            manager.handleOperations(operation);
        }
    }
}
