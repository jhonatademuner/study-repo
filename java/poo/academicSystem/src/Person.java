public class Person {

    protected String name;
    protected String regId;

//    ===========================================================

    public Person(String name, String regId) {
        this.name = name;
        this.regId = regId;
    }

//    ===========================================================

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getCpf() {
        return regId;
    }

    protected void setCpf(String regId) {
        this.regId = regId;
    }

//    ===========================================================

    public String toString() {
        return this.getName() + " (CPF: " + this.getCpf() + ")";
    }

}
