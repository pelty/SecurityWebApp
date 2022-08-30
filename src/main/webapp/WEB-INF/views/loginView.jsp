<%-- 
    Document   : loginView
    Created on : 30 juil. 2022, 19:33:11
    Author     : dev-pro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://bootswatch.com/5/flatly/bootstrap.min.css" rel="stylesheet">
        <link href="https://bootswatch.com/5/flatly/bootstrap.css" rel="stylesheet">
        <title>Login</title>
    </head>
    <body>
        <jsp:include page="_menu.jsp"></jsp:include>   

      <h3>S'authentifier</h3>

      <p style="color: red;">${errorString}</p>

      <form method="POST" action="${pageContext.request.contextPath}/login">
         <input type="hidden" name="redirectId" value="${param.redirectId}" />
         <table border="0">
            <tr>
               <td>Nom Utilisateur</td>
               <td><input type="text" name="userName" value= "${user.userName}" /> </td>
            </tr>
            <tr>
               <td>Mot de passe</td>
               <td><input type="password" name="password" value= "${user.password}" /> </td>
            </tr>
         
            <tr>
               <td colspan ="2">
                  <input type="submit" value= "Submit" />
                  <a href="${pageContext.request.contextPath}/">Annuler</a>
               </td>
            </tr>
         </table>
      </form>

      <p style="color:blue;">S'authentifier avec:</p>
      
      employee1/123 <br>
      manager1/123
    </body>
</html>
