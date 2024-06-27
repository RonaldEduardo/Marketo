package service;

import java.util.List;
import java.util.stream.Collectors;
import model.Setor;


public class SetorService {
  private final List<Setor> setores;

  public SetorService(List<Setor> setores) {
    this.setores = setores;
  }

  // Retorna uma lista com os nomes dos setores
  public List<String> getNomesSetores() {
    return setores.stream()
        .map(Setor::getNome)
        .collect(Collectors.toList());
  }


  // Lista os setores, mostrando o nome e a descrição de cada um
  public void listarSetores() {
    List<String> nomesDescricaoSetores = setores.stream()
        .map(setor -> setor.getNome() + " - " + setor.getDescricao())
        .collect(Collectors.toList());

    nomesDescricaoSetores.forEach(System.out::println);
  }

  // Cria um novo setor com o nome e descrição fornecidos e o adiciona à lista de setores
  public List<Setor> criaSetor(final String nome, final String descricao) {
    Setor setor = new Setor(nome, descricao);
    setores.add(setor);
    return setores;
  }

  // Retorna o nome do setor correspondente ao nome fornecido, ignorando
  // maiúsculas e minúsculas
  public String getSetorByName(String nome) {
    for (Setor setor : setores) {
      if (setor.getNome().equalsIgnoreCase(nome)) {
        return setor.getNome();
      }
    }
    return null;
  }
}
