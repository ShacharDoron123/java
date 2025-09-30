import java.util.*;
public class Main {
    public static Scanner reader = new Scanner(System.in);
    public static int countEmpty(int [] arr) {
        int count=0;
        for(int i=0; i < arr.length;i++) {
            if(arr[i]==0)
                count++;
        }
        return count;
    }
    public static void clearArr(int [] arr)
    {
        for (int i=0;i < arr.length;i++)
        {
            arr [i]= 0;
        }
    }
    public static void Print2048(int [] arr )
    {
        System.out.print("|");
        for (int i=0;i < arr.length;i++)
        {
            System.out.print(arr[i] + "|");
        }
    }
    public static int[] moveToRight (int[]arr){
        for (int j=1;j<=8;j++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i + 1] == 0) {
                    arr[i + 1] = arr[i];
                    arr[i] = 0;
                }
            }
        }
        return arr;
    }
    public static int[] moveToLeft (int[]arr){
        for(int j=1;j<=8;j++){
            for(int i=arr.length-1;i>0;i--) {
                if(arr[i-1]==0)
                {
                    arr[i-1]=arr[i];
                    arr [i] = 0;
                }
            }
        }
        return arr;
    }
    public static void addNum(int [] arr){
        int emptyCount = countEmpty(arr);
        if (emptyCount == 0)
            return;
        int count=0;
        while (count!=1){
            int i = (int) (Math.random() * arr.length);
            if (arr[i]==0){
                int num = (int) (Math.random() * (101));
                if (num<=25){
                    arr[i]=4;
                    count++;
                }
                if (num>25&&num<=100){
                    arr[i]=2;
                    count++;
                }
            }
        }
    }
    public static int margeToRight(int[]arr){
        int score=0;
        for (int j=1;j<=8;j++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i + 1] == arr [i]) {
                    score += (arr[i])*2;
                    arr[i + 1] = arr[i]*2;
                    arr[i] = 0;
                }
            }
        }
        return score;
    }

    public static int margeToLeft(int[]arr){
        int score=0;
        for(int j=1;j<=8;j++){
            for(int i=arr.length-1;i>0;i--) {
                if(arr[i-1]==arr [i])
                {
                    score += (arr[i])*2;
                    arr[i - 1] = arr[i]*2;
                    arr[i] = 0;
                }
            }
        }
        return score;
    }
    public static boolean canMarge(int [] arr) {
        int[] Narr = new int[8];
        for (int k = 0; k < arr.length; k++) {
            Narr[k] = arr[k];
        }
        int score = 0;
        for (int j = 1; j <= 8; j++) {
            for (int i = Narr.length - 1; i > 0; i--) {
                if (Narr[i - 1] == Narr[i]) {
                    score += (Narr[i]) * 2;
                    Narr[i - 1] = Narr[i] * 2;
                    Narr[i] = 0;
                }
            }
        }
        for (int j=1;j<=8;j++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (Narr[i + 1] == Narr[i]) {
                    score += (Narr[i])*2;
                    Narr[i + 1] = Narr[i]*2;
                    Narr[i] = 0;
                }
            }
        }
        return score > 0;
    }
    public static void main(String[] args) {
        int choice, score=0;
        int []arr=new int[8];
        clearArr(arr);
        addNum(arr);
        Print2048(arr);
        while (countEmpty(arr)!=0 || canMarge(arr)){
            choice = reader.nextInt();
            if (choice==1){
                moveToLeft(arr);
                score += margeToLeft(arr);
                moveToLeft(arr);
            }
            if (choice==2){
                moveToRight(arr);
                score += margeToRight(arr);
                moveToRight(arr);
            }

            addNum(arr);
            Print2048(arr);
        }
        System.out.println(" ");
        System.out.println( "the final score is: " +score);
        System.out.println(" ");
        System.out.println("game over!!!");
    }
}
