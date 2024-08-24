public class CheckingAccount extends Account{

    private double limit;

    CheckingAccount(Person owner, Manager m){
        super(owner, m);
        this.setLimit(200);
    }

    CheckingAccount(String n, Person o, Date d){
        super(n, o, d);
        this.setLimit(200);
        System.out.println("NEW CHECKING ACCOUNT ADDED IN THE SYSTEM");
    }

    protected double available(){
        return this.getBalance() + this.getLimit();
    }

    void statement(){
        System.out.println("******* CHECKING ACCOUNT STATEMENT *******");
        super.statement();
    }

    void overdraft(double fees){
        if (this.getBalance() < 0){
            this.setBalance(this.getBalance() + (this.getBalance() / 100) * fees);
            System.out.println("The fees was applied.");
        } else {
            System.out.println("The fees was not applied.");
        }
    }

    private double getLimit() {
        return limit;
    }

    private void setLimit(double l) {
        this.limit = l;
    }
}
