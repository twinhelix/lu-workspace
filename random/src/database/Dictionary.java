package database;

import java.util.NoSuchElementException;

/**
 * The <code>Dictionary</code> class provides a simplified interface for
 * implementations of abstract data types that map keys to values, with each key
 * being associated to at most one value.
 * <p>
 * Given a <tt>Dictionary</tt> and a key, the associated element can be looked
 * up. Any non-<code>null</code> object can be used as a key and as a value.
 * Keys are <code>Comparable</code> objects.
 * <p>
 * The iterator returns dictionary-entries in ascending order by key.
 * 
 * @param <K>
 *            type for the <i>comparable</i> key element
 * @param <V>
 *            type for the associated value element
 */
public interface Dictionary<K extends Comparable<K>, V> 
extends Iterable<DictionaryEntry<K, V>> {

	/**
	 * Returns the number of key-value Entry objects stored in this dictionary.
	 * 
	 * @return the number of entries in this dictionary.
	 */
	public int size();

	/**
	 * Tests if this Dictionary contains no Entry objects.
	 * 
	 * @return <tt>true</tt> if this dictionary contains no entries,
	 *         <tt>false</tt> otherwise.
	 */
	public boolean isEmpty();

	/**
	 * Returns the value associated with the named key in this dictionary. There
	 * can be at most one value associated with each key.
	 * 
	 * @param key
	 *            the key whose associated value is to be returned.
	 * @return the value mapped on to by the specified key.
	 * 
	 * @throws NoSuchElementException
	 *             if the specified key does not exist in the dictionary.
	 * @throws NullPointerException
	 *             if this dictionary does not permit <tt>null</tt> keys or
	 *             values, and the specified key or value is <tt>null</tt>.
	 *             (optional)
	 */
	public V get(K key);

	/**
	 * Creates a dictionary entry associating the named key with the specified
	 * value. If the dictionary previously contained an entry for this key, the
	 * old value is updated with the specified value.
	 * 
	 * @param key
	 *            the key with which the specified value is to be associated.
	 * @param value
	 *            the value to be associated with the specified key.
	 * 
	 * @throws NullPointerException
	 *             if this dictionary does not permit <tt>null</tt> keys or
	 *             values, and the specified key or value is <tt>null</tt>.
	 *             (optional)
	 */
	public void put(K key, V value);

	/**
	 * Removes the entry with the named key from this dictionary if it is present.
	 * 
	 * @param key
	 *            the key whose entry is to be removed from the dictionary.
	 * 
	 * @throws NullPointerException
	 *             if this dictioanry does not permit <tt>null</tt> keys and
	 *             the specified key is <tt>null</tt>. (optional)
	 * @throws NoSuchElementException
	 *             if no entry existed in the dictionary for the named key.
	 *             (optional)
	 */
	public void remove(K key);

	/**
	 * Removes all entries from this dictionary.
	 */
	public void clear();

}
