package com.ndg.calculator;

import com.ndg.calculator.instructions.Instructions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/****
 * Integration tests for {@link RPNCalculator}
 */
public class RPNCalculatorIT {

    private InputStream stdin;
    private PrintStream stdout;

    @Before
    public void setup() {
        stdin = System.in;
        stdout = System.out;
    }

    @After
    public void tearDown() {
        System.setIn(stdin);
        System.setOut(stdout);
    }

    @Test
    public void testEcho() throws Exception {
        ByteArrayOutputStream baos = initTestStreamsAndSetInput("5 4");
        Calculator calculator = newCalculator();
        calculator.start();
        String result = getResult(baos);
        assertEquals("stack:5 4", result);
    }

    @Test
    public void testCalculation() throws Exception {
        ByteArrayOutputStream baos = initTestStreamsAndSetInput("1 2 3 4 5 * * * *");
        Calculator calculator = newCalculator();
        calculator.start();
        String result = getResult(baos);
        assertEquals("stack:120", result);
    }

    @Test
    public void testParameterError() throws Exception {
        ByteArrayOutputStream baos = initTestStreamsAndSetInput("1 2 3 * 5 + * * 6 5");
        Calculator calculator = newCalculator();
        calculator.start();
        String result = getResult(baos);
        assertTrue(result.startsWith("operator *: insufficient parameters"));
    }


    protected String getResult(ByteArrayOutputStream baos) throws UnsupportedEncodingException {
        return baos.toString("UTF-8").trim();
    }

    private ByteArrayOutputStream initTestStreamsAndSetInput(String input) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos, true, "UTF-8");
        System.setIn(new ByteArrayInputStream(new String(input + "\r\n").getBytes("UTF-8")));
        System.setOut(printStream);
        return baos;
    }

    private Calculator newCalculator() {
        return new RPNCalculator(){
            @Override
            protected boolean canTerminate(Instructions instructions) {
                return true;
            }
        };
    }
}
