import javax.swing.*;
import java.awt.*;

public class LudoBoard extends JPanel {
    private final int BOARD_SIZE = 400;
    private final int SQUARE_SIZE = BOARD_SIZE / 11;

    public LudoBoard() {
        setPreferredSize(new Dimension(BOARD_SIZE, BOARD_SIZE));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw the white background
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, BOARD_SIZE, BOARD_SIZE);

        // Draw the colored home areas
        drawHomeArea(g2d, 0, 0, Color.RED);
        drawHomeArea(g2d, 6, 0, Color.GREEN);
        drawHomeArea(g2d, 0, 6, Color.YELLOW);
        drawHomeArea(g2d, 6, 6, Color.BLUE);

        // Draw the paths
        drawPath(g2d);
    }

    private void drawHomeArea(Graphics2D g2d, int x, int y, Color color) {
        g2d.setColor(color);
        g2d.fillRect(x * SQUARE_SIZE, y * SQUARE_SIZE, 5 * SQUARE_SIZE, 5 * SQUARE_SIZE);
        g2d.setColor(Color.WHITE);
        g2d.fillRect((x + 1) * SQUARE_SIZE, (y + 1) * SQUARE_SIZE, 3 * SQUARE_SIZE, 3 * SQUARE_SIZE);
    }

    private void drawPath(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (i == 5 || j == 5) {
                    g2d.drawRect(i * SQUARE_SIZE, j * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Ludo Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new LudoBoard());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}