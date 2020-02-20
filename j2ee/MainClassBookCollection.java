import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    String Title, Author, Publisher;
    double price;
    Book(String Title, String Author, String Publisher, double price){
        this.Title = Title;
        this.Author = Author;
        this.Publisher = Publisher;
        this.price = price;
    }
    public String toString(){
        return "Book:{" + "\n" +
                "Title: " + Title + "\n" +
                "Author: " + Author + "\n" +
                "Publisher: " + Publisher + "\n" +
                "Price: " + price + "\n" +
                "}\n";
    }
    public static List<Book> sort(List<Book> books){
        Book Temp;
        for(int i = 0; i<books.size(); i++){
            for(int j = 0; j<books.size()-i-1; j++){
                if(books.get(j).Title.compareToIgnoreCase(books.get(j+1).Title)>0){
                    Temp = books.get(j);
                    books.set(j, books.get(j+1));
                    books.set(j+1, Temp);
                }
            }
        }
        return books;
    }
}

public class MainClassBookCollection {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        while(true){
            System.out.println("1: Enter a Book\n" +
                    "2: Delete a Book\n" +
                    "3: Sort\n" +
                    "4: View\n" +
                    "5: Exit");
            int ch = Integer.parseInt(sc.nextLine());
            switch (ch){
                case 1:
                    generateBook();
                    break;
                case 2:
                    deleteBook();
                    break;
                case 3:
                    books = new ArrayList<>(Book.sort(books));
                    break;
                case 4:
                    displayBooks();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    private static void displayBooks() {
        for(Book b: books){
            System.out.println((books.indexOf(b) + 1) + ": " + b);
        }
    }

    private static void deleteBook() {
        displayBooks();
        System.out.println("Enter the number you want deleted");
        int n = Integer.parseInt(sc.nextLine());
        books.remove(books.get(--n));
    }

    private static void generateBook() {
        System.out.print("Enter the Title: ");
        String Title = sc.nextLine();
        System.out.print("Enter the Author: ");
        String Author = sc.nextLine();
        System.out.print("Enter the Publisher: ");
        String Publisher = sc.nextLine();
        System.out.print("Enter the price: ");
        double price = Double.parseDouble(sc.nextLine());
        books.add(new Book(Title, Author, Publisher, price));
    }
}
