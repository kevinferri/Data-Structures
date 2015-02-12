package prep;

public class HashTable {
  
  private int length;
  
  private static class Entry {
    String key;
    String value;
    Entry next;
    
    Entry(String key, String value, Entry next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }
    
  }
    
  
  public static Entry[] table;
  private int entries;
  
  HashTable() {
    table = new Entry[64];
    this.length = 64;
  }
  
  HashTable(int initialSize) {
    table = new Entry[initialSize];
    this.length = initialSize;
  }
  
  // This is only if we know the key will be a string
  private static int hash(String key) {
    int hashVal = 0;
    for (int i = 0; i < key.length(); i++) {
      hashVal = ((127 * hashVal + key.charAt(i)) % 16908799) % table.length;
    }
    return hashVal;
  }
  
  public void insert(String key, String value) {
    if (key == null) return;
    
    int bucket = hash(key);
    
    // Check if the key has been used already
    while(table[bucket] != null) {
      if (table[bucket].key.equals(key)) {
        break;
      }
      // Collision! create a chain
      table[bucket] = table[bucket].next;
    }
    
    if (table[bucket] != null) {
      // It has been set already, update with newest insert
      table[bucket].value = value;
    } else {
      table[bucket] = new Entry(key, value, table[bucket]);
      entries++;
    }
  }
  
  public String find(String key) {
    int bucket = hash(key);
    
    Entry chain = table[bucket];
    while (chain != null) {
      if (chain.key.equals(key)) {
        return chain.value;
      }
      chain = chain.next;
    }
    return null;
  }
  
  public void remove(String key) {
    int bucket = hash(key);
    
    if (table[bucket] == null) {
      return;
    }
    
    if (table[bucket].key.equals(key)) {
      // If the key is in the first node on the list, then table[bucket] must be changed to elimnate the first node from the list
      table[bucket] = table[bucket].next;
      entries--;
      return;
    }
    
    // We have to remove a node from somewhere in the middle of the list, or at the end. Use a pointer to traverse the chain, looking for an entry that contains the specified key, and remove it if it is found
    // The node that precedes curr in the list. Prev.next is always equal to curr.
    Entry prev = table[bucket];
    Entry curr = prev.next;
    
    while (curr != null && curr.key.equals(key)) {
      curr = curr.next;
      prev = curr;
    }
    
    // If we get to this point, the either curr is null or curr.key is equal to key.
    
    if (curr != null) {
      prev.next = curr.next;
      entries--;
    }
  }
  
  public int size() {
    return entries;
  }
  
  public static void main(String[] args) {
  }
  
}
