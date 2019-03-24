package com.ndg.calculator.instructions;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Instructions for rpm calculator
 */
public class RPNInstructions implements Instructions {
    private List<Object> instructions;

    public RPNInstructions() {
        instructions = new ArrayList<>();
    }

    @Override
    public void add(String element) {
        instructions.add(element);
    }

    @Override
    public void add(BigDecimal element) {
        instructions.add(element);
    }

    @Override
    public void setInstructions(Collection instructions) {
        this.instructions = new ArrayList<>(instructions);
    }

    @Override
    public Collection getInstructions() {
        return instructions;
    }
}
