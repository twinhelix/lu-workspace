package HashTable;

import java.util.Stack;

public class HashTable {
	private static final int TABLE_SIZE = 12;
	private HashTableNode<String>[] table;
	private int size;

	@SuppressWarnings("unchecked")
	public HashTable() {
		size = 0;
		table = new HashTableNode[TABLE_SIZE];
	}

	public void addElement(String word) {
		int pos = hashing(word);

		HashTableNode<String> newItem = new HashTableNode<String>(word);
		if (table[pos] == null) {
			table[pos] = newItem;

		} else {
			HashTableNode<String> root = table[pos];

			add(root, newItem);
		}
		size++;
	}

	private HashTableNode<String> add(HashTableNode<String> curr,
			HashTableNode<String> newItem) {
		if (curr == null) {
			curr = newItem;

		} else if (curr.getItem().compareTo(newItem.getItem()) < 0) {
			curr.setRight(add(curr.getRight(), newItem));

		} else if (curr.getItem().compareTo(newItem.getItem()) > 0) {
			curr.setLeft(add(curr.getLeft(), newItem));

		} else {
			curr.setItem(newItem.getItem());
			size--;
		}
		return curr;
	}

	public int getSize() {
		return size;
	}

	public boolean isPresent(String word) {
		int pos = hashing(word);

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
			if (temp.getRight() != null)
				printStack(temp.getRight());
		}
	}
}
