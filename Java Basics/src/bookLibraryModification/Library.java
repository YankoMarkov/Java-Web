package bookLibraryModification;

import java.util.ArrayList;
import java.util.List;

class Library {
	
	private String name;
	private List<Book> books;
	
	public Library() {
		this.books = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
