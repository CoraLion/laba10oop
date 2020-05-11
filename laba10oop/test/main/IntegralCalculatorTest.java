package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.DoubleUnaryOperator;

import static org.junit.jupiter.api.Assertions.*;

class IntegralCalculatorTest {

    Controller controller;
    IntegralCalculator calculator;

    @BeforeEach
    void setUp() {
    }

    public double fun(double t){
        return 3 * Math.sqrt(t);
    }

    @Test
    void calculate() {
        double a = 1;
        double b = 9;
        double n = 100000;
        calculator = new IntegralCalculator(a,b,n,this::fun);
        double res = calculator.calculate();
        double res1 = 51.9;
        assertEquals(res, res1, 0.1);
    }
}