package pm_prova2;

public class Musculacao extends Atividade {

    private final int quantidadeAparelhos;

    public Musculacao(String nome, String horario, int duracaoAula, int maxParticipantes,
                      double valorMensal, StatusAtividade status, int quantidadeAparelhos) {
        super(nome, horario, duracaoAula, maxParticipantes, valorMensal, status);
        this.quantidadeAparelhos = quantidadeAparelhos;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[Musculação] " + dadosBasicos() + " | Aparelhos: " + quantidadeAparelhos);
    }

    @Override
    public boolean atividadeColetiva() {
        return false;
    }
}
