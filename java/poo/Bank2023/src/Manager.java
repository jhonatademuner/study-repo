import java.util.Scanner;

public class Manager extends Person {

    String matriculation, password;

    Manager(){
        super();
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the matriculation: ");
        this.matriculation = s.nextLine();

        System.out.println("Enter the password: ");
        this.password = s.nextLine();
    }

    Manager(String n, Date db, char s, String c, String mat, String pass) {
        super(n, db, s, c);
        this.matriculation = mat;
        this.password = pass;
    }

    boolean validateAccess(String pass){
        return pass.equals(this.password);
    }

    boolean validateAccess(){
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the password: ");
        String pass = s.nextLine();
        return this.validateAccess(pass);
    }

}
