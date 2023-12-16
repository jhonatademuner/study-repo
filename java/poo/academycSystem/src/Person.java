public abstract class Person {

    protected String name;
    protected String regId;

//    ===========================================================

    public Person(String name, String regId) {
        this.name = name;
        this.regId = regId;
    }

//    ===========================================================

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegId() {
        return this.regId;
    }

    public void setCpf(String regId) {
        this.regId = regId;
    }

//    ===========================================================

    public String toString() {
        return this.getName() + " (CPF: " + this.getRegId() + ")";
    }
}
