import java.util.ArrayList;
import java.util.EmptyStackException;

/*
 * This class can be used to create a stack of numbers (as double values).
 * A stack resembles a stack of dinner plates in a dining hall.
 * You push a number onto the stack to store it in the stack.
 * You pop the stack to get the most recent number that was placed on the stack.
 * 
 * If I push the numbers 1, 2, and 3 onto the stack, my stack will look like the following,
 *          |  3  |
 *          |  2  |
 *          |  1  |
 *          -------
 * If I pop the stack, the number returned will be 3 and the stack will look like the following,
 *          |  2  |
 *          |  1  |
 *          -------
 * A stack is a last in first out (LIFO) type of data structure.
 */
public class Stack {
    private ArrayList<Double> stackList;

    // Constructor
    public Stack() {
        stackList = new ArrayList<>();
    }

    // Push method: adds an element to the top of the stack
    public void push(double value) {
        stackList.add(value);
    }

    // removes and returns the top element of the stack
    public double pop() {
        if (stackList.isEmpty()) {
            throw new EmptyStackException();
        }
        return stackList.remove(stackList.size() - 1);
    }

    // Peek at the top element without removing it
    public double peek() {
        if (stackList.isEmpty()) {
            throw new EmptyStackException();
        }
        return stackList.get(stackList.size() - 1);
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    // Get the current size of the stack
    public int size() {
        return stackList.size();
    }

    public void clear() {
        stackList.clear();
    }

    public static void main(String[] args) {

        System.out.println("-----------------------------");

        Stack stack = new Stack();
        for (int i = 0; i < 10; i++) {
            double val = i + 1;
            stack.push(val);
            System.out.printf("push: %5.2f%n", val);
        }

        System.out.println("-----------------------------");

        while (true) {
            try {
                double val = stack.pop();
                System.out.printf("pop:  %5.2f%n", val);
            } catch (EmptyStackException e) {
                // break from the loop.
                break;
            }
        }

        stack.clear();
        while (true) {
            try {
                double val = stack.pop();
                System.out.printf("pop:  %5.2f%n", val);
            } catch (EmptyStackException e) {
                // break from the loop.
                break;
            }
        }
    }
}
