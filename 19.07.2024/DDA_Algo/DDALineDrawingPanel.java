package DDA_Algo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DDALineDrawingPanel extends JPanel {
	private int x1, y1, x2, y2;
	private boolean drawLine = false;

	public DDALineDrawingPanel() {
		setPreferredSize(new Dimension(800, 600));
	}

	public void setLineCoordinates(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		drawLine = true;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, getWidth(), getHeight());

		g2d.setColor(Color.WHITE);

		// Draw axes
		g2d.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2); // X-axis
		g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight()); // Y-axis

		if (drawLine) {
			drawDDALine(g2d, x1, y1, x2, y2);
		}
	}

	private void drawDDALine(Graphics2D g, int x1, int y1, int x2, int y2) {
		// Translate coordinates to central origin
		int translatedX1 = getWidth() / 2 + x1;
		int translatedY1 = getHeight() / 2 - y1;
		int translatedX2 = getWidth() / 2 + x2;
		int translatedY2 = getHeight() / 2 - y2;

		// Calculate dx and dy
		int dx = translatedX2 - translatedX1;
		int dy = translatedY2 - translatedY1;

		// Calculate the number of steps
		int steps = Math.max(Math.abs(dx), Math.abs(dy));

		// Calculate increment in x & y for each step
		float xIncrement = (float) dx / steps;
		float yIncrement = (float) dy / steps;

		// Initialize starting point
		float x = translatedX1;
		float y = translatedY1;

		// Draw the line
		for (int i = 0; i <= steps; i++) {
			g.drawLine(Math.round(x), Math.round(y), Math.round(x), Math.round(y));
			x += xIncrement;
			y += yIncrement;
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("DDA Line Drawing with Central Origin");
		DDALineDrawingPanel panel = new DDALineDrawingPanel();
		frame.add(panel, BorderLayout.CENTER);

		JPanel controlPanel = new JPanel();
		JTextField x1Field = new JTextField(5);
		JTextField y1Field = new JTextField(5);
		JTextField x2Field = new JTextField(5);
		JTextField y2Field = new JTextField(5);
		JButton drawButton = new JButton("Draw Line");

		controlPanel.add(new JLabel("X1:"));
		controlPanel.add(x1Field);
		controlPanel.add(new JLabel("Y1:"));
		controlPanel.add(y1Field);
		controlPanel.add(new JLabel("X2:"));
		controlPanel.add(x2Field);
		controlPanel.add(new JLabel("Y2:"));
		controlPanel.add(y2Field);
		controlPanel.add(drawButton);

		drawButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int x1 = Integer.parseInt(x1Field.getText());
				int y1 = Integer.parseInt(y1Field.getText());
				int x2 = Integer.parseInt(x2Field.getText());
				int y2 = Integer.parseInt(y2Field.getText());
				panel.setLineCoordinates(x1, y1, x2, y2);
			}
		});

		frame.add(controlPanel, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
