<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Dados Empresa:
	<br />
	<form action="/gerenciador/editarEmpresa" method="post">
		Nome: <input type="text" name="nome" value="${ empresa.nome }" /> <br />
		Data: <input type="text" name="data"
			value="<fmt:formatDate value="${empresa.data }" pattern="dd/MM/yyyy"/>" />
		<br /> <input type="hidden" name="id" value="${empresa.id }" /> <input
			type="submit" />
	</form>

</body>
</html>
