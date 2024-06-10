import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        final String MENU = "1 - Listar Usuários\n2 - Cadastrar Usuário\n3 - Listar Setores\n4 - Cadastrar Setor\n5 - Listar Tarefas\n6 - Cadastrar Tarefa\n7 - Sair\n";
        Scanner scan = new Scanner(System.in);
        int escolhaUser;


        List<Setor> setores = List.of(
            new Setor("TI", "Tecnologia da Informação"),
            new Setor("RH", "Recursos Humanos"),
            new Setor("Financeiro", "Financeiro")
        );
        setorService setorService = new setorService(setores);

        String setorTI = setorService.nomesSetores().get(0);
        String setorMarketing = setorService.nomesSetores().get(1);
        String setorFinanceiro = setorService.nomesSetores().get(2);


        ArrayList<Usuario> usuarios = new ArrayList<>(List.of(
            new Usuario(1, "João", "joao@exemplo.com", setorTI),
            new Usuario(2, "Maria", "maria@exemplo.com,", setorMarketing),
            new Usuario(3, "José", "jose@exemplo.com", setorFinanceiro)
        ));

        usuariosService usuariosService = new usuariosService(usuarios);

        System.out.printf(MENU);
        escolhaUser = scan.nextInt();

        switch(escolhaUser){
            case 1:
                usuariosService.listarNomesUsuarios();
                break;
            case 2:
                System.out.println("Digite o nome do usuário: ");
                String nome = scan.next();
                System.out.println("Digite o email do usuário: ");
                String email = scan.next();
                System.out.println("Selecione o setor do usuário: ");
                setorService.listarSetores();
                int escolhaSetor = scan.nextInt() + 1;
                String setor = setorService.nomesSetores().get(escolhaSetor);
                usuariosService.criaUsuarios(nome, email, setor);
                break;
            case 3:
                setorService.listarSetores();
                break;
            default:
                System.out.println("Opção inválida");
        }
        scan.close();
    }
}
