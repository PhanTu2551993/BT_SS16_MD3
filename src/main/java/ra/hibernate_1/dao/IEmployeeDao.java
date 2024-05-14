package ra.hibernate_1.dao;

import ra.hibernate_1.entity.Employee;

import java.util.List;

public interface IEmployeeDao {
    List<Employee> getEmployee();
    public Employee getEmployeeById(Integer empId);
    public boolean insertEmployee(Employee emp);
    public boolean updateEmployee(Employee emp);
    public boolean deleteEmployee(Integer empId);
    public List<Employee> getEmployeeByName(String name);
}
