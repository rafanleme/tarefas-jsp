package com.tarefas.service;

import java.io.IOException;
import java.io.PrintWriter;
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
		
		String descricao = req.getParameter("descricao");
		String data = req.getParameter("data");
		String urgente = req.getParameter("urgente");
		
		Boolean urgenteBool = false;
		
		if(urgente.equals("on")) {
			urgenteBool = true;
		}
		
		Tarefa tarefa = new Tarefa(descricao, new Date(), urgenteBool);
		
		TarefasRepository.adicionarTarefa(tarefa);
		
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
