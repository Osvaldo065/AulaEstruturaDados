import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GerenciadorFilasParque {
    private Queue<String> filaVIP;
    private Queue<String> filaPadrao;
    private int contadorVisitantes;
    private int capacidadeAtracao;
    private int tempoAtendimentoVIP; // em segundos
    private int tempoAtendimentoPadrao; // em segundos

    public GerenciadorFilasParque(int capacidade, int tempoVIP, int tempoPadrao) {
        filaVIP = new LinkedList<>();
        filaPadrao = new LinkedList<>();
        contadorVisitantes = 1;
        capacidadeAtracao = capacidade;
        tempoAtendimentoVIP = tempoVIP;
        tempoAtendimentoPadrao = tempoPadrao;
    }

    public void adicionarVisitante(boolean isVIP) {
        String id = (isVIP ? "VIP-" : "PAD-") + contadorVisitantes++;
        if (isVIP) {
            filaVIP.add(id);
            System.out.println("Visitante " + id + " adicionado à fila VIP.");
        } else {
            filaPadrao.add(id);
            System.out.println("Visitante " + id + " adicionado à fila padrão.");
        }
    }

    public void simularAtracao() {
        System.out.println("\n=== INICIANDO ATRAÇÃO ===");
        System.out.println("Capacidade: " + capacidadeAtracao + " visitantes");
        
        int vagasRestantes = capacidadeAtracao;
        
        // Atendendo visitantes VIP primeiro
        while (vagasRestantes > 0 && !filaVIP.isEmpty()) {
            String visitante = filaVIP.poll();
            System.out.println("Embarcando " + visitante + " (VIP) - Tempo estimado: " + tempoAtendimentoVIP + "s");
            vagasRestantes--;
            try {
                Thread.sleep(tempoAtendimentoVIP * 1000); // Simula o tempo de atendimento
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // Atendendo visitantes padrão
        while (vagasRestantes > 0 && !filaPadrao.isEmpty()) {
            String visitante = filaPadrao.poll();
            System.out.println("Embarcando " + visitante + " (Padrão) - Tempo estimado: " + tempoAtendimentoPadrao + "s");
            vagasRestantes--;
            try {
                Thread.sleep(tempoAtendimentoPadrao * 1000); // Simula o tempo de atendimento
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        if (vagasRestantes == capacidadeAtracao) {
            System.out.println("Nenhum visitante nas filas para embarcar.");
        } else {
            System.out.println("Atração lotada. Próximo ciclo começará em breve.");
        }
    }

    public void mostrarFilas() {
        System.out.println("\n=== ESTADO DAS FILAS ===");
        System.out.println("Fila VIP (" + filaVIP.size() + " visitantes):");
        int count = 1;
        for (String vip : filaVIP) {
            System.out.println("  " + count++ + ". " + vip);
        }
        
        System.out.println("\nFila Padrão (" + filaPadrao.size() + " visitantes):");
        count = 1;
        for (String padrao : filaPadrao) {
            System.out.println("  " + count++ + ". " + padrao);
        }
        
        // Calcular tempos estimados
        if (!filaVIP.isEmpty() || !filaPadrao.isEmpty()) {
            int tempoEstimadoVIP = filaVIP.size() * tempoAtendimentoVIP / Math.max(1, capacidadeAtracao);
            int tempoEstimadoPadrao = filaPadrao.size() * tempoAtendimentoPadrao / Math.max(1, capacidadeAtracao);
            
            System.out.println("\nTempo estimado de espera:");
            System.out.println("  VIP: ~" + tempoEstimadoVIP + " segundos");
            System.out.println("  Padrão: ~" + (tempoEstimadoVIP + tempoEstimadoPadrao) + " segundos");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== CONFIGURAÇÃO INICIAL ===");
        System.out.print("Capacidade da atração por ciclo: ");
        int capacidade = scanner.nextInt();
        
        System.out.print("Tempo de atendimento VIP (segundos): ");
        int tempoVIP = scanner.nextInt();
        
        System.out.print("Tempo de atendimento Padrão (segundos): ");
        int tempoPadrao = scanner.nextInt();
        
        GerenciadorFilasParque parque = new GerenciadorFilasParque(capacidade, tempoVIP, tempoPadrao);

        while (true) {
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("1 - Adicionar visitante VIP");
            System.out.println("2 - Adicionar visitante padrão");
            System.out.println("3 - Simular ciclo da atração");
            System.out.println("4 - Mostrar estado das filas");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    parque.adicionarVisitante(true);
                    break;
                case 2:
                    parque.adicionarVisitante(false);
                    break;
                case 3:
                    parque.simularAtracao();
                    break;
                case 4:
                    parque.mostrarFilas();
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