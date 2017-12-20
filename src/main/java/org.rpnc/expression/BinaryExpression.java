package org.rpnc.expression;

import org.rpnc.operation.BinaryOperation;

/**
 */
public class BinaryExpression implements Expression {
    private final Expression left;
    private final Expression right;
    private final BinaryOperation op;

    public BinaryExpression(Expression left, BinaryOperation op, Expression right) {
        this.left = left;
        this.right = right;
        this.op = op;
    }

    @Override
    public long evaluate() {
        return op.evaluate(left, right);
    }

    @Override
    public String toString() {
        return "(" + left + ") " + op + " (" + right + ")"; 
    }
}
