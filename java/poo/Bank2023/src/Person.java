import java.util.Scanner;

public class Person {
    String name, cpf;
    Date dateBirth;
    char sex;

    Person(){
        System.out.println("******  ENTER THE PERSON INFORMATION ******");

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the name: ");
        this.name = s.nextLine();

        System.out.println("Enther the CPF: ");
        this.cpf = s.nextLine();

        System.out.println("Enter the date of birth: ");
        this.dateBirth = new Date();

        System.out.println("Enter the sex: ");
        this.sex = s.nextLine().charAt(0);

        System.out.println("*******************************************\n");
    }

    Person (String n, Date db, char s, String c){
        this.name = n;
        this.dateBirth = db;
        this.sex = s;
        this.cpf = c;
        System.out.println("\n*******************************************");
        System.out.println("NEW PERSON ADDED IN THE SYSTEM");
        System.out.println("*******************************************\n");
    }



    int getAge(Date d){
        if (d.month > this.dateBirth.month){
            return d.year - this.dateBirth.year;
        }
        if (d.month == this.dateBirth.month && d.day >= this.dateBirth.day){
            return d.year - this.dateBirth.year;
        }
        return d.year - this.dateBirth.year - 1;
    }
}
