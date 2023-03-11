/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm_interface1;
import java.util.*;
/**
 *
 * @author Sakib Sadri
 */
public class ATM_Interface {
     int ATM_ID=979802887;
     int PIN = 12345;
     int TRANSFER_ID=82989056;
     double BALANCE,amount,amount1,amount2;

Scanner sc = new Scanner(System.in);
public void checkPin(){
System.out.println("\n  WELCOME TO ATM MACHINE ");    
System.out.print("Enter Your ATM_ID:");
int atm_id = sc.nextInt();
System.out.print("Enter Your ATM_PIN:");
int pin = sc.nextInt();
if((atm_id==ATM_ID)&&(pin==PIN)){
    Command_menu();
}
else{
    System.out.println("""
                       ATM_ID or PIN is INCORRECT!!
                       Enter a valid credential!
                       Try Again!""");
    checkPin();
}

}

public void Command_menu(){
    System.out.print("""
                     \n!!!Command_menu!!!
                     1.Transcation History. 
                     2.Withdraw. 
                     3.Deposit. 
                     4.Transfer. 
                     5.Check Balance. 
                     6.Quit.
                     Enter Your Choice:""");

    char choice = sc.next().charAt(0);
    // command menu---------------------------------------------------------------------------------------------------------------------
    switch(choice){
        case '1' -> {
            System.out.println(" Your Transaction_History is as follows :");   
            System.out.println(" Your current Balance is: "+BALANCE+
                             "\n Withdrawal ammount is:  -"+amount+
                             "\n Deposited amount is:    +"+amount1+
                             "\n Transfered amount is:   -"+amount2);
            Command_menu();
        }
        case '2' -> {
            System.out.print("Enter Amount to Withdraw:");
            amount = sc.nextDouble();
                            System.out.println(amount);

            if(amount > BALANCE){
                System.out.println("INSUFFICIENT BALANCE");
            }
            else{
                // Balance = BALANCE-amount;
                BALANCE = BALANCE-amount;
                System.out.println("Money Withdraws Successfully!!");
                // System.out.println(BALANCE);
            }
            Command_menu();
        }
        case '3' -> {
            System.out.print("Enter the Amount:");
            amount1=sc.nextDouble();
            // Balance1 = BALANCE +amount1;
            BALANCE = BALANCE + amount1;
            System.out.println("Money Deposited Successfully!");
            Command_menu();
        }


        case '4' -> {
            System.out.print("Enter Transfer_ID:");
            int transfer_id=sc.nextInt();
            if(transfer_id==TRANSFER_ID){
                System.out.print("Enter Amount:");
                amount2 = sc.nextDouble();
                if(amount2 < BALANCE){
                    System.out.println("Money Transmitted Successfully!");
                    // Balance2 = BALANCE - amount2;
                    BALANCE = BALANCE - amount2;
                    System.out.println("Your Balance is:"+BALANCE);
                }
                else{
                    System.out.println("INSUFFICIENT BALANCE!!\nTry Again!");
                }
            }
            else{
                System.out.println("Entered Transfer_ID is not matched!!\nTry Again!");
            }
            Command_menu();
        }
        case '5' -> {
            System.out.println("Balance:"+BALANCE);
            Command_menu();
        }
        case '6' -> System.out.println("Thank you for using ATM!!\nHave a nice day");

        default ->{ System.out.println("INVALID CHOICE!\nTry Again");
                   Command_menu();
    }
    }

}

    public static void main(String[] args) throws Exception {
        ATM_Interface atm=new ATM_Interface();
        atm.checkPin();
    }   
}
