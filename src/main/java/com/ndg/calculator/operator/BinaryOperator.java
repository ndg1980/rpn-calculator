package com.ndg.calculator.operator;


public abstract class BinaryOperator extends MathematicalOperator {

    @Override
    public int getOperandCount() {
        return 2;
    }
}
