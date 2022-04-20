import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Application {

    private final Window window;

    public Application() {
        window = new Window(this);
    }

    public void update() {

    }

    // draw here
    public void draw(Graphics g) {

        g.setColor(Color.orange);
        g.fillRect(100, 100, 400, 600);
    }

    public void keyEvent(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                stop();
                break;
            case KeyEvent.VK_W:

            default:
                break;
        }
    }


    public void mouseEvent(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            System.out.println("click");
        }
    }

    private void stop() {
        window.getTimer().stop();
        window.dispose();
        System.exit(0);
    }

    public static void main(String[] args) {
        new Application();
    }

}
