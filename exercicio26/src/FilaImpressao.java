import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FilaImpressao {
    private Queue<String> filaImpressao;
    private int documentoAtual;

    public FilaImpressao() {
        filaImpressao = new LinkedList<>();
        documentoAtual = 1;
    }

    // Adiciona um documento à fila de impressão
    public void adicionarDocumento(String nomeDocumento) {
        String documento = "Doc" + documentoAtual++ + "_" + nomeDocumento;
        filaImpressao.add(documento);
        System.out.println("Documento adicionado: " + documento);
    }

    // Processa (imprime) o próximo documento da fila
    public void imprimirProximo() {
        if (!filaImpressao.isEmpty()) {
            String documento = filaImpressao.poll();
            System.out.println("Imprimindo: " + documento);
        } else {
            System.out.println("Fila de impressão vazia!");
        }
    }

    // Mostra todos os documentos na fila
    public void mostrarFila() {
        System.out.println("\n=== FILA DE IMPRESSÃO ===");
        if (filaImpressao.isEmpty()) {
            System.out.println("A fila está vazia.");
        } else {
            System.out.println("Documentos na fila (" + filaImpressao.size() + "):");
            for (String doc : filaImpressao) {
                System.out.println("  - " + doc);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilaImpressao impressora = new FilaImpressao();

        while (true) {
            System.out.println("\nMENU DA IMPRESSORA");
            System.out.println("1 - Adicionar documento");
            System.out.println("2 - Imprimir próximo documento");
            System.out.println("3 - Mostrar fila de impressão");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do documento: ");
                    String nomeDoc = scanner.nextLine();
                    impressora.adicionarDocumento(nomeDoc);
                    break;
                case 2:
                    impressora.imprimirProximo();
                    break;
                case 3:
                    impressora.mostrarFila();
                    break;
                case 4:
                    System.out.println("Encerrando sistema de impressão...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}