public class User {
    private String name;
    private Book issuedBook;

    public User(String name) {
        this.name = name;
        this.issuedBook = null;
    }

    public String getName() {
        return name;
    }

    public Book getIssuedBook() {
        return issuedBook;
    }

    public boolean issueBook(Book book) {
        if (issuedBook == null && !book.isIssued()) {
            book.setIssued(true);
            issuedBook = book;
            return true;
        }
        return false;
    }

    public boolean returnBook() {
        if (issuedBook != null) {
            issuedBook.setIssued(false);
            issuedBook = null;
            return true;
        }
        return false;
    }
}
