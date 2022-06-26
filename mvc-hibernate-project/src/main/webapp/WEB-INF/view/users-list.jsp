<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
  <title>Spring Examples. MVC + Hibernate. List Users</title>
  <style>
    #users {
      font-family: Arial, Helvetica, sans-serif;
      border-collapse: collapse;
      width: 100%;
    }
    
    #users td, #users th {
      border: 1px solid #ddd;
      padding: 4px;
    }
    
    #users tr:nth-child(even){background-color: #f2f2f2;}
    
    #users tr:hover {background-color: #ddd;}
    
    #users th {
      padding-top: 6px;
      padding-bottom: 6px;
      text-align: left;
      background-color: #0c8bbb;
      color: white;
    }
    </style>
</head>
<body>
  <h2>Spring Examples. MVC + Hibernate. List Users</h2>
  <hr>
  <a href="/mvc-hibernate">Main</a><br/>
  <a href="add-form">Add User</a>
  <hr>

  <table id="users">
    <caption><h3>List of Users</h3></caption>
    <thead>
      <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>E-mail</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="user" items="${users}">
        <c:url var="updateLink" value="/user/update-form">
          <c:param name="userId" value="${user.userId}" />
        </c:url>

        <c:url var="deleteLink" value="/user/delete">
          <c:param name="userId" value="${user.userId}" />
        </c:url>

        <tr>
          <td>${user.firstName} </td>
          <td>${user.lastName} </td>
          <td>${user.email} </td>
          <td>
            <a href="${updateLink}">Update</a> |
            <a href="${deleteLink}" onclick="if (!(confirm('Delete this user?'))) return false;">
              Delete
            </a>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</body>
</html>
