<%-- 
    Document   : userInfoView
    Created on : 30 juil. 2022, 19:35:22
    Author     : dev-pro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://bootswatch.com/5/flatly/bootstrap.min.css" rel="stylesheet">
        <link href="https://bootswatch.com/5/flatly/bootstrap.css" rel="stylesheet">
        <title>Info Utilisateur</title>
    </head>
    <body>
        <jsp:include page="_menu.jsp"></jsp:include>          
        <h3>Bonjour: ${loginedUser.userName}</h3>

        Nom d'utilisateur: <b>${loginedUser.userName}</b>
        <br />
        Genre: ${loginedUser.gender } <br />        
        
    </body>
</html>
