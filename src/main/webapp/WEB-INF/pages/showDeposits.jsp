<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Strona glowna</title>
</head>
<body>
	<center>

		<h2>Deposits:</h2>		
			<table style="border-collapse: collapse;" border="1"
				bordercolor="#006699" width="700">
				<tr bgcolor="lightblue">
					<th>Lp</th>
					<th>Id</th>
					<th>number</th>
					<th>amount</th>
					<th>endDate</th>
				</tr>
				<c:forEach var="deposit" items="${DEPOSITS}" varStatus="status">
					<tr>
						<td><c:out value="${status.index+1}"></c:out></td>
						<td><c:out value="${deposit.id}"></c:out></td>
						<td><c:out value="${deposit.number}"></c:out></td>
						<td><c:out value="${deposit.amount}"></c:out></td>
						<td><c:out value="${deposit.end_date}"></c:out></td>
					</tr>
			</c:forEach>
			</table>
	</center>
</body>
</html>