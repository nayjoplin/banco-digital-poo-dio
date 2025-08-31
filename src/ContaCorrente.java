public class ContaCorrente extends Conta {

    private static final double TARIFA_SAQUE = 0.0; // pode ajustar para simular tarifa
    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void sacar(double valor) {
        double total = valor + TARIFA_SAQUE;
        if (total <= 0) {
            System.out.println("Valor de saque inválido.");
            return;
        }
        if (saldo < total) {
            System.out.println("Saldo insuficiente para saque (inclui tarifa).");
            return;
        }
        saldo -= total;
        System.out.printf("Saque CC de R$%.2f (tarifa R$%.2f). Saldo: R$%.2f%n", valor, TARIFA_SAQUE, saldo);
    }
}
