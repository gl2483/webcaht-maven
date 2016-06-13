<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/javascript/jquery-1.12.3.js"></script>
        <script type="text/javascript">
            $().ready(function(){
                
                $("#signup").click(function(){
                    window.location.replace("signup");
                });
                
                
            });
        </script>
    </head>
        
    <body>
        <table>
            <tr>
                <td><label>User name: </label></td>
                <td><input type="text" id="username" ></td>
            </tr>
            <tr>
                <td><label>Password: </label></td>
                <td><input type="password" id="password" ></td>
            </tr>
            <tr>
                <td><input type="button" id="login" value="Log In"></td>
                <td><input type="button" id="signup" value="Sign Up"></td>
            </tr>
        </table>
        
    </body>
</html>
