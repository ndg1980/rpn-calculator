package com.ndg.calculator.operator;

import com.ndg.calculator.parameters.EvaluatedParameters;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;

/**
 * Plus operator
 */
public class Plus extends BinaryOperator {
    @Override
    protected void execute(EvaluatedParameters evaluatedParameters, Collection<BigDecimal> operands) {
        Iterator<BigDecimal> iterator = operands.iterator();
        BigDecimal first = iterator.next();
        BigDecimal second = iterator.next();
        evaluatedParameters.add(first.add(second));
    }

    @Override
    public String getKey() {
        return "+";
    }
}
