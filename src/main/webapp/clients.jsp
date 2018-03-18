<%@ page import="com.ongoni.entities.Client" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <%
      for (Client client : (List<Client>) request.getAttribute("clients")) {
    %>
    <tr>
      <td><%= client.getId() %></td>
      <td><%= client.getName() %></td>
      <td><%= client.getBankAccountNumber() %></td>
      <td><%= client.getBankAccountBalance() %></td>
    </tr>
    <%
      }
    %>
  </table>
</div>
</body>
</html>