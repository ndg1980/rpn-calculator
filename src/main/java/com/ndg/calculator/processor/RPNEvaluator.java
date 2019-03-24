package com.ndg.calculator.processor;

import com.ndg.calculator.instructions.Instructions;
import com.ndg.calculator.parameters.EvaluatedParameters;
import com.ndg.calculator.parameters.RPNEvaluatedParameters;
import com.ndg.calculator.operator.Operator;
import com.ndg.calculator.operator.OperatorRegistry;

import java.math.BigDecimal;

/**
 * Evaluates RPNInstructions
 */
public class RPNEvaluator implements Processor {

    @Override
    public void process(Instructions instructions) throws ProcessorException {
        EvaluatedParameters evaluatedParameters = new RPNEvaluatedParameters();
        try {
            for (Object element : instructions.getInstructions()) {
                if (element instanceof String) {
                    Operator operator = OperatorRegistry.getInstance().getByType((String) element);
                    operator.execute(evaluatedParameters);
                } else {
                    evaluatedParameters.add((BigDecimal) element);
                }
            }
        } catch (ProcessorException exception) {
            instructions.setInstructions(evaluatedParameters.getParameters());
            throw exception;
        }
        instructions.setInstructions(evaluatedParameters.getParameters());
    }
}
