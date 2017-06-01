<%-- 
    Document   : cadastrarhospede
    Created on : May 31, 2017, 6:40:23 PM
    Author     : Chaina
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
       <h1>Cadastrar Recepcionista</h1>  
       <form:form method="post" action="save">    
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
                    <td> </td>    
                    <td><input type="submit" value="Save" /></td>    
                </tr>    
            </table>    
       </form:form>    
