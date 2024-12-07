import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class OlympicLogo extends JPanel {
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = Math.min(getWidth(), getHeight()) / 8;

        drawRing(g2d, centerX - 2.2 * radius, centerY, radius, Color.BLUE);
        drawRing(g2d, centerX, centerY, radius, Color.BLACK);
        drawRing(g2d, centerX + 2.2 * radius, centerY, radius, Color.RED);
        drawRing(g2d, centerX - 1.1 * radius, centerY + radius, radius, Color.YELLOW);
        drawRing(g2d, centerX + 1.1 * radius, centerY + radius, radius, Color.GREEN);
    }

    private void drawRing(Graphics2D g2d, double x, double y, double radius, Color color) {
        Stroke originalStroke = g2d.getStroke();
        g2d.setStroke(new BasicStroke((float) (radius / 5)));
        g2d.setColor(color);
        g2d.draw(new Ellipse2D.Double(x - radius, y - radius, 2 * radius, 2 * radius));
        g2d.setStroke(originalStroke);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Olympic Logo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new OlympicLogo());
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}