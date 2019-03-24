package com.ndg.calculator;

import com.ndg.calculator.instructions.Instructions;
import com.ndg.calculator.instructions.RPNInstructions;
import com.ndg.calculator.processor.Processor;
import com.ndg.calculator.processor.ProcessorFactory;
import com.ndg.calculator.processor.ProcessorType;
import com.ndg.calculator.reader.ConsoleReader;
import com.ndg.calculator.reader.Reader;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of an RPN Calculator
 */
public class RPNCalculator extends RecursiveCalculator {
    private List<Processor> processors;
    private Reader reader;
    private Instructions instructions;

    public RPNCalculator() {
        initProcessors();
        setInstructions(new RPNInstructions());
        setReader(new ConsoleReader());
    }

    protected void initProcessors() {
        setProcessors(new ArrayList<>());

        //validate instructions
        addProcessor(ProcessorType.DEFAULT_VALIDATOR);
        //evaluate instructions
        addProcessor(ProcessorType.RPN_EVALUATOR);
        //print instructions
        addProcessor(ProcessorType.STACK_PRINTER);
    }

    protected void setProcessors(List<Processor> processors) {
        this.processors = processors;
    }

    protected void setReader(Reader reader) {
        this.reader = reader;
    }

    protected void setInstructions(Instructions instructions) {
        this.instructions = instructions;
    }

    @Override
    protected Instructions initInstructions() {
        return this.instructions;
    }

    @Override
    protected Reader getReader() {
        return this.reader;
    }

    @Override
    protected List<Processor> getProcessors() {
        return this.processors;
    }

    protected void addProcessor(ProcessorType processorType) {
        ProcessorFactory processorFactory = ProcessorFactory.getInstance();
        getProcessors().add(processorFactory.getHandler(processorType));
    }
}
