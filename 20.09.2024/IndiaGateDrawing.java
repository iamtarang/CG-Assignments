import javax.swing.*;
import java.awt.*;

public class IndiaGateDrawing extends JPanel {
    public IndiaGateDrawing() {
        setPreferredSize(new Dimension(600, 400));
        setBackground(new Color(135, 206, 235)); // Sky blue background
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Enable anti-aliasing for smoother lines
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw ground
        g2d.setColor(new Color(34, 139, 34)); // Forest green
        g2d.fillRect(0, 350, 600, 50);

        // Main structure
        g2d.setColor(new Color(210, 180, 140)); // Tan color for sandstone
        g2d.fillRect(150, 100, 300, 250);

        // Arched opening
        g2d.setColor(new Color(135, 206, 235)); // Sky blue for the opening
        g2d.fillArc(200, 150, 200, 300, 0, 180);

        // Top decoration
        g2d.setColor(new Color(210, 180, 140));
        int[] xPoints = {150, 300, 450};
        int[] yPoints = {100, 50, 100};
        g2d.fillPolygon(xPoints, yPoints, 3);

        // Detailing
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        
        // Outline
        g2d.drawRect(150, 100, 300, 250);
        g2d.drawPolygon(xPoints, yPoints, 3);
        g2d.drawArc(200, 150, 200, 300, 0, 180);

        // Horizontal lines
        g2d.drawLine(150, 150, 450, 150);
        g2d.drawLine(150, 300, 450, 300);

        // Text
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("India Gate", 250, 380);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("India Gate Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new IndiaGateDrawing());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}