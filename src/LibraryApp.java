import java.util.ArrayList;
import java.util.Scanner;
public class LibraryApp {
    private ArrayList<Book> books =  new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    public void run(){
        while(true){
            menu();
            System.out.println("Enter your choice");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    PrintAllBooks();
                    break;
                case 2:
                    AddNewBook();
                    break;
                case 3:
                    SearchBookByTitle();
                    break;
                case 4:
                    BorrowBook();
                    break;
                case 5:
                    ReturnBook();
                    break;
                case 6:
                    deleteBook();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }
    public void menu(){
        System.out.println();
        System.out.println("Welcome to Library App");
        System.out.println("1. Print all Books");
        System.out.println("2. Add new Book");
        System.out.println("3. Search Books by title");
        System.out.println("4. Borrow Book");
        System.out.println("5. Return Book");
        System.out.println("6. Delete Book by id");
        System.out.println("7. Quit");
    }
    public void PrintAllBooks(){
        if(books.isEmpty()){
            System.out.println("There are no books in the library");
        }
        else{
            books.forEach(System.out::println);
        }
    }
    public void AddNewBook(){
        System.out.println("Please enter the title of the book you would like to add:");
        String title = scanner.nextLine();
        System.out.println("Please enter the author of the book you would like to add:");
        String author = scanner.nextLine();
        System.out.println("Please enter the year of the book you would like to add:");
        int year = scanner.nextInt();
        scanner.nextLine();
        books.add(new Book(title,author,year));
        System.out.println("Book added successfully");
    }
    public void SearchBookByTitle(){
        System.out.println("Please enter the part of title of the book you would like to search:");
        String searchTitle = scanner.nextLine().toLowerCase();
        for (Book book : books){
            if(book.getTitle().toLowerCase().contains(searchTitle)){
                System.out.println(book);
                System.out.println("Book found successfully");
            }
            else{
                System.out.println("Book not found");
            }
        }
    }
    public void BorrowBook(){
        System.out.println("Please enter the  Id of book you would like to borrow:");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        for(Book book : books){
            if(book.getId() == bookId){
                if (book.isAvailable()){
                    book.markAsBorrowed();
                    System.out.println("Book Borrowed");
                }
                else{
                    System.out.println("The Book has been already borrowed");
                }
            }
        }
    }
    public void ReturnBook(){
        System.out.println("Please enter Id of the book you would like to return:");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        for(Book book : books){
            if(book.getId() == bookId && !book.isAvailable()){
                book.markAsReturned();
                System.out.println("Book Returned");
            }
        }
    }
    public void deleteBook(){
        System.out.println("Please enter the id of book you would like to delete:");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        for(Book book : books){
            if(book.getId() == bookId){
                books.remove(book);
                System.out.println("Book Deleted successfully");
            }
            else {
                System.out.println("The Book is not found");
            }
        }
    }
}
