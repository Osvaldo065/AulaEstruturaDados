import java.util.Stack;

public class InversorString {
    public static String inverterString(String original) {
        // Cria uma pilha de caracteres
        Stack<Character> pilha = new Stack<>();
        
        // 1. Empilha cada caractere da string
        for (int i = 0; i < original.length(); i++) {
            pilha.push(original.charAt(i));
        }
        
        // 2. Desempilha os caracteres para construir a string invertida
        StringBuilder invertida = new StringBuilder();
        while (!pilha.isEmpty()) {
            invertida.append(pilha.pop());
        }
        
        return invertida.toString();
    }

    public static void main(String[] args) {
        String texto = "Programação em Java";
        System.out.println("Original: " + texto);
        
        String textoInvertido = inverterString(texto);
        System.out.println("Invertida: " + textoInvertido);
    }
}