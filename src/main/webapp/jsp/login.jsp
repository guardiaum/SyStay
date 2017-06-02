<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>SyStay - Login</title>
    </head>
    <body>
        <h1 align="center">SyStay</h1>
        <form:form id="loginForm" modelAttribute="login" action="loginProcess" method="post">
            <table align="center">
                <tr>
                    <td>
                        <form:label path="username">Username: </form:label>
                    </td>
                    <td>
                        <form:input path="username" name="username" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="senha">Password:</form:label>
                    </td>
                    <td>
                        <form:password path="senha" name="senha" />
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td align="left">
                        <form:button id="login" name="login">Login</form:button>
                    </td>
                </tr>
                </table>
        </form:form>
        <table align="center">
            <tr>
                <td style="font-style: italic; color: red;"><%= request.getParameter("message") %></td>
            </tr>
        </table>
    </body>
</html>