import javax.swing.*;
import java.awt.*;

public class StopWatchRunner {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("StopWatch App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        StopWatchLabel stopWatchLabel = new StopWatchLabel();
        stopWatchLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        stopWatchLabel.setBackground(Color.white);
        stopWatchLabel.setForeground(new Color(180, 0, 0));
        frame.setBackground(Color.white);

        frame.add(stopWatchLabel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
