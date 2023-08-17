package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.html.StyleSheet;

public class labTring extends JFrame implements ActionListener {
    private final JList ImageList;
    private final JPanel listPanel, imagePanel;
    private final JButton okButton;
    private final JLabel images[];

    labTring() {
        super("my Slider");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setVisible(true);

        images = new JLabel[3];
        images[0] = new JLabel(new ImageIcon(getClass().getResource("lion.jpg")));
        images[1] = new JLabel(new ImageIcon(getClass().getResource("tiger.jpg")));
        images[2] = new JLabel(new ImageIcon(getClass().getResource("rabbit.jpg")));

        imagePanel = new JPanel();
        for (int i = 0; i < images.length; i++){
            images[i].setVisible(false);
            imagePanel.add( images[i]);
        }

        add(imagePanel);

        String animals[] = {"Lion", "Tiger", "Rabbit"};
        ImageList = new JList(animals);
        ImageList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        okButton = new JButton("Show");
        okButton.addActionListener(this);

        listPanel = new JPanel(new GridLayout(4, 0));
        listPanel.add(ImageList);
        listPanel.add(okButton );

        add(listPanel, "West");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        for (int i = 0; i < 3; i++)
            if (images[i].isVisible())
                images[i].setVisible(false);

        images[ImageList.getSelectedIndex()].setVisible(true);
    }


    public static void main(String[] args) {
        new labTring();
    }
}


