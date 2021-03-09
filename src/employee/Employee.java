package employee;

import java.util.ArrayList;

public class Employee {
    private int id;
    private int managerID;
    private String name;
    private ArrayList<Employee> subordinates;

    private static int idIncrementor = 0;

    public Employee (String name) {
        idIncrementor++;

        this.id = idIncrementor;
        this.managerID = 0;
        this.name = name;
        this.subordinates = new ArrayList<Employee>();
    }

    public int GetID() {
        return this.id;
    }

    public int GetManagerID() {
        return this.managerID;
    }

    public void SetManagerID(int managerID) {
        this.managerID = managerID;
    }

    public String GetName() {
        return this.name;
    }

    public ArrayList<Employee> GetSubordinates() {
        return this.subordinates;
    }

    public boolean AddSubordinate(Employee e) {
        return this.subordinates.add(e);
    }

}
