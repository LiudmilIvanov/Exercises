package htmlTagRemover;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class HTMLTagRemover {

	private static final String htmlFileName = "resources/Problem1.txt";
	private static final String CHARSET = "windows-1251";

	public static void main(String[] args) {
		File file = null;
		Scanner input = null;
		StringBuilder result = new StringBuilder();
		try {
			file = new File(htmlFileName);
			input = new Scanner(file);
			while (input.hasNext()) {
				String line = input.nextLine();
				line = removeAllTags(line);
				line = removeDoubleNewLines(line);
				line = trimNewLines(line);
				if (! line.equals("")) {
					System.out.println(line);
			}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File is missing!!!");
			e.printStackTrace();
		} catch (IOException ioEx) {
			System.out.println("Wrong input!!");
			ioEx.printStackTrace();

		} finally {
			if (input != null) {
				input.close();
			}
		}

	}

	private static String trimNewLines(String str) {
		int start = 0;
		while (start < str.length() && str.charAt(start)=='\n') {
			start++;
			}
			int end = str.length()-1;
			while (end >= 0 && str.charAt(end)=='\n') {
			end--;
			}
			if (start > end) {
			return "";
			}
			String trimmed = str.substring(start, end+1);
		return trimmed;
	}

	private static String removeDoubleNewLines(String str) {
		while (str.indexOf("\n\n") != -1) {
			str = str.replaceAll("\n\\s+", "\n");
		}
		return str;
	}

	private static String removeAllTags(String str) {
		String stringWithoutTags = str.replaceAll("<[^>]*>", "\n");
		return stringWithoutTags;
	}
}
