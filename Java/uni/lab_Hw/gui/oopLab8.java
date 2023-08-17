package Java.uni.lab;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;

public class oopLab8 extends JFrame implements ListSelectionListener {
    private JPanel subMine;
    private JList<String> animalList;
    private ImageIcon cat, lion, rabbit;
    JLabel imagelabel;

    oopLab8() {
        super("show images");
        setVisible(true);
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        cat = new ImageIcon("D:\\Me\\Media\\sourceCode\\Java\\uni\\lab\\cat.jpg");
        lion =new ImageIcon("D:\\Me\\Media\\sourceCode\\Java\\uni\\lab\\lion.jpg");
        rabbit =new ImageIcon("D:\\Me\\Media\\sourceCode\\Java\\uni\\lab\\rabbit.jpg");
        imagelabel = new JLabel();
        imagelabel.setIcon(cat);
        imagelabel.setVisible(false);

        String[] list = { "cat", "lion", "rabbit"};
        animalList = new JList<>(list);
        
        animalList.addListSelectionListener(this);

        subMine = new JPanel(new BorderLayout());
        subMine.setVisible(true);
        subMine.add(animalList);

        add(new JScrollPane(imagelabel));
        add(subMine, BorderLayout.WEST);
    }

    public void valueChanged(ListSelectionEvent e) {
        String s = animalList.getSelectedValue();
        imagelabel.setVisible(false);
        switch (s) {
            case "cat":
                imagelabel.setIcon(cat);
                break;
            case "lion":
                imagelabel.setIcon(lion);
                break;
            case "rabbit":
                imagelabel.setIcon(rabbit);
                break;
        }
        imagelabel.setVisible(true);
    }
    public static void main(String[] args) {
        new oopLab8();
    }
}