package com.ndg.calculator.processor;

/**
 * Factory to initialize {@link Processor} objects
 */
public class ProcessorFactory {

    private static ProcessorFactory processorFactory;

    private ProcessorFactory(){
    }

    public static ProcessorFactory getInstance() {
        if (processorFactory == null) {
            processorFactory = new ProcessorFactory();
        }
        return processorFactory;
    }

    public Processor getHandler(ProcessorType processorType) {
        switch (processorType) {
            case DEFAULT_VALIDATOR:
                return new DefaultValidator();
            case RPN_EVALUATOR:
                return new RPNEvaluator();
            case STACK_PRINTER:
                return new StackPrinter();
        }
        throw new RuntimeException("Unknown ProcessorType");
    }
}
