package com.ndg.calculator.parameters;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class RPNEvaluatedParameters implements EvaluatedParameters {

    private Collection<BigDecimal> processedData;

    public RPNEvaluatedParameters() {
        initData();
    }

    protected void initData() {
        processedData = new Stack();
    }

    @Override
    public void add(BigDecimal parameters) {
        ((Stack<BigDecimal>) getParameters()).push(parameters.setScale(getScale(), getRoundingMode()));
    }

    protected int getScale() {
        return 15;
    }

    protected RoundingMode getRoundingMode() {
        return RoundingMode.HALF_UP;
    }

    @Override
    public Collection<BigDecimal> getParameters() {
        return processedData;
    }

    @Override
    public Collection<BigDecimal> getOperands(String operatorType, int count) throws ParameterException {
        List<BigDecimal> operands = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (!getParameters().isEmpty() && ((Stack<BigDecimal>) getParameters()).peek() != null) {
                operands.add(((Stack<BigDecimal>) getParameters()).pop());
            } else {
                throw new ParameterException("operator " + operatorType + ": insufficient parameters");
            }
        }
        Collections.reverse(operands);
        return operands;
    }
}
