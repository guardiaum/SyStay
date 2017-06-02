<%-- 
    Document   : cadastraradministrador
    Created on : Jun 01, 2017, 13:40:23 PM
    Author     : Johny
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
       <a href="home">Home</a>
       <h1>Cadastrar Administrador</h1>  
             
       <form:form method="post" action="salvaradministrador">    
            <table >    
                <tr>    
                    <td>Numero Documento: </td>   
                    <td><form:input path="numeroDocumento"  /></td>  
                </tr>    
                <tr>    
                    <td>Nome :</td>    
                    <td><form:input path="nome" /></td>  
                </tr>
                <tr>    
                    <td>Salario :</td>    
                    <td><form:input path="salario" /></td>  
                </tr>
                <tr>    
                    <td colspan="2"><h4>Informações de Login</h4></td>
                </tr>
                <tr>    
                    <td>Usuario :</td>    
                    <td><form:input path="login.username" /></td>  
                </tr>
                <tr>    
                    <td>Senha :</td>    
                    <td><form:input path="login.senha" /></td>  
                </tr>
                <tr>    
                    <td> </td>    
                    <td><input type="submit" value="Cadastrar" /></td>    
                </tr>    
            </table>    
       </form:form>    
