import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GerenciadorFilaRestaurante {
    private Queue<String> filaEspera;
    private int mesasDisponiveis;
    private int contadorClientes;

    public GerenciadorFilaRestaurante(int totalMesas) {
        filaEspera = new LinkedList<>();
        mesasDisponiveis = totalMesas;
        contadorClientes = 1;
    }

    // Adiciona um novo cliente à fila de espera
    public void adicionarCliente(String nomeCliente) {
        String cliente = "Cliente #" + contadorClientes++ + " - " + nomeCliente;
        filaEspera.add(cliente);
        System.out.println(cliente + " adicionado à fila de espera.");
        
        // Verifica se já pode ser atendido
        verificarAtendimento();
    }

    // Libera uma mesa (pode ser chamado quando clientes saem)
    public void liberarMesa() {
        mesasDisponiveis++;
        System.out.println("Uma mesa foi liberada. Mesas disponíveis: " + mesasDisponiveis);
        verificarAtendimento();
    }

    // Verifica se pode atender alguém da fila
    private void verificarAtendimento() {
        while (mesasDisponiveis > 0 && !filaEspera.isEmpty()) {
            mesasDisponiveis--;
            String cliente = filaEspera.poll();
            System.out.println("\n[ATENDIDO] " + cliente + " - Por favor, dirija-se à mesa!");
            System.out.println("Mesas restantes: " + mesasDisponiveis);
        }
    }

    // Mostra o estado atual da fila
    public void mostrarEstado() {
        System.out.println("\n=== SITUAÇÃO DO RESTAURANTE ===");
        System.out.println("Mesas disponíveis: " + mesasDisponiveis);
        System.out.println("Clientes na fila de espera: " + filaEspera.size());
        
        if (!filaEspera.isEmpty()) {
            System.out.println("\nPróximos clientes na fila:");
            int count = 1;
            for (String cliente : filaEspera) {
                System.out.println(count++ + ". " + cliente);
                if (count > 5) break; // Mostra apenas os 5 primeiros
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o número total de mesas do restaurante: ");
        int totalMesas = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        
        GerenciadorFilaRestaurante restaurante = new GerenciadorFilaRestaurante(totalMesas);

        while (true) {
            System.out.println("\nSISTEMA DE GERENCIAMENTO DO RESTAURANTE");
            System.out.println("1 - Adicionar cliente à fila");
            System.out.println("2 - Liberar mesa (clientes saíram)");
            System.out.println("3 - Ver situação atual");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    restaurante.adicionarCliente(nome);
                    break;
                case 2:
                    restaurante.liberarMesa();
                    break;
                case 3:
                    restaurante.mostrarEstado();
                    break;
                case 4:
                    System.out.println("Encerrando sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}