import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class LineClippingDemo extends JPanel {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int INSIDE = 0;
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static final int BOTTOM = 4;
    private static final int TOP = 8;

    private Rectangle clipWindow;
    private ArrayList<Line2D.Double> lines;
    private ArrayList<Line2D.Double> clippedLines;

    public LineClippingDemo() {
        clipWindow = new Rectangle(200, 150, 400, 300);
        lines = new ArrayList<>();
        clippedLines = new ArrayList<>();

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                lines.add(new Line2D.Double(e.getPoint(), e.getPoint()));
                repaint();
            }

            public void mouseReleased(MouseEvent e) {
                lines.get(lines.size() - 1).setLine(
                    lines.get(lines.size() - 1).getP1(),
                    e.getPoint()
                );
                clipLines();
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                lines.get(lines.size() - 1).setLine(
                    lines.get(lines.size() - 1).getP1(),
                    e.getPoint()
                );
                repaint();
            }
        });
    }

    private void clipLines() {
        clippedLines.clear();
        for (Line2D.Double line : lines) {
            Line2D.Double clippedLine = clipLine(line);
            if (clippedLine != null) {
                clippedLines.add(clippedLine);
            }
        }
    }

    private int computeOutCode(double x, double y) {
        int code = INSIDE;
        if (x < clipWindow.x) code |= LEFT;
        else if (x > clipWindow.x + clipWindow.width) code |= RIGHT;
        if (y < clipWindow.y) code |= TOP;
        else if (y > clipWindow.y + clipWindow.height) code |= BOTTOM;
        return code;
    }

    private Line2D.Double clipLine(Line2D.Double line) {
        double x1 = line.x1, y1 = line.y1, x2 = line.x2, y2 = line.y2;
        int outcode1 = computeOutCode(x1, y1);
        int outcode2 = computeOutCode(x2, y2);
        boolean accept = false;

        while (true) {
            if ((outcode1 | outcode2) == 0) {
                accept = true;
                break;
            } else if ((outcode1 & outcode2) != 0) {
                break;
            } else {
                double x, y;
                int outcodeOut = (outcode1 != 0) ? outcode1 : outcode2;

                if ((outcodeOut & TOP) != 0) {
                    x = x1 + (x2 - x1) * (clipWindow.y - y1) / (y2 - y1);
                    y = clipWindow.y;
                } else if ((outcodeOut & BOTTOM) != 0) {
                    x = x1 + (x2 - x1) * (clipWindow.y + clipWindow.height - y1) / (y2 - y1);
                    y = clipWindow.y + clipWindow.height;
                } else if ((outcodeOut & RIGHT) != 0) {
                    y = y1 + (y2 - y1) * (clipWindow.x + clipWindow.width - x1) / (x2 - x1);
                    x = clipWindow.x + clipWindow.width;
                } else {
                    y = y1 + (y2 - y1) * (clipWindow.x - x1) / (x2 - x1);
                    x = clipWindow.x;
                }

                if (outcodeOut == outcode1) {
                    x1 = x;
                    y1 = y;
                    outcode1 = computeOutCode(x1, y1);
                } else {
                    x2 = x;
                    y2 = y;
                    outcode2 = computeOutCode(x2, y2);
                }
            }
        }

        if (accept) {
            return new Line2D.Double(x1, y1, x2, y2);
        }
        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw clipping window
        g2d.setColor(Color.BLACK);
        g2d.draw(clipWindow);

        // Draw original lines
        g2d.setColor(Color.BLUE);
        for (Line2D.Double line : lines) {
            g2d.draw(line);
        }

        // Draw clipped lines
        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(2));
        for (Line2D.Double line : clippedLines) {
            g2d.draw(line);
        }

        // Draw instructions
        g2d.setColor(Color.BLACK);
        g2d.drawString("Click and drag to draw lines. Lines will be clipped against the black rectangle.", 10, 20);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cohen-Sutherland Line Clipping Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new LineClippingDemo());
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}