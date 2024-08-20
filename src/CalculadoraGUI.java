import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraGUI extends JFrame implements ActionListener{
    private JTextField display;
    private Calculadora calculadora;
    private double num1, num2;
    private String operacao;
    private boolean startNextNumber;

    public CalculadoraGUI(){
        calculadora = new Calculadora();
        startNextNumber = false;

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
                "C", "√", "%", "+/-"
        };

        for (String label : labels) {
            JButton botao = new JButton(label);
            botao.setFont(new Font("Arial", Font.PLAIN, 36));
            botao.addActionListener(this);
            painel.add(botao);
        }

        add(painel, BorderLayout.CENTER);
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch(comando){
            case "C":
                display.setText("");
                operacao = null;
                num1 = 0;
                num2 = 0;
                startNextNumber = false;
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                if (!startNextNumber) {
                    num1 = Double.parseDouble(display.getText());
                    operacao = comando;
                    startNextNumber = true;
                }
                break;
            case "=":
                if (operacao != null) {
                    num2 = Double.parseDouble(display.getText());
                    calcular();
                    operacao = null;
                    startNextNumber = true;
                }
                break;
            case "√":
                num1 = Double.parseDouble(display.getText());
                display.setText(String.valueOf(calculadora.raizQuadrada(num1)));
                startNextNumber = true;
                break;
            case "%":
                num2 = Double.parseDouble(display.getText());
                display.setText(String.valueOf(calculadora.porcentagem(num1, num2)));
                startNextNumber = true;
                break;
            case "+/-":
                num1 = Double.parseDouble(display.getText());
                display.setText(String.valueOf(calculadora.inversaoSinal(num1)));
                startNextNumber = true;
                break;
            default:
                if (startNextNumber) {
                    display.setText(comando);
                    startNextNumber = false;
                } else {
                    display.setText(display.getText() + comando);
                }
        }
    }

    private void calcular(){
        double resultado = 0;

        switch (operacao) {
            case "+":
                resultado = calculadora.adicionar(num1, num2);
                break;
            case "-":
                resultado = calculadora.subtrair(num1, num2);
                break;
            case "*":
                resultado = calculadora.multiplicar(num1, num2);
                break;
            case "/":
                try {
                    resultado = calculadora.dividir(num1, num2);
                } catch (ArithmeticException e) {
                    display.setText("Erro");
                    return;
                }
                break;
        }

        display.setText(String.valueOf(resultado));
        num1 = resultado;  // Armazena o resultado como o primeiro número para futuras operações
    }
}

