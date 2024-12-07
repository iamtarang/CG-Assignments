import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlyingPlaneAnimation extends JPanel implements ActionListener {
    private int planeX = -50; // Start off-screen to the left
    private final int planeY = 100;
    private final int planeWidth = 50;
    private final int planeHeight = 20;
    private final Timer timer;

    public FlyingPlaneAnimation() {
        setPreferredSize(new Dimension(400, 300));
        setBackground(new Color(135, 206, 235));
        timer = new Timer(50, this); // Update every 50 milliseconds
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Enable anti-aliasing for smoother lines
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw plane body
        g2d.setColor(Color.WHITE);
        g2d.fillRect(planeX, planeY, planeWidth, planeHeight);

        // Draw plane nose
        int[] xPoints = {planeX + planeWidth, planeX + planeWidth, planeX + planeWidth + 10};
        int[] yPoints = {planeY, planeY + planeHeight, planeY + planeHeight / 2};
        g2d.fillPolygon(xPoints, yPoints, 3);

        // Draw plane tail
        g2d.fillRect(planeX - 10, planeY - 10, 10, 30);

        // Draw plane wing
        g2d.fillRect(planeX + 10, planeY + planeHeight, 30, 10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        planeX += 5; // Move the plane 5 pixels to the right
        if (planeX > getWidth()) {
            planeX = -50; // Reset the plane position when it goes off-screen
        }
        repaint(); // Request a repaint to update the plane's position
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Flying Plane Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new FlyingPlaneAnimation());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}