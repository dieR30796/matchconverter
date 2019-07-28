package utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * This class is in charge of taking in files to the application.
 */
public class FileUtil {
	private static final String directory = "./src/main/resources/input/";
	public static List<String> readLinesFromFile(String fileName) {
		String path = directory + fileName;
		try {
			return Files.readAllLines(Paths.get(path));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
