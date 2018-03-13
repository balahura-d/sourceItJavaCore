package Lesson5;

public class Content {
	String autor;
	String name;
	enum jenre {
		POETRY,PROSE,DRAMA,NATURAL_SCIENCE,PSYHOLOGY,HISTORY,LOW
	}
	
	public String toString() {
		return (name + " by " + autor + "in"/* + jenre*/);
	}
	
	public Content (String autor,String name,String jenre) {
		this.autor = autor;
		this.name = name;
//		this.jenre = jenre.toUpperCase();
	}
}
