public class Carro {
    // Atributos
    private String marca;
    private String modelo;
    private int velocidadeAtual;
    private boolean ligado;

    // Construtor
    public Carro(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadeAtual = 0;
        this.ligado = false;
    }

    // Método para ligar o carro
    public void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println("O carro foi ligado.");
        } else {
            System.out.println("O carro já está ligado.");
        }
    }

    // Método para desligar o carro
    public void desligar() {
        if (ligado && velocidadeAtual == 0) {
            ligado = false;
            System.out.println("O carro foi desligado.");
        } else if (velocidadeAtual > 0) {
            System.out.println("Não é possível desligar o carro em movimento.");
        } else {
            System.out.println("O carro já está desligado.");
        }
    }

    // Método para acelerar
    public void acelerar(int incremento) {
        if (ligado) {
            if (incremento > 0) {
                velocidadeAtual += incremento;
                System.out.println("Acelerando. Velocidade atual: " + velocidadeAtual + " km/h");
            } else {
                System.out.println("O incremento de velocidade deve ser positivo.");
            }
        } else {
            System.out.println("Não é possível acelerar com o carro desligado.");
        }
    }

    // Método para frear
    public void frear(int decremento) {
        if (ligado) {
            if (decremento > 0) {
                if (velocidadeAtual >= decremento) {
                    velocidadeAtual -= decremento;
                    System.out.println("Freando. Velocidade atual: " + velocidadeAtual + " km/h");
                } else {
                    velocidadeAtual = 0;
                    System.out.println("Carro parado completamente.");
                }
            } else {
                System.out.println("O decremento de velocidade deve ser positivo.");
            }
        } else {
            System.out.println("O carro já está parado e desligado.");
        }
    }

    // Método para exibir status
    public void exibirStatus() {
        System.out.println("\n--- Status do Carro ---");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Estado: " + (ligado ? "Ligado" : "Desligado"));
        System.out.println("Velocidade Atual: " + velocidadeAtual + " km/h");
    }

    // Getters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public boolean isLigado() {
        return ligado;
    }

    // Exemplo de uso
    public static void main(String[] args) {
        Carro meuCarro = new Carro("Ford", "Focus");

        meuCarro.exibirStatus();
        meuCarro.ligar();
        meuCarro.acelerar(30);
        meuCarro.acelerar(20);
        meuCarro.frear(15);
        meuCarro.frear(35); // Vai parar completamente
        meuCarro.desligar();
        meuCarro.exibirStatus();
    }
}