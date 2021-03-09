package system;

import java.util.ArrayList;
import java.util.HashMap;

import employee.Employee;

public class System {
    private ArrayList<Employee> employees;
    private HashMap<Integer, Employee> employeeMap;

    public System () {
        this.employees = new ArrayList<Employee>();
        this.employeeMap = new HashMap<Integer, Employee>();
    }

    public void RegisterEmployee(Employee e) {
        this.employees.add(e);
        this.employeeMap.put(e.GetID(), e);
    }

    public void RegisterManager(int employeeID, int managerID) {
        Employee e = this.employeeMap.get(employeeID);
        e.SetManagerID(managerID);
    }

}
