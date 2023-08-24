public class Bank2023 {
    public static void main(String[] args) {

        Date d1 = new Date(7, 29, 2003);
        d1.print();
        Date d2 = new Date(5, 22, 2008);
        d2.print();

        Person p1 = new Person("Maria", d1, 'F', "123.456.789.-00");
        Person p2 = new Person("Joao", d2, 'M', "234.567.890-00");
        Manager m1 = new Manager("Jose", d1, 'M', "345.678.901-00", "1234", "1234");

        CheckingAccount c1 = new CheckingAccount("1234-5", p1, new Date(24, 8, 2023));
        SavingsAccount c2 = new SavingsAccount("2345-6", p2, new Date(24, 8, 2023));

        System.out.println(m1.validateAccess("1234"));
        System.out.println(m1.validateAccess("12345"));

        System.out.println(d1.later(d2));
        System.out.println(d2.later(d1));

        c2.deposit(1000);

        for (int i = 0; i < 10; i++) {
            c2.incomes(0.5);
            System.out.println(c2.available());
        }
    }
}