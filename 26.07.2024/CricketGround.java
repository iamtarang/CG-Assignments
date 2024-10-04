import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class CricketGround extends JComponent {
	private int width;
	private int height;

	// Constructor
	public CricketGround(int w, int h) {
		width = w;
		height = h;
	}

	// Method to draw the field
	private void drawField(Graphics2D g2d) {
		// Draw the outer rectangle
		Rectangle2D.Double rect = new Rectangle2D.Double(0, 0, width, height);
		g2d.setColor(new Color(100, 149, 237));
		g2d.fill(rect);
	}

	// Method to draw the ellipse
	private void drawEllipse(Graphics2D g2d) {
		Ellipse2D.Double ellipse = new Ellipse2D.Double(10, 10, width - (width / 6), height - (height / 8));
		g2d.setColor(Color.GREEN);
		g2d.fill(ellipse);
	}

	// Method to draw the boundary
	private void drawBoundary(Graphics2D g2d) {
		Ellipse2D.Double boundary = new Ellipse2D.Double(35, 40, width - (width / 4), height - (height / 4));
		g2d.setColor(Color.WHITE);
		g2d.setStroke(new BasicStroke(5)); // Adjust thickness here
		g2d.draw(boundary);
	}

	// Method to draw the pitch
	private void drawPitch(Graphics2D g2d) {
		double pitchWidth = width / 3.2;
		double pitchHeight = height / 8.0;
		double pitchX = (width - pitchWidth) / 2;
		double pitchY = (height - pitchHeight) / 2;

		Rectangle2D.Double pitch = new Rectangle2D.Double(pitchX - 30, pitchY - 10, pitchWidth, pitchHeight);
		g2d.setColor(Color.GRAY);
		g2d.fill(pitch);
	}

	// * Method to draw the wickets
	// private void drawWickets(Graphics2D g2d) {
	// g2d.setColor(Color.WHITE);
	// double wicketWidth = width / 100.0;
	// double wicketHeight = height / 15.0;

	// // Wickets at the top
	// for (int i = 0; i < 3; i++) {
	// double x = (width / 2.0) - wicketWidth + (i * (wicketWidth + 10));
	// double y = (height / 2.0) - (height / 16.0) - wicketHeight;
	// g2d.fill(new Rectangle2D.Double(x, y, wicketWidth, wicketHeight));
	// }

	// // Wickets at the bottom
	// for (int i = 0; i < 3; i++) {
	// double x = (width / 2.0) - wicketWidth + (i * (wicketWidth + 10));
	// double y = (height / 2.0) + (height / 16.0);
	// g2d.fill(new Rectangle2D.Double(x, y, wicketWidth, wicketHeight));
	// }
	// }

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		// Enable anti-aliasing for better rendering
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHints(rh);

		drawField(g2d);
		drawEllipse(g2d);
		drawBoundary(g2d);
		drawPitch(g2d);
		// drawWickets(g2d);
	}

	public static void main(String[] args) {
		int w = 640;
		int h = 480;

		JFrame frame = new JFrame();
		CricketGround cGround = new CricketGround(w, h);

		frame.setSize(w, h);
		frame.setTitle("Cricket Ground in Java");
		frame.add(cGround);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
