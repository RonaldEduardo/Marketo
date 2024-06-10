import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        final String MENU = "\n============================================\n1 - Listar Usuários\n2 - Cadastrar Usuário\n3 - Listar Setores\n4 - Cadastrar Setor\n5 - Listar Tarefas\n6 - Cadastrar Tarefa\n7 - Sair\n\n";
        Scanner scan = new Scanner(System.in);
        int escolhaUser;
        boolean loopMenu = true;


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

        while(loopMenu) {
            System.out.printf(MENU);
            escolhaUser = scan.nextInt();

            switch(escolhaUser){
                case 1:
                    usuariosService.listarNomesUsuarios();
                    break;
                case 2:
                    usuariosService.adicionarUsuario(setores);
                    break;
                case 3:
                    setorService.listarSetores();
                    break;
                case 7:
                    loopMenu = false;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
        scan.close();
    }

}
