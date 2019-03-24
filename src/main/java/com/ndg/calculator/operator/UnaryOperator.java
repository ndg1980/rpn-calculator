package com.ndg.calculator.operator;


public abstract class UnaryOperator extends MathematicalOperator {

    @Override
    public int getOperandCount() {
        return 1;
    }
}
