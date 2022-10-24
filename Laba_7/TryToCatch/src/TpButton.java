import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TpButton extends JFrame {
    private JPanel jPanel;
    private JLabel point;

    public TpButton() {
        setDefaultCloseOperation(3);
        setBounds(0, 0, 800, 600);
        setResizable(false);
        setLayout(new BorderLayout());
        initPoint();
        initPanel();
        setVisible(true);
    }

    private void initPoint() {
        point = new JLabel();
        point.setForeground(Color.RED);
        add(point, BorderLayout.SOUTH);
    }

    private void updatePos(Point cord) {
        point.setText("X: " + cord.x + " Y: " + cord.y);
    }

    private void initPanel() {
        jPanel = new JPanel(null);
        jPanel.setBackground(Color.ORANGE);
        JButton button = new JButton("Banana. Shake me");
        button.setSize(200,50);
        button.setBackground(Color.YELLOW);
        button.setLocation(300,300);
        jPanel.add(button);
        add(jPanel);
        addMouseAction(button);
    }

    private void addMouseAction(JButton button) {
        jPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                updatePos(mouseEvent.getPoint());
            }
        });
        jPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                button.setLocation(mouseEvent.getPoint());
            }
        });
        ButtonHandler handler = new ButtonHandler(button);
        button.addMouseMotionListener(handler);
        button.addKeyListener(handler);
    }

    private class ButtonHandler extends KeyAdapter implements MouseMotionListener {
        private final JButton button;

        private ButtonHandler(JButton button) {
            this.button = button;
        }

        @Override
        public void mouseDragged(MouseEvent mouseEvent) {
            int newX = mouseEvent.getX() + button.getX()-100;
            int newY = mouseEvent.getY() + button.getY()-25;
            updatePos(new Point(newX, newY));
            if ((mouseEvent.getModifiers() & ActionEvent.CTRL_MASK) != 0) {
                button.setLocation(newX, newY);
            }
        }

        @Override
        public void keyTyped(KeyEvent keyEvent) {
            if (keyEvent.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                StringBuilder s = new StringBuilder(button.getText());
                try {
                    s.deleteCharAt(s.length() - 1);
                } catch (StringIndexOutOfBoundsException e) {
                    return;
                }
                button.setText(String.valueOf(s));
                button.setSize(button.getPreferredSize().width, 50);
                return;
            }
            button.setText(button.getText() + keyEvent.getKeyChar());
            button.setSize(button.getPreferredSize().width, 50);
        }
        @Override
        public void mouseMoved(MouseEvent mouseEvent) {}
    }
}