public class App {

    public static void main(String[] args) throws Exception {

        //Faça um programa que conte a quantidade de vogais em uma string.

        String str = "Meu nome é Osvaldo";
        int count = 0;
        char[] vogais = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < vogais.length; j++) {
                if (str.charAt(i) == vogais[j]) {
                    count++;
                    System.out.println("A quantidade de vogais é: " + count);
                }
            }
        }

    }
}
