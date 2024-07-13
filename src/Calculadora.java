import java.util.ArrayList;
import java.util.List;

    public class Calculadora {
        private List<String> historico = new ArrayList<>();

        public double adicionar(double num1, double num2) {
            double resultado = num1 + num2;
            historico.add(num1 + "+" + num2 + "=" + resultado);
            return resultado;
        }

    public double subtrair(double num1, double num2) {
            double resultado = num1 - num2;
            historico.add(num1 + "-" + num2 + "=" + resultado);
            return resultado;
        }

    public double multiplicar(double num1, double num2) {
            double resultado = num1 * num2;
            historico.add(num1 + "*" + num2 + "=" + resultado);
            return resultado;
        }

    public double dividir(double num1, double num2) throws ArithmeticException {
            if (num2 == 0) {
                throw new ArithmeticException("Division por zero não é permitida.");
            }
            double resultado = num1 / num2;
            historico.add(num1 + "/" + num2 + "=" + resultado);
            return resultado;
        }

        public List<String> getHistorico() {
            return historico;
        }
    }


