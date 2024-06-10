public class Usuario {
  final private int id;
  final private String nome;
  final private String email;
  final private String setor;

  public Usuario(int id, String nome, String email, String setor) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.setor = setor;
  }


  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String email() {
    return email;
  }

  public String getSetor() {
    return setor;
  }





}
