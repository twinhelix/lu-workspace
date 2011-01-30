package hashtable;

/**
 * HashTableInterface.java: interface class offering access procedures for a
 * hash table.
 * 
 * Note that the hash table itself never appears as a parameter to any of the
 * access procedures; rather, it is an encapsulated variable, declared and
 * initialized in the implementation class (HashTable.java).
 */
public interface HashTableInterface {

	/** Number of buckets allowed */
	public static final int HASHTABLE_SIZE = 13;

	/**
	 * Adds the given word to the hash table in an appropriate location, as
	 * determined by a hashing function. To be precise, it's the word converted
	 * to all lower case that's added, to make usage of the hash table
	 * case-insensitive.
	 * 
	 * @param word a new word to add to hash table
	 */
	public void addWord(String word);

	/**
	 * Returns whether the given word is present in the hash table. Again, it's
	 * actually the word converted to all lower case that's checked, to make
	 * usage of the hash table case-insensitive.
	 * 
	 * @param word
	 *            the word to search for in the hash-table
	 * 
	 * @return <tt>true</tt> if the word is present in the hashtable,
	 *         <tt>false</tt> otherwise.
	 */
	public boolean isWordPresent(String word);

	/**
	 * Returns the total number of calls to AddWord() or IsWordPresent() made so
	 * far in the lifetime of the hash table.
	 * 
	 * @return the total number of calls made to addWord() or isWordPresent().
	 */
	public int howManyUsages();

	/**
	 * Returns the total number of internal node operations (inspection of an
	 * existing node or creation of a new one) performed so far in the lifetime
	 * of the hash table.
	 * 
	 * @return the total number of node operations made since creation of the
	 *         hashtable.
	 */
	public int howManyInternalNodeOperations();

}
