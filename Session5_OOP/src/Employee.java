public class Employee extends Person{
    private double salary;

    public Employee(String id, String name) {
        super(id, name);
    }

    public Employee(String id, String name, double salary) {
        super(id, name);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
