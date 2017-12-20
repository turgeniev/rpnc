package org.rpnc.expression;

/**
 */
public class Literal implements Expression {
    
    private final long value;

    public Literal(String value) {
        this.value = Long.parseLong(value);
    }

    @Override
    public long evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
