package database;

import java.util.Iterator;

/**
 *  A class offering access procedures for a database of cats
 *  in a cattery and their dietary requirements.
 */
public class Database  {

    private Dictionary<String, Integer> dictionary;

    /**
     * Constructs a new database for use in the Cattery.
     *  
     * @param dictionary dictionary to store information.
     */
    public Database(Dictionary<String,Integer> dictionary) {
    	this.dictionary = dictionary;
    }

    /**
     * If the named cat is not present in the database, adds a fresh entry,
     * in the correct place, with the given name and number of tins.
     * Otherwise, that existing cat has its tins changed to the given value.
     * 
     * @param name name of the cat to be added to the database.
     * @param tins number of tins the named cat eats per week.
     */
    public void add(String name, int tins){
        dictionary.put(name, tins);
    }
    
    /**
     * Returns the total number of cats in the database.
     * 
     * @return number of cats in the database.
     */
    public int countCats() {
        return dictionary.size();
    }

    /**
     * Returns the total number of tins eaten each week by all the cats.
     * 
     * @return total number of tins needed per week by the Cattery.
     */
    public int countTins() {
        int res = 0;

        Iterator<DictionaryEntry<String,Integer>> iterator = dictionary.iterator();
        while(iterator.hasNext()){
            res += iterator.next().getValue(); 
        }
        return res;

    }

    /**
     * If the named cat is present in the database, deletes it.
     * Otherwise leaves the database unchanged.
     * 
     * @param name the name of the cat to be removed from the database.
     */
    public void delete(String name) {
        try{
            dictionary.remove(name);
        }catch(Exception e){
        	//leave the database unchanged
        	System.out.println(name + " not in database.");
        }
        
    }

    /**
     * If the cat is in the database, returns that cat's weekly quota of tins.
     * Otherwise returns -1.
     * 
     * @param name the name of the cat to query
     * @return the number of tins the named cat eats per week. 
     */
    public int lookup(String name) {
    	try{
    		return dictionary.get(name);
    	}
    	catch(Exception e){
    		return -1;
    	}
    }

    /**
     * Displays contents of the database as <Name> [tab] <Tins>
     * (e.g., Tibbles   14), in alphabetical order of cats, one to a line.
     */
    public void printDatabase() {
        Iterator<DictionaryEntry<String,Integer>> iterator = dictionary.iterator();
        DictionaryEntry<String,Integer> tmp;
        while(iterator.hasNext()){
            tmp = iterator.next();
            System.out.println(tmp.getKey() + "\t" + tmp.getValue());
        }
    }

    /**
     * Removes all mappings from this map.
     */
    public void clear(){
    	dictionary.clear();
    }

    /**
     * Return the class name of the concrete ADT implementation.
     * 
     * @return the class-name of the underlying dictionary implementation.
     */
    protected String getDictionaryType(){
    	return dictionary.getClass().getSimpleName();
    }
    

}
