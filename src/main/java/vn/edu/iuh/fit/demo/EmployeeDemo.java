package vn.edu.iuh.fit.demo;

import vn.edu.iuh.fit.dao.EmployeeDAO;
import vn.edu.iuh.fit.models.Employee;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class EmployeeDemo {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO= new EmployeeDAO();
        /*System.out.println(employeeDAO.add(new Employee(1, "43, Dong Hung Thuan 11", LocalDateTime.of(2002, 11, 21, 14, 30),
                "vanbac21112k2@gmail.com", "ThuyTien", "0388495421", 1)));*/
        /*System.out.println(employeeDAO.update(new Employee(1, "43, Dong Hung Thuan 11", LocalDateTime.of(2002, 11, 21, 14, 30),
                "vanbac21112k2@gmail.com", "Hoang Thuy Tien", "0388495421", 1)));*/
        //System.out.println(employeeDAO.detele(1));
        //System.out.println(employeeDAO.get(1));
        employeeDAO.getAll().forEach(e -> System.out.println(e.toString()));
    }
}
