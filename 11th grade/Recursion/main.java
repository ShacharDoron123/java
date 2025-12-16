public class Main {
    public static boolean isSame(int n){
        if (n<=10){
            return false;
        }
        else {
            if (n%10==(n/10)%10){
                return true;
            }
            return isSame(n/10);
        }
    }
    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        return isPrime(n, 2);
    }

    public static boolean isPrime(int n, int i) {
        if (i * i > n)
            return true;
        if (n % i == 0)
            return false;
        return isPrime(n, i + 1);
    }
    public static int sum(int []arr){
        return sum(arr,0);
    }
    public static int sum(int []arr,int i){
        if (i>=arr.length){
            return 0;
        }
        else {
            if (isPrime(arr[i])){
                return arr[i]+sum(arr, i+1);
            }
            else return sum(arr,i+1);
        }
    }
    public static void main(String[] args) {
        //isSame:
        System.out.println(isSame(11));
        System.out.println(isSame(12));
        System.out.println(isSame(100));
        //isPrime:
        System.out.println(isPrime(1));
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        //sum:
        int []arr = {1,0,2,3,4,5,6,7,8,9};
        System.out.println(sum(arr));
    }
}
