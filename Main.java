import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Please enter a number:");
        int x = scnr.nextInt();
        int numDigits = 0;
        numDigits = String.valueOf(x).length();
        int i = 0;
        int[] outputArray = new int[9];
        int tempVal = 0;
        int j = 0;
        boolean isNegative = false;



        tempVal = x;
        //checks to see if user input is a negative number, then changes it back to a positive number.
        if(x < 0){
            tempVal = x * -1;
            x = tempVal;
            isNegative = true;
        }
        //so the array won't try and switch the minus sign with an integer.
        if(isNegative){
            numDigits = numDigits - 1;
        }
        // loop populating the array with the last digit of the number on up to the first.
        for(i = 0; i < numDigits; ++i){
            tempVal = tempVal % 10;
            outputArray[i] = tempVal;
            x = x / 10;
            tempVal = x;

        }
        System.out.print("The number you entered in reverse is: ");
        if(isNegative){
            System.out.print("-");
        }
        for(j = 0; j < numDigits; ++j){
            System.out.print(outputArray[j]);
        }


     return;
    }
}
