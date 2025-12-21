public class Main {
    //ex 1:
    public static boolean isGeometric(int[] arr){
        double q = (double)arr[1]/arr[0];
        return isGeometric(arr,0,q);
    }
    public static boolean isGeometric(int[] arr, int index, double q){
        if (arr.length < 2) {
            return true;
        }
        if (index>=arr.length-1){
            return true;
        }
        if (!(arr[index]*q==arr[index+1])){
            return false;
        }
        return isGeometric(arr,index+=1,q);
    }
    //ex 2:
    public static boolean isSymmetrical(int[] arr) {
        return isSymmetrical(arr, 0, arr.length - 1);
    }
    public static boolean isSymmetrical(int[] arr, int left, int right) {
        if (left >= right) {
            return true;
        }

        if (arr[left] != arr[right]) {
            return false;
        }

        return isSymmetrical(arr, left + 1, right - 1);
    }
    //ex 3:
    public static int printSeriesSum(int x, int d, int n){
        return printSeriesSum(x, d, n, 0);
    }
    public static int printSeriesSum(int x, int d, int n, int index){
        if (index == n){
            return 0;
        }
        System.out.println(x);

        return x + printSeriesSum(x + d, d, n, index + 1);
    }
    //ex 4:
    public static int reverse(int n) {
        return reverse(n, 0);
    }
    public static int reverse(int n, int temp) {
        if (n == 0) {
            return temp;
        }
        return reverse(n / 10, temp * 10 + n % 10);
    }
    //ex 5:
    public static double average(int[] arr) {
        if (arr.length == 0)
            return 0;
        return sum(arr, 0) / arr.length;
    }
    public static double sum(int[] arr, int index) {
        if (index == arr.length)
            return 0;
        return arr[index] + sum(arr, index + 1);
    }
    //ex 6:
    public static double averageOfNum(int n) {
        return (double) averageOfNum(n, 0)/countDigits(n);
    }
    public static double averageOfNum(int n, int sum){
        if (n == 0)
            return sum;
        sum += n%10;
        return averageOfNum(n/10,sum);
    }
    public static int countDigits(int n) {
        if (n == 0)
            return 0;
        return 1 + countDigits(n / 10);
    }
    //ex 7:
    public static boolean isAllDigitsAreDiff(int n){
        if (n==0)
            return true;
        if (isDigitInNum(n/10,n%10))
            return false;
        return isAllDigitsAreDiff(n/10);
    }
    public static boolean isDigitInNum(int n,int digit){
        if (n==0)
           return false;
        if (digit == n%10){
            return true;
        }
        return isDigitInNum(n/10,digit);
    }
    //ex 8:
    public static int maxInArr(int[]arr){
        if (arr.length == 0)
            return -999;
        return maxInArr(arr,-999,0);
    }
    public static int maxInArr(int[]arr,int max,int index){
        if (index > arr.length-1)
            return max;
        if (arr[index]>max)
            max = arr[index];
        index++;
        return maxInArr(arr,max,index);
    }
    // 9:
    public static void reverseArr(int[] arr) {
        reverseArr(arr, 0, arr.length - 1);
    }
    public static void reverseArr(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        reverseArr(arr, left + 1, right - 1);
    }
    //10:
    public static boolean isAllEqual(int[]arr){
        return isAllEqual(arr,0);
    }
    public static boolean isAllEqual(int[] arr, int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] != arr[i + 1]) {
            return false;
        }
        return isAllEqual(arr, i + 1);
    }

    public static void main(String[] args) {

        // ex 1
        int[] g1 = {2, 4, 8, 16};
        int[] g2 = {2, 4, 9, 16};
        System.out.println("ex1: " + isGeometric(g1)); // true
        System.out.println("ex1: " + isGeometric(g2)); // false

        // ex 2
        int[] s1 = {1, 2, 3, 2, 1};
        int[] s2 = {1, 2, 3, 4};
        System.out.println("ex2: " + isSymmetrical(s1)); // true
        System.out.println("ex2: " + isSymmetrical(s2)); // false

        // ex 3
        System.out.println("ex3 series + sum:");
        int sum = printSeriesSum(1, 2, 4);
        System.out.println("sum = " + sum);

        // ex 4
        System.out.println("ex4: " + reverse(1234)); // 4321

        // ex 5
        int[] a1 = {2, 4, 6, 8};
        System.out.println("ex5: " + average(a1)); // 5.0

        // ex 6
        System.out.println("ex6: " + averageOfNum(246)); // 4.0

        // ex 7
        System.out.println("ex7: " + isAllDigitsAreDiff(1234)); // true
        System.out.println("ex7: " + isAllDigitsAreDiff(1223)); // false

        // ex 8
        int[] m = {3, 17, 9, 2};
        System.out.println("ex8: " + maxInArr(m)); // 17

        // ex 9
        int[] r = {1, 2, 3, 4, 5};
        reverseArr(r); // [5,4,3,2,1]
        System.out.println("ex9: ");
        printArray(r);

        // ex 10
        int[] e1 = {7, 7, 7};
        int[] e2 = {7, 7, 5};
        System.out.println("ex10: " + isAllEqual(e1)); // true
        System.out.println("ex10: " + isAllEqual(e2)); // false
    }
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
