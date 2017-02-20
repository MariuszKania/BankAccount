<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Strona glowna</title>
</head>
<body>
	<center>

		<h2>Welcome!</h2>
<input type="button" value="New Client " onclick="document.location.href='newClientForm.do'">		
			<table style="border-collapse: collapse;" border="1"
				bordercolor="#006699" width="700">
				<tr bgcolor="lightblue">
					<th>Lp</th>
					<th>Id</th>
					<th>Name</th>
					<th>Surname</th>
				</tr>
				<c:forEach var="client" items="${ALL_CLIENTS}" varStatus="status">
					<tr>
						<td><c:out value="${status.index+1}"></c:out></td>
						<td><c:out value="${client.id}"></c:out></td>
						<td><c:out value="${client.name}"></c:out></td>
						<td><c:out value="${client.surname}"></c:out></td>
			
					<td>
					&nbsp;&nbsp;<a href="showAccounts.do?id=${client.id}">Show accounts</a>
				</td>
				<td>
					&nbsp;&nbsp;<a href="addAccount.do?id=${client.id}">Add account</a>
				</td>
				</tr>
			</c:forEach>
			</table>
	</center>
</body>
</html>