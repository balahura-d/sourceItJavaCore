package lesson9.homework9;

public class ClockDegrees {
	private static double getDegrees(int time) {
		if (time >= 0 & time < 60) {
			return 6.0 * time;
		} else {
			throw new IllegalArgumentException();
		}
	}

	private static double getDegrees(double time) {
		if (time >= 12.0) {
			time -= 12;
		}
		if (time >= 0 & time < 12) {
			return 30.0 * time;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public static void main(String[] args) {
		double time = 15.5;
		int hour = (int)time;
		int minute = 30;
		double minuteDegrees = getDegrees(minute);
		double hourDegrees = getDegrees(time);
		
		System.out.println(hour);
		System.out.println(minute);
		System.out.println(minuteDegrees);
		System.out.println(hourDegrees);
		
	}
	
	public static void getDegreesBetwenHourAndMinute(Long time) {
		
	}
	public static void getDegreesBetwenMinuteAndSecond(Long time) {
		
	}
	public static void getDegreesBetwenHourAndSecond(Long time) {
		
	}
	public static void getHourWithFractional(Long time) {
		
	}
	public static void getMinuteWithFractional(Long time) {
		
	}
	
	
}
