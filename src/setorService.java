import java.util.List;
import java.util.stream.Collectors;

public class setorService {
  private final List<Setor> setores;


  public setorService(List<Setor> setores) {
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
  }

}
