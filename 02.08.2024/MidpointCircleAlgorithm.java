import javax.swing.*;
import java.awt.*;

public class MidpointCircleAlgorithm extends JPanel {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        
        // Draw a circle with center at (200, 200) and radius 150
        drawCircle(g2d, 200, 200, 150);
    }

    private void drawCircle(Graphics2D g, int centerX, int centerY, int radius) {
        int x = radius;
        int y = 0;
        int err = 0;

        while (x >= y) {
            plotCirclePoints(g, centerX, centerY, x, y);
            y++;
            err += 1 + 2*y;
            if (2*(err-x) + 1 > 0) {
                x--;
                err += 1 - 2*x;
            }
        }
    }

    private void plotCirclePoints(Graphics2D g, int centerX, int centerY, int x, int y) {
        g.drawLine(centerX + x, centerY + y, centerX + x, centerY + y);
        g.drawLine(centerX - x, centerY + y, centerX - x, centerY + y);
        g.drawLine(centerX + x, centerY - y, centerX + x, centerY - y);
        g.drawLine(centerX - x, centerY - y, centerX - x, centerY - y);
        g.drawLine(centerX + y, centerY + x, centerX + y, centerY + x);
        g.drawLine(centerX - y, centerY + x, centerX - y, centerY + x);
        g.drawLine(centerX + y, centerY - x, centerX + y, centerY - x);
        g.drawLine(centerX - y, centerY - x, centerX - y, centerY - x);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Midpoint Circle Algorithm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MidpointCircleAlgorithm());
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}