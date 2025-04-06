import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FilaAtendimentoBanco {
    private Queue<String> filaNormal;
    private Queue<String> filaPrioritaria;
    private int contadorClientes;

    public FilaAtendimentoBanco() {
        filaNormal = new LinkedList<>();
        filaPrioritaria = new LinkedList<>();
        contadorClientes = 1;
    }

    // Adiciona um novo cliente à fila
    public void adicionarCliente(boolean prioritario) {
        String numeroCliente = gerarNumeroAtendimento(prioritario);
        if (prioritario) {
            filaPrioritaria.add(numeroCliente);
            System.out.println("Cliente prioritário adicionado: " + numeroCliente);
        } else {
            filaNormal.add(numeroCliente);
            System.out.println("Cliente normal adicionado: " + numeroCliente);
        }
    }

    // Gera o número de atendimento
    private String gerarNumeroAtendimento(boolean prioritario) {
        String prefixo = prioritario ? "P" : "N";
        return prefixo + contadorClientes++;
    }

    // Atende o próximo cliente
    public void atenderProximo() {
        // Prioriza clientes prioritários, mas atende normais se não houver prioritários
        if (!filaPrioritaria.isEmpty()) {
            String cliente = filaPrioritaria.poll();
            System.out.println("Atendendo cliente prioritário: " + cliente);
        } else if (!filaNormal.isEmpty()) {
            String cliente = filaNormal.poll();
            System.out.println("Atendendo cliente normal: " + cliente);
        } else {
            System.out.println("Não há clientes na fila!");
        }
    }

    // Mostra o estado atual das filas
    public void mostrarFilas() {
        System.out.println("\n=== FILAS DE ATENDIMENTO ===");
        System.out.println("Clientes prioritários (" + filaPrioritaria.size() + "):");
        for (String cliente : filaPrioritaria) {
            System.out.println("  - " + cliente);
        }

        System.out.println("\nClientes normais (" + filaNormal.size() + "):");
        for (String cliente : filaNormal) {
            System.out.println("  - " + cliente);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilaAtendimentoBanco banco = new FilaAtendimentoBanco();

        while (true) {
            System.out.println("\nSISTEMA DE ATENDIMENTO BANCÁRIO");
            System.out.println("1 - Adicionar cliente normal");
            System.out.println("2 - Adicionar cliente prioritário");
            System.out.println("3 - Atender próximo cliente");
            System.out.println("4 - Mostrar filas");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    banco.adicionarCliente(false);
                    break;
                case 2:
                    banco.adicionarCliente(true);
                    break;
                case 3:
                    banco.atenderProximo();
                    break;
                case 4:
                    banco.mostrarFilas();
                    break;
                case 5:
                    System.out.println("Encerrando sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}