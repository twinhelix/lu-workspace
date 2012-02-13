package Tree;

import java.util.*;

import com.sun.xml.internal.messaging.saaj.soap.impl.TreeException;

public class BinarySearchTree<K extends Comparable<K>, V> {
	private TreeNode<K, V> root;
	private int size;

	public BinarySearchTree() {
		root = null;
		size = 0;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public int getSize() {
		return size;
	}

	public void insert(K key, V value) {
		TreeNode<K, V> newItem = new TreeNode<K, V>(key, value);
		if (root == null) {
			root = newItem;
			size++;
		} else {
			root = insertNode(root, key, value);
			size++;
		}
	}

	private TreeNode<K, V> insertNode(TreeNode<K, V> node, K key, V value) {
		if (node == null)
			node = new TreeNode<K, V>(key, value);
		else if (node.getKey().compareTo(key) < 0)
			node.setRight(insertNode(node.getRight(), key, value));
		else if (node.getKey().compareTo(key) > 0)
			node.setLeft(insertNode(node.getLeft(), key, value));
		else {
			node.setValue(value);
			size--;
		}

		return node;
	}

	public void delete(K key) {
		if (isEmpty()) {
			throw new TreeException("Empty Tree");
		}

		else {
			root = deleteNode(root, key);
		}
	}

	private TreeNode<K, V> deleteNode(TreeNode<K, V> node, K key) {
		if (node == null) {
			throw new TreeException("Node not found");
		} else if (node.getKey().compareTo(key) == 0)
			node = deleteItem(node);
		else {
			if (node.getKey().compareTo(key) < 0) {
				TreeNode<K, V> newRight = deleteNode(node.getRight(), key);
				node.setRight(newRight);
			} else {
				TreeNode<K, V> newLeft = deleteNode(node.getLeft(), key);
				node.setLeft(newLeft);
			}
		}

		return node;
	}

	private TreeNode<K, V> deleteItem(TreeNode<K, V> node) {
		if (node.getLeft() == null && node.getRight() == null)
			node = null;

		else if (node.getLeft() != null && node.getRight() == null)
			node = node.getLeft();

		else if (node.getRight() != null && node.getLeft() == null)
			node = node.getRight();
		else {
			TreeNode<K, V> newNode = findLeftMost(node.getRight());
			newNode.setRight(deleteLeftMost(node.getRight()));
			newNode.setLeft(node.getLeft());
			node = newNode;
		}
		return node;
	}

	private TreeNode<K, V> findLeftMost(TreeNode<K, V> node) {
		while (node.getLeft() != null)
			node = node.getLeft();
		return node;
	}

	private TreeNode<K, V> deleteLeftMost(TreeNode<K, V> node) {
		if (node.getLeft() == null)
			node = node.getRight();
		else
			node.setLeft(deleteLeftMost(node.getLeft()));

		return node;
	}

	public V retrieve(K key) {
		TreeNode<K, V> curr = root;
		while (curr != null && curr.getKey().compareTo(key) != 0) {
			if (curr.getKey().compareTo(key) < 0)
				curr = curr.getRight();
			else
				curr = curr.getLeft();
		}
		if (curr != null)
			return curr.getValue();
		else
			return null;
	}

	public Iterator<TreeNode<K, V>> iterator() {
		return new TreeIterator();
	}

	private class TreeIterator implements Iterator<TreeNode<K, V>> {
		TreeNode<K, V> curr;
		Stack<TreeNode<K, V>> stack;

		public TreeIterator() {
			curr = root;
			stack = new Stack<TreeNode<K, V>>();

		}

		public boolean hasNext() {
			return !stack.isEmpty() || curr != null;
		}

		public TreeNode<K, V> next() {

			while (curr != null) {
				stack.push(curr);
				curr = curr.getLeft();
			}

			if (hasNext()) {

				if (stack.peek().getRight() != null) {
					curr = stack.peek().getRight();
				}
			}
			return stack.pop();
		}

		public void remove() {
			// TODO Auto-generated method stub

		}
	}

}
