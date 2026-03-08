public class Library {
    private String name;
    private Book[] books;
    private int count;

    public Library(String name, int capacity) {
        this.name = name;
        this.books = new Book[capacity];
        this.count = 0;
    }

    public void addBook(Book b) {
        if (count < books.length) {
            books[count++] = b;
        }
    }

    public void removeBook(int bookId) {
        for (int i = 0; i < count; i++) {
            if (books[i].getId() == bookId) {
                for (int j = i; j < count - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[--count] = null;
                break;
            }
        }
    }

    public void searchByAuthor(String authorName) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < books[i].getAuthorCount(); j++) {
                if (books[i].getAuthorName(j).equalsIgnoreCase(authorName)) {
                    books[i].displayInfo();
                    found = true;
                    break;
                }
            }
        }
        if (!found) System.out.println("No books found for author: " + authorName);
    }

    public double getAveragePrice() {
        if (count == 0) return 0.0;
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += books[i].getPrice();
        }
        return total / count;
    }

    @Override
    public String toString() {
        return "Library{name='" + name + "', totalBooks=" + count + "}";
    }
}