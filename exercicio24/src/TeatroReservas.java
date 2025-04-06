import java.util.Stack;
import java.util.Scanner;

public class TeatroReservas {
    private Stack<String> assentosDisponiveis;
    private Stack<String> assentosReservados;
    private int capacidadeTotal;

    public TeatroReservas(int capacidade) {
        this.capacidadeTotal = capacidade;
        assentosDisponiveis = new Stack<>();
        assentosReservados = new Stack<>();
        inicializarAssentos();
    }

    private void inicializarAssentos() {
        // Cria assentos de A1 até A[n] onde n é a capacidade
        for (int i = capacidadeTotal; i >= 1; i--) {
            assentosDisponiveis.push("A" + i);
        }
    }

    public boolean reservarAssento() {
        if (!assentosDisponiveis.isEmpty()) {
            String assento = assentosDisponiveis.pop();
            assentosReservados.push(assento);
            System.out.println("Assento " + assento + " reservado com sucesso!");
            return true;
        }
        System.out.println("Não há assentos disponíveis!");
        return false;
    }

    public boolean cancelarUltimaReserva() {
        if (!assentosReservados.isEmpty()) {
            String assento = assentosReservados.pop();
            assentosDisponiveis.push(assento);
            System.out.println("Reserva do assento " + assento + " cancelada!");
            return true;
        }
        System.out.println("Não há reservas para cancelar!");
        return false;
    }

    public void mostrarEstado() {
        System.out.println("\n=== ESTADO DO TEATRO ===");
        System.out.println("Capacidade total: " + capacidadeTotal);
        System.out.println("Assentos disponíveis: " + assentosDisponiveis.size());
        System.out.println("Assentos reservados: " + assentosReservados.size());
        System.out.println("Últimos 5 assentos disponíveis: " + 
            (assentosDisponiveis.size() > 5 ? assentosDisponiveis.subList(0, 5) : assentosDisponiveis));
        System.out.println("Últimas 5 reservas: " + 
            (assentosReservados.size() > 5 ? assentosReservados.subList(0, 5) : assentosReservados));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe a capacidade do teatro: ");
        int capacidade = scanner.nextInt();
        
        TeatroReservas teatro = new TeatroReservas(capacidade);
        
        while (true) {
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("1 - Reservar assento");
            System.out.println("2 - Cancelar última reserva");
            System.out.println("3 - Visualizar estado");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    teatro.reservarAssento();
                    break;
                case 2:
                    teatro.cancelarUltimaReserva();
                    break;
                case 3:
                    teatro.mostrarEstado();
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