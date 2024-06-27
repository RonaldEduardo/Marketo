import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Setor;
import model.Usuario;
import service.SetorService;
import service.TarefasService;
import service.UsuarioService;
import util.UserInteract;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Cria uma lista de setores mutáveis
        List<Setor> setoresMutaveis = new ArrayList<>(List.of(
                new Setor("TI", "Tecnologia da Informação"),
                new Setor("RH", "Recursos Humanos"),
                new Setor("Financeiro", "Financeiro")));

        // Cria um serviço de setor com a lista de setores mutáveis
        SetorService setorService = new SetorService(setoresMutaveis);

        // Cria uma lista de usuários
        ArrayList<Usuario> usuarios = new ArrayList<>(List.of(
            new Usuario(1, "João", "joao@exemplo.com", setorService.getSetorByName("TI")),
            new Usuario(2, "Maria", "maria@exemplo.com,", setorService.getSetorByName("RH")),
            new Usuario(3, "José", "jose@exemplo.com", setorService.getSetorByName("Financeiro"))
        ));

        // Cria um serviço de usuário com a lista de usuários
        UsuarioService usuarioService = new UsuarioService(usuarios);

        // Cria uma instância de UserInteract com os serviços de setor, usuário e tarefas
        UserInteract userInteract = new UserInteract(setorService, usuarioService, new TarefasService(new ArrayList<>()));

        // Chama o método de menu para interagir com o usuário
        userInteract.menu(scan);
    }
}
