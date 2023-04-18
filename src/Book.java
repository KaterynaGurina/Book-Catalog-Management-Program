// -----------------------------------------------------
// Assignment 3
// Written by: Kateryna Gurina_40188793
// -----------------------------------------------------
import java.io.Serializable;
import java.util.Arrays;

/**
 * This class represents a book, which includes a title, author(s), price, International Standard Book Number (ISBN),
 * genre, and publication year.
 */
public class Book implements Cloneable, Serializable{
    
    String title;
    String authors;
    Double price;
    int[] isbn;
    String genre;
    int year;

    /**
     * Creates a new {@code Book} object with default values for all fields.
     */
    public Book () {
        this.title = "";
        this.authors = "";
        this.price = 0.0;
        this.isbn = null;
        this.genre = "";
        this.year = 0;
    }

    /**
     * Creates a new {@code Book} object with the specified values for all fields.
     *
     * @param title the title of the book
     * @param authors the author(s) of the book
     * @param price the price of the book
     * @param isbn the International Standard Book Number (ISBN) of the book
     * @param genre the genre of the book
     * @param year the publication year of the book
     */
    public Book(String title, String authors, Double price, int[] isbn, String genre, int year) {
        this.title = title;
        this.authors = authors;
        this.price = price;
        this.isbn = isbn;
        this.genre = genre;
        this.year = year;
    }

    /**
     * Returns the title of the book.
     *
     * @return the title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title the new title of the book
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the author(s) of the book.
     *
     * @return the author(s) of the book
     */
    public String getAuthors() {
        return authors;
    }

    /**
     * Sets the author(s) of the book.
     *
     * @param authors the new author(s) of the book
     */
    public void setAuthors(String authors) {
        this.authors = authors;
    }

    /**
     * Returns the price of the book.
     *
     * @return the price of the book
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets the price of the book.
     *
     * @param price the new price of the book
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Returns the International Standard Book Number (ISBN) of the book.
     *
     * @return the International Standard Book Number (ISBN) of the book
     */
    public int[] getIsbn() {
        return isbn;
    }

    /**
     * Sets the International Standard Book Number (ISBN) of the book.
     *
     * @param isbn the new International Standard Book Number (ISBN) of the book
     */
    public void setIsbn(int[] isbn) {
        this.isbn = isbn;
    }

    /**
     * Returns the genre of the book.
     *
     * @return the genre of the book
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the genre of the book.
     *
     * @param genre the new genre of the book
     */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
     * Returns the year the book was published.
     *
     * @return the year the book was published
     */
	public int getYear() {
		return year;
	}

    /**
     * Sets the year the book was published.
     *
     * @param year the year the book was published
     */
	
	public void setYear(int year) {
		this.year = year;
	}
	
    /**
     * Compares this {@code Book} to the specified object for equality.
     *
     * @param obj the object to compare this {@code Book} to
     * @return {@code true} if the two objects are equal, {@code false} otherwise
     */
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Book))
			return false;
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (isbn != other.isbn)
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	/**
     * Returns a string representation of the book.
     *
     * @return a string representation of the book
     */
	
	@Override
	public String toString() {
		return title + " " + authors + " " + price + " " + Arrays.toString(isbn) + " " + genre + " " + year;
	}	
}
