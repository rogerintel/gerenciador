<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/novaEmpresa" var="linkEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nova Empresa</title>
</head>
<body>

Dados Empresa
	<form action=${linkEmpresa } method="post">
		Nome: <input type="text" name="nome"> <br />
		Data: <input type="text" name="data"> <br />
		<input type="submit">
	</form>

</body>
</html>