<%-- 
    Document   : listarhospedes
    Created on : Jun 2, 2017, 12:13:07 AM
    Author     : Chaina
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<a href="home">Home</a>
<h1>Lista de Administradores</h1>

<a href="cadastraradmin"><h2>Cadastrar</h2></a>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Documento</th><th>Name</th><th>Detalhes</th><th>Editar</th><th>Excluir</th></tr>  
   <c:forEach var="adm" items="${list}">   
        <tr>  
            <td>${adm.numeroDocumento}</td>  
            <td>${adm.nome}</td>
            <td><a href="exibiradmin/${adm.numeroDocumento}">Detalhes</a></td>
            <td><a href="editaradmin/${adm.numeroDocumento}">Editar</a></td>  
            <td><a href="deletaradmin/${adm.numeroDocumento}">Excluir</a></td>  
        </tr>  
   </c:forEach>  
</table>  
<br/>  
