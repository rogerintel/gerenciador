<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.List, br.com.alura.gerenciador.servlet.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	Lista de Empresas:
	<br /><br />
	<c:forEach items="${empresas }" var="empresa">
		<li>
		${empresa.nome } - <fmt:formatDate value="${empresa.data }" pattern="dd/MM/yyyy"/>
		<a href="/gerenciador/visualizarEmpresa?id=${empresa.id }" >editar</a>
		<a href="/gerenciador/removerEmpresa?id=${empresa.id }" >remover</a>
		</li>
	</c:forEach>
</body>
</html>