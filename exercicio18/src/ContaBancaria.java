public class ContaBancaria {
    // Atributos
    private String numeroConta;
    private String titular;
    private double saldo;

    // Construtor
    public ContaBancaria(String numeroConta, String titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0.0;  // Saldo inicializa zerado
    }

    // Método para depositar
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    // Método para sacar
    public void sacar(double valor) {
        if (valor > 0) {
            if (saldo >= valor) {
                saldo -= valor;
                System.out.println("Saque de R$" + valor + " realizado com sucesso.");
            } else {
                System.out.println("Saldo insuficiente para saque.");
            }
        } else {
            System.out.println("Valor de saque inválido.");
        }
    }

    // Método para verificar saldo
    public double verificarSaldo() {
        return saldo;
    }

 
    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

 
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria("12345-6", "João da Silva");
        
        System.out.println("Titular: " + conta.getTitular());
        System.out.println("Conta: " + conta.getNumeroConta());
        
        conta.depositar(1000.00);
        System.out.println("Saldo atual: R$" + conta.verificarSaldo());
        
        conta.sacar(300.00);
        System.out.println("Saldo atual: R$" + conta.verificarSaldo());
        
        conta.sacar(800.00);  // Tentativa de saque maior que o saldo
    }
}
