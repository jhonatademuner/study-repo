public class Manager extends Person {

    String matriculation, password;

    Manager(String n, Date db, char s, String c, String mat, String pass) {
        super(n, db, s, c);
        this.matriculation = mat;
        this.password = pass;
    }

    boolean validateAccess(String pass){
        return pass.equals(this.password);

    }

}
