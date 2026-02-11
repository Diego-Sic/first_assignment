package restAPI;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TimeCardTest {
    
    private Employee employee;
    private TimeCard timeCard;
    
    @BeforeEach
    void setUp() throws Exception {
        employee = new Employee();
        employee.setEmployeeID("101");
        employee.setEmployee_Name("John");
        employee.setEmployee_LastName("Doe");
        employee.setEmployee_Hourly_Rate(20.0);
        
        timeCard = new TimeCard(employee);
    }
    
    @Test
    void testConstructorWithEmployee() {
        assertNotNull(timeCard);
        assertEquals(employee, timeCard.getEmployee());
        assertEquals("101", timeCard.getEmployeeID());
    }
    
    @Test
    void testSetAndGetTimerCardID() {
        String expectedID = "TC001";
        timeCard.setTimerCardID(expectedID);
        assertEquals(expectedID, timeCard.getTimerCardID());
    }
    
    @Test
    void testSetAndGetEmployeeID() {
        String expectedID = "202";
        timeCard.setEmployeeID(expectedID);
        assertEquals(expectedID, timeCard.getEmployeeID());
    }
    
    @Test
    void testSetAndGetWeek() {
        String expectedWeek = "Week1";
        timeCard.setWeek(expectedWeek);
        assertEquals(expectedWeek, timeCard.getWeek());
    }
    
    @Test
    void testSetAndGetAmountHours() {
        double expectedHours = 40.0;
        timeCard.setAmount_hours(expectedHours);
        assertEquals(expectedHours, timeCard.getAmount_hours(), 0.001);
    }
    
    @Test
    void testGetEmployee() {
        assertEquals(employee, timeCard.getEmployee());
    }
    
    @Test
    void testSetEmployee() {
        Employee newEmployee = new Employee();
        newEmployee.setEmployeeID("303");
        newEmployee.setEmployee_Name("Jane");
        newEmployee.setEmployee_LastName("Smith");
        newEmployee.setEmployee_Hourly_Rate(25.0);
        
        timeCard.setEmployee(newEmployee);
        
        assertEquals(newEmployee, timeCard.getEmployee());
        assertEquals("303", timeCard.getEmployeeID());
    }
    
    @Test
    void testGetWeeklyPayWithValidEmployee() {
        timeCard.setAmount_hours(40.0);
        int weeklyPay = timeCard.get_weekly_pay();
        assertEquals(800, weeklyPay);
    }
    
    @Test
    void testGetWeeklyPayWithZeroHours() {
        timeCard.setAmount_hours(0.0);
        int weeklyPay = timeCard.get_weekly_pay();
        assertEquals(0, weeklyPay);
    }
    
    @Test
    void testGetWeeklyPayWithDecimalHours() {
        timeCard.setAmount_hours(37.5);
        int weeklyPay = timeCard.get_weekly_pay();
        assertEquals(750, weeklyPay);
    }
    
    @Test
    void testGetWeeklyPayWithOvertimeHours() {
        timeCard.setAmount_hours(50.0);
        int weeklyPay = timeCard.get_weekly_pay();
        assertEquals(1000, weeklyPay);
    }
    
    
    @Test
    void testGetWeeklyPayCastingToInt() {
        employee.setEmployee_Hourly_Rate(20.99);
        timeCard.setAmount_hours(10.0);
        
        int weeklyPay = timeCard.get_weekly_pay();
        assertEquals(209, weeklyPay);
    }
    
    @Test
    void testGetWeeklyPayWithHighRate() {
        employee.setEmployee_Hourly_Rate(100.0);
        timeCard.setAmount_hours(40.0);
        
        int weeklyPay = timeCard.get_weekly_pay();
        assertEquals(4000, weeklyPay);
    }
    
    @Test
    void testTimeCardWithAllFields() {
        timeCard.setTimerCardID("TC123");
        timeCard.setWeek("Week5");
        timeCard.setAmount_hours(42.5);
        
        assertEquals("TC123", timeCard.getTimerCardID());
        assertEquals("Week5", timeCard.getWeek());
        assertEquals(42.5, timeCard.getAmount_hours(), 0.001);
        assertEquals("101", timeCard.getEmployeeID());
    }
    
    @Test
    void testEmployeeIDSyncWhenSettingEmployee() {
        Employee newEmployee = new Employee();
        newEmployee.setEmployeeID("999");
        
        timeCard.setEmployee(newEmployee);
        
        assertEquals("999", timeCard.getEmployeeID());
        assertEquals(newEmployee.getEmployeeID(), timeCard.getEmployeeID());
    }
    
    @Test
    void testGetWeeklyPayWithPartTimeHours() {
        timeCard.setAmount_hours(15.5);
        int weeklyPay = timeCard.get_weekly_pay();
        assertEquals(310, weeklyPay);
    }
}