public class Calculadora {

    public double adicionar(double num1, double num2) {
        return num1 + num2;
    }

   public double subtrair(double num1, double num2) {
        return num1 - num2;
   }

   public double multiplicar(double num1, double num2) {
        return num1 * num2;
   }

   public double dividir(double num1, double num2) throws ArithmeticException {
        if (num2 == 0) {
            throw new ArithmeticException("Division por zero não é permitida.");
        }
        return num1 / num2;
   }
}
