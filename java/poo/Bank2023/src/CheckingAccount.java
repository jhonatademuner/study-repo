public class CheckingAccount extends Account{

    double limit;

    CheckingAccount(String n, Person o, Date d){
        super(n, o, d);
        this.limit = 200;
        System.out.println("New checking account added in the system.");
    }

    double available(){
        return this.balance + this.limit;
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
