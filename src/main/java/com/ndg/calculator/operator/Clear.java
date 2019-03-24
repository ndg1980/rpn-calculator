package com.ndg.calculator.operator;

import com.ndg.calculator.parameters.EvaluatedParameters;

/**
 * Clear operator
 */
public class Clear implements Operator {
    @Override
    public String getKey() {
        return "clear";
    }

    @Override
    public void execute(EvaluatedParameters evaluatedParameters) {
        evaluatedParameters.getParameters().clear();
    }
}
