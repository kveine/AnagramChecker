import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Anagrams {
	
	public static void main(String[] args) throws IOException {
		String wordsPath = "words.txt";
		String listPath = "list.txt";
	
		List<String> words = readFromFile(wordsPath);
		List<String> list = readFromFile(listPath);
		
		checkForAnagrams(words, list);
	
	}
	
	public static List<String> readFromFile(String path) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(path));
        List<String> words = new ArrayList<String>();

        String line;
        while ((line = reader.readLine()) != null) {
        	words.add(line);
        }
        reader.close();
        
        return words;
	}

	public static void checkForAnagrams(List<String> words, List<String> list) {
		Map<String, ArrayList<String>> myHashMap = new HashMap<String, ArrayList<String>>();

		for(String a: words){
			ArrayList<String> valuesForHashMap = new ArrayList<String>();
			
			for(String b: list){
				char[] word = a.toCharArray();
				char[] anagram = b.toCharArray();
				if(!Arrays.equals(word, anagram)){
					Arrays.sort(word);
					Arrays.sort(anagram);
					if(Arrays.equals(word, anagram)){
						valuesForHashMap.add(b);
					}
				}
			}
			
			if(!valuesForHashMap.isEmpty()){
				myHashMap.put(a, valuesForHashMap);
			}
		}
		
		for(Map.Entry<String, ArrayList<String>> entry : myHashMap.entrySet()) {
		    String key = entry.getKey();
		    ArrayList<String> value = entry.getValue();
		    System.out.print(key + ": ");
		    for(String aString : value){
		        System.out.print(aString + " ");
		    }
		    System.out.println();
		}
	}
}
