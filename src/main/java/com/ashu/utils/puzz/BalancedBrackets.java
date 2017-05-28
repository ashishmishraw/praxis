package com.ashu.utils.puzz;

import java.util.*;

/**
 * Created by mishra.ashish@icloud.com
 */
public class BalancedBrackets {

    private static Map<Character, Character> braketPairs = new HashMap<>();

    static {
        braketPairs.put('{','}');
        braketPairs.put('(',')');
        braketPairs.put('[',']');
    }

    private static Set<Character> openBrackets = braketPairs.keySet();
    private static Collection<Character> closedBrackets = braketPairs.values();

    public static boolean isBalanced(String expression) throws InterruptedException {

        Stack<Character> stack = new Stack<>();

        for ( char c : expression.toCharArray() ) {

            if (openBrackets.contains(c)) {
                stack.push(c);
            } else if (closedBrackets.contains(c)) {
                if ( !stack.isEmpty() && braketPairs.get(stack.peek()) == c ) {
                    stack.pop();
                }
            } else return false;
        }
        if (stack.size() != 0)
            return false;

        return true;
    }

    public static void main(String[] args) {

        try {

            Scanner in = new Scanner(System.in);
            int t = in.nextInt();

            for (int a0 = 0; a0 < t; a0++) {
                String expression = in.next();
                System.out.println((isBalanced(expression)) ? "YES" : "NO");
            }
        } catch (InterruptedException iex) {
            System.err.println("Some error happened ..");
        }
    }
}
