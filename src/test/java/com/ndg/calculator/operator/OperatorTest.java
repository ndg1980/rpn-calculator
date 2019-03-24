package com.ndg.calculator.operator;

import com.ndg.calculator.parameters.EvaluatedParameters;
import com.ndg.calculator.parameters.RPNEvaluatedParameters;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Unit tests for Operators
 */
public class OperatorTest {
    @Test
    public void testPlus() throws Exception {
        EvaluatedParameters evaluatedParameters = new RPNEvaluatedParameters();
        evaluatedParameters.add(BigDecimal.TEN);
        evaluatedParameters.add(BigDecimal.valueOf(2));
        MathematicalOperator plus = (MathematicalOperator) OperatorRegistry.getInstance().getByType("+");
        plus.execute(evaluatedParameters);
        assertEquals("Expected 10 + 2 to be 12.000000000000000",
                toExpectedScale(BigDecimal.valueOf(12)), evaluatedParameters.getParameters().iterator().next());
    }

    @Test
    public void testMinus() throws Exception {
        EvaluatedParameters evaluatedParameters = new RPNEvaluatedParameters();
        evaluatedParameters.add(BigDecimal.TEN);
        evaluatedParameters.add(BigDecimal.valueOf(2));
        MathematicalOperator minus = (MathematicalOperator) OperatorRegistry.getInstance().getByType("-");
        minus.execute(evaluatedParameters);
        assertEquals("Expected 10 - 2 to be 8.000000000000000",
                toExpectedScale(BigDecimal.valueOf(8)), evaluatedParameters.getParameters().iterator().next());
    }

    @Test
    public void testDivision() throws Exception {
        EvaluatedParameters evaluatedParameters = new RPNEvaluatedParameters();
        evaluatedParameters.add(BigDecimal.TEN);
        evaluatedParameters.add(BigDecimal.valueOf(3));
        MathematicalOperator division = (MathematicalOperator) OperatorRegistry.getInstance().getByType("/");
        division.execute(evaluatedParameters);
        assertEquals("Expected 10/3 to be 3.333333333333333",
                BigDecimal.valueOf(3.333333333333333), evaluatedParameters.getParameters().iterator().next());
    }


    @Test
    public void testMultiplication() throws Exception {
        EvaluatedParameters evaluatedParameters = new RPNEvaluatedParameters();
        evaluatedParameters.add(BigDecimal.TEN);
        evaluatedParameters.add(BigDecimal.valueOf(3));
        MathematicalOperator multiplication = (MathematicalOperator) OperatorRegistry.getInstance().getByType("*");
        multiplication.execute(evaluatedParameters);
        assertEquals("Expected 10*3 to be 30.000000000000000",
                toExpectedScale(BigDecimal.valueOf(30)), evaluatedParameters.getParameters().iterator().next());
    }

    @Test
    public void testSquareRoot() throws Exception {
        EvaluatedParameters evaluatedParameters = new RPNEvaluatedParameters();
        evaluatedParameters.add(BigDecimal.valueOf(6));
        MathematicalOperator squareRoot = (MathematicalOperator) OperatorRegistry.getInstance().getByType("sqrt");
        squareRoot.execute(evaluatedParameters);
        assertEquals("Expected square root of 6 to be 2.449489742783178",
        BigDecimal.valueOf(2.449489742783178), evaluatedParameters.getParameters().iterator().next());
    }

    @Test
    public void testUndo() throws Exception {
        EvaluatedParameters evaluatedParameters = new RPNEvaluatedParameters();
        evaluatedParameters.add(BigDecimal.ONE);
        evaluatedParameters.add(BigDecimal.TEN);
        assertEquals("Expect there to be 2 elements in evaluatedParameters before calling undo", 2, evaluatedParameters.getParameters().size());
        Operator undo = OperatorRegistry.getInstance().getByType("undo");
        undo.execute(evaluatedParameters);
        assertEquals("Expect there to be 1 element in evaluatedParameters after calling undo", 1, evaluatedParameters.getParameters().size());
    }

    @Test
    public void testClear() throws Exception {
        EvaluatedParameters evaluatedParameters = new RPNEvaluatedParameters();
        evaluatedParameters.add(BigDecimal.ONE);
        evaluatedParameters.add(BigDecimal.TEN);
        assertEquals("Expect there to be 2 elements in evaluatedParameters before calling clear", 2, evaluatedParameters.getParameters().size());
        Operator clear = OperatorRegistry.getInstance().getByType("clear");
        clear.execute(evaluatedParameters);
        assertEquals("Expect there to be 0 elements in evaluatedParameters after calling clear", 0, evaluatedParameters.getParameters().size());

    }


    private BigDecimal toExpectedScale(BigDecimal value) {
        return value.setScale(15, RoundingMode.HALF_UP);
    }

    private List<BigDecimal> getOperands(BigDecimal first, BigDecimal second) {
        List<BigDecimal> operands = new ArrayList();
        operands.add(first);
        operands.add(second);
        return operands;
    }
}
