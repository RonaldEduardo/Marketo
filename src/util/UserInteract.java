package util;

import java.util.List;
import java.util.Scanner;
import model.Setor;
import service.SetorService;
import service.TarefasService;
import service.UsuarioService;


public class UserInteract {
  private final SetorService setoresService;
  private final UsuarioService usuariosService;
  private final TarefasService tarefasService;

  public UserInteract(SetorService setoresService, UsuarioService usuariosService, TarefasService tarefasService) {
    this.setoresService = setoresService;
    this.usuariosService = usuariosService;
    this.tarefasService = tarefasService;
  }

  public void menu(Scanner scan) {
    final String MENU = "\n============================\n1 - Listar Usuários\n2 - Cadastrar Usuário\n3 - Listar Setores\n4 - Cadastrar Setor\n5 - Cadastrar Tarefa\n6 - Listar Tarefas\n7 - Sair\n\n";
    final String INVALID_OPTION = "Opção inválida";
    boolean loopMenu = true;

    while (loopMenu) {
      System.out.printf(MENU);
      int escolhaUser = scan.nextInt();
      scan.nextLine();

      switch (escolhaUser) {
        case 1:
          usuariosService.listarNomesUsuarios(); // Chama o método para listar os nomes dos usuários
          break;
        case 2:
          adicionarUsuario(scan); // Chama o método para adicionar um novo usuário
          break;
        case 3:
          setoresService.listarSetores(); // Chama o método para listar os setores
          break;
        case 4:
          adicionarSetor(scan); // Chama o método para adicionar um novo setor
          break;
        case 5:
          adicionarTarefa(scan); // Chama o método para adicionar uma nova tarefa
          break;
        case 6:
          tarefasService.listarTarefas(); // Chama o método para listar as tarefas
          break;
        case 7:
          loopMenu = false; // Sai do loop do menu
          break;
        default:
          System.out.println(INVALID_OPTION); // Exibe uma mensagem de opção inválida
      }
    }
    scan.close(); // Fecha o Scanner
  }

  private void adicionarUsuario(Scanner scan) {
    String nome = getNome(scan); // Chama o método para obter o nome do usuário
    String email = getEmail(scan); // Chama o método para obter o email do usuário
    String setor = getSetor(scan); // Chama o método para obter o setor do usuário

    usuariosService.criaUsuarios(nome, email, setor); // Chama o método para criar um novo usuário
  }

  private String getNome(Scanner scan) {
    final String PROMPT_NOME = "Digite o nome do usuário: ";
    System.out.println(PROMPT_NOME);
    return scan.nextLine(); // Lê a próxima linha digitada pelo usuário
  }

  private String getEmail(Scanner scan) {
    final String PROMPT_EMAIL = "Digite o email do usuário: ";
    System.out.println(PROMPT_EMAIL);
    return scan.nextLine(); // Lê a próxima linha digitada pelo usuário
  }

  private String getSetor(Scanner scan) {
    final String PROMPT_SETOR = "Selecione o setor do usuário: ";
    System.out.println(PROMPT_SETOR);
    setoresService.listarSetores(); // Chama o método para listar os setores
    int escolhaSetor = scan.nextInt() - 1;
    scan.nextLine();
    return setoresService.getNomesSetores().get(escolhaSetor); // Retorna o nome do setor escolhido pelo usuário
  }

  private void adicionarTarefa(Scanner scan) {
    String titulo = getTituloTarefa(scan); // Chama o método para obter o título da tarefa
    String descricao = getDescricaoTarefa(scan); // Chama o método para obter a descrição da tarefa
    String responsavel = getResponsavelTarefa(scan); // Chama o método para obter o responsável pela tarefa
    String requerente = getRequerenteTarefa(scan); // Chama o método para obter o requerente da tarefa

    tarefasService.addTarefa(titulo, descricao, responsavel, requerente); // Chama o método para adicionar uma nova tarefa
  }

  private String getTituloTarefa(Scanner scan) {
    final String PROMPT_TITULO = "Digite o título da tarefa: ";
    System.out.println(PROMPT_TITULO);
    return scan.nextLine(); // Lê a próxima linha digitada pelo usuário
  }

  private String getDescricaoTarefa(Scanner scan) {
    final String PROMPT_DESCRICAO = "Digite a descrição da tarefa: ";
    System.out.println(PROMPT_DESCRICAO);
    return scan.nextLine(); // Lê a próxima linha digitada pelo usuário
  }

  private String getResponsavelTarefa(Scanner scan) {
    final String PROMPT_RESPONSAVEL = "Selecione o responsável pela tarefa: ";
    System.out.println(PROMPT_RESPONSAVEL);
    usuariosService.listarNomesUsuarios(); // Chama o método para listar os nomes dos usuários
    int escolhaUsuario = scan.nextInt() - 1;
    scan.nextLine();
    return usuariosService.nomesUsuarios().get(escolhaUsuario); // Retorna o nome do responsável escolhido pelo usuário
  }

  private String getRequerenteTarefa(Scanner scan) {
    final String PROMPT_REQUERENTE = "Selecione quem está requisitando a tarefa: ";
    System.out.println(PROMPT_REQUERENTE);
    usuariosService.listarNomesUsuarios(); // Chama o método para listar os nomes dos usuários
    int escolhaUsuario = scan.nextInt() - 1;
    scan.nextLine();
    return usuariosService.nomesUsuarios().get(escolhaUsuario); // Retorna o nome do requerente escolhido pelo usuário
  }

  public List<Setor> adicionarSetor(Scanner scan) {
    String nome = getSetorByName(scan); // Chama o método para obter o nome do setor
    String descricao = getDescricaoSetor(scan); // Chama o método para obter a descrição do setor
    return setoresService.criaSetor(nome, descricao); // Chama o método para criar um novo setor
  }

  private String getSetorByName(Scanner scan) {
    System.out.println("Digite o nome do setor: ");
    final String nome = scan.next();
    return nome;
  }

  private String getDescricaoSetor(Scanner scan) {
    System.out.println("Digite a descrição do setor: ");
    final String descricao = scan.next();
    return descricao;
  }
}
