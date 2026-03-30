public class Main {
    // ex1
    public static void printPostOrder(BinNode<Integer> t){
        if (t == null)
            return;
        printPostOrder(t.getLeft());
        printPostOrder(t.getRight());
        System.out.println(t.getValue());
    }
    // ex2
    public static void printInOrder(BinNode<Integer> t){
        if (t == null)
            return;
        printInOrder(t.getLeft());
        System.out.println(t.getValue());
        printInOrder(t.getRight());
    }
    // ex3
    public static void printPreOrder(BinNode<Integer> t){
        if (t == null)
            return;
        System.out.println(t.getValue());
        printPreOrder(t.getLeft());
        printPreOrder(t.getRight());
    }
    // ex4
    public static void printChildrenSmallerThanParent(BinNode<Integer> t){
        if (t == null)
            return;

        printChildrenSmallerThanParent(t.getLeft());
        printChildrenSmallerThanParent(t.getRight());

        if (t.getLeft() != null && t.getLeft().getValue() < t.getValue())
            System.out.println(t.getLeft().getValue());

        if (t.getRight() != null && t.getRight().getValue() < t.getValue())
            System.out.println(t.getRight().getValue());
    }
    // ex5
    public static void printNodeGreaterThanChild(BinNode<Integer> t){
        if (t == null)
            return;

        if (t.hasLeft() && t.hasRight() &&
                (t.getValue() > t.getLeft().getValue() || t.getValue() > t.getRight().getValue())) {
            System.out.println(t.getValue());
        }

        printNodeGreaterThanChild(t.getLeft());
        printNodeGreaterThanChild(t.getRight());
    }
    // ex6
    public static int sumNodes(BinNode<Integer> t){
        if (t == null)
            return 0;

        return t.getValue() + sumNodes(t.getLeft()) + sumNodes(t.getRight());
    }
    // ex7
    public static int countLeaves(BinNode<Integer> t){
        if (t == null)
            return 0;

        if (!t.hasLeft() && !t.hasRight())
            return 1;

        return countLeaves(t.getLeft()) + countLeaves(t.getRight());
    }
    // ex8
    public static int sumRightChildren(BinNode<Integer> t){
        if (t == null)
            return 0;

        int sum = 0;

        if (t.getRight() != null)
            sum += t.getRight().getValue();

        return sum + sumRightChildren(t.getRight()) + sumRightChildren(t.getLeft());
    }
    // ex9
    public static int countSingleChildNodes(BinNode<Integer> t){
        if (t == null)
            return 0;

        if (t.hasRight() && !t.hasLeft())
            return 1 + countSingleChildNodes(t.getRight());

        if (!t.hasRight() && t.hasLeft())
            return 1 + countSingleChildNodes(t.getLeft());

        return countSingleChildNodes(t.getLeft()) + countSingleChildNodes(t.getRight());
    }
    // ex10
    public static int countEvenNodes(BinNode<Integer> t){
        if (t == null)
            return 0;

        if (t.getValue() % 2 == 0)
            return 1 + countEvenNodes(t.getLeft()) + countEvenNodes(t.getRight());

        return countEvenNodes(t.getLeft()) + countEvenNodes(t.getRight());
    }
    // ex11
    public static int countOccurrences(BinNode<Integer> t, int x){
        if (t == null)
            return 0;

        if (t.getValue() == x)
            return 1 + countOccurrences(t.getLeft(), x) + countOccurrences(t.getRight(), x);

        return countOccurrences(t.getRight(), x) + countOccurrences(t.getLeft(), x);
    }
    // ex12
    public static int countGrandparentNodes(BinNode<Integer> t){
        if (t == null)
            return 0;

        int count = 0;

        if (t.getLeft() != null &&
                (t.getLeft().getLeft() != null || t.getLeft().getRight() != null))
            count++;
        else if (t.getRight() != null &&
                (t.getRight().getLeft() != null || t.getRight().getRight() != null))
            count++;

        return count + countGrandparentNodes(t.getLeft()) + countGrandparentNodes(t.getRight());
    }
    // ex13
    public static int countSingleOddChildNodes(BinNode<Integer> t){
        if (t == null)
            return 0;

        if (t.hasRight() && !t.hasLeft() && t.getRight().getValue() % 2 != 0)
            return 1 + countSingleOddChildNodes(t.getRight()) + countSingleOddChildNodes(t.getLeft());

        if (!t.hasRight() && t.hasLeft() && t.getLeft().getValue() % 2 != 0)
            return 1 + countSingleOddChildNodes(t.getLeft()) + countSingleOddChildNodes(t.getRight());

        return countSingleOddChildNodes(t.getRight()) + countSingleOddChildNodes(t.getLeft());
    }
    // ex14
    public static int countNodesWithEqualChildren(BinNode<Integer> t){
        if (t == null)
            return 0;

        int count = 0;

        if (t.hasLeft() && t.hasRight() &&
                t.getLeft().getValue().equals(t.getRight().getValue())) {
            count = 1;
        }

        return count + countNodesWithEqualChildren(t.getLeft()) + countNodesWithEqualChildren(t.getRight());
    }
    // ex15
    public static int countNodesSmallerThanChild(BinNode<Integer> t) {
        if (t == null)
            return 0;

        int count = 0;

        if ((t.hasLeft() && t.getValue() < t.getLeft().getValue()) ||
                (t.hasRight() && t.getValue() < t.getRight().getValue())) {
            count = 1;
        }

        return count
                + countNodesSmallerThanChild(t.getLeft())
                + countNodesSmallerThanChild(t.getRight());
    }
    // ex16
    public static int countChildrenGreaterThanParent(BinNode<Integer> t) {
        if (t == null)
            return 0;

        int count = 0;

        if (t.hasLeft() && t.getLeft().getValue() > t.getValue())
            count += 1;

        if (t.hasRight() && t.getRight().getValue() > t.getValue())
            count += 1;

        count += countChildrenGreaterThanParent(t.getLeft());
        count += countChildrenGreaterThanParent(t.getRight());

        return count;
    }
    //ex 23
    public static boolean isAllValuesAreOdd(BinNode<Integer>t){
        if (t == null)
            return true;
        if (t.getValue() % 2 == 0)
            return false;
        return isAllValuesAreOdd(t.getLeft()) && isAllValuesAreOdd(t.getRight());
    }
    //ex 24
    public static boolean isAllBrothersHaveEqualValues(BinNode<Integer> t){
        if (t == null)
            return true;
        if ((t.hasLeft() && !t.hasRight()) || (!t.hasLeft() && t.hasRight()))
            return false;
        if (t.hasLeft() && t.hasRight()) {
            if (!t.getLeft().getValue().equals(t.getRight().getValue()))
                return false;
        }
        return isAllBrothersHaveEqualValues(t.getLeft()) && isAllBrothersHaveEqualValues(t.getRight());
    }
    //ex 25
    public static boolean isAllBrothersEqualToParent(BinNode<Integer> t) {
        if (t == null)
            return true;
        if (t.hasLeft() && t.getValue() != t.getLeft().getValue())
            return false;
        if (t.hasRight() && t.getValue() != t.getRight().getValue())
            return false;
        return isAllBrothersEqualToParent(t.getLeft()) &&  isAllBrothersEqualToParent(t.getRight());
    }
    //ex 26
    public static boolean isHas8(BinNode<Integer>t){
        if (t == null)
            return true;
        if (t.getValue() == 8)
            return false;
        return isHas8(t.getLeft()) && isHas8(t.getRight());
    }
    //ex 27
    public static boolean hasNodeWithDifferentChildren(BinNode<Integer>t){
        if (t == null)
            return false;

        if (t.hasRight() && t.hasLeft() && t.getLeft().getValue() != t.getRight().getValue())
            return true;
        return hasNodeWithDifferentChildren(t.getLeft()) || hasNodeWithDifferentChildren(t.getRight());
    }
    //ex 28
    public static boolean isLeftGreaterRightSmaller(BinNode<Integer> t){
        if (t == null)
            return true;
        if (t.hasLeft() && !(t.getLeft().getValue() > t.getValue())){
            return false;
        }
        if (t.hasRight() && !(t.getRight().getValue()<t.getValue())){
            return false;
        }
        return isLeftGreaterRightSmaller(t.getRight()) && isLeftGreaterRightSmaller(t.getLeft());
    }
}
