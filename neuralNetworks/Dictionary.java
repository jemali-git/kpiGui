package neuralNetworks;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Dictionary {
	String wordDes;
	Map<Character, Dictionary> map;

	public Dictionary() {

	}

	public void addWord(String word, String wordDest) {
		word = word.toLowerCase();
		Dictionary dictionary = this;
		for (int i = 0; i < word.length(); i++) {
			if (dictionary.map == null) {
				dictionary.map = new HashMap<>();
			}
			Dictionary newDictionary = dictionary.map.get(word.charAt(i));
			// System.out.println(newDictionary);

			if (newDictionary == null) {
				newDictionary = new Dictionary();
				if (i == word.length() - 1) {
					newDictionary.wordDes = wordDest;
				}
				dictionary.map.put(word.charAt(i), newDictionary);
			}
			if (i == word.length() - 1) {
				newDictionary.wordDes = wordDest;
			}
			dictionary = newDictionary;
		}
	}

	public String getWordDest(String word) {
		String wordDest = word;
		word = word.toLowerCase();
		Dictionary dictionary = this;
		for (int i = 0; i < word.length(); i++) {
			if (dictionary.map == null) {
				break;
			}
			if (dictionary.map.get(word.charAt(i)) != null) {
				dictionary = dictionary.map.get(word.charAt(i));
				if (dictionary.wordDes != null) {
					wordDest = dictionary.wordDes;
				}
			} else {
				break;
			}
		}
		return wordDest;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		if (map != null) {

			Iterator<Entry<Character, Dictionary>> entries = map.entrySet().iterator();
			while (entries.hasNext()) {
				Entry<Character, Dictionary> thisEntry = entries.next();
				Character character = thisEntry.getKey();
				Dictionary dictionary = thisEntry.getValue();
				stringBuilder.append("\"" + character + "\"" + ":{");
				if (dictionary.wordDes != null) {
					stringBuilder.append("\"wordDes\":" + "\"" + dictionary.wordDes + "\"");
					if (dictionary.map != null) {
						stringBuilder.append(",");
					}
				}
				stringBuilder.append(dictionary + "}");
				if (entries.hasNext()) {
					stringBuilder.append(",");
				}
			}
		}

		return stringBuilder.toString();
	}

}
