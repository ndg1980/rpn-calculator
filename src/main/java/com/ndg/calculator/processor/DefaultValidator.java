package com.ndg.calculator.processor;

import com.ndg.calculator.instructions.Instructions;
import com.ndg.calculator.operator.OperatorRegistry;

/**
 * Check whether given operators are supported by calculator
 *
 */
public class DefaultValidator implements Processor {
    @Override
    public void process(Instructions instructions) throws ProcessorException {
        for (Object element : instructions.getInstructions()) {
            if (element instanceof String) {
                OperatorRegistry.getInstance().getByType((String) element);
            }
        }
    }
}
