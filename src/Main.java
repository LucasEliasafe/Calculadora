import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma operação: ");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Subtrair");
            System.out.println("3 - Multiplicar");
            System.out.println("4 - Dividir");
            System.out.println("0 - ");
            System.out.println("5 - Sair");

            int escolha = scanner.nextInt();

            if (escolha == 5) {
                System.out.println("Saindo");
                break;
            }

            System.out.println("Digite um valor: ");
            double num1 = scanner.nextDouble();

            System.out.println("Digite um valor: ");
            double num2 = scanner.nextDouble();

            double resultado = 0;
            boolean operacaoValida = true;

            switch (escolha) {
                case 1:
                    resultado = calculadora.adicionar(num1, num2);
                    break;

                case 2:
                    resultado = calculadora.subtrair(num1, num2);
                    break;

                case 3:
                    resultado = calculadora.multiplicar(num1, num2);
                    break;

                case 4:
                    try {
                        resultado = calculadora.dividir(num1, num2);
                    } catch (ArithmeticException e) {
                        operacaoValida = false;
                    }
                    break;
                default:
                    System.out.println("Operação Inválida");
                    operacaoValida = false;
            }

            if (operacaoValida) {
                System.out.println("Resultado: " + resultado);
            }
        }
        scanner.close();
    }
}
