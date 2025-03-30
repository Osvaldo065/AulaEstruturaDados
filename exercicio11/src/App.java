
public class App {
    public static void main(String[] args) throws Exception {

        //Crie um programa que encontre o valor máximo em um array de inteiros.

        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int max = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > max) {
                max = numeros[i];
            }
        }
        System.out.println("O valor máximo é: " + max);
    }
}
