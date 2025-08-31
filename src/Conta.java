public abstract class Conta {
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = 1;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque inválido.");
            return;
        }
        if (saldo < valor) {
            System.out.println("Saldo insuficiente para saque.");
            return;
        }
        saldo -= valor;
        System.out.printf("Saque de R$%.2f realizado. Saldo atual: R$%.2f%n", valor, saldo);
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de depósito inválido.");
            return;
        }
        saldo += valor;
        System.out.printf("Depósito de R$%.2f realizado. Saldo atual: R$%.2f%n", valor, saldo);
    }

    public void transferir(double valor, Conta destino) {
        if (destino == null) {
            System.out.println("Conta de destino inválida.");
            return;
        }
        if (valor <= 0) {
            System.out.println("Valor de transferência inválido.");
            return;
        }
        if (saldo < valor) {
            System.out.println("Saldo insuficiente para transferência.");
            return;
        }
        this.saldo -= valor;
        destino.saldo += valor;
        System.out.printf("Transferência de R$%.2f para %s (ag %d, conta %d) realizada.%n",
                valor, destino.cliente.getNome(), destino.agencia, destino.numero);
        System.out.printf("Seu novo saldo: R$%.2f%n", this.saldo);
    }

    public String resumo() {
        return String.format("%s - Agência: %d | Conta: %d | Cliente: %s | Saldo: R$%.2f",
                this.getClass().getSimpleName(), agencia, numero, cliente.getNome(), saldo);
    }

    // Getters
    public int getAgencia() { return agencia; }
    public int getNumero() { return numero; }
    public double getSaldo() { return saldo; }
    public Cliente getCliente() { return cliente; }
}
