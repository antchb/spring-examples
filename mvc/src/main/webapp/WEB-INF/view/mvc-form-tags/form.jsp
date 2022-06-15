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

    <div>
      Sex: 
      <form:select path="sex">
        <form:option value="M" label="Male" />
        <form:option value="F" label="Female" />
      </form:select>
    </div>

    <div>
      Country: 
      <form:select path="country">
        <form:options items="${countryOptions}" />
      </form:select>
    </div>
    
    <div>
      <br/>User Type:<br/>
      <!-- It can be populated the same way as dropdown form with loaded values -->
      Admin   <form:radiobutton path="type" value="Admin" />
      Support <form:radiobutton path="type" value="Support" />
      User    <form:radiobutton path="type" value="User" />
    </div>
    <!-- It calls setter methods as "set" + $path -->
    <hr>
    <div><input type="submit" value="Submit" /></div>
  </form:form>
  <br/>

</body>
</html>
