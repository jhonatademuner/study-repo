import java.util.Scanner;

public class Person {
    private String name;
    private String cpf;
    private Date dateBirth;
    private char sex;

    Person(){
        System.out.println("******  ENTER THE PERSON INFORMATION ******");

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the name: ");
        this.setName(s.nextLine());

        System.out.println("Enter the CPF: ");
        this.setCpf(s.nextLine());

        System.out.println("Enter the date of birth: ");
        this.setDateBirth(new Date());

        System.out.println("Enter the sex: ");
        this.setSex(s.nextLine().charAt(0));

        System.out.println("*******************************************\n");
    }

    Person (String n, Date db, char s, String c){
        this.setName(n);
        this.setDateBirth(db);
        this.setSex(s);
        this.setCpf(c);
        System.out.println("\n*******************************************");
        System.out.println("NEW PERSON ADDED IN THE SYSTEM");
        System.out.println("*******************************************\n");
    }



    int getAge(Date d){
        if (d.getMonth() > this.getDateBirth().getMonth()){
            return d.getYear() - this.getDateBirth().getYear();
        }
        if (d.getMonth() == this.getDateBirth().getMonth() && d.getDay() >= this.getDateBirth().getDay()){
            return d.getYear() - this.getDateBirth().getYear();
        }
        return d.getYear() - this.getDateBirth().getYear() - 1;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getCpf() {
        return cpf;
    }

    protected void setCpf(String cpf) {
        this.cpf = cpf;
    }

    protected Date getDateBirth() {
        return dateBirth;
    }

    protected void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    protected char getSex() {
        return sex;
    }

    protected void setSex(char sex) {
        this.sex = sex;
    }
}
