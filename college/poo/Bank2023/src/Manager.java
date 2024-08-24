import java.util.Scanner;

public class Manager extends Person {

    private String matriculation;
    private String password;

    Manager(){
        super();
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the matriculation: ");
        this.setMatriculation(s.nextLine());

        System.out.println("Enter the password: ");
        this.setPassword(s.nextLine());
    }

    Manager(String n, Date db, char s, String c, String mat, String pass) {
        super(n, db, s, c);
        this.setMatriculation(mat);
        this.setPassword(pass);
    }

    boolean validateAccess(String pass){
        return pass.equals(this.getPassword());
    }

    boolean validateAccess(){
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the password: ");
        String pass = s.nextLine();
        return this.validateAccess(pass);
    }

    private String getMatriculation() {
        return matriculation;
    }

    private void setMatriculation(String matriculation) {
        this.matriculation = matriculation;
    }

    private String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }
}
