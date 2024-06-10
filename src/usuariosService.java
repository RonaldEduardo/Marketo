import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class usuariosService {
  private final List<Usuario> usuarios;

  public usuariosService(List<Usuario> usuarios) {
    this.usuarios = usuarios;
  }

  private List<String> nomesUsuarios() {
    List<String> nomeUsuario = usuarios.stream()
        .map(Usuario::getNome)
        .collect(Collectors.toList());
    return nomeUsuario;
  }

  private List<String> idsUsuarios() {
    List<String> idUsuarios = usuarios.stream()
        .map(Usuario::getId)
        .map(Object::toString)
        .collect(Collectors.toList());

    return idUsuarios;
  }

  public void listarNomesUsuarios() {
    List<String> nomesIdsUsuarios = new ArrayList<>();
    List<String> nomes = nomesUsuarios();
    List<String> ids = idsUsuarios();

    for (int i = 0; i < nomes.size(); i++) {
        String nomeId = ids.get(i) + " - " + nomes.get(i);
        nomesIdsUsuarios.add(nomeId);
    }

    nomesIdsUsuarios.forEach(System.out::println);
  }

  public List<Usuario> adicionarUsuario(List<Setor> setores) {
    setorService setorService = new setorService(setores);

    try (Scanner scan = new Scanner(System.in)) {
        // your code that uses the Scanner object
        System.out.println("Digite o nome do usuário: ");
        String nome = scan.next();
        System.out.println("Digite o email do usuário: ");
        String email = scan.next();
        System.out.println("Selecione o setor do usuário: ");
        setorService.listarSetores();
        int escolhaSetor = scan.nextInt() - 1;
        scan.nextLine();
        String setor = setorService.nomesSetores().get(escolhaSetor);
        return criaUsuarios(nome, email, setor);
    }
  }

  private List<Usuario> criaUsuarios(String nome, String email, String setor) {
    Usuario usuario = new Usuario(usuarios.size() + 1, nome, email, setor);
    usuarios.add(usuario);
    return usuarios;
  }

}
