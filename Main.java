import java.sql.*;

class ManagementSystem{
    
    public static Connection getConnection(){
        Connection con = null;
       try{
        String url="";
        String user="";
        String pass="";
        
        Connection con = DriveManager.getConnection(url,user,pass);
        
       } 
       catch( SQLException e)
       {
           System.out.println("error");
           
       }
       return con;
    }
    
    public void addEmp( String name, String designation, double salary, String department ){
        String insertQuery = "INSERT INTO Employee (employeeName, designation, salary, department) VALUES (?, ?, ?, ?)";
        try(Connection con= getConnection(); PrepareStatemnt ps = con.prepareStatemnt(insertQuery)) {
            ps.setString(1, name);
            ps.setString(2, designation);
            ps.setDouble(3, salary);
            ps.setString(4, department);
            ps.executeUpdate();
        } catch(SQLException e) {  System.out.println("error");}
        
    }
    
    public void viewEmp(){
          String query = "SELECT * FROM Employee";
          try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)){
              ResultSet rs = ps.executeQuery());
              while(rs.next()){
                  System.out.println("ID: " + rs.getInt("employeeID") +
                                   ", Name: " + rs.getString("employeeName") +
                                   ", Designation: " + rs.getString("designation") +
                                   ", Salary: " + rs.getDouble("salary") +
                                   ", Department: " + rs.getString("department"));
              }
          }
          
          catch (SQLException e) {
            e.printStackTrace();
        }
             
    }
    
    public void updateEmp( int id, String name, String designation, double salary, String department ){
        String updateQuery =  "UPDATE Employee SET employeeName = ?, designation = ?, salary = ?, department = ? WHERE employeeID = ?";
        try(Connection con=getConnection(); PrepareStatement ps = con.prepareStatement(updateQuery)){
            ps.setString(1, name);
            ps.setString(2, designation);
            ps.setDouble(3, salary);
            ps.setString(4, department);
            ps.setInt(5, id);
            ps.executeUpdate();
            System.out.println("Employee updated successfully.");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public void deletEmp( int id ){
         String query = "DELETE FROM Employee WHERE employeeID = ?";
         
         try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            
            ps.setInt(1, id);
           
            ps.executeUpdate();
           
            System.out.println("Employee deleted successfully.");
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args){
         EmployeeManagementSystem ems = new EmployeeManagementSystem();

        ems.addEmployee("Alice", "Developer", 50000, "IT");

        System.out.println("\nEmployee List:");
        ems.viewAllEmployees();

        ems.updateEmployee(1, "Alice Johnson", "Senior Developer", 60000, "IT");

        ems.deleteEmployee(1);


        System.out.println("\nEmployee List after deletion:");
        ems.viewAllEmployees();
    }
}
