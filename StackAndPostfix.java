// Member 3 - Task A3
// My own Stack class and a postfix calculator
// DSA521S mini group project, 2026

public class StackAndPostfix {

    // ------- My Stack class -------

    static class Stack {

        int[] data;    // this array holds the numbers
        int top;       // points to the top of the stack (-1 means empty)

        Stack(int size) {
            data = new int[size];
            top = -1;   // empty at the start
        }

        // push: put a number on top of the stack
        void push(int value) {
            top = top + 1;        // move the top up by one
            data[top] = value;    // put the number there
        }

        // pop: take the top number off and give it back
        int pop() {
            int value = data[top];   // save the top number
            top = top - 1;           // move the top down
            return value;            // give the number back
        }

        // peek: look at the top number without removing it
        int peek() {
            return data[top];
        }

        // isEmpty: is the stack empty?
        boolean isEmpty() {
            if (top == -1) {
                return true;
            } else {
                return false;
            }
        }

        // print: show everything in the stack, bottom to top
        void print() {
            System.out.print("[ ");
            for (int i = 0; i <= top; i++) {
                System.out.print(data[i]);
                if (i < top) {
                    System.out.print(", ");
                }
            }
            System.out.println(" ]");
        }
    }

    // ------- Postfix calculator -------

    static int evaluate(String expression) {

        // split the string into pieces by spaces
        // "5 3 + 2 *" becomes ["5", "3", "+", "2", "*"]
        String[] parts = expression.split(" ");

        // make a new empty stack
        Stack stack = new Stack(parts.length);

        System.out.println("Evaluating: " + expression);

        // go through each piece one by one
        for (int i = 0; i < parts.length; i++) {

            String piece = parts[i];

            // check if this piece is an operator
            if (piece.equals("+") || piece.equals("-") ||
                piece.equals("*") || piece.equals("x") || piece.equals("/")) {

                // pop two numbers. The first one popped is the right one.
                int right = stack.pop();
                int left = stack.pop();

                int result = 0;

                if (piece.equals("+")) {
                    result = left + right;
                } else if (piece.equals("-")) {
                    result = left - right;
                } else if (piece.equals("*") || piece.equals("x")) {
                    result = left * right;
                } else if (piece.equals("/")) {
                    result = left / right;
                }

                System.out.println("Operator " + piece + ": "
                        + left + " " + piece + " " + right + " = " + result);

                // put the answer back on the stack
                stack.push(result);
                stack.print();

            } else {

                // otherwise it is a number, so push it
                int number = Integer.parseInt(piece);
                stack.push(number);
                System.out.println("Push " + number);
                stack.print();
            }
        }

        // at the end, the answer is the last thing on the stack
        return stack.pop();
    }

    // ------- Main -------
    public static void main(String[] args) {
        System.out.println("=== Member 3: Stack + Postfix Evaluator ===\n");

        int answer = evaluate("5 3 + 2 *");

        System.out.println("\nFinal answer: " + answer);
    }
}