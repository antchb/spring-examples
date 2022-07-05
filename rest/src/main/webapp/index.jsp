<!doctype html>
<html lang="en">
<head>
  <title>Spring Examples - REST</title>
</head>
<body>
  <h2>Spring Examples - REST. Main Page</h2>
  <hr>
  <a href="/rest">Main</a><br/>
  <hr>
  <p>
    Get All Users [GET]: <a href="${pageContext.request.contextPath}/api/users">Get All Users</a><br/><br/>
    Get User [GET]: ${pageContext.request.contextPath}/api/users/{USER_ID}<br/><br/>
    Add User [POST]: ${pageContext.request.contextPath}/api/users/<br/><br/>
    Update User [PUT]: ${pageContext.request.contextPath}/api/users/<br/><br/>
    Delete User [DELETE]: ${pageContext.request.contextPath}/api/users/<br/><br/>
  </p>
  <hr>
</body>
</html>
