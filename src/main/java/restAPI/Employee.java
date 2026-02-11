package restAPI;

public class Employee {
    private String EmployeeID;
    private String Employee_title;
    private String Employee_Name;
    private String Employee_LastName;
    private double Employee_Hourly_Rate;
    
    public Employee() {
    }
    

    public String getEmployeeID() {
        return EmployeeID;
    }
    
    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }
    
    public String getEmployee_title() {
        return Employee_title;
    }
    
    public void setEmployee_title(String employee_title) {
        Employee_title = employee_title;
    }
    
    public String getEmployee_Name() {
        return Employee_Name;
    }
    
    public void setEmployee_Name(String employee_Name) {
        Employee_Name = employee_Name;
    }
    
    public String getEmployee_LastName() {
        return Employee_LastName;
    }
    
    public void setEmployee_LastName(String employee_LastName) {
        Employee_LastName = employee_LastName;
    }
    
    public double getEmployee_Hourly_Rate() {
        return Employee_Hourly_Rate;
    }
    
    public void setEmployee_Hourly_Rate(double employee_Hourly_Rate) {
        Employee_Hourly_Rate = employee_Hourly_Rate;
    }
    
    public void change_hourly_rate(Employee employee, double newRate) {
        employee.setEmployee_Hourly_Rate(newRate);
    }
}