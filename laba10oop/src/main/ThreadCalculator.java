package main;

import java.util.function.DoubleUnaryOperator;

public class ThreadCalculator implements Runnable {
    private IntegralCalculator calculator;
    private Controller controller;

    public ThreadCalculator(Controller controller, double a, double b, double n, DoubleUnaryOperator f) {
        calculator = new IntegralCalculator(a, b, n, f);
        this.controller = controller;
    }

    @Override
    public void run(){
        double res = calculator.calculate();
        controller.sendResult(res);
    }

}
