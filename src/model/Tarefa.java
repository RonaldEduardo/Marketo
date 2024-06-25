package model;
public class Tarefa {
  final String titulo;
  final String descricao;
  final boolean finalizada;
  final String requerente;
  final String responsavel;

  public String getTitulo() {
    return titulo;
  }

  public String getDescricao() {
    return descricao;
  }

  public boolean isFinalizada() {
    return finalizada;
  }

  public String getRequerente() {
    return requerente;
  }

  public String getResponsavel() {
    return responsavel;
  }

  public Tarefa(String titulo, String descricao, boolean finalizada, String requerente, String responsavel) {
    this.titulo = titulo;
    this.descricao = descricao;
    this.finalizada = finalizada;
    this.requerente = requerente;
    this.responsavel = responsavel;
  }
}
