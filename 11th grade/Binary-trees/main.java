public class Main {
    //ex 1
    public static void printEnd(BinNode<Integer> t){
        if (t == null)
            return;
        printEnd(t.getLeft());
        printEnd(t.getRight());
        System.out.println(t.getValue());
    }
    //ex 2
    public static void prinFromLToR(BinNode<Integer> t){
        if (t == null)
            return;
        prinFromLToR(t.getLeft());
        System.out.println(t.getValue());
        prinFromLToR(t.getRight());
    }
    //ex 3
    public static void printStart(BinNode<Integer>t){
        if (t == null)
            return;
        System.out.println(t.getValue());
        printStart(t.getLeft());
        printStart(t.getRight());
    }
    //ex 4
    public static void printIfL(BinNode<Integer> t){
        if (t == null)
            return;

        printIfL(t.getLeft());
        printIfL(t.getRight());

        if (t.getLeft() != null && t.getLeft().getValue() < t.getValue())
            System.out.println(t.getLeft().getValue());

        if (t.getRight() != null && t.getRight().getValue() < t.getValue())
            System.out.println(t.getRight().getValue());
    }
    //ex 5
    public static void printIf(BinNode<Integer> t){
        if (t == null)
            return;
        if (t.hasLeft() && t.hasRight() && (t.getValue()>t.getLeft().getValue() || t.getValue()>t.getRight().getValue())){
            System.out.println(t.getValue());
        }
        printIf(t.getLeft());
        printIf(t.getRight());
    }
    //ex 6
    public static int sumOfNodes(BinNode<Integer> t){
        if (t == null)
            return 0;

        return t.getValue() + sumOfNodes(t.getLeft()) + sumOfNodes(t.getRight());
    }
    //ex 7
    public static int numOfLif(BinNode<Integer> t){
        if (t == null)
            return 0;

        if (!t.hasLeft() && !t.hasRight())
            return 1;

        return numOfLif(t.getLeft()) + numOfLif(t.getRight());
    }
    //ex 8
    public static int sumOfRight(BinNode<Integer> t){
        if (t == null)
            return 0;

        if (!t.hasRight())
            return sumOfRight(t.getLeft());

        return t.getRight().getValue() + sumOfRight(t.getRight()) + sumOfRight(t.getLeft());
    }
    //ex 9
    public static int countNodesWithOneChild(BinNode<Integer> t){
        if (t == null)
            return 0;
        if (t.hasRight() && !t.hasLeft())
            return 1 + countNodesWithOneChild(t.getRight());
        if (!t.hasRight() && t.hasLeft())
            return 1 + countNodesWithOneChild(t.getLeft());
        return countNodesWithOneChild(t.getLeft()) + countNodesWithOneChild(t.getRight());
    }
    //ex 10
    public static int numOfEven(BinNode<Integer>t){
        if (t == null)
            return 0;
        if (t.getValue()%2 == 0)
            return 1 + numOfEven(t.getRight()) + numOfEven(t.getLeft());
        return numOfEven(t.getLeft()) + numOfEven(t.getRight());
    }
    //ex 11
    public static int numOfNodeEToX(BinNode<Integer> t, int x){
        if (t == null)
            return 0;
        if (t.getValue()== x)
            return 1 + numOfNodeEToX(t.getLeft(),x) + numOfNodeEToX(t.getRight(),x);
        return numOfNodeEToX(t.getRight(),x)+numOfNodeEToX(t.getLeft(),x);
    }
    //ex 14
    public static int numOfNodeE(BinNode<Integer> t){
        if (t == null)
            return 0;
        if (t.hasLeft() && t.hasRight() && (t.getLeft().getValue() == t.getRight().getValue()))
            return 1 + numOfNodeE(t.getRight()) + numOfNodeE(t.getLeft());
        return numOfNodeE(t.getLeft()) + numOfNodeE(t.getRight());
    }
}
