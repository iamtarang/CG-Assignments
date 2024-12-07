import javax.swing.*;
import java.awt.*;

public class SimpleSolarSystem extends JPanel {
    public SimpleSolarSystem() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw Sun
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(190, 190, 20, 20);

        // Draw Earth's orbit
        g2d.setColor(Color.WHITE);
        g2d.drawOval(100, 100, 200, 200);

        // Draw Earth
        g2d.setColor(Color.BLUE);
        g2d.fillOval(300, 190, 10, 10);

        // Draw Mars' orbit
        g2d.setColor(Color.WHITE);
        g2d.drawOval(50, 50, 300, 300);

        // Draw Mars
        g2d.setColor(Color.RED);
        g2d.fillOval(50, 190, 8, 8);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Solar System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new SimpleSolarSystem());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}