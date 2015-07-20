<%@ taglib prefix="s" uri ="/struts-tags"%>
<html>
	<head>
		<title>Struts Login</title>
	</head>
	<body>
		<div style="color: red">
			<s:property value ="mensagem"/>
		</div>
		<s:form action="Login">
			<s:label value="Usuário: "/>	
			<s:textfield name="usuario"/>
			<s:label value="Senha: "/>
			<s:password name="senha"/>
			<s:submit value="Enviar"/>
		</s:form>
		<br>
		<s:a href="usuarioFormulario.jsp">Cadastrar</s:a>
	</body>
</html>