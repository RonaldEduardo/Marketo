package service;

import java.util.List;
import model.Tarefa;

public class TarefasService {
  private final List<Tarefa> tarefas;

  public TarefasService(List<Tarefa> tarefas) {
    this.tarefas = tarefas;
  }
  // Este método adiciona uma nova tarefa à lista de tarefas.
  // Recebe como parâmetros o título, descrição, requerente e responsável da tarefa.
  // Cria um novo objeto Tarefa com os valores fornecidos e adiciona à lista de tarefas.
  // Retorna a lista de tarefas atualizada.
  public List<Tarefa> addTarefa(String titulo, String descricao, String requerente, String responsavel) {
    Tarefa tarefa = new Tarefa(titulo, descricao, false, requerente, responsavel);
    tarefas.add(tarefa);
    return tarefas;
  }

  // Este método lista todas as tarefas presentes na lista de tarefas.
  // Percorre a lista de tarefas e exibe informações sobre cada tarefa, como título, requerente, responsável e se está finalizada.
  public void listarTarefas() {
    for (Tarefa tarefa : tarefas) {
      String tarefaInfo = "Titulo: " + tarefa.getTitulo() + "\nRequerente: " + tarefa.getRequerente() + "\nAtribuida a: " + tarefa.getResponsavel() + "\nFinalizada: " + tarefa.isFinalizada();
      System.out.println(tarefaInfo);
    }
  }
}
