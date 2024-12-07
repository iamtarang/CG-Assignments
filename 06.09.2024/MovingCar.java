import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MovingCar extends JPanel implements ActionListener {
    private int carX = 0;
    private final int carY = 200;
    private final int carWidth = 100;
    private final int carHeight = 50;
    private final int wheelRadius = 10;
    private final int windowWidth = 600;
    private final int windowHeight = 400;
    private final Timer timer;

    public MovingCar() {
        timer = new Timer(20, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw road
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRect(0, carY + carHeight - 10, windowWidth, 50);

        // Draw car body
        g2d.setColor(Color.RED);
        g2d.fillRect(carX, carY, carWidth, carHeight);

        // Draw car top
        g2d.setColor(Color.RED);
        g2d.fillRect(carX + 20, carY - 20, 60, 20);

        // Draw windows
        g2d.setColor(Color.CYAN);
        g2d.fillRect(carX + 25, carY - 15, 20, 15);
        g2d.fillRect(carX + 55, carY - 15, 20, 15);

        // Draw wheels
        g2d.setColor(Color.BLACK);
        g2d.fillOval(carX + 15, carY + carHeight - wheelRadius, wheelRadius * 2, wheelRadius * 2);
        g2d.fillOval(carX + carWidth - 25, carY + carHeight - wheelRadius, wheelRadius * 2, wheelRadius * 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        carX += 5;
        if (carX > windowWidth) {
            carX = -carWidth;
        }
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(windowWidth, windowHeight);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moving Car");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MovingCar());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}