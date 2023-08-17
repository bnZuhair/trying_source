package labActivivty;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Lab3OOP extends JFrame implements ChangeListener {
    private final JSlider rs, gs, bs;
    private final JPanel p1;
    private int R, G, B;

    Lab3OOP() {

        rs = new JSlider();
        rs.setMinimum(0);
        rs.setMaximum(250);
        rs.setPaintLabels(true);
        rs.setPaintTicks(true);
        rs.setMajorTickSpacing(50);

        gs = new JSlider();
        gs.setMinimum(0);
        gs.setMaximum(250);
        gs.setPaintTicks(true);
        gs.setPaintLabels(true);
        gs.setMajorTickSpacing(50);

        bs = new JSlider();
        bs.setMinimum(0);
        bs.setMaximum(250);
        bs.setPaintTicks(true);
        bs.setPaintLabels(true);
        bs.setMajorTickSpacing(50);

        p1 = new JPanel();
        p1.add(rs);
        p1.add(gs);
        p1.add(bs);


        add(p1, "North");
        rs.addChangeListener(this);
        gs.addChangeListener(this);
        bs.addChangeListener(this);
    }


    @Override
    public void stateChanged(ChangeEvent e) {
        R = rs.getValue();
        G = gs.getValue();
        B = bs.getValue();

        getContentPane().setBackground(new Color(R, G, B));
    }

    public static void main(String[] args) {
        Lab3OOP win = new Lab3OOP();
        win.setVisible(true);
        win.setDefaultCloseOperation(EXIT_ON_CLOSE);
        win.setSize(500, 250);

    }
}
