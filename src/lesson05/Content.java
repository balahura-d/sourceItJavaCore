package lesson05;

enum Jenre {
	POETRY, PROSE, DRAMA, NATURAL_SCIENCE, PSYHOLOGY, HISTORY, LOW
}

public class Content {
	private String author;
	private String name;
	private Jenre jenre;

	public Content(String author, String name/* , String jenre */) {
		this.author = author;
		this.name = name;
		// this.jenre = jenre.toUpperCase();
	}

	public Content(String name/* , String jenre */) {
		this.author = null;
		this.name = name;
		// this.jenre = jenre.toUpperCase();
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		if (author != null) {
			return author;
		} else {
			return "unknown author";
		}
	}

	public String getJenre() {
		return jenre.toString();
	}

	public String toString() {
		if (author.length() > 0) {
			return ("\"" + name + "\" by " + author/* + " in " + jenre */);
		} else {
			return (name);
		}
	}

}
