import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraGUI extends JFrame implements ActionListener{
    private JTextField display;
    private Calculadora calculadora;
    private double num1, num2;
    private String operacao;

    public CalculadoraGUI(){
        calculadora = new Calculadora();

        setTitle("Calculadora");
        setSize(400,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 48));
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5, 4));

        String[] labels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
        };

        for (String label : )
    }

}
