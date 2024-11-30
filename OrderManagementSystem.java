/******************************************************************************
Problem 2: Order Management System using ArrayList
Objective: Create a system to track customer orders in a shopping system, where each order has an order ID, customer name, and list of products.

Problem Statement: Implement an Order class with the following attributes:

orderID (String)
customerName (String)
products (ArrayList<String>)
Use an ArrayList<Order> to store and manage customer orders. The program should allow the following operations:

Add a new order.
Remove an order based on the order ID.
Add or remove products from a specific order.
Display all orders placed by a particular customer.


*******************************************************************************/
import java.util.Scanner;
import java.util.ArrayList;

class Order{
    Scanner sc= new Scanner(System.in);
    private String orderId;
    private String customerName;
    
    public Order( String orderId, String customerName){
        this.orderId=orderId;
        this.customerName=customerName;
       
    }
    //------------------------------------------------------------
    public String getOrderId(){
        return orderId;
    }
    //-------------------------------------------------------------
    public String getCustomerName(){
        return customerName;
    }
    //------------------------------------------------------------
    
    
    public void displayDetais(){
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer Name: " + customerName);
        
    }
    
    
}

//----------------------------------------------------------------------------

class OrderManagementSystem{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
       
        
        int choice;
        do{
            System.out.println("1. Add Order");
            System.out.println("2. Remove Order");
            System.out.println("3. Add Product to Order");
            System.out.println("4. Remove Product from Order");
            System.out.println("5. Display Orders by Customer");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            
            switch(choice){
                case 1 :
                    Order o = new Order("","");
                    
                    break;
                case 2 :
                    break;
                case 3 :
                    break;
                case 4 :
                    break;
                case 5 :
                    break;
                case 6 :
                    break;
            }
        } 
        
        while( choice < 5);
        
    }
}
