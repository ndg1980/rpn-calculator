package com.ndg.calculator.operator;

import com.ndg.calculator.parameters.EvaluatedParameters;

import java.math.BigDecimal;
import java.util.List;

/**
 * Undo operator
 */
public class Undo implements Operator {
    @Override
    public String getKey() {
        return "undo";
    }

    @Override
    public void execute(EvaluatedParameters evaluatedParameters) {
        List<BigDecimal> data = (List<BigDecimal>) evaluatedParameters.getParameters();
        data.remove(data.size() - 1);
    }
}
