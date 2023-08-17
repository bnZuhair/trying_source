package labActivivty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Lab1OOP extends JFrame implements ActionListener {
    Lab1OOP otherFrame;

    JButton show2;
    Lab1OOP() {
        setLayout(new FlowLayout());
        setSize(900, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        show2 = new JButton("show other");
        show2.addActionListener(this);
        add(show2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        otherFrame.setVisible(true);
    }

    public static void main (String[]args){
        Lab1OOP win1 = new Lab1OOP();
        win1.setTitle("fram 1");
        win1.setVisible(true);

        Lab1OOP win2 = new Lab1OOP();
        win2.setTitle("frame 2");
        win1.otherFrame = win2;
        win2.otherFrame = win1;


    }
}