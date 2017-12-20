package org.rpnc.expression;

/**
 */
public class DupExpression implements Expression {
    private final Expression expression;

    public DupExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public long evaluate() {
        return expression.evaluate();
    }

    @Override
    public String toString() {
        return String.valueOf(expression);
    }
}
