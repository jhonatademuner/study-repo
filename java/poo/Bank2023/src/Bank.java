public class Bank {

    public static void main(String[] args) {

        Manager m = new Manager();

        CheckingAccount c1 = new CheckingAccount(m);
        SavingsAccount s1 = new SavingsAccount(m);

        c1.statement();
        s1.statement();

        c1.withdrawal(200);
        s1.deposit(50);
        s1.transfer(30, c1);

        c1.statement();
        s1.statement();
    }
}