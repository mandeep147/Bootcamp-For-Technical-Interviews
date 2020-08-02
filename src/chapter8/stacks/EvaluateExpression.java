/**
 * Given an arithmetic expression with *,/,- and + operators and single digit numbers,
 * evaluate it and return the result.
 * <p>
 * For example,
 * 1 + 2 / 1 + 3 * 2 -> 9
 * <p>
 * Constraints:
 * 1. No parenthesis
 * 2. input is in form of an array of characters
 * 3. fraction should be treat as floor integer value -> 1/2 is 0
 * 4. return 0, if expression is empty
 * 5. assume expression is always valid
 */
package chapter8.stacks;

import java.util.Stack;

import static util.Utils.printInput;

/**
 * @author mandeep
 */
public class EvaluateExpression {
    public static void main(String args[]) {
        char[] input = {'1', '+', '2', '/', '1', '+', '3', '*', '2'};
        printInput(evaluateExpression(input));
        printInput(evaluateExpression(new char[]{}));
        printInput(evaluateExpression(new char[]{'1', '+', '2'}));
        printInput(evaluateExpression(new char[]{'1'}));
    }
    
    /**
     * Time: O(n)
     * Space: O(n)
     *
     * @param expression
     * @return
     */
    private static int evaluateExpression(char[] expression) {
        if (expression == null || expression.length == 0) {
            return 0;
        }
        
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();
        
        for(char ch : expression) {
            if(isOperand(ch)) {
                operand.push(ch-'0');
            } else if (isOperator(ch)) {
                while(!operator.isEmpty() && precedence(operator.peek()) >= precedence(ch)) {
                    process(operator, operand);
                }
                operator.push(ch);
            }
        }
        
        while(!operator.isEmpty()) {
            process(operator, operand);
        }
        
        return operand.pop();
    }
    
    private static boolean isOperand(char ch) {
        return (ch >= '0') && (ch <= '9');
    }
    
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
    
    private static int precedence(char ch) {
        switch (ch) {
            case '/':
            case '*': return 2;
            case '-':
            case '+': return 1;
            default: throw new IllegalArgumentException("Invalid operator: " + ch);
        }
    }
    
    private static void process(Stack<Character> operator, Stack<Integer> operand) {
        int secondOperand = operand.pop();
        int firstOperand = operand.pop();
        
        char operation = operator.pop();
        int result = 0;
        
        switch(operation) {
            case '/': result = firstOperand / secondOperand; break;
            case '*': result = firstOperand * secondOperand; break;
            case '+': result = firstOperand + secondOperand; break;
            case '-': result = firstOperand - secondOperand; break;
        }
        
        operand.push(result);
    }
}
