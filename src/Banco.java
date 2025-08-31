import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas = new ArrayList<>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarConta(Conta conta) {
        if (conta != null && !contas.contains(conta)) {
            contas.add(conta);
        }
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void listarContas() {
        System.out.println("=== Contas do Banco " + nome + " ===");
        for (Conta c : contas) {
            System.out.println(c.resumo());
        }
    }
}
