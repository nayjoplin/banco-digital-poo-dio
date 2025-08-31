public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void renderJuros(double taxa) {
        if (taxa <= 0) {
            System.out.println("Taxa inválida.");
            return;
        }
        double acrescimo = saldo * taxa;
        saldo += acrescimo;
        System.out.printf("Rendimento aplicado (%.2f%%): +R$%.2f | Saldo: R$%.2f%n", taxa * 100, acrescimo, saldo);
    }
}
