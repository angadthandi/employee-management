import employee.Employee;
import system.ManageSystem;

public class App {
    public static void main(String[] args) throws Exception {
        Employee manager = new Employee("Achilees");
        Employee e1 = new Employee("Hector");
        Employee e2 = new Employee("Paris");
        Employee e3 = new Employee("Helen");

        ManageSystem ms = new ManageSystem();
        ms.RegisterEmployee(manager);
        ms.RegisterEmployee(e1);
        ms.RegisterEmployee(e2);
        ms.RegisterEmployee(e3);

        ms.RegisterManager(e1.GetID(), manager.GetID());
        ms.RegisterManager(e2.GetID(), manager.GetID());
        ms.RegisterManager(e3.GetID(), manager.GetID());
        ms.PrintDetails(e1.GetID());
        ms.PrintLine("Employee Details - 1");

        ms.PrintDetails("P");
        ms.PrintLine("Employee Details - prefix P");

        ms.PrintDetails("He");
        ms.PrintLine("Employee Details - prefix He");

        for (Employee e: ms.GetSubordinates(manager.GetName())) {
            ms.PrintDetails(e.GetID());
        }
        ms.PrintLine("Manager Subordinates - By Name - Achilees");

        for (Employee e: ms.GetSubordinates(manager.GetID())) {
            ms.PrintDetails(e.GetID());
        }
        ms.PrintLine("Manager Subordinates - By ID - Achilees");

        for (Employee e: ms.GetSubordinates(e1.GetID())) {
            ms.PrintDetails(e.GetID());
        }
        ms.PrintLine("Employee Subordinates - By ID - Hector");
    }
}
