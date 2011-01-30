/*
 *  TEST RUNS FOR BinarySearchTree:
 *	load 10			benchmark: 3.3
 *	load 100		benchmark: 7.79
 *	load 1000		benchmark: 12.442
 *	load 10000		benchmark: 16.4793
 */
package database;

import java.util.*;

public class BinarySearchTree<K extends Comparable<K>, V> implements
		Dictionary<K, V> {
	/* Declare variables for tree */
	private int size;
	private BinarySearchTreeEntry<K, V> root;

	/** Constructor */
	public BinarySearchTree() {
		root = null;
		size = 0;
	}

	/** Deletes all nodes in tree */
	public void clear() {
		root = null;
		size = 0;
	}

	/** Get target node */
	public V get(K key) {
		BinarySearchTreeEntry<K, V> temp = root;
		V ret = null;
		K compare = temp.getKey();
		while (temp != null && !key.equals(compare)) {
			if (key.compareTo(compare) < 0)
				temp = temp.getLeftTree();
			else
				temp = temp.getRightTree();
			compare = temp.getKey();
		}
		if (temp != null)
			ret = temp.getValue();
		else
			throw new NullPointerException();
		return ret;
	}

	/** Check if tree is empty by checking root node */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Put a node in the tree by finding its position first If tree is empty,
	 * just put new node as root Else iterate through tree to find where new
	 * node position should be and places it in the empty spot
	 */
	public void put(K key, V value) {
		BinarySearchTreeEntry<K, V> newNode = new BinarySearchTreeEntry<K, V>(
				key, value);
		BinarySearchTreeEntry<K, V> temp = root;

		if (root == null) {
			root = newNode;
		} else {
			boolean added = false;
			while (!added) {
				if (key.compareTo(temp.getKey()) < 0) {
					if (temp.getLeftTree() == null) {
						temp.setLeftTree(newNode);
						added = true;
					} else
						temp = temp.getLeftTree();

				} else {
					if (temp.getRightTree() == null) {
						temp.setRightTree(newNode);
						added = true;
					} else
						temp = temp.getRightTree();
				}
			}
		}
		size++;
	}

	/** Removes a node found by its given key, calls help functions */
	public void remove(K key) {
		if (root == null) {
			throw new NullPointerException();
		} else {
			root = deleteItem(root, key);
			size--;
		}
	}

	/**
	 * Deletes an item from the tree, if not found, throws exception else if
	 * checks where in the tree the node is found using recursion and calls
	 * deleteNode function to remove it from there
	 */
	private BinarySearchTreeEntry<K, V> deleteItem(
			BinarySearchTreeEntry<K, V> node, K key) {

		if (node == null) {
			throw new NoSuchElementException();
		} else {
			if (node.getKey().compareTo(key) == 0) {
				node = deleteNode(node);
			} else if (node.getKey().compareTo(key) > 0) {
				BinarySearchTreeEntry<K, V> newLeft = deleteItem(node
						.getLeftTree(), key);
				node.setLeftTree(newLeft);
			} else {
				BinarySearchTreeEntry<K, V> newRight = deleteItem(node
						.getRightTree(), key);
				node.setRightTree(newRight);
			}
		}
		return node;
	}

	/**
	 * Deletes target node from its position, re-constructs tree using the
	 * leftMostNode method
	 */
	private BinarySearchTreeEntry<K, V> deleteNode(
			BinarySearchTreeEntry<K, V> node) {
		BinarySearchTreeEntry<K, V> ret;

		if (node.getLeftTree() == null && node.getRightTree() == null)
			ret = null;
		else {
			if (node.getLeftTree() != null && node.getRightTree() == null)
				ret = node.getLeftTree();
			else if (node.getLeftTree() == null && node.getRightTree() != null)
				ret = node.getRightTree();
			else {
				ret = leftMostNode(node.getRightTree());
				BinarySearchTreeEntry<K, V> newRightTree = deleteLeftMost(node
						.getRightTree());
				ret.setRightTree(newRightTree);
				ret.setLeftTree(node.getLeftTree());
			}
		}
		return ret;
	}

	/** Finds left most node using recursion */
	private BinarySearchTreeEntry<K, V> leftMostNode(
			BinarySearchTreeEntry<K, V> node) {

		if (node.getLeftTree() == null)
			return null;
		else {
			return leftMostNode(node.getLeftTree());
		}
	}

	/** Deletes the left most node from tree */
	private BinarySearchTreeEntry<K, V> deleteLeftMost(
			BinarySearchTreeEntry<K, V> node) {

		if (node.getLeftTree() == null)
			return node.getRightTree();
		else {
			BinarySearchTreeEntry<K, V> child = deleteLeftMost(node
					.getLeftTree());
			node.setLeftTree(child);
			return node;
		}
	}

	/** Returns size of the tree */
	public int size() {
		return size;
	}

	/** Returns an iterator for the binary search tree */
	public Iterator<DictionaryEntry<K, V>> iterator() {
		return new TreeIterator();
	}

	/** Iterator for binary tree */
	private class TreeIterator implements Iterator<DictionaryEntry<K, V>> {
		/* Declare variables for Iterator */
		Stack<BinarySearchTreeEntry<K, V>> worklist = new Stack<BinarySearchTreeEntry<K, V>>();
		BinarySearchTreeEntry<K, V> pointer = root;

		/** Constructor, sets up stack */
		public TreeIterator() {
			if (pointer != null)
				worklist.push(pointer);
		}

		/** Checks if any more nodes remain in stack */
		public boolean hasNext() {
			return !worklist.isEmpty();
		}

		/** Gets next node, uses stack to store all nodes */
		public DictionaryEntry<K, V> next() {
			BinarySearchTreeEntry<K, V> ret = null;

			while (pointer.getLeftTree() != null) {

				pointer = pointer.getLeftTree();
				worklist.push(pointer);
			}

			if (hasNext()) {
				ret = worklist.pop();
				if (ret.getRightTree() != null) {
					pointer = ret.getRightTree();
					worklist.push(pointer);
				}
			}
			return ret;
		}

		/** Remove not implemented */
		public void remove() {
			// No need to implement method
		}
	}
}
