import java.awt.*; //* for color and graphics
import java.awt.geom.*; //* for shapes and paths
import javax.swing.*;

//* As JComponent is an abstract class
public class DrawingCanvas extends JComponent {
	private int width;
	private int height;

	// * constructor
	public DrawingCanvas(int w, int h) {
		width = w;
		height = h;
	}

	protected void paintComponent(Graphics g) {
		// * Casting the graphics obj to graphics 2D obj explicitly
		Graphics2D g2d = (Graphics2D) g;

		// * To smoothen out the edges and blend with the bg
		RenderingHints rh = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setRenderingHints(rh);

		// * .Double means it allows us to create using double and not just int
		Rectangle2D.Double rect = new Rectangle2D.Double(0, 0, width, height);

		// * coloring the rectangle for visibility using RGB values
		g2d.setColor(new Color(100, 149, 237));
		g2d.fill(rect);

		Ellipse2D.Double ellipse = new Ellipse2D.Double(200, 75, 100, 100);
		g2d.setColor(Color.RED);
		g2d.fill(ellipse);

		Line2D.Double line = new Line2D.Double(100, 250, 300, 75);
		g2d.setColor(Color.BLACK);
		g2d.draw(line);

	}
}
