package utils;

import enums.PeriodName;
import java.text.MessageFormat;

import static enums.PeriodName.*;

class TimeUtil {
	String formatTime(String timeString, PeriodName periodName) {
		if(noFormattingNeeded().contains(periodName)) {
			return timeString.substring(0,5);
		} else {
			int minutes = Integer.parseInt(timeString.substring(0, 2));
			String formatted =  checkMilliseconds(timeString);
			if (isExtraTime(minutes, periodName)) {
				return checkAdditionalTime(formatted, periodName);
			} else {
				return formatted;
			}
		}
	}

	private boolean isExtraTime(int minutes, PeriodName periodName) {
		if (minutes >= 90 && periodName.equals(SECOND_HALF)) {
			return true;
		} else return minutes >= 45 && periodName.equals(FIRST_HALF);
	}

	private String checkMilliseconds(String timeString) {
		int milliseconds = getMilliseconds(timeString);
		if (milliseconds >= 500) {
			int second = getSeconds(timeString) + 1;
			return MessageFormat.format("{0}:{1}", checkNumberFormat(getMinutes(timeString)), checkNumberFormat(second));
		} else {
			return timeString.substring(0, 5);
		}
	}

	/**
	 * #
	 * @param number
	 * @return This method ensures that on our output always displays times with 2 digits. e.g. 03:08 not 3:08.
	 */
	private String checkNumberFormat(int number) {
		return number > 9 ? String.valueOf(number) : "0" + number;
	}

	private String checkAdditionalTime(String timeString, PeriodName periodName) {
		String time = periodName.equals(FIRST_HALF) ? "45:00" : "90:00";
		int minuteMinus = periodName.equals(FIRST_HALF) ? 45 : 90;
		int leftover = getMinutes(timeString) - minuteMinus;
		return MessageFormat.format("{0} +{1}:{2}" , time, checkNumberFormat(leftover), checkNumberFormat(getSeconds(timeString)));
	}

	private int getMinutes(String timeString) {
		return Integer.parseInt(timeString.substring(0,2));
	}

	private int getSeconds(String timeString) {
		return Integer.parseInt(timeString.substring(3,5));
	}

	private int getMilliseconds(String string) {
		return Integer.parseInt(string.substring(6, 9));
	}

}
