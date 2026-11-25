package pm_prova2;

import java.util.ArrayList;
import java.util.List;

public class Spinning extends Atividade implements ControladorPresenca {

    private final int quantidadeBicicletas;
    private final List<String> presencas = new ArrayList<>();

    public Spinning(String nome, String horario, int duracaoAula, int maxParticipantes,
                    double valorMensal, StatusAtividade status, int quantidadeBicicletas) {
        super(nome, horario, duracaoAula, maxParticipantes, valorMensal, status);
        this.quantidadeBicicletas = quantidadeBicicletas;
    }

    @Override
    public void registrarPresenca(String nomeParticipante) {
        if (getStatus() == StatusAtividade.INATIVA) {
            throw new IllegalStateException("A atividade " + getNome() + " está inativa.");
        }
        presencas.add(nomeParticipante);
        System.out.println("Presença de " + nomeParticipante + " registrada em " + getNome() + ".");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[Spinning] " + dadosBasicos() + " | Bicicletas: " + quantidadeBicicletas
                + " | Presenças: " + presencas.size());
    }

    @Override
    public boolean atividadeColetiva() {
        return true;
    }
}
