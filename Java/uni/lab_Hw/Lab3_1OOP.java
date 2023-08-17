package labActivivty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class Lab3_1OOP extends JFrame implements ActionListener, ItemListener {
    private final JTextField tf;
    private final JButton b1;
    private final JLabel l1, l2;
    private final JComboBox cb;
    private final JRadioButton rb1, rb2;
    private final ButtonGroup gb;
    private final JPanel p;
    private boolean isUp = true;

    Lab3_1OOP() {
        super("my counter");
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(700, 200);
        setLocation(640, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p = new JPanel();
        l1 = new JLabel("Counter");
        p.add(l1);

        tf = new JTextField("0",10);
        tf.setEditable(false);
        p.add(tf);
        tf.addActionListener(this);

        rb1 = new JRadioButton("up", true);
        rb2 = new JRadioButton("Down", false);
        gb = new ButtonGroup();
        gb.add(rb1);
        gb.add(rb2);
        p.add(rb1);
        p.add(rb2);
        rb1.addItemListener(this);
        rb2.addItemListener(this);

        l2 = new JLabel("steps:");
        p.add(l2);

        String nums[] = {"1", "2", "3", "4", "5"};
        cb = new JComboBox<String>(nums);
        p.add(cb);

        b1 = new JButton("Count");
        p.add(b1);
        b1.addActionListener(this);


        add(p);
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getSource().equals(rb1)) isUp = true;
        if (ie.getSource().equals(rb2)) isUp = false;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int cbValue = cb.getSelectedIndex() + 1;
        int tfValue = Integer.parseInt(tf.getText());
        int finalValue;
        if (isUp) finalValue = tfValue + cbValue;
        else finalValue = tfValue - cbValue;

        tf.setText(String.valueOf(finalValue));

    }

    public static void main(String[] args) {
        new Lab3_1OOP();
    }

}
