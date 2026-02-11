package restAPI;

public class TimeCard {
    private String TimerCardID;
    private String EmployeeID;
    private String Week;
    private double amount_hours;
    private Employee employee;
    
    public TimeCard(Employee employee) {
        this.employee = employee;
        this.EmployeeID = employee.getEmployeeID();
    }
    
    public String getTimerCardID() {
        return TimerCardID;
    }
    
    public void setTimerCardID(String timerCardID) {
        TimerCardID = timerCardID;
    }
    
    public String getEmployeeID() {
        return EmployeeID;
    }
    
    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }
    
    public String getWeek() {
        return Week;
    }
    
    public void setWeek(String week) {
        Week = week;
    }
    
    public double getAmount_hours() {
        return amount_hours;
    }
    
    public void setAmount_hours(double amount_hours) {
        this.amount_hours = amount_hours;
    }
    
    public Employee getEmployee() {
        return employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
        this.EmployeeID = employee.getEmployeeID();
    }
    
    public int get_weekly_pay() {
        if (employee != null) {
            double weeklyPay = amount_hours * employee.getEmployee_Hourly_Rate();
            return (int) weeklyPay;  // Cast to int as per return type
        }
        return 0;
    }
}