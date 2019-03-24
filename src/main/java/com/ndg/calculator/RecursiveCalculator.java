package com.ndg.calculator;

import com.ndg.calculator.parameters.ParameterException;
import com.ndg.calculator.instructions.Instructions;
import com.ndg.calculator.processor.Processor;
import com.ndg.calculator.reader.Reader;

import java.util.List;

/**
 * Abstract class defining the steps followed by a recursive calculator
 */
public abstract class RecursiveCalculator implements Calculator {

    /**
     * {@inheritDoc}
     */
    public void start() throws CalculatorException {
        execute(initInstructions());
    }

    /**
     * Initialises an {@link Instructions} object. Such objects hold the instructions given to a {@link Calculator}
     *
     * @return {@link Instructions}
     */
    protected abstract Instructions initInstructions();

    /**
     * Returns a {@link Reader} object, used to read instructions given to a {@link Calculator}
     *
     * @return {@link Reader}
     */
    protected abstract Reader getReader();

    /**
     * Returns a list of {@link Processor}s which process the given {@link Instructions}
     * @return
     */
    protected abstract List<Processor> getProcessors();

    /**
     * Non-terminating execution of a {@link Calculator}
     * @param instructions
     * @throws CalculatorException
     */
    public void execute(Instructions instructions) throws CalculatorException {
        //read input
        getReader().populateInstructions(instructions);
        //process input
        for (Processor processor : getProcessors()) {
            try {
                processor.process(instructions);
            } catch (ParameterException exception) {
                System.out.println(exception.getMessage());
            }
        }
        if (!canTerminate(instructions)) {
            //repeat
            execute(instructions);
        }
    }

    protected boolean canTerminate(Instructions instructions) {
        return false;
    }
}
