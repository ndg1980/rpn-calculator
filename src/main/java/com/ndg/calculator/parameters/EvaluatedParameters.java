package com.ndg.calculator.parameters;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Container to hold parameters being evaluated by an {@link Operator}
 */
public interface EvaluatedParameters {
    /**
     * Add element to evaluated parameters
     * @param parameters
     */
    void add(BigDecimal parameters);

    /**
     * Get evaluated parameters
     * @return
     */
    Collection<BigDecimal> getParameters();

    /**
     * Defines mechanism used to retrieve operands when evaluating parameters
     * @param operatorType
     * @param count
     * @return
     * @throws ParameterException
     */
    Collection<BigDecimal> getOperands(String operatorType, int count) throws ParameterException;
}
