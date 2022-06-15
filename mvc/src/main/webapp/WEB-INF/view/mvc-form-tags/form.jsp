<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
  <title>Spring Examples - MVC. Spring Form Tags</title>
</head>
<body>
  <h2>Spring Examples - MVC. Spring Form Tags</h2>
  <hr>
  <a href="/mvc">Main</a>
  <hr>

  <h4>MVC Form Tags - Text Field</h4>
  <form:form action="process" modelAttribute="user">
    <!-- It calls getter methods as "get" + $path -->
    <div>First Name: <form:input path="firstName" /></div>
    <div>Last Name: <form:input path="lastName" /></div>

    <!-- It calls setter methods as "set" + $path -->
    <div><input type="submit" value="Submit" /></div>
  </form:form>
  <br/>

</body>
</html>
