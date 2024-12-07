import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;

public class NameVector extends JComponent { 

    private int width;
    private int height;

    // Constructor
    public NameVector(int w, int h) {
        width = w;
        height = h;
    }

    // Method to draw Line
    private void drawLine(Graphics2D g2d) {
        // Letter T
        Line2D.Double tH = new Line2D.Double(30, 40, 90, 40);
        Line2D.Double tV = new Line2D.Double(60, 40, 60, 100);
        
        // Letter A
        Line2D.Double aL = new Line2D.Double(100, 40, 80, 100);
        Line2D.Double aR = new Line2D.Double(100, 40, 120, 100);
        Line2D.Double aH = new Line2D.Double(90, 70, 110, 70);

        // Letter R
        Line2D.Double rV = new Line2D.Double(130, 40, 130, 100);
        Line2D.Double rD = new Line2D.Double(130, 70, 150, 100);
        
        // Letter A
        Line2D.Double a2L = new Line2D.Double(180, 40, 160, 100);
        Line2D.Double a2R = new Line2D.Double(180, 40, 200, 100);
        Line2D.Double a2H = new Line2D.Double(170, 70, 190, 70);
        
        // Letter n
        Line2D.Double nL = new Line2D.Double(210, 40, 210, 100);
        Line2D.Double nR = new Line2D.Double(240, 40, 240, 100);
        Line2D.Double nD = new Line2D.Double(210, 40, 240, 70);
        
        // Letter R
        Line2D.Double gV = new Line2D.Double(280, 85, 300, 85);
        Line2D.Double gD = new Line2D.Double(295, 85, 295, 100);
        
        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(3));

        g2d.draw(tH);
        g2d.draw(tV);

        g2d.draw(aL);
        g2d.draw(aR);
        g2d.draw(aH);
        
        g2d.draw(rV);
        g2d.draw(rD);
        
        g2d.draw(a2L);
        g2d.draw(a2R);
        g2d.draw(a2H);

        g2d.draw(nL);
        g2d.draw(nR);
        g2d.draw(nD);

        g2d.draw(gV);
        g2d.draw(gD);
    }

    // Method to draw arcs
    private void drawArcs(Graphics2D g2d) {
        Arc2D.Double rArc = new Arc2D.Double(120, 40, 30, 30, 270, 180, Arc2D.OPEN); 
        Arc2D.Double gArc = new Arc2D.Double(250, 40, 50, 60, 50, 270, Arc2D.OPEN);

        g2d.setColor(Color.WHITE);
        
        g2d.setStroke(new BasicStroke(3));
        g2d.draw(rArc);
        g2d.draw(gArc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
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
        NameVector nameVector = new NameVector(w, h);

        frame.setSize(w, h);
        frame.setTitle("Name using Lines and Arcs");
        frame.add(nameVector);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
