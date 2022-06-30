<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
<head>
  <title>Spring Examples - Security</title>
</head>
<body>
  <h2>Spring Examples - Security. Main Page</h2>
  <hr>
  <a href="/security">Main</a><br/>

  <security:authorize access="hasRole('ADMIN')">
    <a href="admin">Admin Page</a><br/>
  </security:authorize>

  <hr>
  <p>User Name: <security:authentication property="principal.username" /></p>
  <p>User Role(s): <security:authentication property="principal.authorities" /></p>

  <form:form action="${pageContext.request.contextPath}/logout" method="POST">
    <input type="submit" value="Logout"/>
  </form:form>
</body>
</html>
