public class Main {
    public static void main(String[] args) {

        int[] arr1 = {1,2,3,4,5,6,7,8,9,10};
        int[] arr2 = {11, 14, 12, 13, 15, 16, 17, 19, 20, 18};


        MyStack s1 = CreateStackFromArray(arr1);
        MyStack s2 = CreateStackFromArray(arr2);

        System.out.println("מחסנית s1: " + s1);
        System.out.println("מחסנית s2: " + s2);


        SpillOn(s1, s2);
        System.out.println("לאחר SpillOn: s2 = " + s2 + ", s1 = " + s1);

        MyStack s1Clone = Clone(s1);
        System.out.println("Original s1: " + s1);
        System.out.println("Clone של s1: " + s1Clone);

        System.out.println("Size של s1: " + Size(s1));
        System.out.println("Sum של s1: " + Sum(s1));
        System.out.println("האם 5 קיים ב-s1? " + Exists(s1, 5));
        System.out.println("האם s1 ממוין? " + IsSorted(s1));

        InsertToBottom(s1, 99);
        System.out.println("לאחר InsertToBottom(99): " + s1);

        MoveTopToBottom(s1);
        System.out.println("לאחר MoveTopToBottom: " + s1);

        int removedBottom = RemoveBottom(s1);
        System.out.println("האיבר שהוסר מתחתית: " + removedBottom + ", מחסנית: " + s1);

        MoveBottomToTop(s1);
        System.out.println("לאחר MoveBottomToTop: " + s1);

        int maxVal = MaxValue(s1);
        System.out.println("האיבר המקסימלי ב-s1: " + maxVal);

        RemoveMax(s1);
        System.out.println("לאחר RemoveMax: " + s1);

        InsertAtPosition(s1, 3, 55);
        System.out.println("לאחר InsertAtPosition (מיקום 3, ערך 55): " + s1);

        int removedAtPos = RemoveAtPosition(s1, 4);
        System.out.println("האיבר שהוסר ממיקום 4: " + removedAtPos + ", מחסנית: " + s1);

        MyStack reversed1 = Reverse1(s1);
        System.out.println("Reverse1 (מחסנית חדשה): " + reversed1);
        System.out.println("s1 המקורית: " + s1);

        Reverse2(s1);
        System.out.println("לאחר Reverse2 (היפוך ב-s1 עצמה): " + s1);

        MyStack sortedNew = SortNewStack(s1);
        System.out.println("מחסנית חדשה ממוינת: " + sortedNew);

        SortStack(s1);
        System.out.println("לאחר מיון s1 עצמה: " + s1);

        System.out.println("==== סיום בדיקות ====");
    }



    public static MyStack CreateStackFromArray(int[] arr){
        MyStack stack = new MyStack(4*arr.length);
        for (int i=0;i<arr.length;i++) {
            stack.push(arr[i]);
        }
        return stack;
    }

    public static int Size(MyStack s) {
        MyStack temp = new MyStack(50);
        int count = 0;
        while (!s.isEmpty()) {
            temp.push(s.pop());
            count++;
        }
        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }
        return count;
    }

    public static void SpillOn(MyStack from, MyStack to){
        int n = Size(from);
        for (int i=0;i<n;i++) to.push(from.pop());
    }

    public static MyStack Clone(MyStack s) {
        MyStack temp = new MyStack(Size(s));
        MyStack copy = new MyStack(Size(s));
        while (!s.isEmpty()) temp.push(s.pop());
        while (!temp.isEmpty()) {
            int x = temp.pop();
            s.push(x);
            copy.push(x);
        }
        return copy;
    }

    public static int Sum(MyStack s) {
        int sum = 0;
        MyStack temp = new MyStack(50);
        while (!s.isEmpty()) { int x = s.pop(); sum += x; temp.push(x); }
        while (!temp.isEmpty()) s.push(temp.pop());
        return sum;
    }

    public static boolean Exists(MyStack s, int x) {
        boolean found = false;
        MyStack temp = new MyStack(50);
        while(!s.isEmpty()) {
            int val = s.pop();
            if(val == x) found = true;
            temp.push(val);
        }
        while(!temp.isEmpty()) s.push(temp.pop());
        return found;
    }

    public static boolean IsSorted(MyStack s) {
        if(s.isEmpty()) return true;
        boolean sorted = true;
        MyStack temp = new MyStack(50);
        int prev = s.pop();
        temp.push(prev);
        while(!s.isEmpty()) {
            int curr = s.pop();
            temp.push(curr);
            if(prev < curr) sorted = false;
            prev = curr;
        }
        while(!temp.isEmpty()) s.push(temp.pop());
        return sorted;
    }

    public static void InsertToBottom(MyStack s,int x) {
        MyStack temp = Clone(s);
        while(!s.isEmpty()) s.pop();
        s.push(x);
        while(!temp.isEmpty()) s.push(temp.pop());
    }

    public static void MoveTopToBottom(MyStack s) {
        MyStack temp = Clone(s);
        int x = s.top();
        while(!s.isEmpty()) s.pop();
        s.push(x);
        while(!temp.isEmpty()) s.push(temp.pop());
    }

    public static int RemoveBottom(MyStack s) {
        MyStack temp = Clone(s);
        while(!s.isEmpty()) s.pop();
        int removed = temp.pop();
        while(!temp.isEmpty()) s.push(temp.pop());
        return removed;
    }

    public static void MoveBottomToTop(MyStack s) {
        MyStack temp = Clone(s);
        while(!s.isEmpty()) s.pop();
        int x = temp.top();
        temp.pop();
        while(!temp.isEmpty()) s.push(temp.pop());
        s.push(x);
    }

    public static int MaxValue(MyStack s) {
        int max = s.top();
        MyStack temp = Clone(s);
        while(!temp.isEmpty()) {
            int val = temp.pop();
            if(val > max) max = val;
        }
        return max;
    }

    public static int RemoveMax(MyStack s) {
        MyStack temp = Clone(s);
        int max = MaxValue(s);
        while(!s.isEmpty()) s.pop();
        while(!temp.isEmpty()) {
            int val = temp.pop();
            if(val != max) s.push(val);
        }
        return max;
    }

    public static void InsertAtPosition(MyStack s,int position,int x) {
        MyStack temp = new MyStack(Size(s));
        for(int i=1;i<position;i++) temp.push(s.pop());
        s.push(x);
        while(!temp.isEmpty()) s.push(temp.pop());
    }

    public static int RemoveAtPosition(MyStack s,int position) {
        MyStack temp = new MyStack(Size(s));
        for(int i=1;i<position;i++) temp.push(s.pop());
        int x = s.pop();
        while(!temp.isEmpty()) s.push(temp.pop());
        return x;
    }

    public static MyStack Reverse1(MyStack s) {
        MyStack newS = new MyStack(Size(s));
        MyStack copy = Clone(s);
        SpillOn(copy,newS);
        return newS;
    }

    public static void Reverse2(MyStack s) {
        MyStack newS = new MyStack(Size(s));
        MyStack copy = Clone(s);
        SpillOn(copy,newS);
        while(!s.isEmpty()) s.pop();
        SpillOn(newS, s);
    }

    public static MyStack SortNewStack(MyStack s) {
        MyStack copy = new MyStack(Size(s));
        MyStack temp = Clone(s);
        while(!temp.isEmpty()) {
            int x = MaxValue(temp);
            copy.push(x);
            RemoveMax(temp);
        }
        return copy;
    }

    public static void SortStack(MyStack s) {
        MyStack temp = Clone(s);
        MyStack sorted = new MyStack(Size(s));
        while(!temp.isEmpty()) {
            int x = MaxValue(temp);
            sorted.push(x);
            RemoveMax(temp);
        }
        while(!s.isEmpty()) s.pop();
        SpillOn(sorted, s);
    }
}
