package org.rpnc;

import java.util.List;

/**
 */
public class ExecutionContext {
    private List<String> tokens;
    private int currIndex;

    public ExecutionContext(List<String> tokens, int currIndex) {
        this.tokens = tokens;
        this.currIndex = currIndex;
    }
    
    String getCurrentToken() {
        return tokens.get(currIndex);
    }

    int gotoNextToken() {
        return --currIndex;
    }

    void gotoIndex(int index) {
        currIndex = index;
    }
}
