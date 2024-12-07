import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bresenham extends JPanel {

	private int x1, y1, x2, y2;
	private boolean drawLine = false;

	public Bresenham() {
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
			drawBresenhamLine(g2d, x1, y1, x2, y2);
		}
	}

	private void drawBresenhamLine(Graphics2D g, int x1, int y1, int x2, int y2) {
		int dx = Math.abs(x2 - x1);
		int dy = Math.abs(y2 - y1);
		int sx = x1 < x2 ? 1 : -1;
		int sy = y1 < y2 ? 1 : -1;
		int err = dx - dy;
		int e2;

		while (true) {
			g.drawLine(x1, y1, x1, y1); // Drawing a single point

			if (x1 == x2 && y1 == y2)
				break;
			e2 = 2 * err;
			if (e2 > -dy) {
				err -= dy;
				x1 += sx;
			}
			if (e2 < dx) {
				err += dx;
				y1 += sy;
			}
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Bresenham Line Drawing with Central Origin");
		Bresenham panel = new Bresenham();
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
