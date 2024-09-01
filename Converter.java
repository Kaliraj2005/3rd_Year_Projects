
// Intentions --> To figure out modifications like meter to centimeter , meter to kilo meter and stuff like that included

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Converter extends JFrame implements ActionListener
{
    private JTextField inputField;
    private JComboBox<String> conversionOptions;
    private JButton convertButton;
    private JLabel resultLabel;

    public Converter()
    {
        setTitle("User Converter");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        inputField = new JTextField(10);
        add(new JLabel("Input:"));
        add(inputField);

        String[] options = {"Meter to Centimeter", "Meter to Kilometer", "Centimeter to Meter", "Kilometer to Meter"};
        conversionOptions = new JComboBox<>(options);
        add(new JLabel("Convert:"));
        add(conversionOptions);

        convertButton = new JButton("Convert");
        convertButton.addActionListener(this);
        add(convertButton);

        resultLabel = new JLabel("Result: ");
        add(resultLabel);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            double inputValue = Double.parseDouble(inputField.getText());
            String selectedOption = (String) conversionOptions.getSelectedItem();

            double result = 0;
            switch (selectedOption)
            {
                case "Meter to Centimeter":
                    result = inputValue * 100;
                    break;
                case "Meter to Kilometer":
                    result = inputValue / 1000;
                    break;
                case "Centimeter to Meter":
                    result = inputValue / 100;
                    break;
                case "Kilometer to Meter":
                    result = inputValue * 1000;
                    break;
            }
            resultLabel.setText("Result: " + result);
        }
        catch (NumberFormatException ex)
        {
            resultLabel.setText("Invalid input. Please enter a valid number.");
        }
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new Converter());
    }
}
