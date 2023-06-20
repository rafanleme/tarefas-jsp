package com.tarefas.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tarefas.entity.Tarefa;
import com.tarefas.repository.TarefasRepository;

@WebServlet("/processa-nova-tarefa")
public class ProcessaNovaTarefa extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Recebendo parametros da tela
		String descricao = req.getParameter("descricao");
		String dataString = req.getParameter("data");
		String urgente = req.getParameter("urgente");
		
		//Tratando checkbox
		Boolean urgenteBool = false;
		
		if(urgente != null) {
			urgenteBool = true;
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date data = new Date();
		try {
			data = dateFormat.parse(dataString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//Criando objeto tarefa, passando o que veio da tela
		Tarefa tarefa = new Tarefa(descricao, data, urgenteBool);
		
		//Adicionando na lista
		TarefasRepository.adicionarTarefa(tarefa);
		
		//Redireciona o usuário para lista de tarefas
		resp.sendRedirect("lista-tarefas.jsp");
		
//		PrintWriter writer = resp.getWriter();
//		writer.write("<html>");
//		writer.write("<head>");
//		writer.write("</head>");
//		writer.write("<body>");
//		writer.write("<p>" + descricao + "</p>");
//		writer.write("<p>" + data + "</p>");
//		writer.write(urgente);
//		writer.write("</body>");
	}

}
