<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <title>Spring Examples - Security. Login</title>
  <style>
    .error {color : red;}
    .logout {color: green;}
  </style>
</head>
<body>
  <h2>Spring Examples - Security. Custom Login Page</h2>
  <hr>
  <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
    <!-- Spring Filters are reading default names username & password! -->
    <c:if test="${param.error != null}">
      <p><i class="error">Wrong Username / Password!</i></p>
    </c:if>
    <c:if test="${param.logout != null}">
      <p><i class="logout">Logout Success</i></p>
    </c:if>

    <p>User Name: <input type="text" name="username" /></p>
    <p>Password: <input type="password" name="password" /></p>

    <input type="submit" value="Login"/> 
  </form:form>
</body>
</html>
