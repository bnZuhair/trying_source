package labActivivty;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Lab2OOp extends JFrame{

    private final JButton convertButton;
    private final JTextArea afterConvert;
    private final JLabel userMessage;
    private final JTextField userInput;
    private final JPanel fromUser;
    Lab2OOp () {
        setVisible(true);
        fromUser = new JPanel();
        fromUser.setBackground(Color.blue);
        fromUser.setLayout(new FlowLayout());
        convertButton = new JButton("convert");
        userMessage = new JLabel("Enter The Distance");
        userInput = new JTextField(10);
        userMessage.setForeground(Color.black);
        fromUser.add(userMessage);
        fromUser.add(userInput);
        fromUser.add(convertButton);

        add(fromUser, "North" );

        afterConvert = new JTextArea("shows after conversions", 10, 20);
        afterConvert.setEditable(false);

        add(afterConvert, "Center");

        ConvertHandler handler = new ConvertHandler();
        convertButton.addActionListener(handler);
        userInput.addActionListener(handler);




    }
    private class ConvertHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) throws NumberFormatException{
            try {

                double num = Double.parseDouble(userInput.getText());
                num = num * 1.607;
                String message = String.format("distance in Km %.2f", num);
                afterConvert.setText(message);
            }catch (Exception ex ){
                JOptionPane.showMessageDialog(null, "Invalid input please Enter a number", "Error Message",
                        JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    public static void main(String[] args) {
            Lab2OOp win = new Lab2OOp();
            win.setSize(920, 880);
            win.setDefaultCloseOperation(EXIT_ON_CLOSE);


    }
}
