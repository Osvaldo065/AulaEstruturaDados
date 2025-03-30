import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de termos da sequência de Fibonacci: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Por favor, insira um número maior que 0.");
        } else {
            System.out.println("Sequência de Fibonacci com " + n + " termos:");
            int a = 0, b = 1;

            for (int i = 1; i <= n; i++) {
                System.out.print(a + " ");
                int next = a + b;
                a = b;
                b = next;
            }
        }

        scanner.close();
    }
}
