package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileUtilTest {
	@Test
	@DisplayName("Test that with a valid input file that the resulting input is not null")
	void testValidFileImports() {
		assertNotNull(FileUtil.readLinesFromFile("input.data"));
	}

	@Test
	@DisplayName("Test that with an invalid input the correct error is being thrown.")
	void testInvalidFilePath() {
		assertThrows(RuntimeException.class, () -> FileUtil.readLinesFromFile("fake-file123.data"));
	}
}
