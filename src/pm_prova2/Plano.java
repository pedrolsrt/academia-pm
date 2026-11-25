package pm_prova2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author glbra
 */
public abstract class Plano {

    private String nome;
    private double valorMensal;
    private int quantidadeMaximaAtividades;
    private StatusPlano status;
    private final List<Atividade> atividades = new ArrayList<>();

    public Plano(String nome,
                 double valorMensal,
                 int quantidadeMaximaAtividades,
                 StatusPlano status) {

        this.nome = nome;
        this.valorMensal = valorMensal;
        this.quantidadeMaximaAtividades = quantidadeMaximaAtividades;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public int getQuantidadeMaximaAtividades() {
        return quantidadeMaximaAtividades;
    }

    public void setQuantidadeMaximaAtividades(int quantidadeMaximaAtividades) {
        this.quantidadeMaximaAtividades = quantidadeMaximaAtividades;
    }

    public StatusPlano getStatus() {
        return status;
    }

    public void setStatus(StatusPlano status) {
        this.status = status;
    }

    public List<Atividade> getAtividades() {
        return List.copyOf(atividades);
    }

    public void associarAtividade(Atividade atividade) {
        if (status != StatusPlano.ATIVO) {
            throw new IllegalStateException("O plano " + nome + " não está ativo.");
        }
        if (atividade.getStatus() == StatusAtividade.INATIVA) {
            throw new IllegalStateException("A atividade " + atividade.getNome() + " está inativa.");
        }
        if (atividades.contains(atividade)) {
            throw new IllegalStateException("A atividade já está associada a este plano.");
        }
        if (atividade.atividadeColetiva() && !permiteAtividadeColetiva()) {
            throw new IllegalStateException("O plano " + nome + " permite apenas atividades individuais.");
        }
        if (atividades.size() >= quantidadeMaximaAtividades) {
            throw new IllegalStateException("O plano " + nome + " atingiu o limite de atividades.");
        }
        atividades.add(atividade);
    }

    public void removerAtividade(Atividade atividade) {
        atividades.remove(atividade);
    }

    protected String dadosBasicos() {
        List<String> nomes = new ArrayList<>();
        for (Atividade a : atividades) {
            nomes.add(a.getNome());
        }
        return nome + " | R$ " + String.format("%.2f", valorMensal) + " | " + status
                + " | Atividades (" + atividades.size() + "/" + quantidadeMaximaAtividades + "): "
                + (nomes.isEmpty() ? "nenhuma" : String.join(", ", nomes));
    }

    public abstract void exibirDetalhes();

    public abstract boolean permiteAtividadeColetiva();
}
