package com.ndg.calculator.operator;

import com.ndg.calculator.parameters.EvaluatedParameters;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Square root operator
 */
public class SquareRoot extends UnaryOperator {
    @Override
    protected void execute(EvaluatedParameters evaluatedParameters, Collection<BigDecimal> operands) {
        BigDecimal operand = operands.iterator().next();
        evaluatedParameters.add(new BigDecimal(Math.sqrt(operand.doubleValue())));
    }

    @Override
    public String getKey() {
        return "sqrt";
    }
}
