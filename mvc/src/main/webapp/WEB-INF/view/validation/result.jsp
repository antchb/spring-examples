<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>Spring Examples - MVC. Result of Form Validation</title>
</head>
<body>
  <h2>Spring Examples - MVC. Result of Form Validation</h2>
  <hr>
  <a href="/mvc">Main</a><br/>
  <a href="input">Form Validation - Input</a>
  <hr>

  <!-- It calls getters for firstName, lastName, etc. -->
  <b>Inserted First Name: </b> ${customer.firstName}<br/>
  <b>Inserted Last Name: </b> ${customer.lastName}<br/>
  <b>Inserted Age: </b> ${customer.age}<br/>
  <b>Inserted Postal Code: </b> ${customer.postalCode}<br/>
  <b>Inserted Promo Code: </b> ${customer.promotionalCode}<br/>
  <hr>

</body>
</html>
