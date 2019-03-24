package com.ndg.calculator.operator;

import com.ndg.calculator.processor.ProcessorException;

import java.util.HashMap;
import java.util.Map;

/**
 * Multiton to keep track of Operators supported by an RPN Calculator
 *
 */
public class OperatorRegistry {
    private static OperatorRegistry operatorRegistry = null;

    private Map<String, Operator> registry = new HashMap<>();

    public static OperatorRegistry getInstance() {
        if (operatorRegistry == null) {
            operatorRegistry = new OperatorRegistry();
        }
        return operatorRegistry;
    }

    private OperatorRegistry(){
        loadOperators();
    }

    protected void loadOperators() {
        setOperator(new Plus());
        setOperator(new Minus());
        setOperator(new Division());
        setOperator(new Multiplication());
        setOperator(new SquareRoot());
        setOperator(new Clear());
        setOperator(new Undo());
    }

    protected void setOperator(Operator operator) {
        registry.put(operator.getKey(), operator);
    }

    public Operator getByType(String mappingType) throws ProcessorException {
        Operator operator = registry.get(mappingType);
        if (operator == null) {
            throw new ProcessorException("Invalid Operator!!!");
        }
        return operator;
    }
}
