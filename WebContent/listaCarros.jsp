<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<title>Lista de Carros</title>
	</head>
	<body>
		<h1>Lista de Carros</h1>
		<ul>
			<s:iterator value="carros">
				<li><s:property value="marca"/> - <s:property value="modelo"/></li>
			</s:iterator>
		</ul>
	</body>
</html>