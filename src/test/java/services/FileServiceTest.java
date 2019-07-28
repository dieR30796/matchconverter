package services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileServiceTest {
	private FileService fileService;

	@BeforeEach
	void setUp() {
		fileService = new FileService();
	}

	@Test
	@DisplayName("Method checkValidStringAndFormat completes all string operations in it's lifecycle and therefore all we need to test" +
			"is the resulting output to ensure that all of the operations have worked correctly.")
	void testCorrectOutputsAreGenerated() {
		List<String> testStrings = Arrays.asList("[PM] -10:00.000", "1234", "[H1] 3:07.513", "[H1] 46:15.752",
				"[H2] 90:00.908", "[PM] 0:00.000", "[H1] 45:00.001", "(H1) 45:00.001");
		List<String> expectedResult = Arrays.asList("INVALID", "INVALID", "03:08 - FIRST_HALF", "45:00 +01:16 - FIRST_HALF",
				"90:00 +00:01 - SECOND_HALF", "00:00 - PRE_MATCH", "45:00 +00:00 - FIRST_HALF", "INVALID");
		assertEquals(fileService.checkValidStringAndFormat(testStrings), expectedResult);
	}
}
