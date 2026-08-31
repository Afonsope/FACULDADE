/*
    Faça um programa que receba as inscrições de professores para un concurso, este programa funcionará da seguinte forma:

    Os dados dos professores serão:
    Nome
    Idade
    tempo de experiència
    área (1 exatas, 2 biologicas, 3 outras)

    Crie uma classe chamada Validacao para calcular a pontuação dos professores, que tenha os métodos:
    calcularPontuacao(int idade, int tempo, int area)

    a pontuação é calculada da seguinte forma:
    a idade será / 2, somada ao tempo * 3 e somada à área, sendo que,
    para cada área será atribuída a pontuação: 1 -> 5 pontos, 2 -> 10 pontos, 3 -> 15 pontos

    crie os atributos:
    Ent pontuação[] new int[3]; // armazenará a pontuação dos 3 primeiros candidatos
    String candidatos[] new String[3]; // armazenará os nomes dos 3 primeiros candidatos 
    int contadorCandidatos = 0; //armazenará quantos candidatos foram inscritos

    Crie a classe que cadastre uma quantidade indeterminada de candidatos, validando cada entrada de dados, ou seja, 
    Nome não pode ter menos de 3 caracteres, idade não pode ser menor de 18, tempo de experiència não pode ser menor 
    que zero, e área deve ser entre 1 e 3.
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int pontuacao[] = new int[3]; // ARMAZENARÁ A PONTUAÇÃO DOS 3 PRIMEIROS CANDIDATOS
        String candidatos[] = new String[3]; //ARMAZENARÁ OS NOMES DOS 3 PRIMEIROS CANDIDATOS
        int contadorCandidatos = 0; // ARMAZENARÁ QUANTOS CANDIDATOS FORAM INSCRITOS

        String nome = new String();
        int idade = 0, tempoExperiencia = 0, area = 0;
        int continuar= 0;

        do{
            // Para NOME
            while (true) {
                try {
                    System.out.println("Informe o nome da participante " + (contadorCandidatos + 1) + "ª: ");
                    nome = scanner.nextLine();
                    
                    if (Validacao.validaNome(nome)) {
                        throw new Exception("Nome deve ter pelo menos 3 caracteres");
                    }
                    break; // Sai do loop se nome for válido
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }

            // Para IDADE
            while (true) {
                try {
                    System.out.println("Informe a idade da participante " + (contadorCandidatos + 1) + "ª: ");
                    idade = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (Validacao.validaIdade(idade)) {
                        throw new Exception("O candidato precisa ser maior de idade (+18)");
                    }
                    break; // Sai do loop se idade for válida
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }

            // Para TEMPO DE EXPERIÊNCIA
            while (true) {
                try {
                    System.out.println("Informe quantos anos de experiência tem a participante " + (contadorCandidatos + 1) + "ª: ");
                    tempoExperiencia = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (Validacao.validaTempoExperiencia(tempoExperiencia, idade)) {
                        throw new Exception("Tempo de experiência inserido incorretamente");
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }

            // Para ÁREA
            while (true) {
                try {
                    System.out.println("Informe a área da participante " + (contadorCandidatos + 1) + "ª: ");
                    System.out.println("| 1 - Exatas | 2 - Biológicas | 3 - Outras |");
                    area = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (Validacao.validaArea(area)) {
                        throw new Exception("Digite apenas um número entre 1 e 3");
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }

            // Para CONTINUAR
            while (true) {
                try {
                    System.out.println("Deseja continuar?");
                    System.out.println("| 1 - Continuar | 0 - Não |");
                    continuar = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (Validacao.validaContinua(continuar)) {
                        throw new Exception("Digite apenas 0 ou 1");
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }

            int score = Validacao.calcularPontuacao(idade, tempoExperiencia, area);

            if(contadorCandidatos < 3){
               candidatos[contadorCandidatos] = nome;
                pontuacao[contadorCandidatos] = score;
                
                // Ordena após cada inserção para manter a ordem
                for (int i = 0; i < contadorCandidatos; i++) {
                    for (int j = i + 1; j <= contadorCandidatos; j++) {
                        if (pontuacao[i] < pontuacao[j]) {
                            // Troca as pontuações
                            int tempPont = pontuacao[i];
                            pontuacao[i] = pontuacao[j];
                            pontuacao[j] = tempPont;
                            
                            // Troca os nomes
                            String tempNome = candidatos[i];
                            candidatos[i] = candidatos[j];
                            candidatos[j] = tempNome;
                        }
                    }
                }
            }
            else {
                // Encontra a posição onde inserir (se for maior que algum existente)
                boolean inseriu = false;
                for(int i = 0; i < 3; i++){
                    if(score > pontuacao[i]){
                        // Desloca os elementos para baixo
                        for(int j = 2; j > i; j--){
                            candidatos[j] = candidatos[j-1];
                            pontuacao[j] = pontuacao[j-1];
                        }
                        // Insere o novo candidato
                        candidatos[i] = nome;
                        pontuacao[i] = score;
                        inseriu = true;
                        break;
                    }
                }
                
                // Se inseriu, reordena para garantir que ficou correto
                if (inseriu) {
                    for (int i = 0; i < 2; i++) {
                        for (int j = i + 1; j < 3; j++) {
                            if (pontuacao[i] < pontuacao[j]) {
                                // Troca pontuações
                                int tempPont = pontuacao[i];
                                pontuacao[i] = pontuacao[j];
                                pontuacao[j] = tempPont;
                                
                                // Troca nomes
                                String tempNome = candidatos[i];
                                candidatos[i] = candidatos[j];
                                candidatos[j] = tempNome;
                            }
                        }
                    }
                }
            }
            
            contadorCandidatos++;
        } while(Validacao.continua(continuar));

        System.out.println("Os classificados no concurso:");
        for(int i = 0; i < 3; i++){
            System.out.println(candidatos[i] + " - " + pontuacao[i] + " pontos");
        }
        System.out.println("E participaram " + contadorCandidatos + " pessoas.");

    }
}
