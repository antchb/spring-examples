<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
  <title>Spring Examples - MVC. Form Validation</title>
  <style>
    .error {color: red}
  </style>
</head>
<body>
  <h2>Spring Examples - MVC. Form Validation</h2>
  <hr>
  <a href="/mvc">Main</a>
  <hr>

  Asterisk (*) means required! <br/><br/>

  <form:form action="process" modelAttribute="customer">
    <!-- It calls getter methods as "get" + $path -->
    <div>
      First Name (*): <form:input path="firstName" />
      <!-- It displays an error message if an error exists -->
      <form:errors path="firstName" cssClass="error" />
    </div>
   
    <div>
      Last Name (*): <form:input path="lastName" />
      <form:errors path="lastName" cssClass="error" />
    </div>
    
    <div>
      Age: <form:input path="age" />
      <form:errors path="age" cssClass="error" />
    </div>

    <div>
      Postal Code: <form:input path="postalCode" />
      <form:errors path="postalCode" cssClass="error" />
    </div>
    <!-- It calls setter methods as "set" + $path -->
    <div><input type="submit" value="Submit" /></div>
  </form:form>
  <br/>

</body>
</html>
