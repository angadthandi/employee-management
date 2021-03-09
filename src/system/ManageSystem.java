package system;

import java.util.ArrayList;
import java.util.HashMap;

import employee.Employee;

public class ManageSystem {
    private ArrayList<Employee> employees;
    private HashMap<Integer, Employee> employeeMap;

    public ManageSystem () {
        this.employees = new ArrayList<Employee>();
        this.employeeMap = new HashMap<Integer, Employee>();
    }

    public void RegisterEmployee(Employee e) {
        this.employees.add(e);
        this.employeeMap.put(e.GetID(), e);
    }

    public void RegisterManager(int employeeID, int managerID) {
        if (!this.employeeMap.containsKey(employeeID) ||
            !this.employeeMap.containsKey(managerID)) {
                System.out.println(
                    "invalid employeeID or managerID"
                );
                return;
        }

        Employee e = this.employeeMap.get(employeeID);
        e.SetManagerID(managerID);

        Employee m = this.employeeMap.get(managerID);
        m.AddSubordinate(e);
    }

    public void PrintDetails(int employeeID) {
        if (!this.employeeMap.containsKey(employeeID)) {
            System.out.println(
                "invalid employeeID"
            );
            return;
        }

        Employee e = this.employeeMap.get(employeeID);

        System.out.printf(
            "ID: %d\n", e.GetID()
        );
        System.out.printf(
            "Name: %s\n", e.GetName()
        );
        System.out.printf(
            "Manager Name: %s\n",
            this.employeeMap.get(e.GetManagerID()).GetName()
        );
    }

    public void PrintDetails(String prefix) {
        for (Employee employee : this.employees) {
            if (
                employee.GetName().startsWith(prefix)
            ) {
                this.PrintDetails(employee.GetID());
            }
        }
    }

    public ArrayList<Employee> GetSubordinates(int managerID) {
        if (!this.employeeMap.containsKey(managerID)) {
            System.out.println(
                "invalid managerID"
            );
            return new ArrayList<Employee>();
        }

        return this.employeeMap.get(managerID).GetSubordinates();
    }

    public ArrayList<Employee> GetSubordinates(String prefix) {
        for (Employee employee : this.employees) {
            if (
                employee.GetName().startsWith(prefix)
            ) {
                return this.employeeMap.get(
                    employee.GetID()
                ).GetSubordinates();
            }
        }

        return new ArrayList<Employee>();
    }

    public void PrintLine(String oper) {
        int n = 40;
        String s = "";
        for (int i=0; i<n; i++) {
            if (i==n/2) {
                s += oper;
            } else {
                s += "-";
            }
        }
        System.out.println(s);
    }

}
