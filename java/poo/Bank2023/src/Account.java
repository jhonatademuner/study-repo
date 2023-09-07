import java.util.Scanner;

public class Account {
    String num;
    Person owner;
    Date creationDt;
    double balance;
    Manager manager;

    Account (Manager m){
        System.out.println("****** ENTER THE MANAGER INFORMATION ******");

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the account number: ");
        this.num = s.nextLine();

        System.out.println("Enter the account owner: ");
        this.owner = new Person();

        System.out.println("Enter the account creation date: ");
        this.creationDt = new Date();

        this.balance = 0;

        this.manager = m;

        System.out.println("*******************************************\n");


        System.out.println("\n*******************************************");
        System.out.println(" NEW MANAGER ACCOUNT ADDED IN THE SYSTEM");
        System.out.println("*******************************************\n");
    }

    Account (String n, Person o, Date d){
        this.num = n;
        this.owner = o;
        this.creationDt = d;
        this.balance = 0.0;
        System.out.println("\n*******************************************");
        System.out.println("      NEW ACCOUNT ADDED IN THE SYSTEM");
        System.out.println("*******************************************\n");

    }

    double available(){
        return this.balance;
    }

    void statement(){
        System.out.println("Account: " + this.num);
        System.out.println("Account owner: " + this.owner.name + " (CPF: " + this.owner.cpf + " )");
        System.out.println("Balance available for withdrawal: " + this.available());
        System.out.println("*******************************************\n");
    }

    void deposit(double value){
        this.balance += value;
    }

    boolean withdrawal(double value){
        if (value <= this.available()){
            this.balance -= value;
            System.out.println("\n*******************************************");
            System.out.println("Withdrawal from account " + this.num + " was successful.\nNew balance: " + this.balance);
            System.out.println("*******************************************\n");
            return true;
        } else {
            System.out.println("\n*******************************************");
            System.out.println("ERROR: Withdrawal from account " + this.num + " was not carried out.");
            System.out.println("*******************************************\n");

            return false;
        }
    }

    boolean transfer(double value, Account destination){
        if (this.withdrawal(value)){
            destination.deposit(value);
            System.out.println("\n*******************************************");
            System.out.println("Transference of $" + value + " from account " + this.num + " to the account " + destination.num + " was successful.");
            System.out.println("*******************************************\n");

            return true;
        } else{
            System.out.println("\n*******************************************");
            System.out.println("ERROR: Transference of $" + value + " from account " + this.num + " to the account " + destination.num + " was not carried out.");
            System.out.println("*******************************************\n");

            return false;
        }
    }



}
