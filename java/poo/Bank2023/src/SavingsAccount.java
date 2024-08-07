public class SavingsAccount extends Account{

    SavingsAccount(Person owner, Manager m){
        super(owner, m);
    }

    SavingsAccount(String n, Person o, Date d){
        super(n, o, d);
        System.out.println("NEW SAVINGS ACCOUNT ADDED IN THE SYSTEM");
    }

    void statement(){
        System.out.println("******* SAVINGS ACCOUNT STATEMENT ********");
        super.statement();
    }

    void incomes(double fees){
        if (this.getBalance() > 0){
            this.setBalance(this.getBalance() + (this.getBalance() / 100) * fees);
            System.out.println("The fees was applied.");
        } else {
            System.out.println("The fees was not applied.");
        }
    }
}
