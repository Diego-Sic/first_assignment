package restAPI;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class PayrollTest {
    
    private Payroll payroll;
    private Employee employee1;
    private Employee employee2;
    private TimeCard timeCard1;
    private TimeCard timeCard2;
    
    @BeforeEach
    void setUp() throws Exception {
        payroll = new Payroll();
        
        employee1 = new Employee();
        employee1.setEmployeeID("101");
        employee1.setEmployee_Name("John");
        employee1.setEmployee_LastName("Doe");
        employee1.setEmployee_Hourly_Rate(20.0);
        
        timeCard1 = new TimeCard(employee1);
        timeCard1.setTimerCardID("TC001");
        timeCard1.setWeek("Week1");
        timeCard1.setAmount_hours(40.0);
        
        employee2 = new Employee();
        employee2.setEmployeeID("102");
        employee2.setEmployee_Name("Jane");
        employee2.setEmployee_LastName("Smith");
        employee2.setEmployee_Hourly_Rate(25.0);
        
        timeCard2 = new TimeCard(employee2);
        timeCard2.setTimerCardID("TC002");
        timeCard2.setWeek("Week1");
        timeCard2.setAmount_hours(35.0);
    }
    
    @Test
    void testDefaultConstructor() {
        assertNotNull(payroll);
        assertNotNull(payroll.getTimeCardID());
        assertTrue(payroll.getTimeCardID().isEmpty());
    }
    
    @Test
    void testAddTimeCard() {
        payroll.addTimeCard(timeCard1);
        assertEquals(1, payroll.getTimeCardID().size());
        assertEquals(timeCard1, payroll.getTimeCardID().get(0));
    }
    
    @Test
    void testAddMultipleTimeCards() {
        payroll.addTimeCard(timeCard1);
        payroll.addTimeCard(timeCard2);
        
        assertEquals(2, payroll.getTimeCardID().size());
        assertEquals(timeCard1, payroll.getTimeCardID().get(0));
        assertEquals(timeCard2, payroll.getTimeCardID().get(1));
    }
    
    @Test
    void testGetPayrollWithSingleEmployee() {
        payroll.addTimeCard(timeCard1);
        List<int[]> payrollList = payroll.get_payroll();
        
        assertEquals(1, payrollList.size());
        assertEquals(101, payrollList.get(0)[0]);
        assertEquals(800, payrollList.get(0)[1]);
    }
    
    @Test
    void testGetPayrollWithMultipleEmployees() {
        payroll.addTimeCard(timeCard1);
        payroll.addTimeCard(timeCard2);
        
        List<int[]> payrollList = payroll.get_payroll();
        
        assertEquals(2, payrollList.size());
        
        assertEquals(101, payrollList.get(0)[0]);
        assertEquals(800, payrollList.get(0)[1]);
        
        assertEquals(102, payrollList.get(1)[0]);
        assertEquals(875, payrollList.get(1)[1]);
    }
    
    @Test
    void testGetPayrollWithEmptyList() {
        List<int[]> payrollList = payroll.get_payroll();
        
        assertNotNull(payrollList);
        assertTrue(payrollList.isEmpty());
    }
    
    @Test
    void testGetPayrollWithZeroHours() {
        timeCard1.setAmount_hours(0.0);
        payroll.addTimeCard(timeCard1);
        
        List<int[]> payrollList = payroll.get_payroll();
        
        assertEquals(1, payrollList.size());
        assertEquals(101, payrollList.get(0)[0]);
        assertEquals(0, payrollList.get(0)[1]);
    }
    
    @Test
    void testGetPayrollWithDecimalHours() {
        timeCard1.setAmount_hours(37.5);
        payroll.addTimeCard(timeCard1);
        
        List<int[]> payrollList = payroll.get_payroll();
        
        assertEquals(1, payrollList.size());
        assertEquals(101, payrollList.get(0)[0]);
        assertEquals(750, payrollList.get(0)[1]);
    }
    
    @Test
    void testGetPayrollWithOvertimeHours() {
        timeCard1.setAmount_hours(50.0);
        payroll.addTimeCard(timeCard1);
        
        List<int[]> payrollList = payroll.get_payroll();
        
        assertEquals(1, payrollList.size());
        assertEquals(101, payrollList.get(0)[0]);
        assertEquals(1000, payrollList.get(0)[1]);
    }
    
    @Test
    void testSetAndGetTimeCardID() {
        List<TimeCard> timeCardList = List.of(timeCard1, timeCard2);
        payroll.setTimeCardID(timeCardList);
        
        assertEquals(2, payroll.getTimeCardID().size());
        assertEquals(timeCard1, payroll.getTimeCardID().get(0));
        assertEquals(timeCard2, payroll.getTimeCardID().get(1));
    }
    
    @Test
    void testGetPayrollCastingToInt() {
        employee1.setEmployee_Hourly_Rate(20.99);
        timeCard1.setAmount_hours(10.0);
        payroll.addTimeCard(timeCard1);
        
        List<int[]> payrollList = payroll.get_payroll();
        
        assertEquals(209, payrollList.get(0)[1]);
    }
    
    @Test
    void testGetPayrollWithSameEmployeeMultipleTimes() {
        TimeCard timeCard1Week1 = new TimeCard(employee1);
        timeCard1Week1.setWeek("Week1");
        timeCard1Week1.setAmount_hours(40.0);
        
        TimeCard timeCard1Week2 = new TimeCard(employee1);
        timeCard1Week2.setWeek("Week2");
        timeCard1Week2.setAmount_hours(35.0);
        
        payroll.addTimeCard(timeCard1Week1);
        payroll.addTimeCard(timeCard1Week2);
        
        List<int[]> payrollList = payroll.get_payroll();
        
        assertEquals(2, payrollList.size());
        assertEquals(101, payrollList.get(0)[0]);
        assertEquals(800, payrollList.get(0)[1]);
        assertEquals(101, payrollList.get(1)[0]);
        assertEquals(700, payrollList.get(1)[1]);
    }
}