package gui;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class showImage extends JFrame {

    private final JLabel tigerImage;
    private final JLabel rabbitImage;
    private final JButton tigerButton;
    private final JButton rabbitButton;

    private final JPanel buttonPanle;
    private final JPanel imagePanle;
    showImage() {
        super("My lovely window");

        buttonPanle = new JPanel();
        add(buttonPanle, "North");

        tigerButton = new JButton("show-hide  tiger");
        buttonPanle.add(tigerButton);

        rabbitButton = new JButton("show-hide rabbit");
        buttonPanle.add(rabbitButton);

        imagePanle = new JPanel();
        add(imagePanle);

        Icon tiger = new ImageIcon(getClass().getResource("gui/tiger.jpg"));
        tigerImage = new JLabel( tiger );
        tigerImage.setToolTipText("An image of a tiger");
        imagePanle.add(tigerImage);
        tigerImage.setVisible(false);

        Icon rabbit = new ImageIcon(getClass().getResource("gui/rabbit.jpg"));
        rabbitImage = new JLabel(rabbit);
        rabbitImage.setToolTipText("a rabbit image");
        imagePanle.add(rabbitImage);
        rabbitImage.setVisible(false);

        ButtonHandler handler = new ButtonHandler();
        rabbitButton.addActionListener(handler);
        tigerButton.addActionListener(handler);


    }
    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == rabbitButton)
                if (rabbitImage.isVisible())
                    rabbitImage.setVisible(false);
                else
                    rabbitImage.setVisible(true);

            if (e.getSource() == tigerButton)
                if (tigerImage.isVisible())
                    tigerImage.setVisible(false);
                else
                    tigerImage.setVisible(true);

        }
    }

    public static void main(String[] args) {
        showImage myWin = new showImage();
        myWin.setVisible(true);
        myWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWin.setSize(1920, 1080);


    }
}
