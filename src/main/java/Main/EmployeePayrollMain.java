package Main;

import Service.EmployeePayrollDBService;
import Service.EmployeePayrollService;

import java.text.ParseException;

public class EmployeePayrollMain {
    public static void main(String[] args) throws ParseException {
        EmployeePayrollDBService employeePayrollDBService=new EmployeePayrollDBService();
        employeePayrollDBService.createTable();

        employeePayrollDBService.readData();
    }
}
