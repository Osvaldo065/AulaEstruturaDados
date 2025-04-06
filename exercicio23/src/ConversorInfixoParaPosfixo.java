import java.util.Stack;
import java.util.HashMap;

public class ConversorInfixoParaPosfixo {

    // Mapa de precedência de operadores
    private static final HashMap<Character, Integer> PRECEDENCIA = new HashMap<>();
    
    static {
        PRECEDENCIA.put('+', 1);
        PRECEDENCIA.put('-', 1);
        PRECEDENCIA.put('*', 2);
        PRECEDENCIA.put('/', 2);
        PRECEDENCIA.put('^', 3);
    }

    public static String infixoParaPosfixo(String expressaoInfixa) {
        StringBuilder saida = new StringBuilder();
        Stack<Character> pilhaOperadores = new Stack<>();
        
        for (int i = 0; i < expressaoInfixa.length(); i++) {
            char c = expressaoInfixa.charAt(i);
            
            // Se for um espaço, ignorar
            if (c == ' ') {
                continue;
            }
            
            // Se for um dígito ou letra (operando), adicionar à saída
            if (Character.isLetterOrDigit(c)) {
                saida.append(c);
            }
            // Se for '(', empilhar
            else if (c == '(') {
                pilhaOperadores.push(c);
            }
            // Se for ')', desempilhar até encontrar '('
            else if (c == ')') {
                while (!pilhaOperadores.isEmpty() && pilhaOperadores.peek() != '(') {
                    saida.append(pilhaOperadores.pop());
                }
                pilhaOperadores.pop(); // Remover o '(' da pilha
            }
            // Se for um operador
            else {
                while (!pilhaOperadores.isEmpty() && 
                       pilhaOperadores.peek() != '(' && 
                       PRECEDENCIA.getOrDefault(pilhaOperadores.peek(), 0) >= PRECEDENCIA.getOrDefault(c, 0)) {
                    saida.append(pilhaOperadores.pop());
                }
                pilhaOperadores.push(c);
            }
        }
        
        // Desempilhar todos os operadores restantes
        while (!pilhaOperadores.isEmpty()) {
            saida.append(pilhaOperadores.pop());
        }
        
        return saida.toString();
    }

    public static void main(String[] args) {
        String[] testes = {
            "A + B",
            "A + B * C",
            "(A + B) * C",
            "A + B * C - D / E",
            "(A + B) * (C - D)",
            "A * B + C * D",
            "A + B + C + D",
            "A ^ B * C - D + E / F / (G + H)"
        };
        
        for (String teste : testes) {
            System.out.println("Infixa: " + teste);
            System.out.println("Pós-fixa: " + infixoParaPosfixo(teste));
            System.out.println();
        }
    }
}