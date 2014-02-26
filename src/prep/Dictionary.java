/**
 * Best compression: ((a * hashCode + b) mod p) mod N; -- a, b, p: positive integers; p is large prime; p is much larger than N
 */

package prep;

public class Dictionary {
	public Entry[] buckets;
	
	Dictionary() {
		 this.buckets = new Entry[Word.WORDS + 140000];
	}

	
	public void insert(Word key, Definition value) {
		this.buckets[key.hashCode()] = new Entry(key, value);
	}
	
	public Entry find(Word key) {		
		return this.buckets[key.hashCode()];
	}
	
	public Entry remove(Word key) {		
		Entry chain = this.buckets[key.hashCode()];
		this.buckets[key.hashCode()] = null;
		return chain;
	}
	
	
	
	public static void main(String[] args) {
		Dictionary table = new Dictionary();
		Word w = new Word("a");
		Definition d = new Definition("d");
		table.insert(w, d);
		System.out.println(table.find(new Word("b")).value.definition);
	}
} 

class Entry {
	public Word key;
	public Definition value;
	public Entry next;
	
	Entry(Word key, Definition value, Entry next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}
	
	Entry(Word key, Definition value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}
	
}

class Word {
	public static final int WORDS = 700000;
	public static final int PRIME = 16908799;
	
	public String word;
	 
	Word(String word) {
		this.word = word;
	}
	
	// This is good for strings
	public int hashCode() {
		String key = this.word;
		int hashVal = 0;
		for (int i = 0; i < key.length(); i++) {
			hashVal = (127 * hashVal + key.charAt(i)) % PRIME;
		}
		return hashVal;
	}
}

class Definition {
	public String definition;
	
	Definition(String definition) {
		this.definition = definition;
	}
}