/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab07;
import java.util.*;
/**
 *
 * @author Ali
 */


public class PostFixer {
    public static void main (String [] args) {
        // Create sample infix expressions as test cases
        ArrayList<String> infix = new ArrayList<String>();

        // Should return postfix
        infix.add("(9 + (8 * 7 - (6 / 5 ^ 4) * 3) * 2)");
        infix.add("(2+(3*8)-5)");
        infix.add("(3*8)");
        for (String expr : infix) {
            System.out.println("Original infix expression: " + expr);
            System.out.println("Postfix expression: " + createPostFix(expr));
            System.out.println();
        }
        
    }
     public static String createPostFix(String infix) {
        // Surround with parens to make sure postFixConverter is invoked
        infix = "(" + infix + ")";

        StringSplitter data = new StringSplitter(infix);
        data.next(); // Skips first opening parenthesis

        // Map of operators and their precedence. Higher integers mean higher
        // precedence.
        Map<String, Integer> opMap = new HashMap<String, Integer>();
        opMap.put("+", 1);
        opMap.put("-", 1);
        opMap.put("*", 2);
        opMap.put("/", 2);
        opMap.put("^", 3);
        if (isInvalidExpression(infix)) {
            return "Illegal expression";
        } else {
            return postFixConverter(infix, data, opMap);
        }
    }
     
         public static boolean isInvalidExpression(String infix) {
        int openParens = 0;
        int closeParens = 0;
        boolean error = false;
        String next = "";
        StringSplitter parser = new StringSplitter(infix);

        while (parser.hasNext()) {
            next = parser.next();
            // Regex checks for anything that isn't a number, an operator, or
            // whitespace.
            if (next.matches("[^0-9\\+\\.\\-\\(\\)\\*/\\^\\%\\s]+")) {
                error = true;
            } else if (next.equals("(")) {
                openParens++;
            } else if (next.equals(")")) {
                closeParens++;
            }
        }
        if (openParens != closeParens) { // Check for parentheses mismatches
            error = true;
        }
        return error;
    }
     public static String postFixConverter(String infix, 
            StringSplitter data, Map<String, Integer> opMap) {

        Stack<String> symbols = new Stack<String>(); // Stack of operators
        String postfix = "";
        String next = "";

        symbols.push("("); // Add opening parens
        while (data.hasNext() && !next.equals(")")) {
            next = data.next();
            if (isNumber(next)) { // Append to postfix string
                postfix += next + " ";
            } else if (opMap.containsKey(next)) { // Next token is an operator
                /* Check precedence. If the new operator has a lower precendence
                 * than the operator on top of the stack, pop the operator in
                 * the stack and append to postfix to ensure correct ordering
                 */
                if (!symbols.peek().equals("(") && 
                        opMap.get(next) <= opMap.get(symbols.peek())) {
                   postfix += symbols.pop() + " "; 
                }
                symbols.push(next);
            } else if (next.equals("(")) { // Create "sub-postfix" expr. first
                postfix += postFixConverter(infix, data, opMap) + " ";
            } 
        }
        while (!symbols.isEmpty() && !symbols.peek().equals("(")) {
            postfix += symbols.pop() + " ";
        }
        return postfix;

    }
     public static boolean isNumber(String next) {
        boolean isNumber = true;
        try {
            Double.parseDouble(next);
        } catch (NumberFormatException e) {
            isNumber = false; 
        }
        return isNumber;
    }
}
