package domain;

import services.FileService;
import utils.FileUtil;

import java.util.List;
import java.util.Scanner;

class MainApp {
	public static void main(String []args) {
		FileService fileService = new FileService();
		System.out.print("Please enter name of file you would like to convert: ");
		Scanner scanner = new Scanner(System.in);
		String inputFile = scanner.nextLine().trim();
		List<String> formattedStrings = fileService.checkValidStringAndFormat(FileUtil.readLinesFromFile(inputFile));
		System.out.println("Formatted data for " + inputFile + ":");
		formattedStrings.forEach(System.out::println);
	}
}
