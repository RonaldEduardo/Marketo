package service;

import java.util.List;
import java.util.stream.Collectors;
import model.Usuario;



public class UsuarioService {
  private final List<Usuario> usuarios;

  public UsuarioService(List<Usuario> usuarios) {
    this.usuarios = usuarios;
  }

  // Retorna uma lista de nomes de usuários
  public List<String> nomesUsuarios() {
    return usuarios.stream()
        .map(Usuario::getNome)
        .collect(Collectors.toList());
  }

  // Lista os nomes dos usuários no console
  public void listarNomesUsuarios() {
    usuarios.forEach(usuario -> {
      String nomeId = usuario.getId() + " - " + usuario.getNome() + ", Setor: " + usuario.getSetor();
      System.out.println(nomeId);
    });
  }

  // Cria um novo usuário com os dados fornecidos e adiciona à lista de usuários
  public List<Usuario> criaUsuarios(String nome, String email, String setor) {
    Usuario usuario = new Usuario(usuarios.size() + 1, nome, email, setor);
    usuarios.add(usuario);
    return usuarios;
  }
}
