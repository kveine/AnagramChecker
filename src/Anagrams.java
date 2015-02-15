import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

	public static void main(String[] args) {
		String wordsPath = "words.txt";
		String listPath = "list.txt";

		try {
			List<String> words = readFromFile(wordsPath);
			List<String> list = readFromFile(listPath);
			checkForAnagrams(words, list);
		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Something went wrong");
		}

	}

	public static List<String> readFromFile(String path) throws IOException,FileNotFoundException {
		List<String> words = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader(path));

		String line;
		while ((line = reader.readLine()) != null) {
			words.add(line);
		}
		reader.close();

		return words;
	}

	public static void checkForAnagrams(List<String> words, List<String> list) {
		Map<String, ArrayList<String>> myHashMap = new HashMap<String, ArrayList<String>>();

		for (String a : words) {
			ArrayList<String> valuesForHashMap = new ArrayList<String>();
			for (String b : list) {
				char[] word = a.toCharArray();
				char[] anagram = b.toCharArray();

				if (!Arrays.equals(word, anagram)) {
					Arrays.sort(word);
					Arrays.sort(anagram);
					if (Arrays.equals(word, anagram)) {
						valuesForHashMap.add(b);
					}
				}
			}

			if (!valuesForHashMap.isEmpty()) {
				myHashMap.put(a, valuesForHashMap);
			}
		}

		for (Map.Entry<String, ArrayList<String>> entry : myHashMap.entrySet()) {
			String key = entry.getKey();
			ArrayList<String> value = entry.getValue();
			System.out.print(key + ": ");
			for (String a : value) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
	}
}
