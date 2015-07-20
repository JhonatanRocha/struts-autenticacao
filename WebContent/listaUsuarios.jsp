<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>Lista de Usuários do Sistema</title>
	</head>
	<body>
		<s:a href="login.jsp">Home</s:a>
		<br/>
		<s:a href ="usuarioFormulario.jsp">Novo Usuário</s:a>
		<hr/>
		<c:if test="${not empty usuarios}">
			<h1>Usuários</h1>
			<table>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Username</th>
					<th>Password</th>
					<th>Alterar</th>
					<th>Remover</th>
				</tr>
				<s:iterator value="usuarios" status="status">
					<tr style="background-color: ${status.even ? '#EEEEEE' : '#FFFFFF'}">
						<td><s:property value="id"/></td>
						<td><s:property value="name"/></td>
						<td><s:property value="username"/></td>
						<td><s:property value="password"/></td>
						<td>
							<s:a action ="UsuarioPreparaAlteracao">
								alterar
								<s:param name="usuario.id" value="id"/>
							</s:a>
						</td>
						<td>
							<s:a action="UsuarioRemove">
							remover
							<s:param name="usuario.id" value="id"/>
							</s:a>
						</td>
					</tr>
				</s:iterator>
			</table>
		</c:if>
		<c:if test="${empty usuarios}">
			<h1>Sem usuários cadastrados.</h1>
		</c:if>
	</body>
</html>