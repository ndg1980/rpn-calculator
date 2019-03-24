package com.ndg.calculator.processor;

import com.ndg.calculator.CalculatorException;

/**
 * De-marks exceptions thrown while executing {@link Processor}s
 */
public class ProcessorException extends CalculatorException {
    private boolean terminate = false;

    public ProcessorException(String message) {
        super(message);
    }
}
