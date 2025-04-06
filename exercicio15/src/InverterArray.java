public class InverterArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        
        System.out.println("Array original:");
        imprimirArray(array);
        
        inverterArray(array);
        
        System.out.println("\nArray invertido:");
        imprimirArray(array);
    }
    
    public static void inverterArray(int[] array) {
        int inicio = 0;
        int fim = array.length - 1;
        
        while (inicio < fim) {
            int temp = array[inicio];
            array[inicio] = array[fim];
            array[fim] = temp;
            
            inicio++;
            fim--;
        }
    }
    
    public static void imprimirArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}