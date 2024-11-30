/******************************************************************************

Problem 1: Library Book Management System using ArrayList
Objective: Design a system to manage a collection of books in a library,
where each book has a title, author, and status (whether it is available or issued).
Problem Statement: Create a Book class with the following attributes:
title (String)
author (String)
isAvailable (boolean)
Write a program that uses an ArrayList<Book> to manage the library's collection. 
The program should allow the following operations:
Add new books to the collection.
Remove a book from the collection based on the title.
Mark a book as issued or returned based on the title.
Display all available books in the library.
*******************************************************************************/

import java.util.ArrayList;
import java.util.Scanner;

class Book{
    Scanner sc= new Scanner(System.in);
    private String title;
    private String author;
    private boolean isAvailable;
    
    public Book(String title, String author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    
    public void readData(){
        System.out.println("Enter the name of the book title-> ");
        title= sc.nextLine();
        System.out.println("Enter the name of the author-> ");
        author= sc.nextLine();
        System.out.println("Enter the status of the book-> ");
        String status= sc.nextLine();
        isAvailable = status.equalsIgnoreCase("yes");
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getAuthor(){
        return author;
    }
    
    public boolean getAvailability(){
        return isAvailable;
    }
    
    public void setAvailability( boolean isAvailable ){
        this.isAvailable=isAvailable;
    }
    
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Status: " + (isAvailable ? "Available" : "Issued"));
    }
    
}


class Library_Book_Management_System{
    public static void main( String[] args){
        //Book b = new Book("","",true);
        Scanner sc= new Scanner(System.in);
        ArrayList<Book> bookList = new ArrayList<>();
        int choice;
        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a new book");
            System.out.println("2. Remove a book");
            System.out.println("3. Mark a book as issued/returned");
            System.out.println("4. Display available books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            
            switch(choice){
                case 1 :
                    Book b = new Book("","",true);
                    b.readData();
                    bookList.add(b);
                    break;
                case 2 :
                    System.out.println("Enter the title name to remove");
                    String titleName=sc.nextLine();
                    for ( Book k : bookList){
                        if ( k.getTitle().equalsIgnoreCase(titleName)){
                            bookList.remove(titleName);
                        }
                        else{
                            System.out.println("the book is not present");
                        }
                    }
                    break;
                case 3 :
                    System.out.println("Enter the title name to mark as issued/returned");
                    String bookname = sc.nextLine();
                    for ( Book j : bookList) {
                        if ( j.getTitle().equalsIgnoreCase(bookname)){
                            if (j.getAvailability()){
                                j.setAvailability(false);
                                System.out.println("Book marked as issued.");
                            }
                            else{
                                j.setAvailability(true);
                                System.out.println("Book marked as returned.");
                            }
                        }
                        
                    }
                    break;
                case 4 :
                    for (Book i : bookList){
                        if (i.getAvailability())
                        {
                        i.displayDetails();
                        System.out.println();
                        }
                        else{
                            System.out.println("book not available");
                        }
                    }
                    break;
                case 5 :
                    break;
                default:
                    System.out.println("Enter the value between 1 to 5");
                    break;
            }
        } 
        while(choice<5);
    }
}

