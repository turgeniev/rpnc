package org.rpnc;

import java.util.Scanner;

/**
 */
public class Application {
    
    public static void main (String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Calculator calculator = new Calculator();

        while (true) {
            System.out.println("Type formula and press Enter or type quit to exit:");
            String input = scanner.nextLine();
            
            if (input.equals("quit")) {
                return; // EXIT
            }
            
            System.out.println(
                    calculator.calculate(input)
            );
        }
    }
}
