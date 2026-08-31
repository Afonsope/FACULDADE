import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Estagiario> listaEstagiarios = new ArrayList<>();
        //cadastrar 5 estagiários ao iniciar o programa
        listaEstagiarios.add(new Estagiario("João Silva", "ADS", 2.5f, "joao.silva@email.com", 20, "M"));
        listaEstagiarios.add(new Estagiario("Maria Oliveira", "ADS", 9.0f, "maria.oliveira@email.com", 19, "F"));
        listaEstagiarios.add(new Estagiario("Carlos Santos", "INFO", 7.5f, "carlos.santos@email.com", 21, "M"));
        listaEstagiarios.add(new Estagiario("Ana Costa", "ADS", 4.0f, "ana.costa@email.com", 18, "F"));
        listaEstagiarios.add(new Estagiario("Pedro Almeida", "AGRO", 7.0f, "pedro.almeida@email.com", 22, "O"));
        //EXIBINDO OS ESTAGIÁRIOS CADASTRADOS PELO SISTEMA
        System.out.println("---- Dados cadastrados pelo sistema ----");
        for (Estagiario estagiario : listaEstagiarios) {
            estagiario.exibir();
        }
        Scanner ler = new Scanner(System.in);
        int opcao=0;
        String continuar="S";
        do{
            Estagiario estagiario = new Estagiario();
            estagiario.cadastrar(ler);
            listaEstagiarios.add(estagiario);
            System.out.println("Deseja cadastrar outro estagiário? (S|N)");
            continuar = ler.next().charAt(0)+"";
        }while(continuar.equalsIgnoreCase("S"));
        //mostrar todos os estagiários cadastrados
        for(Estagiario estagiario : listaEstagiarios){
            estagiario.exibir();
        }
        do {
            mostrarMenu();
            opcao = ler.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite a idade mínima:");
                    int idadeMinima = ler.nextInt();
                    System.out.println("Estagiários com idade acima de " + idadeMinima + ":");
                    for (Estagiario estagiario : listaEstagiarios) {
                        if (estagiario.getIdade() > idadeMinima) {
                            System.out.println(estagiario.getNome() + " - Idade: " + estagiario.getIdade());
                        }
                    }
                    break;
                case 2:
                    System.out.println("Estagiários com média geral acima de 7,0:");
                    for (Estagiario estagiario : listaEstagiarios) {
                        if (estagiario.getMediaGeral() > 7.0) {
                            System.out.println(estagiario.getNome() + " - Média Geral: " + estagiario.getMediaGeral());
                        }
                    }
                    break;
                case 3:
                    int countM = 0, countF = 0, countO = 0;
                    for (Estagiario estagiario : listaEstagiarios) {
                        switch (estagiario.getSexo()) {
                            case "M":
                                countM++;
                                break;
                            case "F":
                                countF++;
                                break;
                            case "O":
                                countO++;
                                break;
                        }
                    }
                    System.out.println("Total de estagiários do sexo M: " + countM);
                    System.out.println("Total de estagiários do sexo F: " + countF);
                    System.out.println("Total de estagiários do sexo O: " + countO);
                    break;
                case 4:
                    System.out.println("Estagiários do curso de ADS:");
                    for (Estagiario estagiario : listaEstagiarios) {
                        if (estagiario.getCurso().equalsIgnoreCase("ADS")) {
                            // System.out.println(estagiario.getNome() + " - Idade: " + estagiario.getIdade());
                            estagiario.exibir();
                        }
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                }
        } while (opcao!=5);
    }
    private static void mostrarMenu(){
        System.out.println("=== MENU ===");
        System.out.println("1 - Mostrar nome de estagiários acima de uma idade informada pelo usuário");
        System.out.println("2 - Mostrar nome de estagiários com média geral acima de 7,0");
        System.out.println("3 - Mostrar total de estagiários em cada sexo");
        System.out.println("4 - Mostrar nome e idade dos estagiários do curso de ADS");
        System.out.println("5 - SAIR");
        System.out.println("Digite a opção desejada:");
    }
}