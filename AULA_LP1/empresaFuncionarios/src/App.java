import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        final int SALARIO_BASE = 1000;

        String nome = new String();
        String email = new String();
        String departamento = new String();
        String funcionariosTI = new String();
        String funcionariosSalarios = new String();
        String funcionariosSalariosReajuste = new String();
        String maiorSalario = new String();

        float salario = 0, somaSalarios = 0, maiorSalarioValor = 0;

        int contFuncionarios = 0,continuar = 0;

        do {
            int validaNome = 0, validaEmail = 0, validaSalario = 0, validaDepartamento = 0;

                do{
                    try {
                        System.out.println("Informe o nome do funcinário: ");
                        nome = scanner.nextLine();
                        if(nome.length() < 10)
                            throw new Exception("Infome um nome com pelo menos 10 caracteres");
                        validaNome = 1;
                    } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                    }
                } while(validaNome == 0);

                do {
                    try {
                        System.out.println("Informe o email do funcinário: ");
                        email = scanner.nextLine();
                        if(email.length() < 15 || !email.contains("@") || !email.contains("."))
                            throw new Exception("Infome um email com pelo menos 15 caracteres e precisa conter um @");
                        validaEmail = 1;
                    } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                    }
                } while(validaEmail == 0);

                do {
                    try {
                        System.out.println("Informe o salário do funcinário: ");
                        salario = scanner.nextFloat();
                        scanner.nextLine(); // limpar buffer
                        if(salario < SALARIO_BASE)
                            throw new Exception("Infome um salario acima de " + SALARIO_BASE);
                        validaSalario = 1;
                    } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                    }
                } while(validaSalario == 0);

                do {
                    try {
                        System.out.println("Informe o departamento do funcinário: ");
                        departamento = scanner.nextLine();
                        if(departamento.equals(""))
                            throw new Exception("O usuario deve ter um departamento");
                        validaDepartamento = 1;
                    } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                    }
                } while(validaDepartamento == 0);

                contFuncionarios++;

                if (contFuncionarios == 1) {
                    maiorSalario = departamento;
                    maiorSalarioValor = salario;
                } else {
                    if (salario > maiorSalarioValor) {
                        maiorSalario = departamento;
                        maiorSalarioValor = salario;
                    }
                }

                somaSalarios += salario;

                if (departamento.toUpperCase().equals("TI") || departamento.toUpperCase().equals("TECNICO EM INFORMÁTICA")) {
                    funcionariosTI += nome + " - " + email + "\n";
                }

                funcionariosSalarios += nome + " - " + departamento + " - " + salario + "\n";

                funcionariosSalariosReajuste += nome + " - " + departamento + " - " + (salario*1.2) + "\n";

            System.out.println("Deseja cadastrar mais um usuario?");
            System.out.println("| 1 - Sim | 2 - Não |");
            continuar = scanner.nextInt();
            scanner.nextLine();
        } while(continuar == 1);

        System.out.println("O departamento do funcionário que recebe o maior salário: " + maiorSalario);
        System.out.println("A média dos salários de todos os funcionários: " + (somaSalarios/contFuncionarios));
        System.out.println("Os e-mail dos funcionários do departamento de TI: " + funcionariosTI);
        System.out.println("Quanto seria o novo salário dos funcionários: " + funcionariosSalarios);
        System.out.println("Quanto seria o novo salário dos funcionários com aumento de 20%: " + funcionariosSalariosReajuste);
        
        scanner.close();
    }
}
