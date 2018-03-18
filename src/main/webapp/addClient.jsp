<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add client</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
<div class="form">
  <form class="add-form" method="post">
    <input type="text" name="name" placeholder="name">
    <input type="password" name="password" placeholder="password">
    <input type="text" name="bank" placeholder="bank account">
    <input type="text" name="balance" placeholder="balance">
    <button>add</button>
  </form>
</div>
</body>
</html>
