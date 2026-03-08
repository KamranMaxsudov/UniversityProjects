public class Main {
    public static void main(String[] args) {
        Library centralLibrary = new Library("Imisli Kitabxanasi", 20);

        Author a1 = new Author(1, "Dale Carneige");
        Book b1 = new Book(101, "How to talk with People", 45.5, 1);
        b1.setYear(2008);
        b1.setPublisher("Sam Sulek");

        b1.addAuthor(a1);
        centralLibrary.addBook(b1);

        System.out.println("Library Inventory:");
        b1.displayInfo();

        System.out.println("\nAPA Reference:");
        b1.getAPAReference();

        System.out.println("\nAverage Book Price: " + centralLibrary.getAveragePrice());
    }
}