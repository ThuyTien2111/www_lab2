package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.dao.EmployeeDAO;
import vn.edu.iuh.fit.models.Employee;

import java.util.List;

public class EmployeeService {
    private EmployeeDAO employeeDAO;

    public EmployeeService() {
        employeeDAO=new EmployeeDAO();
    }
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAll();
    }

    public Employee getEmployeeById(long id) {
        return employeeDAO.get(id);
    }

    public boolean addEmployee(Employee employee) {
        if((employee.getStatus()!=0)&&(employee.getStatus()!=1)&&(employee.getStatus()!=2)) return false;
        return employeeDAO.add(employee);
    }

    public boolean updateEmployee(Employee employee) {
        if((employee.getStatus()!=0)&&(employee.getStatus()!=1)&&(employee.getStatus()!=2)) return false;
        return employeeDAO.update(employee);
    }

    public boolean deleteEmployee(long id) {
        return employeeDAO.detele(id);
    }

    public boolean activateEmployee(long id) {
        return employeeDAO.activeEmp(id);
    }



}
