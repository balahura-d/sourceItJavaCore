package lesson05;

import java.util.ArrayList;

import lesson05.Book;
import lesson05.Content;

public class Main {
	public static void main(String[] args) {

		ArrayList<Book> bookShell = new ArrayList<>();
		String author = "J. K. Rowling";
		String publisher = "MDK";
		int year = 2000;

		Content firstHP = new Content("J. K. Rowling", "Harry Potter and The Philosopher's Stone");
		Content secondHP = new Content("J. K. Rowling", "Harry Potter and The Chamber of Secrets");
		Content thirdHP = new Content("J. K. Rowling", "Harry Potter and The Prisoner of Azkaban");
		Content fourthHP = new Content("J. K. Rowling", "Harry Potter and The Goblet of Fire");
		Content fifthHP = new Content("J. K. Rowling", "Harry Potter and The Order of the Phoenix");
		Content sixthHP = new Content("J. K. Rowling", "Harry Potter and The Half-Blood Prince");
		Content seventhHP = new Content("J. K. Rowling", "Harry Potter and The Deathly Hallows");
		
		Book firstHPbook = new Book(firstHP, "РОСМЭН", 1997, 332, "hard", 99.9);
		Book secondHPbook = new Book(secondHP, "РОСМЭН", 1998, 360, "hard", 99.9);
		Book thirdHPbook = new Book(thirdHP, "РОСМЭН", 1999, 462, "hard", 99.9);
		Book fourthHPbook = new Book(fourthHP, "РОСМЭН", 2000, 617, "hard", 99.9);
		Book fifthHPbook = new Book(fifthHP, "РОСМЭН", 2003, 800, "hard", 99.9);
		Book sixthHPbook = new Book(sixthHP, "РОСМЭН", 2005, 607, "plastic", 99.9);
		Book seventhHPbook = new Book(seventhHP, "РОСМЭН", 2007, 607, "plastic", 99.9);

		Book bookDontsova1 = new Book("Dontsova", "Ubijca - sadovnik", "MDK", 2004, 246, "SofT", 45f);
		Book bookDontsova2 = new Book("Dontsova", "Ubijstvo v lesu", "MDK", 2004, 246, "SofT", 45f);
		Book bookDontsova3 = new Book("Dontsova", "Eshcho odno ubijstvo", "MDK", 2004, 246, "SofT", 45f);

		bookShell.add(bookDontsova1); //0
		bookShell.add(bookDontsova2);//1
		bookShell.add(bookDontsova3);//2
		bookShell.add(firstHPbook);//3
		bookShell.add(secondHPbook);//4
		bookShell.add(thirdHPbook);//5
		bookShell.add(fourthHPbook);//6
		bookShell.add(fifthHPbook);//7
		bookShell.add(sixthHPbook);//8
		bookShell.add(seventhHPbook);//9

		System.out.println("We have "+Book.numberOfBooks + " books in our bookshell.\nHere it are:");
		for (Book book : bookShell) {
			System.out.println(book);
		}
		System.out.println("*******************************************");
		System.out.println("All books of " + author + " is:");
		bookShell.stream().filter((b) -> b.getAuthor().equals(author))
			 .forEach((b) -> System.out.println(b));
		System.out.println("*******************************************");
		System.out.println("All books published in " + publisher + " is:");
		bookShell.stream().filter((b) -> b.getPublisher().equals(publisher))
		.forEach((b) -> System.out.println(b));
		System.out.println("*******************************************");
		System.out.println("All books published after " + year + " is:");
		bookShell.stream().filter((b) -> b.getYear() > year)
		.forEach((b) -> System.out.println(b));
		
	}
}
