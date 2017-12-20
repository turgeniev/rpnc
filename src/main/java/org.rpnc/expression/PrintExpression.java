package org.rpnc.expression;

/**
 */
public class PrintExpression implements Expression {
    private final Expression expression;

    public PrintExpression(Expression expression) {
        this.expression = expression;
    }

    public long evaluate() {
        long value = expression.evaluate();
        System.out.println(value);
        return value;
    }

    @Override
    public String toString() {
        return "PRINT " + expression;
    }
}
