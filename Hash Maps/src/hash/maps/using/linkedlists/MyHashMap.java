package hash.maps.using.linkedlists;

public class MyHashMap {

	public static void main(String[] args) {
		System.out.println("Welcome to Hash table data structure!\n");
		String paragraph = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
		
		LinkedHashMap<String, Integer> hashMap = new LinkedHashMap<>();
		String[] words = paragraph.toLowerCase().split(" ");
		
		for (String word : words) {
			Integer value = hashMap.get(word);
			if (value == null)
				value = 1;
			else
				value = value + 1;
			hashMap.add(word, value);
		}
		
		System.out.println(hashMap);
		System.out.println();
		for (String word : words) {
			int frequency = hashMap.get(word);
			System.out.println("Frequency of '" + word + "' : \t" + frequency);
		}
		
		System.out.println("\nHashMap after removing the word 'avoidable' : \n");
		hashMap.remove("avoidable");
		System.out.println(hashMap);
	}
}
