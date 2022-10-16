import com.sun.jdi.connect.Connector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.MissingFormatArgumentException;
import java.util.MissingResourceException;

public class Window extends JFrame {
    private Series series;

    Window(String str){
        super(str);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JFrame name = new JFrame("Series");
        name.setSize(800, 600);
        name.setResizable(false);
        name.setLayout(null);
        name.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel title = new JLabel();
        title.setLayout(new BorderLayout(0,0));

        JLabel titleLabel = new JLabel("  Series Counter");
        title.add(titleLabel, BorderLayout.CENTER);
        titleLabel.setSize(300, 100);
        titleLabel.setBounds(name.getSize().width/2 - titleLabel.getSize().width/6, name.getSize().height/8, 300, 100);
        name.add(titleLabel);

        JTextField firstElement = new JTextField("First Element");
        firstElement.setBounds(name.getSize().width/2 - 250 - firstElement.getSize().width/2, name.getSize().height/3, 100, 50);
        firstElement.setSize(100, 50);
        name.add(firstElement);

        JTextField secondElement = new JTextField("De");
        secondElement.setBounds(name.getSize().width/2 - firstElement.getSize().width/2, name.getSize().height/3, 100, 50);
        secondElement.setSize(100, 50);
        name.add(secondElement);

        JTextField thirdElement = new JTextField("Num Of Elements");
        thirdElement.setBounds(name.getSize().width/2 + 250 - firstElement.getSize().width, name.getSize().height/3, 100, 50);
        thirdElement.setSize(100, 50);
        name.add(thirdElement);

        JRadioButton radioButtonLinear = new JRadioButton("Linear");
        radioButtonLinear.setBounds(name.getSize().width/2 -250 - radioButtonLinear.getSize().width, name.getSize().height/2 - 25, 200, 50);
        name.add(radioButtonLinear);
        radioButtonLinear.setSelected(true);
        JRadioButton radioButtonExponential = new JRadioButton("Exponential");
        radioButtonExponential.setBounds(name.getSize().width/2 - 250 - radioButtonExponential.getSize().width, name.getSize().height/2 + 25, 200, 50);
        name.add(radioButtonExponential);
        radioButtonExponential.setSelected(true);

        ButtonGroup group = new ButtonGroup();
        group.add(radioButtonLinear);
        group.add(radioButtonExponential);

        JButton create = new JButton("Create");
        create.setSize(300, 100);
        create.setBounds(name.getSize().width/2 - create.getSize().width, name.getSize().height/2 + 150, 300, 50);
        name.add(create);

        JButton write = new JButton("Write");
        write.setSize(300, 100);
        write.setBounds(name.getSize().width/2  , name.getSize().height/2 + 150, 300, 50);
        name.add(write);

        JTextField file = new JTextField("new File");
        file.setSize(600, 50);
        file.setBounds(name.getSize().width/2 - file.getSize().width/2, name.getSize().height/2 + 100, 600, 50);
        file.setSize(600, 50);
        name.add(file);

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    double f1 = Double.parseDouble(firstElement.getText());
                    double f2 = Double.parseDouble(secondElement.getText());
                    int f3 = Integer.parseInt(thirdElement.getText());

                    if (radioButtonLinear.isSelected()){
                        series = new LinearSeries(f1, f2, f3);
                    }
                    if (radioButtonExponential.isSelected()){
                        series = new LinearSeries(f1, f2, f3);
                    }

                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(Window.this, "Error", ex.getMessage(), 0);
                    create.setSelected(false);
                }

            }
        });

        write.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try {
                   if (file.getText() == ""){
                       throw new MissingFormatArgumentException("No text as File Name");
                   }else {
                       File fileOutput  = new File("src\\" + file.getText() + ".txt");
                       series.save(fileOutput);
                   }
               } catch (FileNotFoundException ex){
                   System.out.println("File not found");
               } catch (IOException ex){
                   System.out.println("IOException");
               }catch (IllegalArgumentException ex){
                   System.out.println("Number of element is not right");
               }
            }
        });
        name.setVisible(true);

    }
}
