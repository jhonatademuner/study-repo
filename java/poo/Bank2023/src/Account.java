import java.util.Scanner;

public class Account {
    private String num;
    private Person owner;
    private Date creationDt;
    private double balance;
    private Manager manager;

    Account (Person owner, Manager m){
        System.out.println("****** ENTER THE MANAGER INFORMATION ******");

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the account number: ");
        this.setNum(s.nextLine());

        this.setOwner(owner);

        System.out.println("Enter the creation date: ");
        this.setCreationDt(new Date());

        this.setBalance(0);

        this.setManager(m);

        System.out.println("*******************************************\n");


        System.out.println("\n*******************************************");
        System.out.println(" NEW ACCOUNT ADDED IN THE SYSTEM");
        System.out.println("*******************************************\n");
    }

    Account (String n, Person o, Date d){
        this.setNum(n);
        this.setOwner(o);
        this.setCreationDt(d);
        this.setBalance(0.0);
        System.out.println("\n*******************************************");
        System.out.println("      NEW ACCOUNT ADDED IN THE SYSTEM");
        System.out.println("*******************************************\n");

    }

    protected double available(){
        return this.getBalance();
    }

    void statement(){
        System.out.println("Account: " + this.getNum());
        System.out.println("Account owner: " + this.getOwner().getName() + " (CPF: " + this.getOwner().getCpf() + " )");
        System.out.println("Balance available for withdrawal: " + this.available());
        System.out.println("*******************************************\n");
    }

    void deposit(double value){
        this.setBalance(this.getBalance() + value);
    }

    void deposit(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value to deposit: ");
        double value = s.nextDouble();
        this.deposit(value);
    }

    boolean withdrawal(double value){
        if (value <= this.available()){
            this.setBalance(this.getBalance() - value);
            System.out.println("\n*******************************************");
            System.out.println("Withdrawal from account " + this.getNum() + " was successful.\nNew balance: " + this.getBalance());
            System.out.println("*******************************************\n");
            return true;
        } else {
            System.out.println("\n*******************************************");
            System.out.println("ERROR: Withdrawal from account " + this.getNum() + " was not carried out.");
            System.out.println("*******************************************\n");

            return false;
        }
    }

    boolean withdrawal(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value to withdrawal: ");
        double value = s.nextDouble();
        return this.withdrawal(value);
    }

    boolean transfer(double value, Account destination){
        if (this.withdrawal(value)){
            destination.deposit(value);
            System.out.println("\n*******************************************");
            System.out.println("Transference of $" + value + " from account " + this.getNum() + " to the account " + destination.getNum() + " was successful.");
            System.out.println("*******************************************\n");

            return true;
        } else{
            System.out.println("\n*******************************************");
            System.out.println("ERROR: Transference of $" + value + " from account " + this.getNum() + " to the account " + destination.getNum() + " was not carried out.");
            System.out.println("*******************************************\n");

            return false;
        }
    }

    boolean transfer(Account destination){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value to transfer: ");
        double value = s.nextDouble();
        return this.transfer(value, destination);
    }


    protected String getNum() {
        return num;
    }

    protected void setNum(String num) {
        this.num = num;
    }

    protected Person getOwner() {
        return owner;
    }

    protected void setOwner(Person owner) {
        this.owner = owner;
    }

    protected Date getCreationDt() {
        return creationDt;
    }

    protected void setCreationDt(Date creationDt) {
        this.creationDt = creationDt;
    }

    protected double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    protected Manager getManager() {
        return manager;
    }

    protected void setManager(Manager manager) {
        this.manager = manager;
    }
}
