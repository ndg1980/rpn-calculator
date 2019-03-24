package com.ndg;

import com.ndg.calculator.Calculator;
import com.ndg.calculator.CalculatorException;
import com.ndg.calculator.RPNCalculator;

/**
 * Entry point to execute RPNCalculator
 */
public class App {

    public static void main(String[] args) {
        Calculator calculator = new RPNCalculator();
        try {
            calculator.start();
        } catch (CalculatorException exception) {
            //Handle known exceptions could terminate Calculator
            System.err.println("Error: " + exception.getMessage());
        } catch (Throwable throwable) {
            //Handle unknown exceptions could terminate Calculator
            System.err.println("Unknown System Error:" + throwable.getMessage());
            throwable.printStackTrace();
        }
    }
}
