package com.tarefas.entity;

import java.util.Date;

public class Tarefa {
	
	public String descricao;
	public Date data;
	public Boolean urgente;
	
	public Tarefa(String descricao, Date data, Boolean urgente) {
		this.descricao = descricao;
		this.data = data;
		this.urgente = urgente;
	}
	
}
