public class SavingsAccount extends Account{

    SavingsAccount(Manager m){
        super(m);
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
        if (this.balance > 0){
            this.balance += (this.balance / 100) * fees;
            System.out.println("The fees was applied.");
        } else {
            System.out.println("The fees was not applied.");
        }
    }
}
