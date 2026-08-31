import java.util.Scanner;
import java.util.ArrayList;

import Entities.AdminEntity;
import Entities.EmpresaEntity;
import Entities.EstagiarioEntity;

public class Menu {

    // ─── Helpers de leitura validada ─────────────────────────────────────────────

    /** Lê um inteiro positivo com do-while + try-catch. */
    private int lerInteiro(Scanner scanner, String campo) {
        int valor = 0;
        boolean valido = false;
        do {
            try {
                System.out.print("Digite " + campo + ": ");
                valor = Integer.parseInt(scanner.nextLine().trim());
                if (valor <= 0) {
                    System.out.println("  [Erro] " + campo + " deve ser um número positivo. Tente novamente.");
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("  [Erro] Valor inválido para " + campo + ". Digite apenas números inteiros.");
            }
        } while (!valido);
        return valor;
    }

    /** Lê um float positivo com do-while + try-catch. */
    private float lerFloat(Scanner scanner, String campo, float min, float max) {
        float valor = 0f;
        boolean valido = false;
        do {
            try {
                System.out.print("Digite " + campo + " (" + min + " a " + max + "): ");
                valor = Float.parseFloat(scanner.nextLine().trim().replace(",", "."));
                if (valor < min || valor > max) {
                    System.out.println("  [Erro] " + campo + " deve estar entre " + min + " e " + max + ".");
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("  [Erro] Valor inválido para " + campo + ". Use ponto ou vírgula como decimal.");
            }
        } while (!valido);
        return valor;
    }

    /** Lê uma String não vazia, respeitando tamanho máximo opcional. */
    private String lerTexto(Scanner scanner, String campo, int maxLength) {
        String valor = "";
        boolean valido = false;
        do {
            try {
                System.out.print("Digite " + campo + ": ");
                valor = scanner.nextLine().trim();
                if (valor.isEmpty()) {
                    System.out.println("  [Erro] " + campo + " não pode ser vazio.");
                } else if (maxLength > 0 && valor.length() > maxLength) {
                    System.out.println("  [Erro] " + campo + " deve ter no máximo " + maxLength + " caracteres.");
                } else {
                    valido = true;
                }
            } catch (Exception e) {
                System.out.println("  [Erro] Falha ao ler " + campo + ". Tente novamente.");
            }
        } while (!valido);
        return valor;
    }

    /** Lê um e-mail com validação básica de formato. */
    private String lerEmail(Scanner scanner) {
        String valor = "";
        boolean valido = false;
        do {
            try {
                System.out.print("Digite o e-mail: ");
                valor = scanner.nextLine().trim();
                if (!valor.matches("^[\\w._%+\\-]+@[\\w.\\-]+\\.[a-zA-Z]{2,}$")) {
                    System.out.println("  [Erro] E-mail inválido. Exemplo: nome@dominio.com");
                } else {
                    valido = true;
                }
            } catch (Exception e) {
                System.out.println("  [Erro] Falha ao ler o e-mail. Tente novamente.");
            }
        } while (!valido);
        return valor;
    }

    /** Lê uma senha com comprimento mínimo. */
    private String lerSenha(Scanner scanner, int minLength) {
        String valor = "";
        boolean valido = false;
        do {
            try {
                System.out.print("Digite a senha (mínimo " + minLength + " caracteres): ");
                valor = scanner.nextLine().trim();
                if (valor.length() < minLength) {
                    System.out.println("  [Erro] A senha deve ter pelo menos " + minLength + " caracteres.");
                } else {
                    valido = true;
                }
            } catch (Exception e) {
                System.out.println("  [Erro] Falha ao ler a senha. Tente novamente.");
            }
        } while (!valido);
        return valor;
    }

    /** Lê um CNPJ com validação de formato (XX.XXX.XXX/XXXX-XX). */
    private String lerCNPJ(Scanner scanner) {
        String valor = "";
        boolean valido = false;
        do {
            try {
                System.out.print("Digite o CNPJ (formato XX.XXX.XXX/XXXX-XX): ");
                valor = scanner.nextLine().trim();
                if (!valor.matches("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}")) {
                    System.out.println("  [Erro] CNPJ inválido. Use o formato XX.XXX.XXX/XXXX-XX.");
                } else {
                    valido = true;
                }
            } catch (Exception e) {
                System.out.println("  [Erro] Falha ao ler o CNPJ. Tente novamente.");
            }
        } while (!valido);
        return valor;
    }

    /** Lê um telefone com validação de formato básico. */
    private String lerTelefone(Scanner scanner) {
        String valor = "";
        boolean valido = false;
        do {
            try {
                System.out.print("Digite o telefone (ex: (11) 91234-5678): ");
                valor = scanner.nextLine().trim();
                if (!valor.matches("\\(\\d{2}\\)\\s?\\d{4,5}-\\d{4}")) {
                    System.out.println("  [Erro] Telefone inválido. Exemplo: (11) 91234-5678");
                } else {
                    valido = true;
                }
            } catch (Exception e) {
                System.out.println("  [Erro] Falha ao ler o telefone. Tente novamente.");
            }
        } while (!valido);
        return valor;
    }

    /** Lê um sexo válido (M/F/O). */
    private String lerSexo(Scanner scanner) {
        String valor = "";
        boolean valido = false;
        do {
            try {
                System.out.print("Digite o sexo (M/F/O): ");
                valor = scanner.nextLine().trim().toUpperCase();
                if (!valor.equals("M") && !valor.equals("F") && !valor.equals("O")) {
                    System.out.println("  [Erro] Sexo inválido. Use M (masculino), F (feminino) ou O (outro).");
                } else {
                    valido = true;
                }
            } catch (Exception e) {
                System.out.println("  [Erro] Falha ao ler o sexo. Tente novamente.");
            }
        } while (!valido);
        return valor;
    }

    // ─── Menu principal ───────────────────────────────────────────────────────────

    public void exibirMenu() {

        Scanner scanner = new Scanner(System.in);

        ArrayList<EmpresaEntity>    empresas    = new ArrayList<>();
        ArrayList<EstagiarioEntity> estagiarios = new ArrayList<>();
        ArrayList<AdminEntity>      admins      = new ArrayList<>();

        int opcao = 0;

        while (opcao != 7) {
            System.out.println("\n========================================");
            System.out.println("  Bem-vindo ao sistema de estágio!");
            System.out.println("========================================");
            System.out.println("1. Cadastrar empresa");
            System.out.println("2. Cadastrar estagiário");
            System.out.println("3. Cadastrar administrador");
            System.out.println("4. Listar empresas");
            System.out.println("5. Listar estagiários");
            System.out.println("6. Listar administradores");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            // Leitura da opção do menu com do-while + try-catch
            boolean opcaoValida = false;
            do {
                try {
                    opcao = Integer.parseInt(scanner.nextLine().trim());
                    if (opcao < 1 || opcao > 7) {
                        System.out.print("  [Erro] Opção inválida (1-7). Tente novamente: ");
                    } else {
                        opcaoValida = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.print("  [Erro] Digite apenas o número da opção desejada: ");
                }
            } while (!opcaoValida);

            switch (opcao) {

                // ── CADASTRAR EMPRESA ─────────────────────────────────────────
                case 1:
                    System.out.println("\n--- Cadastrar Empresa ---");
                    EmpresaEntity novaEmpresa = new EmpresaEntity();

                    novaEmpresa.setId(lerInteiro(scanner, "o ID da empresa"));
                    novaEmpresa.setNome(lerTexto(scanner, "o nome da empresa", 100));
                    novaEmpresa.setEmail(lerEmail(scanner));
                    novaEmpresa.setSenha(lerSenha(scanner, 6));
                    novaEmpresa.setSite(lerTexto(scanner, "o site da empresa", 200));
                    novaEmpresa.setContato(lerTexto(scanner, "o contato da empresa", 100));
                    novaEmpresa.setTelefone(lerTelefone(scanner));
                    novaEmpresa.setCNPJ(lerCNPJ(scanner));
                    novaEmpresa.setIE(lerTexto(scanner, "a IE da empresa", 20));

                    empresas.add(novaEmpresa);
                    System.out.println("\n✔ Empresa cadastrada com sucesso!");
                    break;

                // ── CADASTRAR ESTAGIÁRIO ──────────────────────────────────────
                case 2:
                    System.out.println("\n--- Cadastrar Estagiário ---");
                    EstagiarioEntity novoEstagiario = new EstagiarioEntity();

                    novoEstagiario.setId(lerInteiro(scanner, "o ID do estagiário"));
                    novoEstagiario.setNome(lerTexto(scanner, "o nome do estagiário", 100));
                    novoEstagiario.setEmail(lerEmail(scanner));
                    novoEstagiario.setSenha(lerSenha(scanner, 6));
                    novoEstagiario.setIdade(lerInteiro(scanner, "a idade do estagiário"));
                    novoEstagiario.setSexo(lerSexo(scanner));
                    novoEstagiario.setCurso(lerTexto(scanner, "o curso do estagiário", 100));
                    novoEstagiario.setMedia(lerFloat(scanner, "a média do estagiário", 0f, 10f));

                    estagiarios.add(novoEstagiario);
                    System.out.println("\n✔ Estagiário cadastrado com sucesso!");
                    break;

                // ── CADASTRAR ADMINISTRADOR ───────────────────────────────────
                case 3:
                    System.out.println("\n--- Cadastrar Administrador ---");
                    AdminEntity novoAdmin = new AdminEntity();

                    novoAdmin.setId(lerInteiro(scanner, "o ID do administrador"));
                    novoAdmin.setNome(lerTexto(scanner, "o nome do administrador", 100));
                    novoAdmin.setEmail(lerEmail(scanner));
                    novoAdmin.setSenha(lerSenha(scanner, 6));
                    novoAdmin.setDepartamento(lerTexto(scanner, "o departamento do administrador", 100));

                    admins.add(novoAdmin);
                    System.out.println("\n✔ Administrador cadastrado com sucesso!");
                    break;

                // ── LISTAR EMPRESAS ───────────────────────────────────────────
                case 4:
                    System.out.println("\n--- Empresas Cadastradas ---");
                    if (empresas.isEmpty()) {
                        System.out.println("Nenhuma empresa cadastrada.");
                    } else {
                        for (EmpresaEntity e : empresas) {
                            System.out.println("ID: " + e.getId()
                                + " | Nome: "  + e.getNome()
                                + " | Email: " + e.getEmail());
                        }
                    }
                    break;

                // ── LISTAR ESTAGIÁRIOS ────────────────────────────────────────
                case 5:
                    System.out.println("\n--- Estagiários Cadastrados ---");
                    if (estagiarios.isEmpty()) {
                        System.out.println("Nenhum estagiário cadastrado.");
                    } else {
                        for (EstagiarioEntity e : estagiarios) {
                            System.out.println("ID: " + e.getId()
                                + " | Nome: "  + e.getNome()
                                + " | Email: " + e.getEmail()
                                + " | Idade: " + e.getIdade());
                        }
                    }
                    break;

                // ── LISTAR ADMINISTRADORES ────────────────────────────────────
                case 6:
                    System.out.println("\n--- Administradores Cadastrados ---");
                    if (admins.isEmpty()) {
                        System.out.println("Nenhum administrador cadastrado.");
                    } else {
                        for (AdminEntity a : admins) {
                            System.out.println("ID: " + a.getId()
                                + " | Nome: "         + a.getNome()
                                + " | Email: "        + a.getEmail()
                                + " | Departamento: " + a.getDepartamento());
                        }
                    }
                    break;

                case 7:
                    System.out.println("\nSaindo do sistema. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }

        scanner.close();
    }
}