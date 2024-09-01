import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Currency_Converter extends JFrame implements ActionListener
{
    private static final double CONVERSION_RATE = 83.0;

    private JTextField dollarField;
    private JButton convertButton;
    private JLabel resultLabel;

    public Currency_Converter()
    {
        setTitle("User Currency Converter");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        dollarField = new JTextField(15);
        add(new JLabel("Enter Your Dollars:"));
        add(dollarField);

        convertButton = new JButton("Click Convert to Rupees");
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
            double dollars = Double.parseDouble(dollarField.getText());

            double rupees = dollars * CONVERSION_RATE;

            resultLabel.setText("Result: ₹" + String.format("%.2f", rupees));
        }
        catch (NumberFormatException ex)
        {
            resultLabel.setText("Input is Invalid !!!");
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new Currency_Converter());
    }
}

