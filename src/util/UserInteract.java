package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Setor;
import model.Tarefa;
import model.Usuario;
import service.SetorService;
import service.TarefasService;
import service.UsuarioService;

public class UserInteract {
  private SetorService setoresService;
  private UsuarioService usuariosService;
  private List<Usuario> usuarios;
  private List<Setor> setores;
  private TarefasService tarefasService;

  public UserInteract(SetorService setoresService, UsuarioService usuariosService, List<Usuario> usuarios,List<Setor> setores, TarefasService tarefasService) {
    this.setoresService = setoresService;
    this.usuariosService = usuariosService;
    this.usuarios = usuarios;
    this.setores = setores;
    this.tarefasService = tarefasService;
  }

  public void menu(Scanner scan) {
    final String MENU = "\n============================\n1 - Listar Usuários\n2 - Cadastrar Usuário\n3 - Listar Setores\n4 - Cadastrar Setor\n5 - Cadastrar Tarefa\n6 - Listar Tarefas\n7 - Sair\n\n";
    boolean loopMenu = true;
    int escolhaUser;

    while (loopMenu) {
      System.out.printf(MENU);
      escolhaUser = scan.nextInt();

      switch (escolhaUser) {
        case 1:
          usuariosService.listarNomesUsuarios();
          break;
        case 2:
          adicionarUsuario(scan);
          break;
        case 3:
          setoresService.listarSetores();
          break;
        case 4:
          setoresService.adicionarSetor();
          break;
        case 5:
          adicionarTarefa(scan);
          break;
        case 6:
          tarefasService.listarTarefas();
          break;
        case 0:
          loopMenu = false;
          break;
        default:
          System.out.println("Opção inválida");
      }
    }
    scan.close();
  }

  private String getNome(Scanner scan) {
    System.out.println("Digite o nome do usuário: ");
    return scan.next();
  }

  private String getEmail(Scanner scan) {
    System.out.println("Digite o email do usuário: ");
    return scan.next();
  }

  private String getSetor(Scanner scan) {
    System.out.println("Selecione o setor do usuário: ");
    setoresService.listarSetores();
    int escolhaSetor = scan.nextInt() - 1;
    scan.nextLine();
    return setoresService.nomesSetores().get(escolhaSetor);
  }

  public List<Usuario> adicionarUsuario(Scanner scan) {
    String nome = getNome(scan);
    String email = getEmail(scan);
    String setor = getSetor(scan);

    return usuariosService.criaUsuarios(nome, email, setor);
  }

  private String getTituloTarefa(Scanner scan) {
    System.out.println("Digite o título da tarefa: ");
    return scan.next();
  }

  private String getDescricaoTarefa(Scanner scan) {
    System.out.println("Digite a descrição da tarefa: ");
    return scan.next();
  }

  private String getResponsavelTarefa(Scanner scan) {
    System.out.println("Selecione o responsável pela tarefa: ");
    usuariosService.listarNomesUsuarios();
    int escolhaUsuario = scan.nextInt() - 1;
    scan.nextLine();
    return usuariosService.nomesUsuarios().get(escolhaUsuario);
  }

  private String getRequerenteTarefa(Scanner scan) {
    System.out.println("Selecione quem esta requisitando a tarefa: ");
    usuariosService.listarNomesUsuarios();
    int escolhaUsuario = scan.nextInt() - 1;
    scan.nextLine();
    return usuariosService.nomesUsuarios().get(escolhaUsuario);
  }

  public List<Tarefa> adicionarTarefa(Scanner scan) {
      String titulo = getTituloTarefa(scan);
      String descricao = getDescricaoTarefa(scan);
      String responsavel = getResponsavelTarefa(scan);
      String requerente = getRequerenteTarefa(scan);

      return tarefasService.addTarefa(titulo, descricao, responsavel, requerente);
  }

}
