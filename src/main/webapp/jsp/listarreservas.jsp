<%-- 
    Document   : listarreservas
    Created on : Jun 3, 2017, 6:22:51 PM
    Author     : Chaina
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<a href="home">Home</a><br/><br/>
<%= session.getAttribute( "theName" ) %><br/>
<h1>Lista de Reservas</h1>

<a href="cadastrarreserva"><h2>Cadastrar</h2></a>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Hóspede</th><th>Data Entrada</th><th>Data Saída</th><th>Detalhes</th><th>Editar</th><th>Excluir</th></tr>  
   <c:forEach var="res" items="${list}">   
        <tr>            
            <td>${res.id}</td>  
            <td>${res.hospede.nome}</td>
            <td>${res.dataEntrada}</td>
            <td>${res.dataSaida}</td>
            <td><a href="exibirreserva/${res.id}">Detalhes</a></td>
            <td><a href="editarreserva/${res.id}">Editar</a></td>  
            <td><a href="daletarreserva/${res.id}">Excluir</a></td>  
        </tr>  
   </c:forEach>  
</table>  
<br/>  
