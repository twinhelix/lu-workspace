package hashtable;

import java.util.Stack;

public class HashTable implements HashTableInterface {
	private int uses;
	private int internal;
	private HashTableNode<String>[] table;

	@SuppressWarnings("unchecked")
	public HashTable() {
		uses = 0;
		internal = 0;
		table = new HashTableNode[HASHTABLE_SIZE];
	}

	public void addWord(String word) {
		int pos = hashing(word);
		uses++;
		HashTableNode<String> newItem = new HashTableNode<String>(word);
		if (table[pos] == null) {
			table[pos] = newItem;
			internal++;
		} else {
			HashTableNode<String> root = table[pos];
			internal++;
			add(root, newItem);
		}
	}

	private HashTableNode<String> add(HashTableNode<String> curr,
			HashTableNode<String> newItem) {
		if (curr == null) {
			curr = newItem;
			internal++;
		} else if (curr.getItem().compareTo(newItem.getItem()) < 0) {
			curr.setRight(add(curr.getRight(), newItem));
			internal++;
		} else if (curr.getItem().compareTo(newItem.getItem()) > 0) {
			curr.setLeft(add(curr.getLeft(), newItem));
			internal++;
		} else {
			curr.setItem(newItem.getItem());
			internal++;
		}
		return curr;
	}

	public int howManyInternalNodeOperations() {
		return internal;
	}

	public int howManyUsages() {
		return uses;
	}

	public boolean isWordPresent(String word) {
		int pos = hashing(word);
		uses++;
		boolean found = false;
		HashTableNode<String> curr = table[pos];
		while (curr != null && !found) {
			if (curr.getItem().compareTo(word) < 0)
				curr = curr.getRight();
			else if (curr.getItem().compareTo(word) > 0)
				curr = curr.getLeft();
			else
				found = true;
		}
		return found;
	}

	private int hashing(String word) {
		word = word.toLowerCase();
		int total = 0;
		char[] letters = word.toCharArray();
		for (int i = 0; i < letters.length; i++)
			total = total + (int) letters[i];
		return total % 13;
	}

	public void print() {
		for (int i = 0; i < table.length; i++) {
			HashTableNode<String> curr = table[i];
			System.out.print(i + " : ");
			printStack(curr);
			System.out.println();
		}
	}

	private void printStack(HashTableNode<String> curr) {
		Stack<HashTableNode<String>> worklist = new Stack<HashTableNode<String>>();
		while (curr != null) {
			worklist.push(curr);
			curr = curr.getLeft();
		}
		
		if (!worklist.isEmpty()) {
			HashTableNode<String> temp = worklist.pop();
			System.out.print(temp.getItem() + " ");			
			if (temp.getRight()!=null)
				printStack(temp.getRight());
		}
	}
}
