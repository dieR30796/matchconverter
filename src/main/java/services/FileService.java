package services;

import utils.StringUtil;
import static enums.StringPattern.*;
import static enums.PeriodName.*;
import java.util.List;

public class FileService {
	public List<String> checkValidStringAndFormat(List<String> inputStrings) {
		for (int i = 0; i < inputStrings.size() ; i++) {
			String string = inputStrings.get(i);
			inputStrings.set(i, getFormattedString(string));
		}
		return inputStrings;
	}

	private String getFormattedString(String string) {
		if (string.matches(INPUT_PATTERN_1.getPattern()) && findPeriodNameFromInput(string) != null) {
			return StringUtil.allStringFunctions(string);
		} else if (string.matches(INPUT_PATTERN_2.getPattern()) && findPeriodNameFromInput(string) != null) {
			return StringUtil.findPeriodNameAndRemoveShort(string);
		} else {
			return "INVALID";
		}
	}
}
