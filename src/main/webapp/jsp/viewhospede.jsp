<%-- 
    Document   : viewhospede
    Created on : Jun 2, 2017, 9:49:39 PM
    Author     : Chaina
--%>

<%@page import="com.dbproject.systay.beans.Hospede"%>
<%@page import="com.dbproject.systay.beans.Endereco"%>
<%@page import="com.dbproject.systay.beans.Telefone"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SyStay - Hospede</title>
    </head>
    <body>
       
    <body>
        <h1>SyStay</h1>
        <h3>${hospede.nome}</h3>
        Número do Documento: ${hospede.numeroDocumento}<br/>
        Data de Nascimento: ${hospede.data_nascimento}<br/>
        <h3>Informações para contato</h3>
         Telefone: (${hospede.telefone[0].cod_area}) ${hospede.telefone[0].numero}<br/>
         Celular: (${hospede.telefone[1].cod_area}) ${hospede.telefone[1].numero}<br/>
         Celular 2: (${hospede.telefone[2].cod_area}) ${hospede.telefone[2].numero}<br/>           
         Comercial: (${hospede.telefone[3].cod_area}) ${hospede.telefone[3].numero}<br/>
         <h3>Endereço</h3>
         Rua ${hospede.endereco.rua}, ${hospede.endereco.numero}. ${hospede.endereco.complemento}<br/>
         Cidade: ${hospede.endereco.cidade}, ${hospede.endereco.estado}. CEP: ${hospede.endereco.cep}
                
    </body>
</html>