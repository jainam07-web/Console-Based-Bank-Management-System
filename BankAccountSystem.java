package project;

import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountSystem extends AccountDetails{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<AccountDetails> list = new ArrayList<>();

        while (true) {
            System.out.println("===WELCOME TO TUKA JOSHI BANKING SYSTEM===");

            System.out.println("1.CREATE ACCOUNT\n2.DEPOSIT MONEY IN AN ACCOUNT\n3.WITHDRAW MONEY FROM ACCOUNT\n4.PRINT DETAILS OF ALL ACCOUNT\n5.EXIT");
            int input = in.nextInt();

            switch (input) {
                case 1:
                    CreateAccount(list);
                    break;

                case 2:
                    depmoney(list);
                    break;

                case 3:
                    Withdraw(list);
                    break;

                case 4:
                    AccDet(list);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("--ENTER A VALID CHOICE--");
                    break;
            }
        }
    }

    public static void Withdraw(ArrayList<AccountDetails> list) {
        if (list.isEmpty()) {
            System.out.println("Pls create an Account First ");
            return;
        }

        Scanner in = new Scanner(System.in);
        String num = "";

        while (true) {

            System.out.println("Enter Your Account number ");
            String numm = in.nextLine();

            if (numm.length() == 15) {
                num = numm;
                break;
            } else {
                System.out.println("enter a valid account number :");
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).AccNo.equals(num)) {
                System.out.println("Account Details Fetched");
                System.out.println("Your current account balance is :" + list.get(i).Balance);

                while (true) {
                    System.out.println("Enter the Amount u want to Withdraw");
                    int with = in.nextInt();

                    if (list.get(i).Balance < with) {
                        System.out.println("Insufficient balance ");

                    } else {
                        list.get(i).Balance = list.get(i).Balance - with;
                        break;
                    }
                }
                break;

            } else {
                System.out.println("Account number not found in details");
            }
        }
    }

    private static void depmoney(ArrayList<AccountDetails> list) {

        Scanner in = new Scanner(System.in);

        if (list.isEmpty()) {
            System.out.println("Pls Create an Account First");
            return;
        }

        String num = "";

        while (true) {

            System.out.println("Enter Your Account number ");
            String numm = in.nextLine();

            if (numm.length() == 15) {
                num = numm;
                break;

            } else {
                System.out.println("enter a valid account number :");
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).AccNo.equals(num)) {

                System.out.println("enter the amount of money you want to deposit :");
                int amt = in.nextInt();

                System.out.println("Account Details Fetched");
                System.out.println("Your current account balance is :" + list.get(i).Balance);

                list.get(i).Balance = list.get(i).Balance + amt;

                System.out.println("your account balance after depositing is:" + list.get(i).Balance);

            } else {
                System.out.println("Account number Not Found in Records");
            }
        }
    }

    public static void AccDet(ArrayList<AccountDetails> list) {

        if (list.isEmpty()) {
            System.out.println("No Account created");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(
                    "ACCOUNT NUMBER:" + list.get(i).AccNo +
                    "\nNAME:" + list.get(i).Name +
                    "\nPHONE NUMBER:" + list.get(i).Phonenumber +
                    "\nBALANCE:" + list.get(i).Balance+"\n ");
        }
    }

    public static void CreateAccount(ArrayList<AccountDetails> list) {

        Scanner in = new Scanner(System.in);

        System.out.println("---Creating an account---");

        AccountDetails account = new AccountDetails();

        while (true) {

            System.out.print("Enter The Account Number");
            String act = in.nextLine();

            if (act.length() == 15) {
                account.AccNo = act;
                break;

            } else {
                System.out.println("Enter A Valid Account Number");
            }
        }

        System.out.println("Enter your name");
        account.Name = in.nextLine();

        System.out.println("Enter your Account Balance");
        account.Balance = in.nextLong();

       
        in.nextLine();

        while (true) {

            System.out.println("enter your phone number");
            String phno = in.nextLine();

            if (phno.length() == 10) {
                account.Phonenumber = "+91" + phno;
                break;

            } else {
                System.out.println("Enter a Valid Phone number ");
            }
        }

        list.add(account);

        System.out.println("Account Details Added Successfully");
    }
}