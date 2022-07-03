<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
<head>
  <title>Spring Examples - Security. Access Denied</title>
</head>
<body>
  <h2>Spring Examples - Security. Access Denied. You do not have access to this page</h2>
  <hr>
  <a href="/security">Main</a><br/>
  <hr>

  <p>User Role(s): <security:authentication property="principal.authorities" /></p>
  <hr>

  <form:form action="${pageContext.request.contextPath}/logout" method="POST">
    <input type="submit" value="Logout"/>
  </form:form>
</body>
</html>
