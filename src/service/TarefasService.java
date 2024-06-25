package service;

import java.util.List;

import model.Tarefa;
import model.Usuario;

public class TarefasService {
  private final List<Tarefa> tarefas;

  public TarefasService(List<Tarefa> tarefas) {
    this.tarefas = tarefas;
  }

  public List<Tarefa> addTarefa(String titulo, String descricao, String requerente, String responsavel) {
    Tarefa tarefa = new Tarefa(titulo, descricao, false, requerente, responsavel);
    tarefas.add(tarefa);
    return tarefas;
  }


  private List<String> pegarTitulo() {
    List<String> tarefas = this.tarefas.stream()
        .map(Tarefa::getTitulo)
        .collect(java.util.stream.Collectors.toList());
    return tarefas;
  }

  private List<String> pegarDescricao() {
    List<String> tarefas = this.tarefas.stream()
        .map(Tarefa::getDescricao)
        .collect(java.util.stream.Collectors.toList());
    return tarefas;
  }

  private List<String> pegarRequerente() {
    List<String> tarefas = this.tarefas.stream()
        .map(Tarefa::getRequerente)
        .collect(java.util.stream.Collectors.toList());
    return tarefas;
  }
  private List<String> pegarResponsavel() {
    List<String> tarefas = this.tarefas.stream()
        .map(Tarefa::getResponsavel)
        .collect(java.util.stream.Collectors.toList());
    return tarefas;
  }

  private List<String> pegarFinalizada() {
    List<String> tarefas = this.tarefas.stream()
        .map(Tarefa::isFinalizada)
        .map(Object::toString)
        .collect(java.util.stream.Collectors.toList());
    return tarefas;
  }

  public void listarTarefas() {
    List<String> titulos = pegarTitulo();
    List<String> descricoes = pegarDescricao();
    List<String> requerentes = pegarRequerente();
    List<String> responsaveis = pegarResponsavel();
    List<String> finalizadas = pegarFinalizada();

    for (int i = 0; i < titulos.size(); i++) {
      String tarefa = "Titulo: " + titulos.get(i) + "\nRequerente: " + requerentes.get(i) + "\nAtribuida a: " + responsaveis.get(i) + "\nFinalizada: " + finalizadas.get(i);
      System.out.println(tarefa);
    }
  }
}
