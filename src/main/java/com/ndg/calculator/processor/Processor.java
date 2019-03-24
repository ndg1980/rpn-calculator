package com.ndg.calculator.processor;

import com.ndg.calculator.instructions.Instructions;

/**
 * Interface implemented Processors of Instructions
 */
public interface Processor {
    void process(Instructions instructions) throws ProcessorException;
}
