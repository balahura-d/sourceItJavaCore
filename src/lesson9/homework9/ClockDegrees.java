package lesson9.homework9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.*;
//import java.util.Calendar;
//import java.util.GregorianCalendar;

public class ClockDegrees {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		String sTime;
		ArrayList<Integer> hhmmss = new ArrayList<>();
		// Calendar c = new GregorianCalendar();
		Date d = new Date();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.print("Enter time here: ");

			Pattern pTime = Pattern
					.compile("\\d{1,2}[ :\\.,]{1}\\d{2}([ :\\.,]{1}\\d{2})?( ?(p|P|a|A)(m|M))?");
			Matcher mTime = pTime.matcher(sTime = br.readLine());

			if (mTime.matches()) {
				Pattern pDigits = Pattern.compile("\\d+");
				Matcher mDigits = pDigits.matcher(sTime);
				while (mDigits.find()) {
					hhmmss.add(Integer.valueOf(mDigits.group()));
				}

				// c.set(Calendar.HOUR_OF_DAY, hhmmss.get(0));
				// c.set(Calendar.MINUTE, hhmmss.get(1));
				d.setHours(hhmmss.get(0)); // ну вот удобнее через дату получилось
				d.setMinutes(hhmmss.get(1));
				if (hhmmss.size() == 3) { // если пользователь вводил и секунды, то массив хранит 3
								// значения
					// c.set(Calendar.SECOND, hhmmss.get(2));
					d.setSeconds(hhmmss.get(2));
				} else { // если не вводил - по-умолчанию считаем 0 секунд
					d.setSeconds(0);
				}

				System.out.println(d);
				System.out.printf("%.2f\n", getDegreesH(d));
				System.out.printf("%.2f\n", getDegreesHM(d));
				System.out.printf("%.2f\n", getDegreesHMS(d));
				System.out.printf("%.2f\n", getDegreesM(d));
				System.out.printf("%.2f\n", getDegreesMS(d));
				System.out.printf("%.2f\n", getDegreesS(d));
				System.out.printf("Разница между часовой и минутной стрелкой равна  %.2f%n",
						getDegreesBetwenHourAndMinute(d));
				System.out.printf("Разница между минутной и секундной стрелкой равна %.2f%n",
						getDegreesBetwenMinuteAndSecond(d));
				System.out.printf("Разница между часовой и секундной стрелкой равна %.2f%n",
						getDegreesBetwenHourAndSecond(d));
			} else {
				System.out.println(sTime + " - Неизвестный формат времени!");
				main(null);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public static double getDegreesH(Date date) {
		// в любом случае, чаовая стрелка проходит циферблат от 0 часов (включая) до 12
		// часов (не включая)
		return (date.getHours() > 12) ? ((date.getHours() - 12) * 30) : (date.getHours() * 30.0);
	}

	@SuppressWarnings("deprecation")
	public static double getDegreesM(Date date) {
		return date.getMinutes() * 6.0;
	}

	@SuppressWarnings("deprecation")
	public static double getDegreesS(Date date) {
		return date.getSeconds() * 6.0;
	}

	public static double getDegreesHM(Date date) {
		// часовая стрелка движется в 12 раз медленее минутной
		return (getDegreesH(date) + getDegreesM(date) / 12);
	}

	public static double getDegreesHMS(Date date) {
		// часовая стрелка движется в 12 раз медленее минутной
		// минутная стрелка движется в 60 раз медленнее секундной
		return (getDegreesH(date) + (getDegreesM(date) / 12) + (getDegreesS(date) / (12 * 60)));
	}

	public static double getDegreesMS(Date date) {
		// минутная стрелка движется в 60 раз медленнее секундной
		return getDegreesM(date) + getDegreesS(date) / 60;
	}

	public static double getDegreesBetwenHourAndMinute(Date date) {
		// return (Math.abs(getDegreesHMS(date) - getDegreesMS(date)));
		return (getDegreesHMS(date) > getDegreesMS(date)) 
				? (360 - getDegreesHMS(date) + getDegreesMS(date))
				: (getDegreesMS(date) - getDegreesHMS(date));
	}

	public static double getDegreesBetwenMinuteAndSecond(Date date) {
		// return (Math.abs(getDegreesMS(date) - getDegreesS(date)));
		return (getDegreesMS(date) > getDegreesS(date)) 
				? (360 - getDegreesMS(date) + getDegreesS(date))
				: (getDegreesS(date) - getDegreesMS(date));
	}

	public static double getDegreesBetwenHourAndSecond(Date date) {
		// return (Math.abs(getDegreesHMS(date) - getDegreesS(date)));
		return (getDegreesHMS(date) > getDegreesS(date)) 
				? (360 - getDegreesHMS(date) + getDegreesS(date))
				: (getDegreesS(date) - getDegreesHMS(date));
	}
}