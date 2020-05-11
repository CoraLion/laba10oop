package main;

import java.util.function.DoubleUnaryOperator;

public class IntegralCalculator {
    private double a;
    private double b;
    private double n;
    private DoubleUnaryOperator f;

    public IntegralCalculator(double a, double b, double n, DoubleUnaryOperator f) {
        this.a = a;
        this.b = b;
        this.n = n;
        this.f = f;
    }



    public double calculate() {
        double h = (b-a)/n;
        double sum = 0;
        for (int i = 0; i < n-1; i++) {
            double t = a + i*h;
            sum += f.applyAsDouble(t)*h;
        }
        return sum;
    }
}
