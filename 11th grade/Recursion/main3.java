public class Main {
    public static void main(String[] args) {
        System.out.println(n5(15,5));
        System.out.println(n6(15));
        System.out.println(n7(20,25));
        n8(123456789);
    }

    public static boolean n5(int n,int d){
        int x;
        if (n == 0)
            return false;
        x = n%10;
        if (x==d)
            return true;
        return n5(n/10,d);
    }
    public static boolean n6(int n){
        int x;
        if (n == 0)
            return true;
        x= n%10;
        if (x%2==0)
            return n6(n/10);
        return false;
    }
    public static boolean n7(int n, int m) {
        if (n == 0 && m == 0)
            return true;

        if (n == 0 || m == 0)
            return false;

        return n7(n / 10, m / 10);
    }
    public static void n8(int n) {
        if (n == 0)
            return;

        int digit = n % 10;

        if (digit % 2 == 0)
            System.out.println(digit);

        n8(n / 10);
    }
}
