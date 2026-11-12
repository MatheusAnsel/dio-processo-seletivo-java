package candidatura;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

    private static final double SALARIO_BASE = 2000.0;
    private static final int MAX_SELECIONADOS = 5;
    private static final int MAX_TENTATIVAS = 3;

    public static void main(String[] args) {
        String[] candidatos = {
            "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO",
            "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"
        };

        System.out.println("=== Processo seletivo ===");
        List<String> selecionados = selecaoCandidatos(candidatos);

        System.out.println();
        imprimirSelecionados(selecionados);

        System.out.println();
        for (String candidato : selecionados) {
            entrandoEmContato(candidato);
        }
    }

    static void analisarCandidato(double salarioPretendido) {
        if (SALARIO_BASE > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (SALARIO_BASE == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }

    static List<String> selecaoCandidatos(String[] candidatos) {
        List<String> selecionados = new ArrayList<>();
        int candidatoAtual = 0;

        while (selecionados.size() < MAX_SELECIONADOS && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.printf("O candidato %s solicitou este valor de salário: R$ %.2f%n",
                    candidato, salarioPretendido);
            analisarCandidato(salarioPretendido);

            if (SALARIO_BASE >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                selecionados.add(candidato);
            }
            candidatoAtual++;
        }
        return selecionados;
    }

    static void imprimirSelecionados(List<String> selecionados) {
        System.out.println("=== Candidatos selecionados ===");
        if (selecionados.isEmpty()) {
            System.out.println("Nenhum candidato foi selecionado.");
            return;
        }
        for (int indice = 0; indice < selecionados.size(); indice++) {
            System.out.println("O candidato de nº " + (indice + 1) + " é " + selecionados.get(indice));
        }
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 0;
        boolean atendeu;

        do {
            tentativasRealizadas++;
            atendeu = atender();
            if (!atendeu) {
                System.out.println("Tentativa " + tentativasRealizadas + " sem sucesso para " + candidato);
            }
        } while (!atendeu && tentativasRealizadas < MAX_TENTATIVAS);

        if (atendeu) {
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato
                    + " NA " + tentativasRealizadas + "ª TENTATIVA");
        } else {
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato
                    + ", NÚMERO MÁXIMO DE TENTATIVAS (" + MAX_TENTATIVAS + ") REALIZADAS");
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static boolean atender() {
        return ThreadLocalRandom.current().nextInt(3) == 1;
    }
}
