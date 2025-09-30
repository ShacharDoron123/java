public class MyBetterStack {
    private int[] arr;
    private int top;

    public MyBetterStack() {
        arr = new int[10];
        top = -1;
    }

    public MyBetterStack(int n) {
        arr = new int[n];
        top = -1;
    }

    public void push(int x) {
        if (top + 1 == arr.length) {
            int[] newArr = new int[arr.length * 2];
            for (int i = 0; i <= top; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[++top] = x;
    }


    public int pop() {
        return arr[top--];
    }

    public int top() {
        return arr[top];
    }

    public boolean IsEmpty() {
        return top == -1;
    }

    public String toString() {
        if (IsEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = top; i >= 0; i--) {
            sb.append(arr[i]);
            if (i != 0) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
