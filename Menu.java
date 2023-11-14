import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 0;

        do {
            System.out.println("CRIADOR DE PESSOAS");
            System.out.println(
                    "1. criar usuário\n\n2. alterar usuário\n\n3. excluir usuário\n\n4. buscar usuário\n\n5. validar usuário");
            try {
                op = sc.nextInt();
            } catch (Exception e) {
                op = 99;
            }
            switch (op) {
                case 1: {
                    System.out.println("Digite o nome do usuário");
                    String nome = sc.next();
                    System.out.println("Digite o email do usuário");
                    String email = sc.next();
                    System.out.println("Digite a senha do usuário");
                    String senha = sc.next();
                    Usuario novoUsuario = new Usuario(0, nome, email, senha);
                    novoUsuario.inserirUsuario();
                    break;
                }
                case 2: {
                    System.out.println("Digite o ID do usuário que você deseja alterar");
                    int id = sc.nextInt();
                    System.out.println("Digite o nome do usuário");
                    String nome = sc.next();
                    System.out.println("Digite o email do usuário");
                    String email = sc.next();
                    System.out.println("Digite a senha do usuário");
                    String senha = sc.next();
                    Usuario alterarUsuario = new Usuario(id, nome, email, senha);
                    alterarUsuario.alterarUsuario();
                    break;
                }
                case 3: {
                    System.out.println("Digite o ID do usuário que você deseja excluir");
                    int id = sc.nextInt();
                    Usuario excluirUsuario = new Usuario(id, null, null, null);
                    excluirUsuario.excluirUsuario();
                    break;
                }
                case 4: {
                    System.out.println("Digite o ID do usuário que você deseja buscar");
                    int id = sc.nextInt();
                    Usuario buscarUsuario = new Usuario(id, null, null, null);
                    buscarUsuario.buscarUsuario();
                    break;
                }
                case 5: {
                    System.out.println("Digite o ID do usuário que você deseja validar");
                    int id = sc.nextInt();
                    System.out.println("Digite o email do usuário");
                    String email = sc.next();
                    System.out.println("Digite a senha do usuário");
                    String senha = sc.next();
                    Usuario validarUsuario = new Usuario(id, null, email, senha);
                    validarUsuario.validarUsuario();
                    break;
                }
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (op != 0);
        sc.close();
    }
}
