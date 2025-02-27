package Week6;

public class Short56_Worker {
    private String id;
    private String name;
    private int age;
    private double salary;
    private String workLocation;

    public Short56_Worker(String id, String name, int age, double salary, String workLocation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocation = workLocation;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    public String getWorkLocation() { return workLocation; }
}
