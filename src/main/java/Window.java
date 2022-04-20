import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    @Getter
    private GamePanel canvas;

    @Getter
    private final Timer timer;
    private final EventHandler eventHandler;

    @Getter
    private final Application app;

    public Window(final Application app) throws HeadlessException {
        super(Config.NAME);

        this.app = app;

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(Config.WIDTH, Config.HEIGHT);
        setMinimumSize(new Dimension(Config.WIDTH, Config.HEIGHT));
        setResizable(false);

        canvas = new GamePanel();
        canvas.setSize(Config.WIDTH, Config.HEIGHT);
        canvas.setFocusable(true);
        canvas.requestFocus();

        add(canvas);

        ActionListener listener = e -> repaint();

        timer = new Timer(30, listener);
        timer.setRepeats(true);
        timer.start();

        pack();

        eventHandler = new EventHandler(this);

        this.addKeyListener(eventHandler);
        canvas.addMouseListener(eventHandler);
        canvas.addMouseMotionListener(eventHandler);
    }

    public void setCanvas(JPanel c) {
        canvas = (GamePanel) c;
    }

    private class GamePanel extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            app.update();
            app.draw(g);
        }
    }

}
