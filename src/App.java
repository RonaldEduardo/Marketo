import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Setor;
import model.Tarefa;
import model.Usuario;
import service.SetorService;
import service.TarefasService;
import service.UsuarioService;
import util.UserInteract;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);


        List<Setor> setores = List.of(
            new Setor("TI", "Tecnologia da Informação"),
            new Setor("RH", "Recursos Humanos"),
            new Setor("Financeiro", "Financeiro")
        );
        SetorService setorService = new SetorService(setores);

        String setorTI = setorService.nomesSetores().get(0);
        String setorMarketing = setorService.nomesSetores().get(1);
        String setorFinanceiro = setorService.nomesSetores().get(2);


        ArrayList<Usuario> usuarios = new ArrayList<>(List.of(
            new Usuario(1, "João", "joao@exemplo.com", setorTI),
            new Usuario(2, "Maria", "maria@exemplo.com,", setorMarketing),
            new Usuario(3, "José", "jose@exemplo.com", setorFinanceiro)
        ));

        UsuarioService usuariosService = new UsuarioService(usuarios);
        TarefasService tarefaService = new TarefasService(new ArrayList<>());

        UserInteract userInteract = new UserInteract(setorService, usuariosService, usuarios, setores, tarefaService);

        userInteract.menu(scan);
    }

}
