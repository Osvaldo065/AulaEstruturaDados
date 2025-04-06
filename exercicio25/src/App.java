import java.util.Stack;
import java.util.Scanner;

public class ListaTarefasPilha {
    private Stack<Tarefa> tarefas;
    private Stack<Tarefa> concluidas;
    private Stack<Operacao> historico;

    public ListaTarefasPilha() {
        tarefas = new Stack<>();
        concluidas = new Stack<>();
        historico = new Stack<>();
    }

    // Classe interna para representar uma tarefa
    private class Tarefa {
        String descricao;
        boolean completa;

        Tarefa(String descricao) {
            this.descricao = descricao;
            this.completa = false;
        }

        @Override
        public String toString() {
            return (completa ? "[X] " : "[ ] ") + descricao;
        }
    }

    // Classe interna para registrar operações (para desfazer)
    private class Operacao {
        String tipo; // "ADD", "REMOVE", "COMPLETE"
        Tarefa tarefa;
        int posicao;

        Operacao(String tipo, Tarefa tarefa) {
            this.tipo = tipo;
            this.tarefa = tarefa;
        }
    }

    // Adiciona uma nova tarefa
    public void adicionarTarefa(String descricao) {
        Tarefa novaTarefa = new Tarefa(descricao);
        tarefas.push(novaTarefa);
        historico.push(new Operacao("ADD", novaTarefa));
        System.out.println("Tarefa adicionada: " + descricao);
    }

    // Remove a última tarefa adicionada
    public void removerUltimaTarefa() {
        if (!tarefas.isEmpty()) {
            Tarefa removida = tarefas.pop();
            historico.push(new Operacao("REMOVE", removida));
            System.out.println("Tarefa removida: " + removida.descricao);
        } else {
            System.out.println("Não há tarefas para remover!");
        }
    }

    // Marca a última tarefa como concluída
    public void completarUltimaTarefa() {
        if (!tarefas.isEmpty()) {
            Tarefa completada = tarefas.pop();
            completada.completa = true;
            concluidas.push(completada);
            historico.push(new Operacao("COMPLETE", completada));
            System.out.println("Tarefa concluída: " + completada.descricao);
        } else {
            System.out.println("Não há tarefas para completar!");
        }
    }

    // Desfaz a última operação
    public void desfazer() {
        if (!historico.isEmpty()) {
            Operacao ultimaOp = historico.pop();
            switch (ultimaOp.tipo) {
                case "ADD":
                    tarefas.pop();
                    System.out.println("Desfeito: Adição de " + ultimaOp.tarefa.descricao);
                    break;
                case "REMOVE":
                    tarefas.push(ultimaOp.tarefa);
                    System.out.println("Desfeito: Remoção de " + ultimaOp.tarefa.descricao);
                    break;
                case "COMPLETE":
                    Tarefa t = concluidas.pop();
                    t.completa = false;
                    tarefas.push(t);
                    System.out.println("Desfeito: Conclusão de " + t.descricao);
                    break;
            }
        } else {
            System.out.println("Nada para desfazer!");
        }
    }

    // Exibe todas as tarefas
    public void mostrarTarefas() {
        System.out.println("\n=== LISTA DE TAREFAS ===");
        System.out.println("Tarefas pendentes (" + tarefas.size() + "):");
        for (Tarefa t : tarefas) {
            System.out.println("  " + t);
        }

        System.out.println("\nTarefas concluídas (" + concluidas.size() + "):");
        for (Tarefa t : concluidas) {
            System.out.println("  " + t);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaTarefasPilha lista = new ListaTarefasPilha();

        while (true) {
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Remover última tarefa");
            System.out.println("3 - Marcar última tarefa como concluída");
            System.out.println("4 - Desfazer última ação");
            System.out.println("5 - Mostrar todas as tarefas");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    lista.adicionarTarefa(descricao);
                    break;
                case 2:
                    lista.removerUltimaTarefa();
                    break;
                case 3:
                    lista.completarUltimaTarefa();
                    break;
                case 4:
                    lista.desfazer();
                    break;
                case 5:
                    lista.mostrarTarefas();
                    break;
                case 6:
                    System.out.println("Encerrando aplicativo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}