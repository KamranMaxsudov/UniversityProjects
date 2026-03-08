public class Author {
    private int id;
    private String fullName;
    private Book[] writtenBooks;
    private int totalBooks;

    public Author(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
        this.writtenBooks = new Book[10];
        this.totalBooks = 0;
    }

    public Author(int id, String fullName, int maxBooks) {
        this(id, fullName);
        this.writtenBooks = new Book[maxBooks];
    }

    public void addBook(Book b) {
        if (totalBooks < writtenBooks.length) {
            writtenBooks[totalBooks++] = b;
        }
    }

    public void showInfo() {
        System.out.println("Author ID: " + id);
        System.out.println("Author Name: " + fullName);
        System.out.print("Books: ");
        for (int i = 0; i < totalBooks; i++) {
            System.out.print(writtenBooks[i].getTitle());
            if (i < totalBooks - 1) System.out.print(", ");
        }
        System.out.println();
    }

    public String getName() {
        return fullName;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Author{name='" + fullName + "', id=" + id + "}";
    }
}