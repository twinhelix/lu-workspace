import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

public class ADTS {
	private Node<String> root = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));

	public ADTS() throws IOException {
		System.err.println("ENTER OPTION: ");
		String s = br.readLine();
		add("g", "6");
		add("c", "3");
		add("b", "2");
		add("a", "1");
		add("q", "123");
		add("m", "13");
		add("h", "2");
		Method[] commands = ADTS.class.getDeclaredMethods();
		while (!s.equals("quit")) {
			if (s.equals("add")) {
				add(br.readLine(), br.readLine());
			} else if (s.equals("print"))
				print(root);
			else if (s.equals("search")) {
				Node<String> hi = search(root, br.readLine());
				if (hi != null)
					System.out.println(hi.getValue());
				else
					System.err.println("ERROR");
			}

			else if (s.equals("remove"))
				root = remove(root, br.readLine());
			else
				System.err.println("WRONG CHOICE!!! ");
			System.err.println("ENTER OPTION: ");
			s = br.readLine();
		}

	}

	public void add(String k, String v) throws IOException {

		Node<String> first = new Node<String>(k, v);
		if (root == null) {
			root = first;
		} else
			put(root, first);

	}

	private Node<String> put(Node<String> it, Node<String> item) {
		if (it == null) {
			it = item;

		} else if (it.getKey().equals(item.getKey())) {
			it = item;
		} else if (it.getKey().compareTo(item.getKey()) < 0) {
			it.setRight(put(it.getRight(), item));
		} else {
			it.setLeft(put(it.getLeft(), item));
		}
		return it;
	}

	public void print(Node<String> p) {
		if (p != null) {
			print(p.getLeft());
			System.out.println(p.getKey() + " " + p.getValue());
			print(p.getRight());
		}
	}

	public void isEmpty() {
		System.out.println(root == null);
	}

	public Node<String> search(Node<String> item, String k) {
		if (item != null) {
			if (item.getKey().equals(k))
				return item;
			else if (item.getKey().compareTo(k) < 0)
				return search(item.getRight(), k);
			else
				return search(item.getLeft(), k);
		} else
			return null;
	}

	public Node<String> remove(Node<String>temp, String k) {
		
		if (temp == null){
			throw new NoSuchElementException("WTF");
		}
		else {
			if (temp.getKey().equals(k))
				temp = delete(temp);
			else if (temp.getKey().compareTo(k) > 0) {
				Node<String> newLeft = remove(temp.getLeft(), k);
				temp.setLeft(newLeft);
			} else {
				Node<String> newRight = remove(temp.getRight(), k);
				temp.setRight(newRight);
			}
		}
		
		return temp;
	}

	private Node<String> delete(Node<String> del) {
		if (del.getLeft() == null && del.getRight() ==null)
			return null;
		else if (del.getLeft() != null && del.getRight() ==null)
			return del.getLeft();
		else if (del.getLeft() == null && del.getRight() !=null)
			return del.getRight();
		else {
			Node<String> temp = findleftmost(del.getRight());
			Node<String> newRight = deleteleftmost (del.getRight());
			temp.setRight(newRight);
			temp.setLeft(del.getLeft());
			return temp;
		}
	}
	
	private Node<String> findleftmost(Node<String> n){
		
		if (n.getLeft()==null){
			return n;
		}else {
			return findleftmost (n.getLeft());
		}
	}
	private Node<String> deleteleftmost(Node<String> n){
	
		if (n.getLeft() == null)
			return n.getRight();
		else {
			Node<String> newkid = deleteleftmost(n.getLeft());
			n.setLeft(newkid);
			return n;
		}
	}
	public static void main(String[] args) throws IOException {
		new ADTS();
	}

}
