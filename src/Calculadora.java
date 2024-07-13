import java.util.ArrayList;
import java.util.List;

public class Calculadora {
    private List<String> historico = new ArrayList<>();

    public double adicionar(double a, double b) {
        double resultado = a + b;
        historico.add(a + " + " + b + " = " + resultado);
        return resultado;
    }

    public double subtrair(double a, double b) {
        double resultado = a - b;
        historico.add(a + " - " + b + " = " + resultado);
        return resultado;
    }

    public double multiplicar(double a, double b) {
        double resultado = a * b;
        historico.add(a + " * " + b + " = " + resultado);
        return resultado;
    }

    public double dividir(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida.");
        }
        double resultado = a / b;
        historico.add(a + " / " + b + " = " + resultado);
        return resultado;
    }

    public List<String> getHistorico() {
        return historico;
    }
}
