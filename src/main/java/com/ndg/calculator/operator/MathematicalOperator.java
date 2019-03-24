package com.ndg.calculator.operator;

import com.ndg.calculator.parameters.EvaluatedParameters;
import com.ndg.calculator.processor.ProcessorException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;

/**
 * Type to de-mark Mathematical operators
 */
public abstract class MathematicalOperator implements Operator {
    @Override
    public void execute(EvaluatedParameters evaluatedParameters) throws ProcessorException {
        Collection<BigDecimal> operands = evaluatedParameters.getOperands(getKey(), getOperandCount());
        execute(evaluatedParameters, operands);
    }

    /**
     * Process the given operands and place result in evaluatedParameters
     * @param evaluatedParameters
     * @param operands
     */
    protected abstract void execute(EvaluatedParameters evaluatedParameters, Collection<BigDecimal> operands);

    /**
     *
     * @return - number of operands required by Operator
     */
    protected abstract int getOperandCount();

    protected int getScale() {
        return 15;
    }

    protected RoundingMode getRoundingMode() {
        return RoundingMode.HALF_UP;
    }
}
