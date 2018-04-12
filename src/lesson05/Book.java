package lesson05;

enum Binding {
	HARD, SOFT, PLASTIC
}

public class Book {
	static int numberOfBooks = 0;
	private int id;
	private Content content;
	private String publisher;
	private int year;
	private int numberOfPages;
	private double price;
	private Binding binding;

	public int getID() {
		return id;
	}

	public String getName() {
		return content.getName();
	}

	public String getAuthor() {
		return content.getAuthor();
	}

	public String getPublisher() {
		return publisher;
	}

	public int getYear() {
		return year;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public double getPrice() {
		return price;
	}

	public String getBinding() {
		return binding.toString().toLowerCase();
	}

	public Book(Content content, String publisher, int year, int pagesNum, String binding, double price) {
		id = ++numberOfBooks;
		this.content = content;
		this.publisher = publisher;
		this.year = year;
		this.numberOfPages = pagesNum;
		this.price = price;
		this.binding = Binding.valueOf(binding.toUpperCase());
	}

	public Book(String author, String name, String publisher, int year, int pagesNum, String binding,
			double price) {
		id = ++numberOfBooks;
		Content content = new Content(author, name);
		this.content = content;
		this.publisher = publisher;
		this.year = year;
		this.numberOfPages = pagesNum;
		this.price = price;
		this.binding = Binding.valueOf(binding.toUpperCase());
	}
	public Book(String name, String publisher, int year, int pagesNum, String binding,
			double price) {
		id = ++numberOfBooks;
		Content content = new Content(name);
		this.content = content;
		this.publisher = publisher;
		this.year = year;
		this.numberOfPages = pagesNum;
		this.price = price;
		this.binding = Binding.valueOf(binding.toUpperCase());
	}

	public String toString() {
		return String.format("It's %s published by %s in %d have %d pages in %s binding. Costs %.2f.", content,
				publisher, year, numberOfPages, binding.toString().toLowerCase(), price);
	}
}
