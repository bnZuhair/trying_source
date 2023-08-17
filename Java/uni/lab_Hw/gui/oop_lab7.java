//name: Saleh Zohair
//uni number: 443814675
package gui;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class oop_lab7 extends JFrame implements Runnable, ActionListener {
    private JPanel buttonsPanel, imagPanel; 
    private JButton startingButton, stopButton;
    private JLabel image;
    private Thread animationThread;

    oop_lab7() { 
        super("animation");
        setSize(700, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        
        imagPanel = new JPanel();
        image = new JLabel(new ImageIcon(""));
        imagPanel.add(image);
        add(imagPanel);

        animationThread = new Thread((Runnable) this);
        
        buttonsPanel = new JPanel();
        startingButton = new JButton("start");
        startingButton.addActionListener(this);
        stopButton = new JButton("stop");
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            animationThread.stop();
            }
        });
        
        buttonsPanel.add(startingButton);
        buttonsPanel.add(stopButton);
        add(buttonsPanel, BorderLayout.NORTH);
    }

    @Override
    public void run() {
        while(true){
		
            for(int i = 0; i< 8; i++){
                image.setIcon(new ImageIcon("D:\\Me\\College\\2nd year\\therid semester\\Advance OOP\\HW lab\\images\\"+ i +".jfif"));
                try {
                    Thread.sleep(500);
                } catch(InterruptedException e) {
                    System.out.println("Thrad Interrupted");
                }
            }
            }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        animationThread = new Thread((Runnable) this);
        animationThread.start();
    }
    public static void main(String[] args) {
        new oop_lab7().setVisible(true);
    }

    
}
