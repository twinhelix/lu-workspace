package pico;

// 

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

// 

public class Symbols {
    private int currentLevel;
    private int maxLevel;
    private int count;
    private final List<Integer> stack;
    private final int globalLevel = 0;
    private final String globalScope = "_";
    private final Map<String, Scopes> map;

    public Symbols() {
        map = new Hashtable<String, Scopes>();
        stack = new ArrayList<Integer>();
        currentLevel = globalLevel;
        maxLevel = globalLevel;
        count = 0;
    }

    public boolean isGlobal() {
        return currentLevel == globalLevel;
    }
 
    private String currentScope() {
        final StringBuffer loc = new StringBuffer(globalScope);

        for (int i = 0; i < currentLevel; i++) {
            loc.append(count);
            loc.append(stack.get(i));
        }

        return loc.toString();
    }

    public boolean declare(final String name) {
        // returns false if the variable is already defined
        // in the current scope
        if (map.containsKey(name)) {
            // which scopeList are the name defined in
            final Scopes scopes = map.get(name);

            if (scopes.contains(currentScope())) {
                // Already declared in this scope
                return false;
            } else {
                scopes.add(currentScope());
            }
        } else {
            // The name is not in the program
            map.put(name, new Scopes(currentScope()));
        } 

        return true;
    }


    public void dumpTable() {
        // print the table
        for (String name : map.keySet()) {
            System.err.println(name);

            for (String pref : (map.get(name)).scopeList) {
                System.err.print(" " + pref + name);
            }

            System.err.println();
        }
    }


    public boolean isVisible(final String name) {
        final Scopes where = map.get(name);

        return (where != null) && (where.visible(currentScope()) != null);
    }

    public String getFullName(final String name) {
        /*
         * Purpose to give  a unique name for a variable used in the current scope  
         * find the scope it was declared in as a string and use a prefix to given name 
         */
        final Scopes where = map.get(name);

        if (where == null) {
            System.err.println(name + " is not in the symbol table");
            dumpTable();
            System.exit(3);

            // maybe it is already the result of getFullName
        }

        final String prefix = where.visible(currentScope());

        return prefix + name;
    }


    public void pushScope() {
        if (currentLevel == maxLevel) {
            stack.add(count);
            count = 0;
            currentLevel++;
            maxLevel++;
        } else {
            stack.set(currentLevel, count);
            currentLevel++;
            count = stack.get(currentLevel) + 1;
        }
    }

    public void popScope() {
        assert (currentLevel > 0);

        if (currentLevel == stack.size()) {
            stack.add(count);
        } else {
            stack.set(currentLevel, count);
        }

        currentLevel--;
        count = stack.get(currentLevel);
    }

    /*
     * A symbol can be declared in one or more scopeList for each symbol there
     * is a list of scopeList containing it search starts in the current scope
     * and looks in parent until reaching the top: global variables
     */
    class Scopes {
        final private List<String> scopeList;

        Scopes(String here) {
            scopeList = new ArrayList<String>();
            scopeList.add(here);
        }

        private boolean contains(final String aScope) {
            return scopeList.contains(aScope);
        }

        private String parent(final String aScope) {
            return aScope.substring(0, aScope.length() - 2);
        }

        private String visible(final String aScope) {
            String found = aScope;

            while (found.length() > 0) {
                if (scopeList.contains(found)) {
                    return found;
                } else {
                    found = parent(found);
                }
            }

            return aScope;
        }

        private void add(final String scope) {
            scopeList.add(scope);
        }
    }
}
