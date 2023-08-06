package bank2019;

public class Person {
    String name, cpf;
    Date dateBirth;
    char sex;

    Person (String n, Date db, char s, String c){
        this.name = n;
        this.dateBirth = db;
        this.sex = s;
        this.cpf = c;
        System.out.println("New person added in the system.");
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
