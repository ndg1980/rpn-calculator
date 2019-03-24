package com.ndg.calculator.reader;

import com.ndg.calculator.instructions.Instructions;

/**
 * Read instructions for calculator
 */
public interface Reader {
    /**
     * Read instructions and populate give {@link Instructions} object
     * @param instructions
     * @return {@link Instructions}
     */
    Instructions populateInstructions(Instructions instructions);
}
