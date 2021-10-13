public interface CalculatorFunction {
    public void start();

    public double getNum();

    public char getOperation();

    public double calc(double num1, double num2, char operation);

    public void repository(double result);
}
