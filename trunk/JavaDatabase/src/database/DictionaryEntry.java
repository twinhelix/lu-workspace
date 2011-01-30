package database;

public interface DictionaryEntry<K, V> {

	/**
	 * Access method for the key corresponding to this entry.
	 * 
	 * @return the key corresponding to this entry.
	 */
	public K getKey();

	/**
	 * Access method for the associated value corresponding to this entry.
	 * 
	 * @return the value corresponding to this entry.
	 */
	public V getValue();
}
