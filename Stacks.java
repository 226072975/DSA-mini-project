import java.util.Scanner;

public class Stacks {

    static final int MAX = 100;

    // Stack structure (using arrays like the original C version)
    static class Stack
    {
        int[] items = new int[MAX];
        int top;
    }

    // Initialize stack
    static void initializeStack(Stack stack)
    {
        stack.top = -1;
    }

    // Check if stack is empty
    static boolean isEmpty(Stack stack)
    {
        if (stack.top == -1)
        {
            return true;
        }

        return false;
    }

    // Push an item onto the stack
    static void push(Stack stack, int value)
    {
        if (stack.top == MAX - 1)
        {
            System.out.println("Stack overflow.");
            return;
        }

        stack.top++;
        stack.items[stack.top] = value;
    }

    // Remove and return the top item
    static int pop(Stack stack)
    {
        int value;

        if (isEmpty(stack))
        {
            System.out.println("Stack underflow.");
            return -1;
        }

        value = stack.items[stack.top];
        stack.top--;

        return value;
    }

    // Return the top item without removing it
    static int peek(Stack stack)
    {
        if (isEmpty(stack))
        {
            System.out.println("Stack is empty.");
            return -1;
        }

        return stack.items[stack.top];
    }

    // Display the contents of the stack
    static void displayStack(Stack stack)
    {
        if (isEmpty(stack))
        {
            System.out.println("Stack: Empty");
            return;
        }

        StringBuilder sb = new StringBuilder("Stack: ");

        for (int i = 0; i <= stack.top; i++)
        {
            sb.append(stack.items[i]).append(" ");
        }

        System.out.println(sb.toString());
    }

    // Perform arithmetic operation
    static int calculate(int operand1, int operand2, char operator)
    {
        switch (operator)
        {
            case '+':
                return operand1 + operand2;

            case '-':
                return operand1 - operand2;

            case '*':
                return operand1 * operand2;

            case '/':
                if (operand2 == 0)
                {
                    System.out.println("Error: Cannot divide by zero.");
                    System.exit(1);
                }

                return operand1 / operand2;

            default:
                System.out.println("Invalid operator.");
                System.exit(1);
                return -1; // unreachable, but Java requires a return
        }
    }

    // Evaluate a postfix expression
    static int evaluatePostfix(String expression)
    {
        Stack stack = new Stack();

        initializeStack(stack);

        int i = 0;

        while (i < expression.length())
        {
            char symbol = expression.charAt(i);

            // Ignore spaces
            if (symbol == ' ')
            {
                i++;
                continue;
            }

            // If the symbol is a number
            if (Character.isDigit(symbol))
            {
                int number = symbol - '0';

                push(stack, number);

                displayStack(stack);
            }

            // If the symbol is an operator
            else
            {
                int operand2;
                int operand1;
                int result;

                operand2 = pop(stack);
                operand1 = pop(stack);

                result = calculate(
                        operand1,
                        operand2,
                        symbol
                );

                push(stack, result);

                displayStack(stack);
            }

            i++;
        }

        return peek(stack);
    }

    // Main program
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a postfix expression: ");
        String expression = scanner.nextLine();

        int result = evaluatePostfix(expression);

        System.out.println("\nFinal Result: " + result);

        scanner.close();
    }
}
