public class Person {
    private String id;
    private  String name;

    public Person() {
    }

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public final void hello(){
        System.out.println("Say hello");
    }
    public void info(){
        System.out.println("ID: " + this.id);
        System.out.println("Name: " + this.name);
    }
    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


}
