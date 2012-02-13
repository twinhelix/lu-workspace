import java.util.*;
import turtleSupport.*;
import java.io.*;

public class TurtleInterpreter {
	public List<Turtle> turtles = new LinkedList<Turtle>();

	Paper p = new Paper(0, 0);

	public static void main(String[] args) {
		TurtleInterpreter t = new TurtleInterpreter();
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String word = sc.next();
			if (word.equals("paper"))
				t.paper(sc.nextInt(), sc.nextInt());
			else if (word.equals("new"))
				t.newTurtle(sc.next(), sc.next(), sc.nextInt(), sc.nextInt());
			else if (word.equals("pen"))
				t.pen(sc.next(), sc.next());
		}
		System.out.println(t.find("bob"));
		t.show();

	}

	public void paper(int height, int width) {
		p.setField(height, width);
		ListIterator<Turtle> it = turtles.listIterator(0);
		while (it.hasNext()) {
			it.next().setXpos(0);
			it.next().setYpos(0);
			it.next().setFace(4);
		}
	}

	public void newTurtle(String type, String name, int xpos, int ypos) {
		Turtle tt = null;

		if (type.equals("bouncy") || type.equals("continuous")
				|| type.equals("reflecting ") || type.equals("wrapping ")) {
			tt = new Turtle(name, false, '*', xpos, ypos, 0, type);
		} else
			tt = new Turtle(name, false, '*', xpos, ypos, 0, type);
		turtles.add(tt);

	}

	public int find(String name) {
		int posi = -1;
		ListIterator<Turtle> it = turtles.listIterator(0);
		while (it.hasNext()) {
			if (name.equals(it.next().getName()))
				posi = it.nextIndex();
		}
		return posi - 1;
	}

	public void show() {
		ListIterator<Turtle> it = turtles.listIterator(0);
		while (it.hasNext()) {
			System.out.println(it.next().getName());
		}
	}

	public void pen(String name, String state) {
		if (state.equals("up")) {

		}

	}
} // end of TurtleInterpreter class
