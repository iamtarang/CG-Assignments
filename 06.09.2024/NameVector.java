// import java.awt.BasicStroke;
// import java.awt.Color;
// import java.awt.Graphics;
// import java.awt.Graphics2D;
// import java.awt.RenderingHints;
// import java.awt.geom.Arc2D;
// import java.awt.geom.Line2D;

// import javax.swing.JComponent;
// import javax.swing.JFrame;

// public class NameVector {

// 	private int width;
// 	private int height;

// 	// Constructor
// 	public NameVector(int w, int h) {
// 		width = w;
// 		height = h;
// 	}


// 	// Method to draw mid Line
// 	private void drawLine(Graphics2D g2d) {
// 		Line2D.Double line = new Line2D.Double(310, 40, 310, 400);
// 		g2d.setColor(Color.WHITE);
// 		g2d.draw(line);
// 	}
	
// 	private void drawArcs(Graphics2D g2d){
// 		Arc2D.Double leftArc = new Arc2D.Double(70, 160, 80, 120, 270, 180, Arc2D.OPEN); // Correct closure type
// 		Arc2D.Double rightArc = new Arc2D.Double(470, 160, 80, 120, 90, 180, Arc2D.OPEN); // Correct closure type
// 		g2d.setColor(Color.WHITE);
// 		g2d.setStroke(new BasicStroke(5)); // Adjust thickness here
// 		g2d.draw(leftArc);
// 		g2d.draw(rightArc);
// 	}

// 	@Override
// 	protected void paintComponent(Graphics g) {
// 		Graphics2D g2d = (Graphics2D) g;

// 		// Enable anti-aliasing for better rendering
// 		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
// 		g2d.setRenderingHints(rh);

// 		drawLine(g2d);
// 		drawArcs(g2d);
// 	}

// 	public static void main(String[] args) {
// 		int w = 640;
// 		int h = 480;

// 		JFrame frame = new JFrame();
// 		NameVector nVector = new NameVector(w, h);

// 		frame.setSize(w, h);
// 		frame.setTitle("Name using Lines and Arcs");
// 		frame.add(nVector);
// 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 		frame.setVisible(true);
// 	}
// }
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class NameVector extends JComponent { 

    private int width;
    private int height;

    // Constructor
    public NameVector(int w, int h) {
        width = w;
        height = h;
    }

    // Method to draw mid Line
    private void drawLine(Graphics2D g2d) {
        Line2D.Double line = new Line2D.Double(310, 40, 310, 400);
        g2d.setColor(Color.WHITE);
        g2d.draw(line);
    }

    // Method to draw arcs
    private void drawArcs(Graphics2D g2d) {
        Arc2D.Double leftArc = new Arc2D.Double(70, 160, 80, 120, 270, 180, Arc2D.OPEN); // Correct closure type
        Arc2D.Double rightArc = new Arc2D.Double(470, 160, 80, 120, 90, 180, Arc2D.OPEN); // Correct closure type
        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(5)); // Adjust thickness here
        g2d.draw(leftArc);
        g2d.draw(rightArc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Add this line to avoid potential painting issues
        Graphics2D g2d = (Graphics2D) g;

        // Enable anti-aliasing for better rendering
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        // Set background color
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, width, height);

        // Draw shapes
        drawLine(g2d);
        drawArcs(g2d);
    }

    public static void main(String[] args) {
        int w = 640;
        int h = 480;

        JFrame frame = new JFrame();
        NameVector nameVector = new NameVector(w, h); // Correct object name

        frame.setSize(w, h);
        frame.setTitle("Name using Lines and Arcs");
        frame.add(nameVector); // Add the correct component
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
