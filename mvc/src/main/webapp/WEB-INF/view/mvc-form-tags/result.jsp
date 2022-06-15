<!DOCTYPE html>
<html>
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
  <b>Inserted First Name: </b> ${user.firstName}<br/>
  <b>Inserted Last Name: </b> ${user.lastName}<br/>
  <hr>

  <h3>MVC Form Tags - Dropdown List</h3>
  <b>Selected Sex: </b> ${user.sex}<br/>
  <b>Selected Country: </b> ${user.country}<br/>

  <h3>MVC Form Tags - Radio Button</h3>
  <b>Selected User Type: </b> ${user.type}<br/>
</body>
</html>
