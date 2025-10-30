<%@page import="modelo.Modelo"%>
<%@page import="java.util.List"%>
<%@page import="modelo.ModeloDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
	   ModeloDao dao = new ModeloDao();
	   List<Modelo> Modelos = null;
	   int quantidade = 0;
	%>
	<h1>Consulta de Modelo</h1>
	<table border="1">
	<%
	  Modelos = dao.consultar();
	  for (Modelo p : Modelos){ %>
	  <tr>
		<td><%= p.getCodigo() %></td>
		<td><%= p.getNome() %></td>
	  </tr>
	<%  } %>
	
</body>
</html>