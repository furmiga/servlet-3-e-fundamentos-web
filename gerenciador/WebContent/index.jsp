<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>
<c:if test="${not empty usuarioLogado}">
	voce esta logado com ${usuarioLogado.email}<br/>
</c:if>
</body>
<form action="executa" method="post">
	<input type="hidden" name="tarefa" value="NovaEmpresa"/>
    Nome: <input type="text" name="nome" /><br/>
    <input type="submit" value="Enviar" />
</form>
<form action="login" method="POST">
	Email <input type="text" name="email"/>
	Senha <input type="text" name="senha"/>
	<input type="submit" value="Logar"/>
</form>
<form action="executa" method="post">
	<input type="hidden" name="tarefa" value="Logout"/>
    <input type="submit" value="Logout" />
</form>
</html>