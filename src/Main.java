public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("DIO Bank");
        Cliente maria = new Cliente("Maria");
        Cliente joao = new Cliente("João");

        Conta ccMaria = new ContaCorrente(maria);
        Conta poupJoao = new ContaPoupanca(joao);

        banco.adicionarConta(ccMaria);
        banco.adicionarConta(poupJoao);

        // Operações
        ccMaria.depositar(1000);
        ccMaria.sacar(250);
        ccMaria.transferir(300, poupJoao);

        ((ContaPoupanca) poupJoao).renderJuros(0.02); // 2%

        // Resumos
        banco.listarContas();
        System.out.println(ccMaria.resumo());
        System.out.println(poupJoao.resumo());
    }
}
