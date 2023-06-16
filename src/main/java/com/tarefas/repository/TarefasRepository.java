package com.tarefas.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tarefas.entity.Tarefa;

public class TarefasRepository {
	
	//Criando lista de tarefas
	static public List<Tarefa> tarefas = new ArrayList<Tarefa>();

	//Construtor da classe
	public TarefasRepository() {
		//Criando tarefas de teste
		Tarefa tarefa1 = new Tarefa("Estar Javascript", new Date(), true);
		Tarefa tarefa2 = new Tarefa("Estar Angular", new Date(), false);
		Tarefa tarefa3 = new Tarefa("Estar JAVA Spring", new Date(), false);
		
		//Adicionando as tarefas na lista
		tarefas.add(tarefa1);
		tarefas.add(tarefa2);
		tarefas.add(tarefa3);
	}
	
	static public void adicionarTarefa(Tarefa tarefa) {
		tarefas.add(tarefa);
	}

}

