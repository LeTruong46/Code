package Week6;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Short56_SalaryHistory {
    private String id;
    private String name;
    private int age;
    private double salary;
    private String status;
    private String date;

    public Short56_SalaryHistory(String id, String name, int age, double salary, String status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
        this.date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }

    @Override
    public String toString() {
        return String.format("%-5s %-10s %-3d %-10.2f %-6s %s", id, name, age, salary, status, date);
    }
}
