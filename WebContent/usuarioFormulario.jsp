<%@ taglib prefix="s" uri ="/struts-tags"%>
<html>
	<head>
		<title>Struts User Sign-in</title>
	</head>
	<body>
		<s:form action="UsuarioAdicionaOuAltera">
			<s:hidden name="usuario.id"/>
			<s:textfield label="Nome: " name="usuario.name"/>
			<s:textfield label="Username: " name="usuario.username"/>
			<s:textfield label="Password: " name="usuario.password"/>
			<s:submit value="Salvar"/>
		</s:form>
	</body>
</html>