<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Strona glowna</title>
</head>
<body>
	<center>

		<h2>Hello:</h2>
<input type="button" value="New Client " onclick="document.location.href='newClientForm.do'">		
			<table style="border-collapse: collapse;" border="1"
				bordercolor="#006699" width="700">
				<tr bgcolor="lightblue">
					<th>Lp</th>
					<th>Id</th>
					<th>number</th>
					<th>clientId</th>
					<th>amount</th>
				</tr>
				<c:forEach var="account" items="${ACCOUNTS}" varStatus="status">
					<tr>
						<td><c:out value="${status.index+1}"></c:out></td>
						<td><c:out value="${account.id}"></c:out></td>
						<td><c:out value="${account.account_number}"></c:out></td>
						<td><c:out value="${account.client.id}"></c:out></td>
						<td><c:out value="${account.amount}"></c:out></td>
						<td>
					&nbsp;&nbsp;<a href="showDeposits.do?id=${account.id}">Show deposits</a>
				</td>
					</tr>
			</c:forEach>
			</table>
	</center>
</body>
</html>