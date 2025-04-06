import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

class ChamadoSuporte {
    String id;
    String descricao;
    int prioridade; // 1 = Alta, 2 = Média, 3 = Baixa
    long timestamp;

    public ChamadoSuporte(String id, String descricao, int prioridade) {
        this.id = id;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        String prioridadeStr = "";
        switch (prioridade) {
            case 1: prioridadeStr = "ALTA"; break;
            case 2: prioridadeStr = "MÉDIA"; break;
            case 3: prioridadeStr = "BAIXA"; break;
        }
        return "[" + id + "] " + descricao + " (" + prioridadeStr + ")";
    }
}

public class SistemaSuporteTecnico {
    private PriorityQueue<ChamadoSuporte> filaChamados;
    private int contadorChamados = 1;

    public SistemaSuporteTecnico() {
        // Comparador que prioriza por prioridade e depois por tempo de chegada
        Comparator<ChamadoSuporte> comparadorPrioridade = (c1, c2) -> {
            if (c1.prioridade != c2.prioridade) {
                return Integer.compare(c1.prioridade, c2.prioridade);
            }
            return Long.compare(c1.timestamp, c2.timestamp);
        };
        
        filaChamados = new PriorityQueue<>(comparadorPrioridade);
    }

    public void adicionarChamado(String descricao, int prioridade) {
        String id = "CHAM-" + contadorChamados++;
        ChamadoSuporte novoChamado = new ChamadoSuporte(id, descricao, prioridade);
        filaChamados.add(novoChamado);
        System.out.println("Chamado adicionado: " + novoChamado);
    }

    public void atenderProximoChamado() {
        if (!filaChamados.isEmpty()) {
            ChamadoSuporte chamado = filaChamados.poll();
            System.out.println("\n=== ATENDENDO CHAMADO ===");
            System.out.println(chamado);
            System.out.println("Problema sendo resolvido...");
            System.out.println("Chamado finalizado com sucesso!\n");
        } else {
            System.out.println("Não há chamados para atender!");
        }
    }

    public void mostrarFila() {
        System.out.println("\n=== FILA DE CHAMADOS ===");
        if (filaChamados.isEmpty()) {
            System.out.println("Nenhum chamado na fila.");
        } else {
            System.out.println("Total de chamados pendentes: " + filaChamados.size());
            System.out.println("Próximos chamados:");
            
            // Criar cópia para exibição sem remover da fila
            PriorityQueue<ChamadoSuporte> copia = new PriorityQueue<>(filaChamados);
            int count = 1;
            while (!copia.isEmpty() && count <= 5) {
                System.out.println(count++ + ". " + copia.poll());
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaSuporteTecnico suporte = new SistemaSuporteTecnico();

        while (true) {
            System.out.println("\nMENU DO SISTEMA DE SUPORTE");
            System.out.println("1 - Adicionar chamado");
            System.out.println("2 - Atender próximo chamado");
            System.out.println("3 - Mostrar fila de chamados");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Descrição do problema: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Prioridade (1-Alta, 2-Média, 3-Baixa): ");
                    int prioridade = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    suporte.adicionarChamado(descricao, prioridade);
                    break;
                case 2:
                    suporte.atenderProximoChamado();
                    break;
                case 3:
                    suporte.mostrarFila();
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