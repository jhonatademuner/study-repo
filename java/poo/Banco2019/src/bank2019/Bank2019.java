package bank2019;

public class Bank2019 {
    public static void main(String[] args) {

        Date d1 = new Date(7, 29, 2003);
        d1.print();
        Date d2 = new Date(5, 22, 2008);
        d2.print();


        Person p1 = new Person("Maria", d1, 'F', "123.456.789.-00");
        Person p2 = new Person("Joao", d2, 'M', "234.567.890-00");


        Account c1 = new Account("1234-5", p1);
        Account c2 = new Account("2345-6", p2);



        c1.statement();
        c2.statement();

        c1.withdrawal(150);
        c1.transfer(100, c2);
        c1.withdrawal(100);
        c1.deposit(100);
        c1.transfer(200, c2);

//        for (int i = 1; i <= 120; i++){
//            c1.overdraft(0.5);
//            System.out.println("Balance after " + i + " days: " + c1.balance);
//        }


    }
}