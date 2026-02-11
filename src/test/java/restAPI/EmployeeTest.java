package restAPI;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeTest {
    
    private Employee employee;
    
    @BeforeEach
    void setUp() throws Exception {
        employee = new Employee();
    }
    
    @Test
    void testDefaultConstructor() {
        assertNotNull(employee);
    }
    
    @Test
    void testSetAndGetEmployeeID() {
        String expectedID = "EMP001";
        employee.setEmployeeID(expectedID);
        assertEquals(expectedID, employee.getEmployeeID());
    }
    
    @Test
    void testSetAndGetEmployeeTitle() {
        String expectedTitle = "Software Engineer";
        employee.setEmployee_title(expectedTitle);
        assertEquals(expectedTitle, employee.getEmployee_title());
    }
    
    @Test
    void testSetAndGetEmployeeName() {
        String expectedName = "John";
        employee.setEmployee_Name(expectedName);
        assertEquals(expectedName, employee.getEmployee_Name());
    }
    
    @Test
    void testSetAndGetEmployeeLastName() {
        String expectedLastName = "Doe";
        employee.setEmployee_LastName(expectedLastName);
        assertEquals(expectedLastName, employee.getEmployee_LastName());
    }
    
    @Test
    void testSetAndGetEmployeeHourlyRate() {
        double expectedRate = 25.50;
        employee.setEmployee_Hourly_Rate(expectedRate);
        assertEquals(expectedRate, employee.getEmployee_Hourly_Rate(), 0.001);
    }
    
    @Test
    void testChangeHourlyRate() {
        employee.setEmployee_Hourly_Rate(20.00);
        double newRate = 30.00;
        employee.change_hourly_rate(employee, newRate);
        assertEquals(newRate, employee.getEmployee_Hourly_Rate(), 0.001);
    }
    
    @Test
    void testChangeHourlyRateWithDifferentEmployee() {
        Employee anotherEmployee = new Employee();
        anotherEmployee.setEmployee_Hourly_Rate(15.00);
        
        double newRate = 22.50;
        employee.change_hourly_rate(anotherEmployee, newRate);
        
        assertEquals(newRate, anotherEmployee.getEmployee_Hourly_Rate(), 0.001);
    }
    
    @Test
    void testEmployeeWithAllFields() {
        employee.setEmployeeID("EMP123");
        employee.setEmployee_title("Manager");
        employee.setEmployee_Name("Jane");
        employee.setEmployee_LastName("Smith");
        employee.setEmployee_Hourly_Rate(35.75);
        
        assertEquals("EMP123", employee.getEmployeeID());
        assertEquals("Manager", employee.getEmployee_title());
        assertEquals("Jane", employee.getEmployee_Name());
        assertEquals("Smith", employee.getEmployee_LastName());
        assertEquals(35.75, employee.getEmployee_Hourly_Rate(), 0.001);
    }
    
    @Test
    void testHourlyRateWithZero() {
        employee.setEmployee_Hourly_Rate(0.0);
        assertEquals(0.0, employee.getEmployee_Hourly_Rate(), 0.001);
    }
    
    @Test
    void testHourlyRateWithNegativeValue() {
        // This tests current behavior - you might want to add validation later
        employee.setEmployee_Hourly_Rate(-10.00);
        assertEquals(-10.00, employee.getEmployee_Hourly_Rate(), 0.001);
    }
}