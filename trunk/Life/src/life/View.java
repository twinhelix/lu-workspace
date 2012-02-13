package life;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class View extends JFrame {
	// Declare variables:
	private static View v = null;
	public int rows, turns, interval;
	private boolean running;
	private Timer timer;
	MyListener mylisten;
	ChangeColor changecol;
	// Constants of the Colors
	private final Color CELL_ALIVE1 = Color.red;
	private final Color CELL_ALIVE2 = Color.green;
	private final Color CELL_DEAD = Color.gray;
	// Contents of GUI
	private cellButton[][] cells;
	private JLabel countLabel;
	private JSlider slide;
	private JButton clear, step, run, stop;
	private Box buttons;
	private Model m;

	private View() {
		// Singleton constructor
		super("Life");
	}

	// Singleton get instance if available,
	// else creates one
	public static View getInstance() {
		if (v == null)
			v = new View();
		return v;
	}

	// Initialize all fields
	public void initialize(int rows) {

		this.rows = rows;
		turns = 0;
		interval = 1;
		running = false;
		mylisten = new MyListener();
		changecol = new ChangeColor();
		timer = new Timer(2000, mylisten);
		setSize(rows * 20 + 50, rows * 20 + 100);
		setLayout(new BorderLayout());
		m = Model.getInstance();
		setupGUI();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

	}

	// Setups up all buttons, the cells, the slider and
	// adds them to the content pane.
	private void setupGUI() {
		buttons = new Box(BoxLayout.X_AXIS);
		Container cp = this.getContentPane();

		countLabel = new JLabel("0", SwingConstants.CENTER);
		cp.add(countLabel, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(rows, rows));
		cells = new cellButton[rows][rows];
		initGrid(panel);
		cp.add(panel, BorderLayout.CENTER);

		slide = new JSlider(JSlider.VERTICAL, 1, 10, 1);
		slide.setMajorTickSpacing(2);
		slide.setMinorTickSpacing(1);
		slide.setPaintTicks(true);
		slide.setPaintLabels(true);
		slide.addChangeListener(new ChangeSpeed());

		cp.add(slide, BorderLayout.EAST);

		clear = new JButton("Clear");
		clear.addActionListener(mylisten);
		step = new JButton("step");
		step.addActionListener(mylisten);
		run = new JButton("run");
		run.addActionListener(mylisten);
		stop = new JButton("stop");
		stop.addActionListener(mylisten);

		buttons.add(clear);
		buttons.add(step);
		buttons.add(run);
		buttons.add(stop);
		cp.add(buttons, BorderLayout.SOUTH);

	}

	// Initializes the grid
	private void initGrid(Container container) {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < rows; c++) {
				cells[r][c] = new cellButton(c, r, CELL_DEAD);
				cells[r][c].setBackground(CELL_DEAD);
				cells[r][c].addMouseListener(changecol);

				container.add(cells[r][c]);
			}
		}
	}

	// Clears the board and resets the counter
	private void clear() {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < rows; c++) {
				cells[r][c].setBackground(CELL_DEAD);
				cells[r][c].p.color = CELL_DEAD;
			}
		}
		turns = 0;
		countLabel.setText("0");
		m.clear();
	}

	// Change cell colors when step is called
	public void updateCellColour(PointColor pc) {
		cells[pc.y][pc.x].p = pc;
		cells[pc.y][pc.x].setBackground(pc.color);
	}

	// Updates timer's delay
	private void updateTimer() {
		timer.setInitialDelay(2000 / interval);
		timer.setDelay(2000 / interval);
	}

	// Increments turns and step label
	private void incTurns() {
		turns++;
		countLabel.setText(Integer.toString(turns));
	}

	// Changes state of buttons when running
	private void changeButtons(boolean b) {
		clear.setEnabled(b);
		step.setEnabled(b);
		stop.setEnabled(b);
	}

	// ////////////////////////////////////////////////////
	// -------------------INNER CLASSES----------------- //
	// ////////////////////////////////////////////////////

	// Listener to change the colors of the cells.
	public class ChangeColor extends MouseAdapter {

		public void mouseClicked(MouseEvent event) {
			if (!running) {
				if (event.getSource() instanceof cellButton) {
					cellButton source = (cellButton) event.getSource();
					Color newColour = CELL_DEAD;

					if (SwingUtilities.isLeftMouseButton(event))
						newColour = CELL_ALIVE1;
					else if (SwingUtilities.isRightMouseButton(event))
						newColour = CELL_ALIVE2;

					source.setBackground(newColour);
					source.p.color = newColour;
					m.addPoint(source.p);
				}
			}
		}
	}

	// Listener for the slider to change speed
	public class ChangeSpeed implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			if (e.getSource() instanceof JSlider) {
				JSlider source = (JSlider) e.getSource();
				if (!source.getValueIsAdjusting()) {
					interval = (int) source.getValue();
					updateTimer();
				}
			}
		}
	}

	// Listener for buttons and the timer
	private class MyListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() instanceof Timer) {
				m.step();
				incTurns();
			} else if (e.getSource() instanceof JButton) {
				JButton bt = (JButton) e.getSource();
				if (bt.equals(clear))
					clear();

				else if (bt.equals(step)) {
					m.step();
					incTurns();
				}

				else if (bt.equals(run)) {
					running = !running;
					if (running) {
						run.setText("pause");
						changeButtons(false);
						updateTimer();
						timer.start();
					} else {
						run.setText("run");
						changeButtons(true);
						timer.stop();
					}
				} else if (bt.equals(stop))
					Life.quit();
			}
		}
	}

	// Buttons include their positions too, easier to use.
	private class cellButton extends JButton {
		public PointColor p;

		public cellButton(int x, int y, Color c) {
			super();
			p = new PointColor(x, y, c);
		}
	}
}