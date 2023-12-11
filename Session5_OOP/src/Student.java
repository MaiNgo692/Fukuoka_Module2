public class Student extends Person{
    private String className;

    public Student(String id, String name) {
        super(id, name);
    }

    public Student(String id, String name, String className) {
        super(id, name);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    @Override
    public void info(){
        super.info();
        System.out.println("Class: " + this.className);
    }

}
