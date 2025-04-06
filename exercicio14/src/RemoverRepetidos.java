import java.util.HashSet;
import java.util.Set;

public class RemoverRepetidos {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 2, 3, 5, 6, 1};
        
        Set<Integer> elementosUnicos = new HashSet<>();
        
        for (int num : array) {
            elementosUnicos.add(num);
        }
        
        System.out.println("Elementos sem repetição:");
        for (int num : elementosUnicos) {
            System.out.print(num + " ");
        }
    }
}