/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Employee Class
class Employee implements Serializable {
    private int employeeID;
    private String name;
    private String department;
    private double salary;
    private String joinDate;

    public Employee(int employeeID, String name, String department, double salary, String joinDate) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.joinDate = joinDate;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return employeeID + "," + name + "," + department + "," + salary + "," + joinDate;
    }
}


class EmployeeManager {
    private static final String FILE_PATH = "employees.txt";
    private List<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
        loadEmployees();
    }


    private void loadEmployees() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                employees.add(new Employee(
                    Integer.parseInt(data[0]), data[1], data[2], Double.parseDouble(data[3]), data[4]
                ));
            }
        } catch (IOException e) {
            System.out.println("Error loading employees: " + e.getMessage());
        }
    }


    private void saveEmployees() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Employee employee : employees) {
                bw.write(employee.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }

 
    public void addEmployee(Employee employee) {
        employees.add(employee);
        saveEmployees();
    }


    public void updateEmployee(int employeeID, Employee updatedEmployee) {
        for (Employee employee : employees) {
            if (employee.getEmployeeID() == employeeID) {
                employee.setName(updatedEmployee.getName());
                employee.setDepartment(updatedEmployee.getDepartment());
                employee.setSalary(updatedEmployee.getSalary());
                employee.setJoinDate(updatedEmployee.getJoinDate());
                saveEmployees();
                return;
            }
        }
        System.out.println("Employee not found.");
    }


    public void deleteEmployee(int employeeID) {
        employees.removeIf(employee -> employee.getEmployeeID() == employeeID);
        saveEmployees();
    }

   
    public double calculateTotalSalaryExpenditure() {
        return employees.stream().mapToDouble(Employee::getSalary).sum();
    }

    public void displayEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);
        
       
        manager.addEmployee(new Employee(1, "John Doe", "IT", 50000, "2023-01-15"));
        manager.addEmployee(new Employee(2, "Jane Smith", "HR", 60000, "2022-11-20"));
        
    
        manager.updateEmployee(1, new Employee(1, "John Doe", "Finance", 55000, "2023-01-15"));
        

        manager.deleteEmployee(2);

        System.out.println("Total Salary Expenditure: " + manager.calculateTotalSalaryExpenditure());

   
        manager.displayEmployees();
    }
}