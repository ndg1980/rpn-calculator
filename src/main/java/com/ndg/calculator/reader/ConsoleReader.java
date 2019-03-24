package com.ndg.calculator.reader;

import com.ndg.calculator.instructions.Instructions;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Reads instuctions from Console
 */
public class ConsoleReader implements Reader {
    private InputStream inputStream;

    public ConsoleReader() {
        setInputStream(System.in);
    }

    public Instructions populateInstructions(Instructions instructions) {
        String line = readInput();
        Arrays.stream(line.split(StringUtils.SPACE)).forEach(element -> {
            if (StringUtils.isNumeric(element)) {
                BigDecimal value = new BigDecimal(element);
                instructions.add(value);
            } else {
                instructions.add(element);
            }
        });
        return instructions;
    }

    protected String readInput() {
        Scanner scanner = new Scanner(getInputStream());
        return scanner.nextLine();
    }

    protected InputStream getInputStream() {
        return this.inputStream;
    }

    protected void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
