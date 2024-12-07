import javax.swing.*;
import java.awt.*;

public class Doraemon extends JPanel {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 500;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Apply scaling transformation (enlarging the drawing by 1.5 times)
        g2d.scale(1.5, 1.5);

        // Face
        g2d.setColor(new Color(0, 162, 232));
        g2d.fillOval(100, 100, 200, 200);

        // White part of face
        g2d.setColor(Color.WHITE);
        g2d.fillOval(125, 140, 150, 160);

        // Eyes
        g2d.setColor(Color.WHITE);
        g2d.fillOval(155, 145, 40, 50);
        g2d.fillOval(205, 145, 40, 50);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(155, 145, 40, 50);
        g2d.drawOval(205, 145, 40, 50);
        g2d.setColor(Color.BLACK);
        g2d.fillOval(170, 160, 15, 20);
        g2d.fillOval(215, 160, 15, 20);

        // Nose
        g2d.setColor(Color.RED);
        g2d.fillOval(190, 185, 20, 20);

        // Mouth
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawArc(150, 200, 100, 50, 0, -180);

        // Whiskers
        g2d.drawLine(140, 190, 100, 180);
        g2d.drawLine(140, 200, 100, 200);
        g2d.drawLine(140, 210, 100, 220);
        g2d.drawLine(260, 190, 300, 180);
        g2d.drawLine(260, 200, 300, 200);
        g2d.drawLine(260, 210, 300, 220);

        // Collar
        g2d.setColor(Color.RED);
        g2d.fillRect(150, 270, 100, 20);

        // Bell
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(185, 270, 30, 30);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(185, 270, 30, 30);
        g2d.drawLine(200, 285, 200, 295);
        g2d.fillOval(197, 295, 6, 6);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Doraemon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Doraemon());
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
