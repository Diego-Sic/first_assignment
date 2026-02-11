package restAPI;

import java.util.ArrayList;
import java.util.List;

public class Payroll {
    private List<TimeCard> TimeCardID;
    
  
    public Payroll() {
        this.TimeCardID = new ArrayList<>();
    }
    

    public List<TimeCard> getTimeCardID() {
        return TimeCardID;
    }
    
    public void setTimeCardID(List<TimeCard> timeCardID) {
        TimeCardID = timeCardID;
    }
    

    public void addTimeCard(TimeCard timeCard) {
        this.TimeCardID.add(timeCard);
    }
    

    public List<int[]> get_payroll() {
        List<int[]> payrollList = new ArrayList<>();

        for (TimeCard timeCard : TimeCardID) {
            int[] payrollEntry = new int[2];
            

            payrollEntry[0] = Integer.parseInt(timeCard.getEmployeeID());
            
 
            payrollEntry[1] = timeCard.get_weekly_pay();
            
            payrollList.add(payrollEntry);
        }
        
        return payrollList;
    }
}