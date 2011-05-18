package ebooks;

public class BookId {
    private Integer bookId;

    public BookId(Integer bookId) {
        this.bookId = bookId;
    }

    public static BookId Of(String bookId) {
        return new BookId(Integer.valueOf(bookId));
    }
}
