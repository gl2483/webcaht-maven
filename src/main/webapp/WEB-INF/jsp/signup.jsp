<%-- 
    Document   : signup
    Created on : Jun 8, 2016, 5:02:27 PM
    Author     : luoguanqi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign up Page</title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/javascript/jquery-1.12.3.js"></script>
        <script type="text/javascript">
            $().ready(function(){
                
                $("#signup").click(function(){
                    var loginData={
                        username: $("#username").val(),
                        password: $("#password").val()
                    };
                    $.ajax({
                        type: "POST",
                        url: "user/CreateAccount",
                        data: loginData,
                        success: function (result) {
                            if(result === 'success')
                                alert("success");
                            else{
                                alert("failed");
                            }
                        },
                        error: function (result) {
                            alert("failed " + result.responseText);
                        }
                    });
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
                <td><input type="button" id="signup" value="Sign Up"></td>
            </tr>
        </table>
    </body>
</html>
