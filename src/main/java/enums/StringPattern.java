package enums;

import lombok.Getter;

/**
 * The reason for 2 regex patterns is if the input comes in as 0:00:000 I want to format that to read 00:00:000 to make it
 * easier for future operations.
 */
@Getter
public enum StringPattern {
	INPUT_PATTERN_1("\\[[A-Z][A-Za-z0-9]\\]\\s\\d:\\d{2}.\\d{3}"),
	INPUT_PATTERN_2("\\[[A-Z][A-Za-z0-9]\\]\\s\\d{2}:\\d{2}.\\d{3}");

	private final String pattern;
	StringPattern(String pattern) {
		this.pattern = pattern;
	}
}
