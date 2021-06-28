<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada?acao=Login" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<body>

	<form action="${linkServletNovaEmpresa }" method="post">

		Usuario: <input type="text" name="login"  />
		Senha: <input type="password" name="senha"  />

		<input type="submit" />
	</form>

</body>
</html>