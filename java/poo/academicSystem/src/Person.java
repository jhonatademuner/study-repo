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
        return this.name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getRegId() {
        return this.regId;
    }

    protected void setCpf(String regId) {
        this.regId = regId;
    }

//    ===========================================================

    public String toString() {
        return this.getName() + " (CPF: " + this.getRegId() + ")";
    }

}
