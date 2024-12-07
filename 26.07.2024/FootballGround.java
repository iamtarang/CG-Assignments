import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class FootballGround extends JComponent {
	private int width;
	private int height;

	// Constructor
	public FootballGround(int w, int h) {
		width = w;
		height = h;
	}

	// Method to draw the field
	private void drawField(Graphics2D g2d) {
		// Draw the outer rectangle
		Rectangle2D.Double rect = new Rectangle2D.Double(0, 0, width, height);
		g2d.setColor(new Color(55, 191, 34));
		g2d.fill(rect);
	}

	// Method to draw the mid Circle
	private void drawEllipse(Graphics2D g2d) {
		Ellipse2D.Double midCircle = new Ellipse2D.Double(275, 180, 70, 70);
		g2d.setColor(Color.WHITE);
		g2d.setStroke(new BasicStroke(5)); 
		g2d.draw(midCircle);
	}

	// Method to draw mid Line
	private void drawMidline(Graphics2D g2d) {
		Line2D.Double line = new Line2D.Double(310, 40, 310, 400);
		g2d.setColor(Color.WHITE);
		g2d.draw(line);
	}

	// Method to draw the boundary
	private void drawBoundary(Graphics2D g2d) {
		Rectangle2D.Double boundary = new Rectangle2D.Double(30, 40, 560, 360);
		g2d.setColor(Color.WHITE);
		g2d.setStroke(new BasicStroke(5));
		g2d.draw(boundary);
	}
	
	// Method to draw the brackets
	private void drawBrackets(Graphics2D g2d) {
		Rectangle2D.Double innerBracL = new Rectangle2D.Double(30, 160, 40, 120);
		Rectangle2D.Double OuterBracL = new Rectangle2D.Double(30, 120, 80, 200);
		Rectangle2D.Double GoalBracL = new Rectangle2D.Double(10, 185, 20, 70);

		Rectangle2D.Double innerBracR = new Rectangle2D.Double(550, 160, 40, 120);
		Rectangle2D.Double OuterBracR = new Rectangle2D.Double(510, 120, 80, 200);
		Rectangle2D.Double GoalBracR = new Rectangle2D.Double(590, 185, 20, 70);
		g2d.setColor(Color.WHITE);
		g2d.setStroke(new BasicStroke(5)); 
		g2d.draw(innerBracL);
		g2d.draw(OuterBracL);
		g2d.draw(GoalBracL);

		g2d.draw(innerBracR);
		g2d.draw(OuterBracR);
		g2d.draw(GoalBracR);
	}

	private void drawArcs(Graphics2D g2d){
		Arc2D.Double leftArc = new Arc2D.Double(70, 160, 80, 120, 270, 180, Arc2D.OPEN);
		Arc2D.Double rightArc = new Arc2D.Double(470, 160, 80, 120, 90, 180, Arc2D.OPEN);
		g2d.setColor(Color.WHITE);
		g2d.setStroke(new BasicStroke(5)); // Adjust thickness here
		g2d.draw(leftArc);
		g2d.draw(rightArc);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		// Enable anti-aliasing for better rendering
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHints(rh);

		drawField(g2d);
		drawEllipse(g2d);
		drawBoundary(g2d);
		drawMidline(g2d);
		drawBrackets(g2d);
		drawArcs(g2d);
	}

	public static void main(String[] args) {
		int w = 640;
		int h = 480;

		JFrame frame = new JFrame();
		FootballGround cGround = new FootballGround(w, h);

		frame.setSize(w, h);
		frame.setTitle("Football Ground in Java");
		frame.add(cGround);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
