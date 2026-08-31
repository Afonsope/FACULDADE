import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String[] modalidades = new String[3];
        
        // CONDIÇÃO PARA CONTINUAR
        int continuar = 0;
        // VARIAVEIS RELACIONADAS A MODALIDADE
        int escolhaMod = 0;
        int[] contModalidades = new int[3];
        // VARIAVEIS RELACIONADAS A TURNO
        int escolhaTurnos = 0;
        int[] modalidade1Turnos =  new int[3];
        int[] modalidade2Turnos =  new int[3];
        int[] modalidade3Turnos =  new int[3];

        // MODALIDADES
        for(int i = 0; i < 3; i++) {
            System.out.println("Informe a " + (i+1) + "ª modalidade desejada: ");
            modalidades[i] = scanner.nextLine();
        }

        do {
            // ALUNO ESCOLHE QUAL MODALIDADE ELE DESEJA
            try {
                System.out.println("Escolha uma modalidade: \n");
                for(int i = 0; i < 3; i++) {
                    System.out.println((i+1) + " | " + modalidades[i]);
                }
                escolhaMod = scanner.nextInt();

                if(escolhaMod == 1)
                    contModalidades[0]++;
                if(escolhaMod == 2)
                    contModalidades[1]++;
                if(escolhaMod == 3)
                    contModalidades[2]++;
                else
                    throw new Exception("Digite um valor entre 1 e 3");
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

            // TURNOS
                System.out.println("Informe o turno desejado para jogar: " + modalidades[(escolhaMod - 1)]);
                System.out.println("| 1 - Manhã | 2 - Tarde | 3 - Noite |");
                escolhaTurnos = scanner.nextInt();
           switch (escolhaTurnos) {

    case 1:
        if (escolhaMod == 1) modalidade1Turnos[0]++;
        if (escolhaMod == 2) modalidade2Turnos[0]++;
        if (escolhaMod == 3) modalidade3Turnos[0]++;
        break;

    case 2:
        if (escolhaMod == 1) modalidade1Turnos[1]++;
        if (escolhaMod == 2) modalidade2Turnos[1]++;
        if (escolhaMod == 3) modalidade3Turnos[1]++;
        break;

    case 3:
        if (escolhaMod == 1) modalidade1Turnos[2]++;
        if (escolhaMod == 2) modalidade2Turnos[2]++;
        if (escolhaMod == 3) modalidade3Turnos[2]++;
        break;

    default:
        System.out.println("Turno inválido.");
}

            try {
                System.out.println("Haverá mais algum voto?");
                System.out.println("| 1 - Sim | 0 - Não |");
                continuar = scanner.nextInt();
                if(continuar > 1)
                    throw new Exception("Digite apenas 0 ou 1");
            } catch(Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while(continuar == 1);

        if (contModalidades[0] > contModalidades[1] && contModalidades[0] > contModalidades[2]) {
            System.out.println("A modalidade mais votada é: " + modalidades[0]);
            if (modalidade1Turnos[0] > modalidade1Turnos[1] && modalidade1Turnos[0] > modalidade1Turnos[2]) {
                System.out.println("E seu turno será de Manhã");
            }
            if (modalidade1Turnos[1] > modalidade1Turnos[0] && modalidade1Turnos[1] > modalidade1Turnos[2]) {
                System.out.println("E seu turno será de Tarde");
            }
            else {
                System.out.println("E seu turno será de Noite");
            }
        }
        if (contModalidades[1] > contModalidades[0] && contModalidades[1] > contModalidades[2]) {
            System.out.println("A modalidade mais votada é: " + modalidades[1]);
            if (modalidade2Turnos[0] > modalidade2Turnos[1] && modalidade2Turnos[0] > modalidade2Turnos[2]) {
                System.out.println("E seu turno será de Manhã");
            }
            if (modalidade2Turnos[1] > modalidade2Turnos[0] && modalidade2Turnos[1] > modalidade2Turnos[2]) {
                System.out.println("E seu turno será de Tarde");
            }
            else {
                System.out.println("E seu turno será de Noite");
            }
        }
        else {
            System.out.println("A modalidade mais votada é: " + modalidades[2]);
            if (modalidade3Turnos[0] > modalidade3Turnos[1] && modalidade3Turnos[0] > modalidade3Turnos[2]) {
                System.out.println("E seu turno será de Manhã");
            }
            if (modalidade3Turnos[1] > modalidade3Turnos[0] && modalidade3Turnos[1] > modalidade3Turnos[2]) {
                System.out.println("E seu turno será de Tarde");
            }
            else {
                System.out.println("E seu turno será de Noite");
            }
        }

/*// Descobrir modalidade mais votada
int indiceMaisVotada = 0;

if (contModalidades[1] > contModalidades[indiceMaisVotada]) {
    indiceMaisVotada = 1;
}

if (contModalidades[2] > contModalidades[indiceMaisVotada]) {
    indiceMaisVotada = 2;
}

System.out.println("A modalidade mais votada é: " + modalidades[indiceMaisVotada]);

// Descobrir turno mais votado da modalidade vencedora
int turnoMaisVotado = 0;
int[] turnosVencedora;

if (indiceMaisVotada == 0) {
    turnosVencedora = modalidade1Turnos;
} 
else if (indiceMaisVotada == 1) {
    turnosVencedora = modalidade2Turnos;
} 
else {
    turnosVencedora = modalidade3Turnos;
}

// Descobrir maior turno
if (turnosVencedora[1] > turnosVencedora[turnoMaisVotado]) {
    turnoMaisVotado = 1;
}

if (turnosVencedora[2] > turnosVencedora[turnoMaisVotado]) {
    turnoMaisVotado = 2;
}

// Mostrar turno
switch (turnoMaisVotado) {
    case 0:
        System.out.println("E seu turno será de Manhã");
        break;
    case 1:
        System.out.println("E seu turno será de Tarde");
        break;
    case 2:
        System.out.println("E seu turno será de Noite");
        break;
}*/



        scanner.close();
    }
}
