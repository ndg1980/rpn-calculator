package com.ndg.calculator.processor;

import com.ndg.calculator.instructions.Instructions;
import org.apache.commons.lang3.StringUtils;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.Iterator;

/**
 * Prints the contents of the data stack of a given {@link Instructions} object.
 *
 * Note that decimal values are printed with a scale of 10.
 *
 */
public class StackPrinter implements Processor {
    private Format format;
    private PrintStream printStream;

    public StackPrinter() {
        DecimalFormat format = new DecimalFormat("###.##########");
        format.setDecimalSeparatorAlwaysShown(false);
        setFormat(format);
        setOutputStream(System.out);
    }

    @Override
    public void process(Instructions instructions) throws ProcessorException {
        getOutputStream().print("stack:");
        Iterator iterator = instructions.getInstructions().iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (element instanceof BigDecimal) {
                getOutputStream().print(getFormat().format(element));
            } else {
                getOutputStream().print(element);
            }
            if (iterator.hasNext()) {
                getOutputStream().print(StringUtils.SPACE);
            }
        }
        getOutputStream().println();
    }

    protected PrintStream getOutputStream() {
        return this.printStream;
    }

    protected void setOutputStream(PrintStream printStream) {
        this.printStream = printStream;
    }

    protected void setFormat(DecimalFormat format) {
        this.format = format;
    }

    protected Format getFormat() {
        return format;
    }
}
