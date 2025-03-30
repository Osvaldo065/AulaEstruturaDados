public class App {
    public static void main(String[] args) throws Exception {

        // valores do Array
        int[] array = {5, 4, 3, 2, 1};

        // Verifica se o array está ordenado
        boolean isSorted = isArraySorted(array);

        // Exibe o resultado
        if (isSorted) {
            System.out.println("O array está ordenado de forma crescente.");
        } else {
            System.out.println("O array NÃO está ordenado de forma crescente.");
        }
    }

    // Método para verificar se o array está ordenado de forma crescente
    public static boolean isArraySorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false; 
            }
        }
        return true;
    }
}
