import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		
		//reversing a string builder, but reversing String is not possible with built-in method
		StringBuilder string1 = new StringBuilder("Mengistu Redae");
		String string2 = string1.reverse().toString();
		String string3 = "raceCar";
		
		//wrong palendirome checking way
		System.out.println("Wrong way: " + string1.reverse().equals(string1));
		System.out.println("Not good for interview: " + string1.equals(string2));
		//correct codding
		System.out.println("Traditional: " + palinderomeCheckTraditional(string1.toString()));
		System.out.println("Using streams: " + palinderomeCheckStreams(string1.toString()));
		System.out.println("Using streams: " + palinderomeCheckStreams(string2));
		
		//number of vowels and consonants
		findNumberOfVowelsAndConsonantsTraditional(string1.toString());
		findNumberOfVowelsAndConsonantsStreams(string1.toString());
	}

	private static boolean palinderomeCheckTraditional(String str) {
		//normalize string
		String normalized = str.toLowerCase();
		//reverse string using stringBuilder or for loop
		StringBuilder reversed = new StringBuilder();
		for(char c: normalized.toCharArray())
			reversed.append(c);
		
		//check equality
		normalized.equals(reversed);
		return true;
	}
	
	private static boolean palinderomeCheckStreams(String str) {
		String normalized = str.toLowerCase();
		
		//IntStream.range() --- Returns a sequential ordered IntStream from 
		//startInclusive(inclusive) to endExclusive (exclusive) by an incremental step of 1.
		return IntStream.range(0, normalized.length()/2)
				.allMatch(i -> normalized.charAt(i) == 
					normalized.charAt(normalized.length()-1-i));
	}
	
	private static void findNumberOfVowelsAndConsonantsTraditional(String str) {
		if(str == null || str.isEmpty())
			return;
		
		String volwels = "aeiouy";
		char[] normalized = str.toLowerCase().trim().toCharArray();
		int numVowels = 0;
		int numConsonants = 0;
		for(char c : normalized) {
			if(volwels.indexOf(c) != -1)
				numVowels++;
			else if(Character.isAlphabetic(c))
				numConsonants++;
		}
		
		System.out.println(numVowels + " vowels : " + numConsonants + " consonants");
	}
	
	private static void findNumberOfVowelsAndConsonantsStreams(String str) {
		String vowels = "aeiouy";
		//String normalized = str.toLowerCase().trim();
		
		List<Integer> letters = str.chars() 
				.filter(Character::isAlphabetic)
				.map(c->Character.toLowerCase(c))
				.boxed()
				.collect(Collectors.toList());
		
		long noVowels = letters.stream()
				.filter(c -> vowels.indexOf(c) != -1)
				.count();
		
		long noConsonants = letters.size() - noVowels;
		
		System.out.println(noVowels + " vowels : " + noConsonants + " consonants");
	}
	
}
