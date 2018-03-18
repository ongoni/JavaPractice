<%@ page import="com.ongoni.entities.Client" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Clients</title>
</head>
<body>
  <table border="1" width="500px" cellpadding="0" cellspacing="0">
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
</body>
</html>