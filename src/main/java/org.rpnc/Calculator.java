package org.rpnc;

import org.rpnc.expression.BinaryExpression;
import org.rpnc.expression.DupExpression;
import org.rpnc.expression.Expression;
import org.rpnc.expression.Literal;
import org.rpnc.expression.PrintExpression;
import org.rpnc.operation.BinaryOperation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 */
public class Calculator {
    
    public long calculate(String formula) {
        List<String> tokens = parse(formula);
        ExecutionContext context = new ExecutionContext(tokens, tokens.size()-1);
        Expression expression = buildExpression(context);
        return expression.evaluate();
    }

    private List<String> parse(String formula) {
        return Arrays.asList(formula.split(" "));
    }

    private Expression buildExpression(ExecutionContext context) {

        String currentToken = context.getCurrentToken();
        switch (currentToken) {
            case "+":
            case "-":
            case "*":
            case "/":
                return buildBinaryExpression(context);
            case "dup":
                return buildDupExpression(context);
            case ".": // separated by space
                context.gotoNextToken();
                return new PrintExpression(buildExpression(context));
            default:
                context.gotoNextToken();
                return new Literal(currentToken);
        }
    }

    private Expression buildBinaryExpression(ExecutionContext context) {
        BinaryOperation binaryOperation = BinaryOperation.from(context.getCurrentToken());

        context.gotoNextToken();
        Expression left = buildExpression(context);
        Expression right = buildExpression(context);        
        
        return new BinaryExpression(left, binaryOperation, right);
    }

    private Expression buildDupExpression(ExecutionContext context) {
        int index = context.gotoNextToken();
        
        Expression expression = new DupExpression(buildExpression(context));
        
        context.gotoIndex(index); // rewind back to tokens consumed by 'dup'
        return expression;
    }
}