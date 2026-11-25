package pm_prova2;

import java.util.Scanner;

/**
 *
 * @author glbra
 */
public class PM_Prova2 {

    public static void main(String[] args) {
        Academia academia = new Academia();
        criarDadosIniciais(academia);
        Scanner scanner = new Scanner(System.in);
        new Menu(academia, scanner).executar();
        scanner.close();
    }

    public static void criarDadosIniciais(Academia academia) {
        academia.adicionarAtividade(new Musculacao("Musculação Manhã", "06:00", 60, 30, 80.0, StatusAtividade.ATIVA, 25));
        academia.adicionarAtividade(new Natacao("Natação Adulto", "07:30", 50, 15, 120.0, StatusAtividade.ATIVA, 1.8));
        academia.adicionarAtividade(new Spinning("Spinning Noite", "19:00", 45, 20, 90.0, StatusAtividade.ATIVA, 20));
        academia.adicionarPlano(new PlanoBasico("Básico", 89.90, 1, StatusPlano.ATIVO));
        academia.adicionarPlano(new PlanoPremium("Premium", 159.90, 5, StatusPlano.ATIVO));
    }
}
