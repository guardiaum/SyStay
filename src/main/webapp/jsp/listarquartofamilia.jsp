<%-- 
    Document   : listarquartofamilia
    Created on : Jun 5, 2017, 4:31:41 AM
    Author     : araujomarianna
--%>

<%@page import="com.dbproject.systay.beans.QuartoFamilia"%>
<%@page import="com.dbproject.systay.beans.Quarto"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<a href="home">Home</a><br/><br/>
    <%= session.getAttribute( "theName" ) %><br/>
    <h1>Quartos Familia do Hotel</h1>
    
    <a href="cadastrarquartofamilia"><h2>Cadastrar novo</h2></a> 
    <table border="2" width="70%" cellpadding="2">  
    <tr><th>ID</th><th>Numero</th><th>Area</th><th>Ramal</th><th>Qtd camas adicionais</th><th>Valor diaria</th><th>Observacao</th><th>Resp. Gerencia</th><th>Tem varanda</th></tr>  
       <c:forEach var="quartofamilia" items="${list}">   
        <tr>
            <td>${quartofamilia.id}</td>
            <td>${quartofamilia.numero}</td>
            <td>${quartofamilia.area}</td>
            <td>${quartofamilia.ramal}</td>                       
            <td>${quartofamilia.qtd_camas_adicionais}</td>
            <td>${quartofamilia.valor_diaria}</td>
            <td>${quartofamilia.observacao}</td>
            <td>${quartofamilia.responsavelGerencia}</td>
            <td>${quartofamilia.tem_varanda}</td>
                
            <td><a href="editarquartofamilia/${quartofamilia.id}">Editar</a></td>  
            <td><a href="deletarquartofamilia/${quartofamilia.id}">Excluir</a></td> 
                
        </tr>  
       </c:forEach>  
    </table>
