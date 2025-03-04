package Week6;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Short56_SalaryHistory {
    private String workerId;
    private int salary;
    private String action;
    private String date;

    public Short56_SalaryHistory(String workerId, int salary, String action) {
        this.workerId = workerId;
        this.salary = salary;
        this.action = action;
        this.date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }

    public String getWorkerId() {
        return workerId;
    }

    public int getSalary() {
        return salary;
    }

    public String getAction() {
        return action;
    }

    public String getDate() {
        return date;
    }
    
    

    @Override
    public String toString() {
        return String.format("%-5s %-10d  %-6s %s", workerId, salary, action, date);
    }
}
