public class Account {
    String num;
    Person owner;
    Date creationDt;
    double balance;

    Account (String n, Person o, Date d){
        this.num = n;
        this.owner = o;
        this.creationDt = d;
        this.balance = 0.0;
        System.out.println("New account added in the system.");
    }

    double available(){
        return this.balance;
    }

    void statement(){
        System.out.println("************ ACCOUNT STATEMENT ************");
        System.out.println("Account: " + this.num);
        System.out.println("Account owner: " + this.owner.cpf);
        System.out.println("Balance available for withdrawal: " + this.available());
        System.out.println("*******************************************\n");
    }

    void deposit(double value){
        this.balance += value;
    }

    boolean withdrawal(double value){
        if (value <= this.available()){
            this.balance -= value;
            System.out.println("Withdrawal from account " + this.num + " was successful.\nNew balance: " + this.balance);
            return true;
        } else {
            System.out.println("ERROR: Withdrawal from account " + this.num + " was not carried out.");
            return false;
        }
    }

    boolean transfer(double value, Account destination){
        if (this.withdrawal(value)){
            destination.deposit(value);
            System.out.println("Transference of $" + value + " from account " + this.num + " to the account " + destination.num + " was successful.");
            return true;
        } else{
            System.out.println("ERROR: Transference of $" + value + " from account " + this.num + " to the account " + destination.num + " was not carried out.");
            return false;
        }
    }



}
