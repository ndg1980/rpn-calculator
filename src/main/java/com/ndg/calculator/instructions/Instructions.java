package com.ndg.calculator.instructions;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Container to hold instructions in memory
 */
public interface Instructions {
    void add(String element);

    void add(BigDecimal element);

    void setInstructions(Collection data);

    Collection getInstructions();
}
