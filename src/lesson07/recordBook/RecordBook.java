package lesson07.recordBook;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Создать класс Зачетная Книжка с внутренним классом, с помощью объектов
 * которого можно хранить информацию о сессиях, зачетах, экзаменах.
 * 
 * @author Дом
 */
public class RecordBook {
	public enum Grade { //уровень оценивания
		EXAM, CREDIT
	}

	static final int POINT_SYSTEM = 5; //пятибальная система

	private String studentName;//имя
	private LocalDate entranse;//дата вступления
	List<Record> session;//лист экзаменов

	public RecordBook(String studentName, int year, int month, int dayOfMonth) {
		this.studentName = studentName;
		entranse = LocalDate.of(year, month, dayOfMonth);
		session = new ArrayList<>();
	}

	public String getStudentName() {
		return studentName;
	}

	public String getEntranseDate() {
		return entranse.toString();
	}

	public void add(Grade grade, String discipline, int mark, String lecturerName) {
		if (mark<=0 || mark>POINT_SYSTEM)
			throw new IllegalArgumentException("Mark must be 0 < mark <= "+POINT_SYSTEM+", not "+mark+"!");
		session.add(new Record(grade, discipline, mark, lecturerName));
	}

	int getCourse() {
		return LocalDate.now().getYear() - entranse.getYear();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Record book of " + studentName + " of " + getCourse() + " course." + System.lineSeparator());
		for (Record record : session) {
			sb.append(record.toString() + System.lineSeparator());
		}
		return sb.toString();
	}

	class Record {
		Grade grade;
		String discipline;
		int mark;
		String lecturerName;
		LocalDate passDate;

		Record(Grade grade, String discipline, int mark, String lecturerName, LocalDate passDate) {
			this.grade = grade;
			if (discipline != null && discipline.length() > 1) {
				this.discipline = discipline;
			}
			if (mark <= POINT_SYSTEM & mark > 0) {
				this.mark = mark;
			}
			this.lecturerName = lecturerName;
			this.passDate = passDate;
		}

		Record(Grade grade, String discipline, int mark, String lecturerName) {
			this.grade = grade;
			if (discipline != null && discipline.length() > 1) {
				this.discipline = discipline;
			}
			if (mark <= POINT_SYSTEM & mark > 0) {
				this.mark = mark;
			}
			this.lecturerName = lecturerName;
			this.passDate = LocalDate.now();
		}

		public String toString() {
			return String.format("[%s] %s : %d : %s : %s", grade, discipline, mark, lecturerName, passDate);
		}
	}
}
