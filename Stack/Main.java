import java.util.Stack;

class MyQueue {

    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        moveElements();

        if (outputStack.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return outputStack.pop();
    }

    public int peek() {
        moveElements();

        if (outputStack.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return outputStack.peek();
    }

    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    private void moveElements() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {

        MyQueue queue = new MyQueue();

        queue.push(10);
        queue.push(20);
        queue.push(30);

        System.out.println("Front: " + queue.peek()); // 10
        System.out.println("Removed: " + queue.pop()); // 10
        System.out.println("Front: " + queue.peek()); // 20
        System.out.println("Is empty: " + queue.empty()); // false

        queue.pop();
        queue.pop();

        System.out.println("Is empty: " + queue.empty()); // true
    }
}