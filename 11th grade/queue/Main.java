public class Main {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();

        q.insert(10);
        q.insert(20);
        q.insert(30);
        q.insert(40);
        q.insert(50);

        System.out.println("Initial queue:");
        printQueue(q);

        Queue<Integer> clone = Clone(q);
        System.out.println("Clone of the queue:");
        printQueue(clone);

        int size = Size(q);
        System.out.println("Queue size: " + size);

        int sum = Sum(q);
        System.out.println("Sum of all elements: " + sum);


        System.out.println("Does 30 exist? " + Exists(q, 30));
        System.out.println("Does 99 exist? " + Exists(q, 99));

        System.out.println("Is the queue sorted? " + IsSorted(q));

        InsertToBottom(q, 60);
        System.out.println("After InsertToBottom(60):");
        printQueue(q);

        MoveTopToBottom(q);
        System.out.println("After MoveTopToBottom:");
        printQueue(q);

        Integer removedBottom = RemoveBottom(q);
        System.out.println("Removed from bottom: " + removedBottom);
        printQueue(q);

        MoveBottomToTop(q);
        System.out.println("After MoveBottomToTop:");
        printQueue(q);


        int max = MaxValue(q);
        System.out.println("Max value in the queue: " + max);


        int removedMax = RemoveMax(q);
        System.out.println("Removed max value: " + removedMax);
        printQueue(q);


        Queue<Integer> newQueue = new Queue<>();
        SpillOn(q, newQueue);
        System.out.println("After SpillOn(q -> newQueue):");
        System.out.print("q (should be empty): ");
        printQueue(q);
        System.out.print("newQueue: ");
        printQueue(newQueue);
    }


    public static <T> void printQueue(Queue<T> q) {
        Queue<T> temp = Clone(q);
        System.out.print("[ ");
        while (!temp.isEmpty()) {
            System.out.print(temp.remove() + " ");
        }
        System.out.println("]");
    }


    public static  <T> void SpillOn (Queue<T> from, Queue<T>  to)
    {
        while (!from.isEmpty())
        {
            to.insert(from.remove());
        }
    }
    public static <T> Queue<T> Clone(Queue<T> q)
    {
        Queue<T> q2 = new Queue<T>();
        Queue<T> temp = new Queue<T>();

        while (!q.isEmpty()) {
            T x = q.remove();
            q2.insert(x);
            temp.insert(x);
        }

        while (!temp.isEmpty()) {
            q.insert(temp.remove());
        }

        return q2;
    }
    public static <T> int Size(Queue<T>q)
    {
        Queue<T> q2 = new Queue<T>();
        Queue<T> temp = new Queue<T>();

        while (!q.isEmpty()) {
            T x = q.remove();
            q2.insert(x);
            temp.insert(x);
        }
        int count =0;
        while (!temp.isEmpty()){
            temp.remove();
            count++;
        }

        while (!q2.isEmpty()) {
            q.insert(q2.remove());
        }

        return count;
    }
    public static int Sum(Queue<Integer> q)
    {
        Queue<Integer> temp = Clone(q);
        int sum = 0;

        while (!temp.isEmpty()) {
            int x = temp.remove();
            sum += x;
        }
        return sum;
    }
    public static boolean Exists(Queue<Integer>q, int x)
    {
        Queue<Integer> temp = Clone(q);

        while (!temp.isEmpty()){
            if (x == temp.remove())
                return true;
        }
        return false;
    }
    public static boolean IsSorted(Queue<Integer> q)
    {
        Queue<Integer> temp = Clone(q);

        if (temp.isEmpty())
            return true;

        int prev = temp.remove();

        while (!temp.isEmpty()) {
            int current = temp.remove();
            if (prev > current) {
                return false;
            }
            prev = current;
        }
        return true;
    }
    public static <T>void InsertToBottom(Queue<T>q,T x)
    {
        q.insert(x);
    }
    public static <T> void MoveTopToBottom(Queue<T> q)
    {
        if (!q.isEmpty()) {
            T x = q.remove();
            q.insert(x);
        }
    }
    public static <T> T RemoveBottom(Queue<T> q)
    {
        if (q.isEmpty())
            return null;

        Queue<T> temp = new Queue<T>();
        T last = null;

        while (!q.isEmpty()) {
            T x = q.remove();
            if (q.isEmpty()) {
                last = x;
            } else {
                temp.insert(x);
            }
        }

        while (!temp.isEmpty()) {
            q.insert(temp.remove());
        }
        return last;
    }
    public static <T> void MoveBottomToTop(Queue<T> q)
    {
        if (q.isEmpty())
            return;

        Queue<T> temp = new Queue<>();

        while (Size(q) > 1) {
            temp.insert(q.remove());
        }

        T last = q.remove();

        q.insert(last);

        while (!temp.isEmpty()) {
            q.insert(temp.remove());
        }
    }
    public static int MaxValue(Queue<Integer>q)
    {
        Queue<Integer> temp = new Queue<>();
        temp = Clone(q);

        int max = temp.remove();

        while (!temp.isEmpty()){
            int current = temp.remove();
            if (current>max){
                max=current;
            }
        }
        return max;
    }
    public static int RemoveMax(Queue<Integer> q)
    {
        int max = MaxValue(q);

        Queue<Integer> temp = new Queue<>();
        boolean removed = false;

        while (!q.isEmpty()) {
            int current = q.remove();
            if (!removed && current == max) {
                removed = true;
                continue;
            }
            temp.insert(current);
        }

        while (!temp.isEmpty()) {
            q.insert(temp.remove());
        }

        return max;
    }
}
