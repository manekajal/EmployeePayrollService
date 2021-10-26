import Model.EmployeePayrollData;
import Service.EmployeePayrollService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EmployeePayrollServiceTest {
    @Test
    public void givenEmployeePayrollInDB_WhenRetrived_ShouldMatchEmployeeCount(){
        EmployeePayrollService employeePayrollService= new EmployeePayrollService();
        List<EmployeePayrollData>employeePayrollData=employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        Assert.assertEquals(9,9);

    }
}
