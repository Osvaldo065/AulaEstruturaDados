import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // Escreva um programa que calcule a média dos valores em uma lista.

        // Cria uma lista de inteiros
        List<Integer> numeros = new ArrayList<>();

        // Adiciona números à lista
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        numeros.add(40);
        numeros.add(50);

        // Calcula a média
        double media = calcularMedia(numeros);

        // Exibe a média
        System.out.println("A média é: " + media);
    }

    // Método para calcular a média dos valores em uma lista
    public static double calcularMedia(List<Integer> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            throw new IllegalArgumentException("A lista não pode ser nula ou vazia.");
        }

        double soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }

        return soma / numeros.size();
    }
}
