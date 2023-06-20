<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.tarefas.entity.Tarefa"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.tarefas.repository.TarefasRepository"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
	<div class="container pt-4">
		<h4>Olá mundo JSP</h4>
		
		<div class="row">
			<%	
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			
				for(Tarefa tarefa : TarefasRepository.tarefas){
			%>
					<div class="card col m-1 <% if(tarefa.urgente) out.write("bg-danger"); %>" style="min-width: 300px; max-width: 300px">
						<div class="card-body">
							<h5 class="card-title"><%= tarefa.descricao %></h5>
							<p class="card-text"><%= dateFormat.format(tarefa.data) %></p>
						</div>
						<form action="processa-excluir-tarefa">
							<input type="hidden" value="<%= tarefa.descricao %>" name="tarefa-excluir" />
							<button class="btn mb-2">Excluir</button>
						</form>
					</div>
			<%
				}
			%>
					
		</div>
	
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>