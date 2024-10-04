import javax.swing.*;

public class DrawingTester {
	public static void main(String[] args) {
		int w = 640;
		int h = 480;

		JFrame frame = new JFrame();
		DrawingCanvas dc = new DrawingCanvas(w, h);

		frame.setSize(w, h);
		frame.setTitle("Graphics in Java");
		frame.add(dc);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}