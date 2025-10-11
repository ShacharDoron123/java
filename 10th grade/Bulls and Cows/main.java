import java.util.*;
public class Work {
	    public static Scanner reader = new Scanner(System.in);
	    public static int random() {
	        //טענת כניסה: הפונקצייה לא מקבלת משתנים
	        //טענת יציאה: הפעולה מחזירה מספר בעל ארבע ספרות ושכל ספרה שונה זו מזו
	        int randomNum = 0, units, tens, hundreds, thousands;
	        boolean uniqueDigits = false;
	        while(!(uniqueDigits))
	        {
	            randomNum = 1000+(int)(Math.random()*9000);
	            units = randomNum % 10;
	            tens = randomNum / 10 % 10;
	            hundreds = randomNum / 100 % 10;
	            thousands = randomNum  / 1000;
	            uniqueDigits = (units != tens && tens != hundreds && hundreds != thousands && units != thousands && tens != thousands && units != hundreds);
	        }
	        return randomNum;
	    }
	    public static int getDigitOfNum(int num, int digitNum)
	    {
	        //טענת כניסה: הפעולה מקבלת מספר ומספר שמציין את הספרה הרצויה
	        //טענת יציאה: מחזירה את הספרה הרצויה מהמספר
	        int digit = num;
	        for(int i = 1; i < digitNum; i++)
	            digit /= 10;
	        digit = digit % 10;
	        return digit;
	    }
	    public static void main(String[] args) {
	        boolean bulPgia = false;
	        int numRandom = random();
	        while(!(bulPgia))
	        {
	            System.out.println("Please enter your guess");
	            int num = reader.nextInt();
	            int countPgia = 0;
	            int countBul = 0;
	            for(int i = 1; i <= 4; i++)
	                if(getDigitOfNum(num, i) == getDigitOfNum(numRandom, i))
	                    countBul++;
	            bulPgia = (countBul == 4);
	            for(int i = 1; i <= 4; i++)
	                for(int j = 1; j <= 4; j++)
	                    if((getDigitOfNum(num, i) == getDigitOfNum(numRandom, j)) && (i != j))
	                        countPgia++;
	            System.out.println(countBul + " Bul " + countPgia + " Pgia");
	        }
	        System.out.println("Bul Pgia");
	    }
	}
