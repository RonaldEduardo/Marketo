package service;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.Setor;

public class SetorService {
  private final List<Setor> setores;


  public SetorService(List<Setor> setores) {
    this.setores = setores;
  }

  public List<String> nomesSetores() {
    return setores.stream()
        .map(Setor::getNome)
        .collect(Collectors.toList());
  }

  public void listarSetores(){
    List<String> setores = nomesSetores();

    setores.forEach(System.out::println);

    //lista a descricao e o nome do setor
  }

  public List<Setor> adicionarSetor() {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.println("Digite o nome do setor: ");
      String nome = scan.next();
      System.out.println("Digite a descrição do setor: ");
      String descricao = scan.next();
      return criaSetor(nome, descricao);
    }
  }

  private List<Setor> criaSetor(String nome, String descricao) {
    Setor setor = new Setor(nome, descricao);
    setores.add(setor);
    return setores;
  }

}
