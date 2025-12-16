public class Main {
    public static void main(String[] args) {
        System.out.println(n(5));
        System.out.println(n1(500));
        System.out.println(n2(90));
        System.out.println(n3(110));
        System.out.println(n4(4));
    }
    public static int n(int n){
        if (n==1 || n==0)
            return 1;
        return n* n(n-1);
    }
    public static int n1(int n) {
        if (n < 10)
            return 1;
        return 1 + n1(n / 10);
    }
    public static int n2(int n) {
        if (n == 0)
            return 0;

        int digit = n % 10;
        int rest = n / 10;

        if (digit % 2 == 0)
            return digit + n2(rest);
        else
            return n2(rest);
    }
    public static int n3(int n) {
        if (n < 10)
            return n;

        return n3(n / 10);
    }
    public static int n4(int n) {
        if (n == 0)
            return 0;

        int x;

        if (n % 2 == 0)
            x = n * n;
        else
            x = n * 2;

        return x + n4(n - 1);
    }
}
