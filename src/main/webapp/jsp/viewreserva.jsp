<%-- 
    Document   : viewreserva
    Created on : Jun 3, 2017, 8:13:15 PM
    Author     : Chaina
--%>

<%@page import="com.dbproject.systay.beans.Reserva"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <a href="../home">Home</a><br/><br/>
        <%= session.getAttribute( "theName" ) %><br/>
        <title>SyStay - Reserva</title>
    </head>
    <body>
        <h1>SyStay - Dados da Reserva</h1>
        <h3>Identificador da reserva: ${reserva.id}</h3>
        <h3>Hospede: ${reserva.hospede.nome} -  ${reserva.hospede.numeroDocumento}</h3>
        Total da reserva: ${reserva.total_reserva}<br/>
        Data que a reserva foi feita: ${reserva.dataCadastro}<br/>
        Data de Entrada: ${reserva.dataEntrada}<br/>
        Data de Saída: ${reserva.dataSaida}<br/>
        Data de Cancelamento: ${reserva.dataCancelamento}<br/>
        Observação: ${reserva.observacao}<br/>                
    </body>
</html>