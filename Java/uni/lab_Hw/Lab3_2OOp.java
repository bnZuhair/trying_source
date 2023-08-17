package labActivivty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class Lab3_2OOp extends JFrame implements ActionListener {
    private final JTextField tf;
    private final JButton allButtons[];
    private final JPanel numbersPanel;
    private long tempValue;
    private boolean isTempEntered = false;
    private String tempOperation = "";

    Lab3_2OOp() {
        super("my calculator");
        setVisible(true);
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        tf = new JTextField(20);
        add(tf, "North");
        tf.setEditable(false);

        allButtons = new JButton[16];
        for (int i = 0; i < allButtons.length; i++) {
            allButtons[i] = new JButton();
            allButtons[i].addActionListener(this);

        }

        allButtons[0].setText("1");
        allButtons[1].setText("2");
        allButtons[2].setText("3");
        allButtons[3].setText("+");
        allButtons[4].setText("4");
        allButtons[5].setText("5");
        allButtons[6].setText("6");
        allButtons[7].setText("-");
        allButtons[8].setText("7");
        allButtons[9].setText("8");
        allButtons[10].setText("9");
        allButtons[11].setText("*");
        allButtons[12].setText("C");
        allButtons[13].setText("0");
        allButtons[14].setText("=");
        allButtons[15].setText("/");

        numbersPanel = new JPanel(new GridLayout(4, 4));
        for (int i = 0; i < allButtons.length; i++)
            numbersPanel.add(allButtons[i]);

        add(numbersPanel);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("C")) {
            tf.setText("");
            tempValue = 0;
        } else if (Character.isDigit(ae.getActionCommand().charAt(0)))
            tf.setText(tf.getText() + ae.getActionCommand());

        else if (ae.getActionCommand().equals("=")) {
            if (isTempEntered) {
                if (tempOperation == "+")
                    tf.setText(String.valueOf(tempValue + Long.parseLong(tf.getText())));
                else if (tempOperation == "-")
                    tf.setText(String.valueOf(tempValue - Long.parseLong(tf.getText())));
                else if (tempOperation == "*")
                    tf.setText(String.valueOf(tempValue * Long.parseLong(tf.getText())));
                else if (tempOperation == "/") {
                    if (Long.parseLong(tf.getText()) == 0)
                        JOptionPane.showMessageDialog(null, "you can't divide by 0");
                    tf.setText(String.valueOf(tempValue / Long.parseLong(tf.getText())));
                }
            }else {
                    tempValue = Long.parseLong(tf.getText());
                    tf.setText("");
                    isTempEntered = true;
                }
        } else {
            tempValue = Long.parseLong(tf.getText());
            if (ae.getActionCommand().equals("+"))
                tempOperation = "+";
            else if (ae.getActionCommand().equals("-"))
                tempOperation = "-";
            else if (ae.getActionCommand().equals("*"))
                tempOperation = "*";
            else if (ae.getActionCommand().equals("/"))
                tempOperation = "/";

            tf.setText("");
            if (!isTempEntered)
                isTempEntered = true;
        }
    }

    public static void main(String[] args) {
        new Lab3_2OOp();
    }
}
