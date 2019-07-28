package enums;

import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This enum is in charge of storing the short and long name of the different periods
 * our input may contain. Both short and long stored in case requirements change in future.
 */
@Getter
public enum PeriodName {
	PRE_MATCH("PM", "PRE_MATCH"),
	FIRST_HALF("H1", "FIRST_HALF"),
	HALF_TIME("HT", "HALF_TIME"),
	SECOND_HALF("H2", "SECOND_HALF"),
	FULL_TIME("FT", "FULL_TIME"),
	INVALID("INVALID");

	private final String shortName;
	private final String longName;

	PeriodName(String shortName, String longName) {
		this.shortName = shortName;
		this.longName = longName;
	}

	PeriodName(String shortName) {
		this.shortName = shortName;
		longName = null;
	}

	/**
	 * Creates map of Key: PeriodName short and Value: PeriodName enum.
	 */
	static final Map periodNameMap = Stream.of(PeriodName.values())
			.collect(Collectors.toMap(PeriodName::getShortName, Function.identity()));

	/**
	 *
	 * @param input
	 * @return This method simply takes in a valid input string and depending on the short name returns the
	 * corresponding PeriodName enum.
	 */
	public static PeriodName findPeriodNameFromInput(String input) {
		return (PeriodName) periodNameMap.get(input.substring(1,3));
	}

	public static List<PeriodName> noFormattingNeeded() {
		return List.of(PRE_MATCH, FULL_TIME, HALF_TIME);
	}
}
