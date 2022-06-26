<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
  <title>Spring Examples - MVC. Result of the MVC Form Tags</title>
</head>
<body>
  <h2>Spring Examples - MVC. Result of the MVC Form Tags</h2>
  <hr>
  <a href="/mvc">Main</a><br/>
  <a href="input">MVC Form Tags - Input</a>
  <hr>

  <h3>MVC Form Tags - Text Field</h3>
  <!-- It calls getters for firstName, lastName, etc. -->
  <strong>Inserted First Name: </strong> ${user.firstName}<br/>
  <strong>Inserted Last Name: </strong> ${user.lastName}<br/>
  <hr>

  <h3>MVC Form Tags - Dropdown List</h3>
  <strong>Selected Sex: </strong> ${user.sex}<br/>
  <strong>Selected Country: </strong> ${user.country}<br/>

  <h3>MVC Form Tags - Radio Button</h3>
  <strong>Selected User Type: </strong> ${user.type}<br/>

  <h3>MVC Form Tags - Checkbox</h3>
  <strong>Selected Operating Systems: </strong>
  <ul>
    <c:forEach var="os" items="${user.operatingSystems}">
      <li>${os}</li>
    </c:forEach>
  </ul>
</body>
</html>
