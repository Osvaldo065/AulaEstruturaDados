public class Circulo {
    // Atributo
    private double raio;
    private static final double PI = 3.14159;

    // Construtor
    public Circulo(double raio) {
        this.raio = raio;
    }

    // Método para calcular área
    public double calcularArea() {
        return PI * raio * raio;
    }

    // Método para calcular circunferência
    public double calcularCircunferencia() {
        return 2 * PI * raio;
    }


    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }


    public static void main(String[] args) {
        Circulo circulo = new Circulo(5.0);
        
        System.out.println("Círculo com raio: " + circulo.getRaio());
        System.out.println("Área: " + circulo.calcularArea());
        System.out.println("Circunferência: " + circulo.calcularCircunferencia());
    }
}
