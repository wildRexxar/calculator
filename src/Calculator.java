import java.util.Scanner;

public class Calculator implements CalculatorFunction {

    Scanner scanner = new Scanner(System.in);
    private boolean status = false;
    int size = 0;
    private double[] arr = new double[5];

    @Override
    public void start() {
        while (!status) {
            char operation = getOperation();
            if (operation == 'e') {
                status = true;
                break;
            }
            double num1 = getNum();
            double num2 = getNum();
            double result = calc(num1, num2, operation);
            System.out.println("Результат операции");
            repository(result);
        }
    }

    @Override
    public double getNum() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введи число:");
            if (sc.hasNextDouble()) {
                return sc.nextDouble();
            }
        }
    }

    @Override
    public char getOperation() {
        System.out.println("Выбери операцию (+, -, *, /, e - выход): ");
        return scanner.next().charAt(0);


    }

    @Override
    public double calc(double num1, double num2, char operation) {
        double result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Неизвестный символ");
                result = calc(num1, num2, getOperation());
        }
        return result;
    }

    @Override
    public void repository(double result) {
        if (size >= 5) {
            size = 0;
        }
        arr[size] = result;
        size++;

        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + "||| ");
        }
        System.out.println();
    }
}