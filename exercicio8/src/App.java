
public class App {
    public static void main(String[] args) throws Exception {

        //Crie um programa que exiba os números primos de 1 a 100.

        int n = 100;
        int i, primos;

        for (i = 2; i <= n; i++) {
            primos = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    primos++;
                }
            }
            if (primos == 2) {
                System.out.println("Os numeros primos são: " + i);
            }
        }

    }
}
