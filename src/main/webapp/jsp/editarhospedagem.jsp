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
        <a href="/SyStay/home">Home</a>
        <h1>Editar Hospedagem</h1>
        <form:form method="post" action="/SyStay/editsavehospedagem"> 
            <table >
                <tr>    
                    <td>Hospedagem: </td>   
                    <td>
                        <form:input path="id" value="${hospedagem.id}" readonly="true"></form:input>
                    </td>  
                </tr>
                <tr>
                    <td>Data checkout: </td> 
                    <td>
                        <form:input path="dataCheckout" value="${hospedagem.dataCheckout}"></form:input>
                    </td>
                </tr>
                    <tr>
                       
                    </tr>
                    <tr><td><input type="submit" value="Checkout" /></td></tr>
                </table>
        </form:form>    
    </body>
</html>