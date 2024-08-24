import java.util.ArrayList;

public class Professor extends Person implements Comparable<Professor>{

    private double salary;

//    ===========================================================

    public Professor(String name, String regId, double salary) {
        super(name, regId);
        this.salary = salary;
    }

//    ===========================================================

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

//    ===========================================================

    public static ArrayList<Professor> convertCsvToArrayList(String csvContent){
        ArrayList<Professor> professorsList = new ArrayList<>();

        String[] lines = csvContent.split("\n");

        for (String line : lines) {
            String[] values = line.split(",");
            try {
                Professor p = new Professor(values[0], values[1], Double.parseDouble(values[2]));
                professorsList.add(p);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println(e.getLocalizedMessage());
            }
        }

        return professorsList;
    }

    @Override
    public int compareTo(Professor p) {
        if (!this.getName().equals(p.getName())) return this.name.compareTo(p.getName());
        return this.regId.compareTo(p.getRegId());
    }
}
