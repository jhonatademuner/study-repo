public class CheckingAccount extends Account{

    double limit;

    CheckingAccount(Manager m){
        super(m);
        this.limit = 200;
    }

    CheckingAccount(String n, Person o, Date d){
        super(n, o, d);
        this.limit = 200;
        System.out.println("NEW CHECKING ACCOUNT ADDED IN THE SYSTEM");
    }

    double available(){
        return this.balance + this.limit;
    }

    void statement(){
        System.out.println("******* CHECKING ACCOUNT STATEMENT *******");
        super.statement();
    }

    void overdraft(double fees){
        if (this.balance < 0){
            this.balance += (this.balance / 100) * fees;
            System.out.println("The fees was applied.");
        } else {
            System.out.println("The fees was not applied.");
        }
    }
}
