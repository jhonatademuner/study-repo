public class SavingsAccount extends Account{

    SavingsAccount(String n, Person o, Date d){
        super(n, o, d);
        System.out.println("New savings account added in the system.");
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
