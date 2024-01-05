import javax.swing.*;
import java.awt.event.*;

public class StopWatchLabel extends JLabel implements MouseListener {
    private long startTime; // Start time of timer.
    private boolean running; // True when the timer is running.
    private Timer timer; // Timer to update the label text.

    public StopWatchLabel() {
        super("  Click to start timer.  ", JLabel.CENTER);
        addMouseListener(this);
        // Set up a timer that calls this ActionListener every 100 milliseconds
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (running) {
                    long currentTime = System.currentTimeMillis();
                    long elapsedMillis = currentTime - startTime;
                    long elapsedSeconds = elapsedMillis / 1000;
                    long millisRemaining = elapsedMillis % 1000;
                    setText(String.format("Elapsed time: %d.%03d sec", elapsedSeconds, millisRemaining));
                }
            }
        });
    }

    public void mousePressed(MouseEvent evt) {
        if (!running) {
            running = true;
            startTime = System.currentTimeMillis();
            timer.start();
        } else {
            running = false;
            timer.stop();
            long endTime = System.currentTimeMillis();
            long elapsedMillis = endTime - startTime;
            long elapsedSeconds = elapsedMillis / 1000;
            long millisRemaining = elapsedMillis % 1000;
            setText(String.format("Time: %d.%03d sec", elapsedSeconds, millisRemaining));
        }
    }

    // Other mouse event methods
    public void mouseReleased(MouseEvent evt) {
    }

    public void mouseClicked(MouseEvent evt) {
    }

    public void mouseEntered(MouseEvent evt) {
    }

    public void mouseExited(MouseEvent evt) {
    }
}
