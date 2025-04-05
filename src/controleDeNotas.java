import java.util.Scanner;


public class controleDeNotas {
    public static void main(String[] args) {
    char continuar;
    double maiorNota = 0;
    double menorNota = 0;
    double soma = 0;
    double media = 0;
    int aprovados = 0;
    int recuperacao = 0;
    int reprovado = 0;
    String status = "";

    Scanner entrada = new Scanner(System.in);
    System.out.println("Quantos alunos deseja cadastrar?: ");
    int quantidade = entrada.nextInt();
    entrada.nextLine();

    String[] nomes = new String[quantidade];
    Double[][] notas = new Double[quantidade][2];

    for (int i = 0; i < quantidade; i++) {
        System.out.println("Aluno " + (i + 1) + ": ");
        nomes[i] = entrada.nextLine();
        for (int j = 0; j < 2; j++) {
        System.out.println("Nota " + (j + 1) + ": ");
        notas[i][j] = entrada.nextDouble();
        }
        entrada.nextLine();
    }


    System.out.println("Resultados:");
    for (int i = 0; i < quantidade; i++) {
        soma = notas[i][0] + notas[i][1];
        media = soma / 2;

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

    }

    }
