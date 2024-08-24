import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    public static int initialMenu(){
        Scanner s = new Scanner(System.in);

        System.out.println("\n*******************************************");
        System.out.println("                MAIN MENU");
        System.out.println("*******************************************");
        System.out.println("1 - Register");
        System.out.println("2 - Movimentation");
        System.out.println("0 - Exit");
        System.out.println("*******************************************");
        System.out.println("Enter the option: ");

        return s.nextInt();
    }

    public static void registerMenu(ArrayList<Person> people, ArrayList<Manager> managers, ArrayList<Account> accounts){
        Scanner s = new Scanner(System.in);

        System.out.println("\n*******************************************");
        System.out.println("                REGISTER MENU");
        System.out.println("*******************************************");
        System.out.println("1 - Register a person");
        System.out.println("2 - Register a manager");
        System.out.println("3 - Register an checking account");
        System.out.println("4 - Register an savings account");
        System.out.println("*******************************************");
        System.out.println("Enter the option: ");

        int op = s.nextInt();
        if (op == 1){
            people.add(new Person());
        } else if (op == 2){
            managers.add(new Manager());
        } else if (op == 3){
            Person owner = pickPerson(people);
            Manager manager = pickManager(managers);
            accounts.add(new CheckingAccount(owner, manager));
        } else if(op == 4){
            Person owner = pickPerson(people);
            Manager manager = pickManager(managers);
            accounts.add(new SavingsAccount(owner, manager));
        }
    }

    public static Person pickPerson(ArrayList<Person> people){
        Scanner s = new Scanner(System.in);

        System.out.println("\n*******************************************");
        System.out.println("                PICK A PERSON");
        System.out.println("*******************************************");

        int i = 1;
        for (Person p : people){
            System.out.println(i + ") " + p.getName() + " (CPF: " + p.getCpf() + ")");
            i++;
        }

        System.out.println("*******************************************");
        System.out.println("Enter the option: ");
        int index = s.nextInt();
        return people.get(index - 1);
    }

    public static Manager pickManager(ArrayList<Manager> managers){
        Scanner s = new Scanner(System.in);

        System.out.println("\n*******************************************");
        System.out.println("                PICK A MANAGER");
        System.out.println("*******************************************");

        int i = 1;
        for (Manager m : managers){
            System.out.println(i + ") " + m.getName() + " (CPF: " + m.getCpf() + ")");
            i++;
        }

        System.out.println("*******************************************");
        System.out.println("Enter the option: ");
        int index = s.nextInt();
        return managers.get(index - 1);
    }

    public static Account pickAccount(ArrayList<Account> accounts){
        Scanner s = new Scanner(System.in);

        System.out.println("\n*******************************************");
        System.out.println("                PICK AN ACCOUNT");
        System.out.println("*******************************************");

        int i = 1;
        for (Account a : accounts){
            System.out.println(i + ") " + a.getNum() + " (Owner: " + a.getOwner().getName() + ")");
            i++;
        }

        System.out.println("*******************************************");
        System.out.println("Enter the option: ");
        int index = s.nextInt();
        return accounts.get(index - 1);
    }

    public static void movimentationMenu(ArrayList<Person> person, ArrayList<Manager> managers, ArrayList<Account> accounts){
        Scanner s = new Scanner(System.in);

        Account account = pickAccount(accounts);

        System.out.println("\n*******************************************");
        System.out.println("                MOVIMENTATION MENU");
        System.out.println("*******************************************");
        System.out.println("1 - Statement");
        System.out.println("2 - Withdraw");
        System.out.println("3 - Deposit");
        System.out.println("4 - Transfer");
        System.out.println("*******************************************");
        System.out.println("Enter the option: ");

        int op = s.nextInt();
        if (op == 1){
            account.statement();
        } else if (op == 2){
            account.withdrawal();
        } else if (op == 3){
            account.deposit();
        } else if (op == 4){
            System.out.println("Pick the destiny account: ");
            Account destiny = pickAccount(accounts);
            System.out.println("Enter the value: ");
            account.transfer(destiny);
        }
    }

    public static void main(String[] args) {

        ArrayList<Person> people = new ArrayList<>();
        ArrayList<Manager> managers = new ArrayList<>();
        ArrayList<Account> accounts = new ArrayList<>();

        int op = initialMenu();
        while (op != 0){
            if (op == 1){
                registerMenu(people, managers, accounts);
            } else if (op == 2) {
                movimentationMenu(people, managers, accounts);
            }

            op = initialMenu();
        }

        System.out.println("\nBye bye! See you later!");

    }
}