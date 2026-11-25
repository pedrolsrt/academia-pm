package pm_prova2;

/**
 *
 * @author glbra
 */
public abstract class Atividade {

    private String nome;
    private String horario;
    private int duracaoAula;
    private int quantidadeMaximaParticipantes;
    private double valorMensal;
    private StatusAtividade status;

    public Atividade(String nome,
                     String horario,
                     int duracaoAula,
                     int quantidadeMaximaParticipantes,
                     double valorMensal,
                     StatusAtividade status) {

        this.nome = nome;
        this.horario = horario;
        this.duracaoAula = duracaoAula;
        this.quantidadeMaximaParticipantes = quantidadeMaximaParticipantes;
        this.valorMensal = valorMensal;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getDuracaoAula() {
        return duracaoAula;
    }

    public void setDuracaoAula(int duracaoAula) {
        this.duracaoAula = duracaoAula;
    }

    public int getQuantidadeMaximaParticipantes() {
        return quantidadeMaximaParticipantes;
    }

    public void setQuantidadeMaximaParticipantes(int quantidadeMaximaParticipantes) {
        this.quantidadeMaximaParticipantes = quantidadeMaximaParticipantes;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public StatusAtividade getStatus() {
        return status;
    }

    public void setStatus(StatusAtividade status) {
        this.status = status;
    }

    protected String dadosBasicos() {
        return nome + " | " + horario + " | " + duracaoAula + " min | máx. " + quantidadeMaximaParticipantes
                + " | R$ " + String.format("%.2f", valorMensal) + " | " + status
                + " | " + (atividadeColetiva() ? "coletiva" : "individual");
    }

    public abstract void exibirDetalhes();

    public abstract boolean atividadeColetiva();
}
