package utils;

import enums.PeriodName;

import java.text.MessageFormat;

import static enums.PeriodName.findPeriodNameFromInput;

public class StringUtil {

	private StringUtil() {

	}
	/**
	 *
	 * @param inputfi
	 * @return This method updates any string that has a time of e.g 3:00:000 and returns
	 * a string of 03:00:000 to make formatting easier.
	 */
	private static String addCharacterToString(String input) {
		return input.substring(0, 5) + 0 + input.substring(5);
	}

	/**
	 *
	 * @param input
	 * @return This method finds the short name in our input and grabs the corresponding PeriodName enum,
	 * then removes the short name from the string.
	 */
	public static String findPeriodNameAndRemoveShort(String input) {
		PeriodName periodName = findPeriodNameFromInput(input);
		input = input.replace("[" + periodName.getShortName() + "] ", "");
		return formatTimeAddPeriodName(input, periodName);
	}

	private static String formatTimeAddPeriodName(String string, PeriodName periodName) {
		TimeUtil timeUtil = new TimeUtil();
		String formattedTimeString = timeUtil.formatTime(string, periodName);
		return MessageFormat.format("{0} - {1}", formattedTimeString, periodName.getLongName());
	}

	public static String allStringFunctions(String input) {
		input = addCharacterToString(input);
		return findPeriodNameAndRemoveShort(input);
	}
}
