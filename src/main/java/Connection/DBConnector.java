package Connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class DBConnector {
    private static Connection connection;

    public static void main(String[] args) throws SQLException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/employee_payroll?useSSl=false";
        String userName = "root";
        String password = "Kajal@95";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        listDrivers();
        try {
            System.out.println("Connecting to database" + jdbcUrl);
            connection = DriverManager.getConnection(jdbcUrl, userName, password);
            System.out.println("Connection is successfull" + connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    private static void listDrivers() {
        Enumeration<Driver> driverlist = DriverManager.getDrivers();
        while (driverlist.hasMoreElements()) {
            Driver driver = driverlist.nextElement();
            System.out.println(" " + driver.getClass().getName());

        }
    }
}
