package com.epam.mentoring;

import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        // practice1();
        practice2();
    }

    static void practice2(){
        Account feriAccount = new Account("Feri", 2000);
        Account katiAccount = new Account("Kati");

//        Create and initialize array #1
//        Account[] accounts = new Account[2];
//        accounts[0] = feriAccount;
//        accounts[1] = katiAccount;

//        Create and initialize array #2
//        Account[] accounts = new Account[]{feriAccount, katiAccount};

//        Create and initialize array #3
        Account[] accounts = {feriAccount, katiAccount};

        printBalance(accounts);

        System.out.println("=========");

        System.out.printf("Account - Id: %d, Account holder: %s\n", feriAccount.getId(), feriAccount.getAccountHolder());

        feriAccount.setAccountHolder("Ferenc");

        feriAccount.credit(10);
        feriAccount.debit(20);
        feriAccount.transferTo(katiAccount, 30);

        System.out.println("=========");

        System.out.printf("Account - Id: %d, Account holder: %s\n", katiAccount.getId(), katiAccount.getAccountHolder());
        katiAccount.setAccountHolder("Katalin");

        katiAccount.credit(15);
        katiAccount.debit(55);
        katiAccount.transferTo(feriAccount, 65);

        System.out.println("=========");

        printBalance(accounts);
    }

    static void printBalance(Account[] accounts){
//        for(int i = 0 ; i < accounts.length ; ++i){
//            Account current = accounts[i];
//            System.out.printf("Balance on %s's account: %d\n", current.getAccountHolder(), current.getBalance());
//        }

        //foreach, same as above
        for(Account current : accounts){
            System.out.printf("Balance on %s's account: %d\n", current.getAccountHolder(), current.getBalance());
        }

    }

    static void practice1(){
        // Task#1 - Print Hello world
        System.out.println("Hello world");
        System.out.println(isLeapYear(2000));
        passOrFail(6);
        printWeekday(1);
        readFromKeyboard();
    }

    // Task#2 - Write an expression to return true if year is a leap year.
    // Leap Years are any year that can be evenly divided by 4 (such as 2012, 2016, etc)
    //      except if it can be evenly divided by 100, then it isn't (such as 2100, 2200, etc)
    //          except if it can be evenly divided by 400, then it is (such as 2000, 2400)
    static boolean isLeapYear(int year) {
        boolean a = year % 4 == 0;
        boolean b = year % 100 != 0;
        boolean c = year % 400 == 0;
        return (a && b) || c;
        // Without introducing variables in a single expression:
        // return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

    // Task#3 - Write a program called CheckPassOrFail which prints "PASS"
    // if the int variable "mark" is more than or equal to 5,
    // or prints "FAIL" otherwise.
    static void passOrFail(int mark) {
        if (mark >= 5) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    // Task#3 - Write a program to print day of week name using switch case.
    static void printWeekday(int weekday) {
        switch (weekday) {
            case 1:
                System.out.println("MONDAY");
                break;  // Don't forget "break"
            case 2:
                System.out.println("TUESDAY");
                break;
            case 3:
                System.out.println("WEDNESDAY");
                break;
            case 4:
                System.out.println("THURSDAY");
                break;
            case 5:
                System.out.println("FRIDAY");
                break;
            case 6:
                System.out.println("SATURDAY");
                break;
            default:
                System.out.println("SUNDAY");
        }
    }

    // Optional Task#4 - Calculate the number of days in a particular month.
    static void printNumberOfDays(int year, int month) {
        int numDays = 0;

        // Add switch here - you can reuse isLeapYear method
        // ...

        System.out.println("Number of Days = " + numDays);
    }


    static void readFromKeyboard(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.next();

        System.out.print("Enter a number: ");
        int inputInt = scanner.nextInt();

        // exit before print input data
        System.exit(0);

        // never will be executed
        System.out.println("inputString: " + inputString + ", inputInt: " + inputInt);
    }
}
