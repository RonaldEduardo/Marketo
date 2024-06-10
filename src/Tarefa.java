public class Tarefa {
  final String titulo;
  final String descricao;
  final boolean finalizada;
  final Usuario requerente;
  final Usuario responsavel;
  
  public Tarefa(String titulo, String descricao, boolean finalizada, Usuario requerente, Usuario responsavel) {
    this.titulo = titulo;
    this.descricao = descricao;
    this.finalizada = finalizada;
    this.requerente = requerente;
    this.responsavel = responsavel;
  }
}
