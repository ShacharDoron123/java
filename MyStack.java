public class MyStack {
    private int[] arr;
    private int top;

    public MyStack(int capacity) {
        arr = new int[capacity];
        top = -1;
    }

    public void push(int x) {
        if (top + 1 >= arr.length) {
            System.out.println("Stack is full!");
            return;
        }
        arr[++top] = x;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return arr[top--];
    }

    public int top() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = top; i >= 0; i--) {
            sb.append(arr[i]);
            if (i != 0) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
