<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Clients</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
<div class="clients">
  <table class="client-table" border="0" cellpadding="10" cellspacing="0">
    <tr>
      <th>id</th>
      <th>name</th>
      <th>bank account</th>
      <th>balance</th>
    </tr>
    <c:forEach var="client" items="${clients}">
      <tr>
        <td>${client.getId()}</td>
        <td>${client.getName()}</td>
        <td>${client.getBankAccountNumber()}</td>
        <td>${client.getBankAccountBalance()}</td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>