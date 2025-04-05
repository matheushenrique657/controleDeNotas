import java.util.Scanner;
import java.util.ArrayList;

public class controleDeNotas {
    public static void main(String[] args) {
    char loop;
    double maiorNota = -1;
    double menorNota = 11;
    double soma = 0;
    double somaMedia = 0;
    double media = 0;

    String status = "";

    Scanner entrada = new Scanner(System.in);
    do{


    System.out.println("Quantos alunos deseja cadastrar?: ");
    int quantidade = entrada.nextInt();
    entrada.nextLine();
        int aprovados = 0;
        int recuperacao = 0;
        int reprovado = 0;
    String[] nomes = new String[quantidade];
    Double[][] notas = new Double[quantidade][2];
    ArrayList<Double> medias = new ArrayList<>();

    for (int i = 0; i < quantidade; i++) {
        System.out.println("Aluno " + (i + 1) + ": ");
        nomes[i] = entrada.nextLine();
        for (int j = 0; j < 2; j++) {
        System.out.println("Nota " + (j + 1) + ": ");
        notas[i][j] = entrada.nextDouble();

        while (notas[i][j] <0 || notas[i][j] > 10) {
            System.out.println("Nota inválida! Digite uma nota entre 1 e 10: ");
            notas[i][j] = entrada.nextDouble();
        }
        }
        entrada.nextLine();
    }


    System.out.println("Resultados:");
    for (int i = 0; i < quantidade; i++) {
        soma = notas[i][0] + notas[i][1];
        media = soma / 2;
        medias.add(media);

        if (media >= 7) {
        status = "Aprovado";
        aprovados++;
        } else if (media >= 5) {
            status = "Recuperação";
            recuperacao++;
        } else {
            status = "Reprovado";
            reprovado++;
        }
        System.out.println(nomes[i] + " - Media: " + media + " - Status: " + status);
       }

    for (int i = 0; i < quantidade; i++) {
        for (int j = 0; j < 2; j++) {
            if (notas[i][j] > maiorNota) {
                maiorNota = notas[i][j];
            } if (notas[i][j] < menorNota) {
                menorNota = notas[i][j];
            }
        }

    }

    for (int i = 0; i < medias.size(); i++) {
        somaMedia += medias.get(i) / medias.size();
    }

    System.out.printf("Media da Turma: %.1f ", somaMedia);
    System.out.println("\nMaior nota: " + maiorNota);
    System.out.println("Menor nota: " + menorNota);
    System.out.println("Aprovado: " + aprovados);
    System.out.println("Recuperacao: " + recuperacao);
    System.out.println("Reprovado: " + reprovado);

    System.out.print("\nCadastrar outra turma? (S/N): ");
    loop = entrada.nextLine().charAt(0);
    entrada.nextLine();
    } while (loop == 'S' || loop == 's');
    }

    }
