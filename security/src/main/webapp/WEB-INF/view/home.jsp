<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
  <title>Spring Examples - Security</title>
</head>
<body>
  <h2>Spring Examples - Security. Main Page</h2>
  <hr>
  <a href="/security">Main</a><br/>
  <hr>
  <form:form action="${pageContext.request.contextPath}/logout" method="POST">
    <input type="submit" value="Logout"/>
  </form:form>
</body>
</html>
