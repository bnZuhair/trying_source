
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class Lab2_2OOP extends JFrame implements ChangeListener {
    private final JSlider redSlider;
    private final JPanel SliderPanel;

    Lab2_2OOP() {
        super("my Slider");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setVisible(true);

        redSlider = new JSlider();
        redSlider.setOrientation(SwingConstants.VERTICAL);
        redSlider.setMinimum(0);
        redSlider.setMaximum(250);
        redSlider.setPaintTicks(true);
        redSlider.setPaintLabels(true);
        redSlider.setMinorTickSpacing(5);
        redSlider.setMajorTickSpacing(25);
        redSlider.addChangeListener(this);
        redSlider.setBorder(BorderFactory.createTitledBorder("Red slider"));


        SliderPanel = new JPanel();
        SliderPanel.add(redSlider);
        add(SliderPanel, "West");


    }

    public void stateChanged(ChangeEvent ce) {
        int redValue = redSlider.getValue();

        this.getContentPane().setBackground(new Color(redValue, 0, 0));
    }

    public static void main(String[] args) {
        new Lab2_2OOP();
    }
}
