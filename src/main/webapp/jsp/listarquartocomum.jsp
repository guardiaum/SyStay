<%-- 
    Document   : viewquartocomum
    Created on : Jun 3, 2017, 2:42:04 PM
    Author     : araujomarianna
--%>
<%@page import="com.dbproject.systay.beans.Quarto"%>
<%@page import="com.dbproject.systay.beans.QuartoComum"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

    
    <a href="home">Home</a><br/><br/>
    <%= session.getAttribute( "theName" ) %><br/>
    <h1>Quartos Comuns do Hotel</h1>
    
    <a href="cadastrarquartocomum"><h2>Cadastrar novo</h2></a> 
    <table border="2" width="70%" cellpadding="2">  
    <tr><th>ID</th><th>Numero</th><th>Area</th><th>Ramal</th><th>Qtd camas</th><th>Tipo Cama</th><th>Valor diaria</th><th>Observacao</th><th>Tem varanda</th><th>Editar</th><th>Excluir</th></tr>  
       <c:forEach var="quartocomum" items="${list}">   
        <tr>
            <td>${quartocomum.id}</td>
            <td>${quartocomum.numero}</td>
            <td>${quartocomum.area}</td>
            <td>${quartocomum.ramal}</td>                       
            <td>${quartocomum.qtd_camas}</td>
            <td>${quartocomum.tipo_camas}</td>
            <td>${quartocomum.valor_diaria}</td>
            <td>${quartocomum.observacao}</td>
            <td>${quartocomum.tem_varanda}</td>
                
            <td><a href="editarquartocomum/${quartocomum.id}">Editar</a></td>  
            <td><a href="deletarquartocomum/${quartocomum.id}">Excluir</a></td> 
                
        </tr>  
       </c:forEach>  
    </table>  
       
                