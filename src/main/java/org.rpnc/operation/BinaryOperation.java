package org.rpnc.operation;

import org.rpnc.expression.Expression;

/**
 */
public enum BinaryOperation {
    ADD {
        @Override
        public long evaluate(Expression left, Expression right) {
            return left.evaluate() + right.evaluate();
        }
    },
    SUBSTRACT {
        @Override
        public long evaluate(Expression left, Expression right) {
            return left.evaluate() - right.evaluate();
        }
    },
    MULTIPLY {
        @Override
        public long evaluate(Expression left, Expression right) {
            return left.evaluate() * right.evaluate();
        }
    },
    DIVIDE {
        @Override
        public long evaluate(Expression left, Expression right) {
            return left.evaluate() / right.evaluate();
        }
    };

    public abstract long evaluate(Expression left, Expression right);
    
    public static BinaryOperation from(String op) {
        switch (op) {
            case "+": return ADD;
            case "-": return SUBSTRACT;
            case "*": return MULTIPLY;
            case "/": return DIVIDE;
            default: return null;
        }
    }
}
