<%-- 
    Document   : editarhospede
    Created on : Jun 2, 2017, 3:30:03 PM
    Author     : Chaina
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<a href="../home">Home</a>
<h1>Editar Administrador</h1>  
<fmt:formatDate type="date" var="theFormattedNasc" value="${data_nascimento}" pattern="dd/MM/yyyy" />
<form:form method="post" action="/SyStay/editsaveadmin">    
    <table >      
        <tr>    
            <td colspan="2"><h4>Dados Pessoais e de Contratação</h4></td>
        </tr>
        <tr>    
            <td>Numero Documento: </td>   
            <td><form:input path="numeroDocumento"  maxlength="20"/></td>  
        </tr>    
        <tr>    
            <td>Nome :</td>
            <td><form:input path="nome" maxlength="25"/></td>  
        </tr>
        <tr>    
            <td>Cargo :</td>    
            <td><form:input path="cargo" /></td>  
        </tr>
        <tr>
            <td>Data nascimento :</td>    
            <td><form:input path="data_nascimento" value="${theFormattedNasc}"/></td> 
        </tr>
        <tr>
            <td>Salario :</td>    
            <td><form:input path="salario" /></td>
        </tr>
        <tr>
            <td>Admissão :</td>    
            <td><form:input path="dataAdmissao" /></td>
        </tr>
        <tr>    
            <td colspan="2"><h5>Informações de Endereço</h5></td>
        </tr>
        <tr>
            <td>Rua :</td>    
            <td><form:input path="endereco.rua" maxlength="50"/></td>  
        </tr>    
        <td>Numero :</td>    
        <td><form:input path="endereco.numero" type="number"/></td>  
    </tr>      
    <tr>
        <td>Complemento :</td>    
        <td><form:input path="endereco.complemento" maxlength="25"/></td>  
    </tr>    
    <tr>
        <td>Bairro :</td>    
        <td><form:input path="endereco.bairro" maxlength="15"/></td>  
    </tr>    
    <tr>
        <td>Cidade :</td>    
        <td><form:input path="endereco.cidade" maxlength="25"/></td>  
    </tr>    
    <tr>
        <td>Estado :</td>    
        <td><form:input path="endereco.estado" maxlength="2"/></td>  
    </tr>    
    <tr>
        <td>Cep :</td>    
        <td><form:input path="endereco.cep" maxlength="8" /></td>  
    </tr>  
    <tr>    
        <td> </td>    
        <td><input type="submit" value="Salvar Alterações" /></td>    
    </tr>    
</table>   
</form:form>    
