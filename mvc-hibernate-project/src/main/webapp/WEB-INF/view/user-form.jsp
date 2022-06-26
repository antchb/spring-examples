<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <title>Spring Examples. MVC + Hibernate. User Form</title>
</head>
<body>
  <h2>Spring Examples. MVC + Hibernate. User Form</h2>
  <hr>
  <a href="/mvc-hibernate">Main</a></br>
  <hr>
  
  <form:form action="save" modelAttribute="user" method="POST">
    <form:hidden path="userId" />

    <div>Last Name: <form:input path="lastName" /></div>
    <div>First Name: <form:input path="firstName" /></div>
    <div>Email: <form:input path="email" /></div>
    <hr>
    <div><input type="submit" value="Save" /></div>
  </form:form>
</body>
</html>
