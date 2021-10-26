package Service;

import Model.EmployeePayrollData;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollDBService {
    Connection connection = null;
    Statement statement = null;
    Scanner scanner=new Scanner(System.in);

    public void createTable() {
        try {
            connection = this.getConnection();
            statement = connection.createStatement();
            String query = "create table employee_payroll(id int not null AUTO_INCREMENT,"
                    + "name varchar(50)not null,"
                    + "salary double not null,"
                    + "start date not null,"
                    + "primary key(id)"
                    + ");";
            statement.executeUpdate(query);
            System.out.println("Table created");
            connection.close();
        } catch (Exception e) {
            System.out.println("Table already exists");
        }
    }



    public List<EmployeePayrollData> readData() {
        String query = "select * from employee_payroll;";
        List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        try {
            connection = this.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
            //    int id=resultSet.getInt("id");
             //  String name=resultSet.getString("name");
             //  double salary=resultSet.getDouble("salary");
            //   LocalDate startDate=resultSet.getDate("start").toLocalDate();

                 //  employeePayrollList.add(new EmployeePayrollData(id,name,salary,startDate));
               int x = resultSet.getInt("id");
                //to fetch value from a column having varchar/text type of value
                String y = resultSet.getString("name");
                //to fetch value from a column having number type of value
               int z = resultSet.getInt("salary");
               LocalDate startDate=resultSet.getDate("start").toLocalDate();
               System.out.println(x + "   " + y + " " + z+ "  " +startDate);


            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeePayrollList;
    }


    private Connection getConnection() throws SQLException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/payroll_service?useSSl=false";
        String userName = "root";
        String password = "Kajal@95";

        Connection connection;
        System.out.println(" Connecting to database"+jdbcUrl);
        connection= DriverManager.getConnection(jdbcUrl,userName,password);
        System.out.println(" Connection is sucessful"+connection);
        return connection;

    }


}
