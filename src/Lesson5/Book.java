package Lesson5;

public class Book {
	static int numberOfBooks = 0;
	private int id;
//	String name;
//	String autors;
	Content content;
	String publisher;
	int year;
	int numberOfPages;
	double price;
	enum binding {
		HARD, SOFT, PLASTIC 
	}
	
	public Book(Content content, String publisher, int year, 
		    int pagesNum, double price, String binding) {
		id = ++numberOfBooks;
		this.content = content;
		this.publisher = publisher;
		this.year = year;
		this.numberOfPages = pagesNum;
		this.price = price;
//		this.binding = binding.toUpperCase();
	}
	
	public Book(String autor, String name, String publisher, int year, 
			    int pagesNum, double price/*, String binding*/) {
			id = ++numberOfBooks;
			this.content.autor = autor;
			this.content.name = name;
			this.publisher = publisher;
			this.year = year;
			this.numberOfPages = pagesNum;
			this.price = price;
//			this.binding = binding.toUpperCase();
		}
	public String toString() {
		return ("It's " + content + " published by " + publisher + " in " + year + " have "
				+ numberOfPages + " pages in " /*+ binding*/ + ". Cost " + price + ".");
	}
}
