import java.util.Arrays;

/**
 * This class represents a collection of books.
 */
public class BookCollection {
    
    private Book[] books;

    /**
     * Creates a new BookCollection object with the specified array of books.
     *
     * @param books the array of books to include in the collection
     */
    public BookCollection(Book[] books) {
        this.books = books;
    }

    /**
     * Returns the array of books in the collection.
     *
     * @return the array of books in the collection
     */
    public Book[] getBooks() {
        return books;
    }

    /**
     * Sets the array of books in the collection.
     *
     * @param books the new array of books to include in the collection
     */
    public void setBooks(Book[] books) {
        this.books = books;
    }

    /**
     * Adds a book to the collection.
     *
     * @param book the book to add to the collection
     */
    public void addBook(Book book) {
        for(int i=0; i<books.length; i++) {
            if(books[i] == null) {
                books[i] = book;
                return;
            }
        }
        System.out.println("Library is full!");
    }

    /**
     * Removes a book from the collection at the specified index.
     *
     * @param index the index of the book to remove from the collection
     */
    public void removeBook(int index) {
        if(index >=0 && index < books.length) {
            books[index] = null;
        }
    }

    /**
     * Searches for books in the collection with the specified title.
     *
     * @param title the title of the books to search for
     * @return an array of books with the specified title
     */
    public Book[] searchByTitle(String title) {
        int count = 0;
        for(int i=0; i<books.length; i++) {
            if(books[i] != null && books[i].getTitle().equals(title)) {
                count++;
            }
        }
        Book[] result = new Book[count];
        count = 0;
        for(int i=0; i<books.length; i++) {
            if(books[i] != null && books[i].getTitle().equals(title)) {
                result[count] = books[i];
                count++;
            }
        }
        return result;
    }

    /**
     * Searches for books in the collection with the specified author.
     *
     * @param author the author of the books to search for
     * @return an array of books with the specified author
     */
    public Book[] searchByAuthor(String author) {
        int count = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getAuthors().equals(author)) {
                count++;
            }
        }
        Book[] result = new Book[count];
        count = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getAuthors().equals(author)) {
                result[count] = books[i];
                count++;
            }
        }
        return result;
    }

    /**
     * Compares this BookCollection to the specified object for equality.
     *
     * @param obj the object to compare this Bookcollection to
     * @return true if the two objects are equal, false otherwise
     */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof BookCollection))
			return false;
		BookCollection other = (BookCollection) obj;
		if (!Arrays.equals(books, other.books))
			return false;
		return true;
	}
	
	/**
     * Returns a string representation of the books in the collection.
     *
     * @return a string representation of the books in the collection
     */
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Books in the book collection:\n");
	    for (Book book : books) {
	        sb.append(book.toString());
	        sb.append("\n");
	    }
	    return sb.toString();}
}