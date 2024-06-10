import java.util.ArrayList;
import java.util.List;
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



  public List<Usuario> criaUsuarios(String nome, String email, String setor) {
    Usuario usuario = new Usuario(usuarios.size() + 1, nome, email, setor);
    usuarios.add(usuario);
    return usuarios;
  }

}
