/*Problem 3: Product Inventory Management using HashMap
Objective: Build a system to manage product inventory in a warehouse, where each product has an ID, name, and stock quantity.

Problem Statement: Create a Product class with the following attributes:

productID (String)
productName (String)
quantity (int)
Use a HashMap<String, Product> to store the product inventory, 
where the key is the productID and the value is the Product object. 
The program should allow the following operations:

Add new products to the inventory.
Update the quantity of a product based on its product ID.
Remove a product from the inventory.
Display the stock levels for all products.*/

import java.util.HashMap;
import java.util.Scanner;

class products{
    private String productId;
    private String productName;
    private int quantity;
    
    public products( String productId, String productName, int quantity){
        this.productId=productId;
        this.productName=productName;
        this.quantity=quantity;
    }
    
     public String getProductID() {
        return productId;
    }

   
    public String getProductName() {
        return productName;
    }

    
    public int getQuantity() {
        return quantity;
    }
    
    public void displayProduct() {
        System.out.println("Product ID: " + productId + ", Product Name: " + productName + ", Quantity: " + quantity);
    }
    
    
    
}


class InventoryManagementSystem{
    private HashMap<String, products> inverntory;
    private Scanner sc;
    
    public InventoryManagementSystem(){
        this.inverntory=new HashMap<>();
        this.sc=new Scanner(System.in);
    }
    
    public void addProduct(){
        System.out.println("Enter the product ID");
        String productId=sc.nextLine();
        System.out.println("Enter the product Name");
        String productName=sc.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();
        
        products p = new products(productId,productName, quantity);
        
       inverntory.put(productId, p);
       System.out.println("Product added successfully!");
        
    }
    
    public void removeProduct(){
        System.out.println("Enter the key to remove the product for inverntory");
        String productId = sc.nextLine();
        if (inverntory.containsKey(productId)) {
            inverntory.remove(productId);
            System.out.println("remove the elements from the inverntory");
        }
        else {
            System.out.println("element is not present");
        }
    }
    
    public void updateProductQuantity() {
        System.out.print("Enter Product ID: ");
        String productId1 = sc.nextLine();
        
        if (inverntory.containsKey(productId1)) {
        products p = inverntory.get(productId1);
        System.out.print("Enter new Quantity: ");
        int newQuantity = sc.nextInt();  // Get the new quantity from the user
        sc.nextLine();  // Consume newline
        p.setQuantity(newQuantity);  // Update the quantity
        System.out.println("Quantity updated successfully!");
        }
        else 
        {
        System.out.println("Product not found!");
        }
    }

    
    public void displayDetails(){
        if (inverntory.isEmpty()){
            System.out.println("the inventory is isEmpty");
        }
        else{
            System.out.println("the inverntory is not empty");
            for ( products p : inverntory.values()) {
                p.displayProduct();
            }
        }
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        InventoryManagementSystem ims = new InventoryManagementSystem();
        
        int choice;
        do {
            System.out.println("\n--- Product Inventory Management ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product Quantity");
            System.out.println("3. Remove Product");
            System.out.println("4. Display All Products");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1 :
                    ims.addProduct();
                    break;
                case 2 :
                    ims.updateProductQuantity();
                    break;
                case 3 :
                    ims.removeProduct();
                    break;
                case 4 :
                    ims.displayDetails();
                    break;
                    
                case 5 :
                    break;
            }
            
        } 
         while (choice < 5);
        
    }
}
