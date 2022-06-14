<!DOCTYPE html>
<html>
<head>
  <title>Spring Examples - MVC. Input HTML Form</title>
</head>
<body>
  <h2>Spring Examples - MVC. Input HTML Form</h2>
  <hr>
  <a href=".">Main</a>
  <hr>

  <h4>Simple Form - No Model</h4>
  <form action="process-simple-form" method="GET">
    <input type="text" name="user_name" placeholder="Enter a user's name" />
    <input type="submit" />
  </form>
  <br/>
  
  <h4>Simple Form - Model. Convert Value to UpperCase - HttpServletRequest</h4>
  <form action="process-simple-form-uppercase" method="GET">
    <input type="text" name="user_name" placeholder="Enter a user's name" />
    <input type="submit" />
  </form>
  <br/>

  <h4>Simple Form - Model. Convert Value to UpperCase - @RequestParam</h4>
  <form action="process-simple-form-uppercase-v2" method="GET">
    <input type="text" name="user_name" placeholder="Enter a user's name" />
    <input type="submit" />
  </form>
  <br/>

</body>
</html>
