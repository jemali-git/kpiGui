package neuralNetworks;

import java.io.File;

public class Main2 {

	public static void main(String[] args) {
			
		
		Dictionary dictionary = new Dictionary();
		dictionary.addWord("abcd", "abc");
		dictionary.addWord("bcd", "abc");
		dictionary.addWord("abces", "bce");
		// try {
		// PrintStream out = new PrintStream(new
		// FileOutputStream("./neuralNetworks/dictionary.json"));
		// out.print("{" + dictionary + "}");
		// } catch (Exception e) {
		// System.out.println(e.toString());
		// }
		
		//System.out.println(dictionary.getWordDest("abcdsdfv"));
	}
}
