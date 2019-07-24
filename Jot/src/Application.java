
public class Application {
	public static void main(String[] args) {
		boolean genNoun = false;
		int adjectives = 0;
		String result = new String();

		if (args.length == 1) {
			genNoun = true;
			adjectives = Integer.parseInt(args[0]) - 1;
		} else if (args.length != 2) {
			System.err.println("Unknown arguments, use: [number] [noun]<optional>");
			return;
		}
		
		new JotWindow("Jot", 400, 450);

		// if 2 arguments passed
		if (!genNoun) {
			adjectives = Integer.parseInt(args[0]);
		}

		JotDictionary dict = new JotDictionary("adjectives.txt");

		// adjectives
		result = result.concat(dict.genWords(adjectives));

		// nouns
		if (genNoun) {
			dict = new JotDictionary("nouns.txt");
			result = result.concat(dict.genWords(1));
		} else {
			result = result.concat(args[1]);
		}
		
		System.out.println("\n--- Name: " + result);
	}
}