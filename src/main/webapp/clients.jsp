<%@ page import="com.ongoni.entities.Client" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clients</title>
</head>
<body>
    <%
        for (Client client : (List<Client>) request.getAttribute("clients")) {
    %>
    <p><%= client.getName() %></p>
    <%
        }
    %>
</body>
</html>