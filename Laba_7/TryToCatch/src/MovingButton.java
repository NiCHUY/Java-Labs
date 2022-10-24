import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;

public class MovingButton extends JFrame {
    private JPanel jPanel;
    public MovingButton() {
        super();
        setDefaultCloseOperation(3);
        setBounds(0, 0, 800,600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel Question = new JLabel("Ты штоль король?");
        Question.setBounds(300, 10,200,40 );
        Question.setFont(new Font(Question.getFont().toString(), Font.BOLD, 20));
        add(Question, BorderLayout.CENTER);
        initBackground();
        initButtons();
        setVisible(true);
    }

    private void initBackground() {
        jPanel = new JPanel(null);
        jPanel.setBackground(Color.GREEN);
        add(jPanel);
    }

    private void initButtons() {
        JButton answerButton = new JButton("Нет");
        answerButton.setSize(60,50);
        answerButton.setLocation(500, 15);
        JButton movingButton = new JButton("Да");
        answerButton.setBackground(Color.GRAY);
        answerButton.setForeground(Color.white);
        movingButton.setBackground(Color.GRAY);
        movingButton.setForeground(Color.white);
        movingButton.setSize(50,50);
        movingButton.setLocation(375, 300);
        jPanel.add(answerButton) ;
        jPanel.add(movingButton);
        answerButton.addActionListener(actionEvent -> JOptionPane.showMessageDialog(this, "Я знаю", "Успокойся", JOptionPane.INFORMATION_MESSAGE ));
        movingButton.addActionListener(actionEvent -> JOptionPane.showMessageDialog(this, "А я за тебя не голосовал", "Успокойся", JOptionPane.ERROR_MESSAGE ));
        movingButton.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                double dist = mouseEvent.getPoint().distance(mouseEvent.getPoint());
                if (dist  < 20) {
                    moveButton(dist);
                }
            }

            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                mouseMoved(mouseEvent);
            }

            private void moveButton(double dist) {
                movingButton.setLocation(new Random().nextInt(600)+100, new Random().nextInt(400)+100);
            }
        });
    }
}