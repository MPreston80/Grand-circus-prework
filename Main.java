import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

       int firstDay     = 0;
       int firstMonth   = 0;
       int firstYear    = 0;
       int secondDay    = 0;
       int secondMonth  = 0;
       int secondYear   = 0;
       int daysCount    = 0;
       int monthCount   = 0;
       int yearsCount   = 0;
       int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
       int laterYear    = 0;
       int laterMonth   = 0;
       int laterDay     = 0;
       int earlierYear  = 0;
       int earlierMonth = 0;
       int earlierDay   = 0;

       //Getting user input and assigning input to a variable.

       System.out.println("Enter the first month: ");
                firstMonth = scnr.nextInt();

       System.out.println("Enter the first day: ");
                firstDay = scnr.nextInt();

        System.out.println("Enter the first year: ");
                firstYear = scnr.nextInt();

        System.out.println("Enter the second month: ");
                secondMonth = scnr.nextInt();

        System.out.println("Enter the second day: ");
                secondDay = scnr.nextInt();

        System.out.println("Enter the second year: ");
                secondYear = scnr.nextInt();

        //Changing days in February to 29 if a leap year.
        if(firstYear % 4 == 0){
            daysInMonth[1] = 29;
        }
        if(secondYear % 4 == 0){
            daysInMonth[1] = 29;
        }

        //Checking for invalid input, such as a month entry of 17.
        if(firstMonth > 12 || firstMonth < 1 || secondMonth > 12 || secondMonth < 1) {
            System.out.println("Invalid entry!");
            return;
        }
         if(firstYear < 0 || secondYear < 0 || firstYear > 9999 || secondYear > 9999){
             System.out.println("Invalid entry!");
             return;
         }
         if(secondDay > daysInMonth[secondMonth - 1]){
             System.out.println("Invalid entry!");
             return;
         }

         if(firstDay > daysInMonth[firstMonth - 1]){
             System.out.println("Invalid entry!");
             return;
         }


        //Next four if statements assign the beginning (earlier) and end (later) dates.

        if(secondYear > firstYear){
            laterYear = secondYear;
            laterMonth = secondMonth;
            laterDay = secondDay;
            earlierYear = firstYear;
            earlierMonth = firstMonth;
            earlierDay = firstDay;
        }
        if(secondYear < firstYear){
            laterYear = firstYear;
            laterMonth = firstMonth;
            laterDay = firstDay;
            earlierYear = secondYear;
            earlierMonth = secondMonth;
            earlierDay = secondDay;
        }

        if((firstYear == secondYear) && (firstMonth > secondMonth)){
            laterYear = firstYear;
            laterMonth = firstMonth;
            laterDay = firstDay;
            earlierDay = secondDay;
            earlierMonth = secondMonth;
            earlierYear = secondYear;
        }

        if((firstYear == secondYear) && (firstMonth < secondMonth)){
            laterDay = secondDay;
            laterMonth = secondMonth;
            laterYear = secondYear;
            earlierDay = firstDay;
            earlierMonth = firstMonth;
            earlierYear = firstYear;
        }

        if(secondYear == firstYear && secondMonth == firstMonth && secondDay == firstDay){
            System.out.println("The difference is zero, you entered the same date twice!");
         return;
        }



        if(secondYear == firstYear && secondMonth == firstMonth && secondDay != firstDay){
            if((secondDay > firstDay)){
                daysCount = secondDay - firstDay;
                System.out.println("The difference between the dates is: " + daysCount + " days, " + monthCount + " months,");
                System.out.println("and " + yearsCount + " years.");
            }
            else{
                daysCount = firstDay - secondDay;
                System.out.println("The difference between the dates is: " + daysCount + " days, " + monthCount + " months,");
                System.out.println("and " + yearsCount + " years.");

            }
         return;

        }

        yearsCount = laterYear - earlierYear;

        if(firstYear != secondYear && secondMonth == firstMonth && laterDay < earlierDay){
            yearsCount = yearsCount - 1;
            monthCount = (12 - earlierMonth) + (laterMonth - 1);
            if(laterMonth == 1){
                daysCount = daysInMonth[11] - earlierDay + laterDay;
            }
            else{
                daysCount = daysInMonth[laterMonth - 2] - earlierDay + laterDay;
            }
        }

        if(firstYear != secondYear && secondMonth == firstMonth && laterDay > earlierDay){
            monthCount = 0;
            daysCount = laterDay - earlierDay;

        }

        if(laterMonth > earlierMonth && laterDay > earlierDay){
            monthCount = laterMonth - earlierMonth;
            daysCount = laterDay - earlierDay;
        }

        if(laterMonth > earlierMonth && laterDay < earlierDay){
            monthCount = laterMonth - earlierMonth -1;
            daysCount = daysInMonth[laterMonth - 2] - earlierDay + laterDay;
        }

        if(laterMonth < earlierMonth && laterDay < earlierDay){
            yearsCount = yearsCount - 1;
            monthCount = (12 - earlierMonth) + (laterMonth - 1);
            if(laterMonth == 1){
                daysCount = daysInMonth[11] - earlierDay + laterDay;
            }
            else{
                daysCount = daysInMonth[laterMonth - 2] - earlierDay + laterDay;
            }
        }

        if(laterMonth < earlierMonth && laterDay > earlierDay){
            yearsCount = yearsCount - 1;
            monthCount = (12 - earlierMonth) + laterMonth;
            daysCount = laterDay - earlierDay;
        }

        System.out.println("The difference between the dates is: " + yearsCount + " years, " + monthCount + " months,");
        System.out.println("and " + daysCount + " days.");







    return;
    }
}
