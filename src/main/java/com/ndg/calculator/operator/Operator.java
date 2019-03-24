package com.ndg.calculator.operator;

import com.ndg.calculator.parameters.EvaluatedParameters;
import com.ndg.calculator.processor.ProcessorException;

/**
 * Interface implemented by operators
 */
public interface Operator {
    /**
     * String literal to enter operator
     * @return
     */
    String getKey();

    void execute(EvaluatedParameters evaluatedParameters) throws ProcessorException;
}
