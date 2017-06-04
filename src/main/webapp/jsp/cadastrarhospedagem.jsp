<%-- 
    Document   : cadastraradministrador
    Created on : Jun 01, 2017, 13:40:23 PM
    Author     : Johny
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String name = request.getParameter("username");

    if (name != null) {
        session.setAttribute("theName", name);
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SyStay - Início</title>
    </head>
    <body>
        <a href="home">Home</a>
        <h1>Cadastrar Hospedagem</h1>
        <form:form method="post" action="salvarhospedagem">    
            <table >
                <tr>    
                    <td>Reserva: </td>   
                    <td> </td>  
                </tr>
                <tr>
                    <td>Responsável: </td>
                    <td><form:label path="responsavel.login.username">${theName}</form:label></td>
                    </tr>
                    <tr>
                        <td>Data Checkin: </td>
                    <%Date dNow = new Date();
                         SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");%>
                         <td><form:label path="dataCheckin"> <%= ft.format(new java.util.Date()) %> </form:label></td>
                </tr>
                <tr>
                    <td>Data Checkout: </td>
                    <!--<td><label path="dataCheckout"><label></td>-->
                </tr>
                <tr>
                    <td>Resta: </td>
                    <td>R$ </td>
                </tr>
                <tr><td><input type="submit" value="Checkin" /></td></tr>
            </table>
        </form:form>    
    </body>
</html>