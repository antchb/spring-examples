<!DOCTYPE html>
<html>
<head>
  <title>Spring Examples - MVC. Result of the Input HTML Form</title>
</head>
<body>
  <h2>Spring Examples - MVC. Result of the Input HTML Form</h2>
  <hr>
  <a href="/mvc">Main</a><br/>
  <a href="simple-form/input">Simple Input HTML Form</a>
  <hr>
  <b>Inserted User's Name: </b> ${param.user_name}<br/>
  <b>Inserted User's Name in upper case (HttpServletRequest): </b> ${model_uppercase_result}<br/>
  <b>Inserted User's Name in upper case (@RequestParam): </b> ${model_uppercase_result_v2}<br/>
</body>
</html>
