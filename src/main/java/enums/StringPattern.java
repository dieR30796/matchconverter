package enums;

import lombok.Getter;

@Getter
public enum StringPattern {
	INPUT_PATTERN_1("\\[[A-Z][A-Za-z0-9]\\]\\s\\d:\\d{2}.\\d{3}"),
	INPUT_PATTERN_2("\\[[A-Z][A-Za-z0-9]\\]\\s\\d{2}:\\d{2}.\\d{3}");

	private final String pattern;
	StringPattern(String pattern) {
		this.pattern = pattern;
	}
}
