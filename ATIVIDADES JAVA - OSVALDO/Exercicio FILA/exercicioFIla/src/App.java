
import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) {
        // Criando uma fila dinâmica usando LinkedList
        Queue<String> fila = new LinkedList<>();

        // Adicionando elementos à fila
        fila.add("Primeiro");
        fila.add("Segundo");
        fila.add("Terceiro");

        // Exibindo a fila
        System.out.println("Fila atual: " + fila);

        // Removendo o elemento da frente da fila
        String removido = fila.poll();
        System.out.println("Elemento removido: " + removido);

        // Exibindo a fila após a remoção
        System.out.println("Fila após remoção: " + fila);

        // Consultando o elemento da frente sem removê-lo
        String frente = fila.peek();
        System.out.println("Elemento na frente da fila: " + frente);

        // Verificando se a fila está vazia
        boolean vazia = fila.isEmpty();
        System.out.println("A fila está vazia? " + vazia);
    }
}
