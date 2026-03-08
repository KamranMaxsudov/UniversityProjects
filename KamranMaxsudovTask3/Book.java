public class Book {
    private int id;
    private String title;
    private Author[] bookAuthors;
    private int authorCount;
    private double price;
    private boolean borrowed;
    private int year;
    private String publisher;

    public Book(int id, String title, double price) {
        this.id = id;
        this.title = title;
        this.bookAuthors = new Author[5];
        this.authorCount = 0;
        this.borrowed = false;
        setPrice(price);
    }

    public Book(int id, String title, double price, int maxAuthors) {
        this(id, title, price);
        this.bookAuthors = new Author[maxAuthors];
    }

    public void addAuthor(Author a) {
        if (authorCount < bookAuthors.length) {
            bookAuthors[authorCount++] = a;
            a.addBook(this);
        }
    }

    public void setPrice(double price) {
        this.price = (price > 0) ? price : 0.0;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setBorrowed(boolean status) {
        this.borrowed = status;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public int getAuthorCount() {
        return authorCount;
    }

    public String getAuthorName(int index) {
        if (index >= 0 && index < authorCount) {
            return bookAuthors[index].getName();
        }
        return null;
    }

    public void displayInfo() {
        System.out.println("Book ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Price: " + price);
        System.out.println("Borrowed: " + borrowed);
        System.out.print("Authors: ");
        for (int i = 0; i < authorCount; i++) {
            System.out.print(bookAuthors[i].getName());
            if (i < authorCount - 1) System.out.print(", ");
        }
        System.out.println();
    }

    public void getAPAReference() {
        String mainAuthor = (authorCount > 0) ? bookAuthors[0].getName() : "Unknown";
        System.out.println(mainAuthor + ". (" + year + "). " + title + ". " + publisher + ".");
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', id=" + id + "}";
    }
}