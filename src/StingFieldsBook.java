	/**
	
	StingFieldsBook represents a book object with all fields as strings
	*/
	public class StingFieldsBook {
	String title;
	String authors;
	String price;
	String isbn;
	String genre;
	String year;
	
	/**
	
	Creates an empty StingFieldsBook object
	*/
	public StingFieldsBook() {
	this.title = "";
	this.authors = "";
	this.price = "";
	this.isbn = "";
	this.genre = "";
	this.year = "";
	}
	/**
	
	Creates a StingFieldsBook object with specified field values
	@param title The title of the book
	@param authors The authors of the book
	@param price The price of the book
	@param isbn The ISBN of the book
	@param genre The genre of the book
	@param year The publication year of the book
	*/
	public StingFieldsBook(String title, String authors, String price, String isbn, String genre, String year) {
	this.title = title;
	this.authors = authors;
	this.price = price;
	this.isbn = isbn;
	this.genre = genre;
	this.year = year;
	}
	/**
	
	Creates a StingFieldsBook object with field values extracted from a String array
	@param arr The String array from which the field values are extracted
	*/
	public StingFieldsBook(String[] arr) {
	this.title = arr[0];
	this.authors = arr[1];
	this.price = arr[2];
	this.isbn = arr[3];
	this.genre = arr[4];
	this.year = arr[5];
	}
	/**
	
	Returns the title of the book
	@return The title of the book
	*/
	public String getTitle() {
	return title;
	}
	/**
	
	Sets the title of the book
	@param title The new title of the book
	*/
	public void setTitle(String title) {
	this.title = title;
	}
	/**
	
	Returns the authors of the book
	@return The authors of the book
	*/
	public String getAuthors() {
	return authors;
	}
	/**
	
	Sets the authors of the book
	@param authors The new authors of the book
	*/
	public void setAuthors(String authors) {
	this.authors = authors;
	}
	/**
	
	Returns the price of the book
	@return The price of the book
	*/
	public String getPrice() {
	return price;
	}
	/**
	
	Sets the price of the book
	@param price The new price of the book
	*/
	public void setPrice(String price) {
	this.price = price;
	}
	/**
	
	Returns the ISBN of the book
	@return The ISBN of the book
	*/
	public String getIsbn() {
	return isbn;
	}
	/**
	
	Sets the ISBN of the book
	@param isbn The new ISBN of the book
	*/
	public void setIsbn(String isbn) {
	this.isbn = isbn;
	}
	/**
	
	Returns the genre of the book
	@return The genre of the book
	*/
	public String getGenre() {
	return genre;
	}
	/**
	
	Sets the genre of the book
	@param genre The new genre of the book
	*/

	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 * Gets the publication year of the book.
	 * @return the year of publication
	 */
	public String getYear() {
		return year;
	}
	/**
	 * Sets the publication year of the book.
	 * @param year the year to set
	*/
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * Compares the current StingFieldsBook object with another object for equality.
	 * @param obj the object to compare with
	 * @return true if the objects are equal, false otherwise
	*/
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof StingFieldsBook))
			return false;
		StingFieldsBook other = (StingFieldsBook) obj;
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
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
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
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
	/**
	 * 	Returns a string representation of the StingFieldsBook object.
	 * @return the string representation of the StingFieldsBook object.
	 */
	
	public String toString() {
		return "StingFieldsBook [title=" + title + ", authors=" + authors + ", price=" + price + ", isbn=" + isbn
				+ ", genre=" + genre + ", year=" + year + "]";
	}
}
