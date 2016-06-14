<%-- 
    Document   : ChatClient
    Created on : May 16, 2016, 1:30:16 PM
    Author     : luoguanqi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <script type="text/javascript" src="${pageContext.request.contextPath}/javascript/jquery-1.12.3.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/javascript/websocket.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chat page</title>
    </head>
    <body>
        <h1>Welcome!!!!!!!!!!</h1>
        <table>
            <tr>
                <td><input type="button" id="connect" value="connect"></td>
                <td><input type="button" id="disconnect" value="Disconnect"></td>
            </tr>
            <tr>
                <td colspan="2"><textarea id="text"></textarea></td>
            </tr>
            <tr>
                <td><input type="text" id="msg"></td>
                <td><input type="button" id="send" value="send"></td>
            </tr>
        </table>
    </body>
</html>
