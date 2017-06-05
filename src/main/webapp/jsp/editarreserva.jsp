<%-- 
    Document   : editarreserva
    Created on : Jun 3, 2017, 8:28:36 PM
    Author     : Chaina
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <a href="../home">Home</a><br/><br/>
    <%= session.getAttribute( "theName" ) %><br/>
    <h1>Editar Reserva</h1>
       <form:form method="post" action="/SyStay/editsavereserva">    
            <table >     
                <tr>    
                    <td colspan="2"><h4>Dados da Reserva</h4></td>
                </tr>
                <tr>   
                    <td><form:input type="hidden" path="id"  maxlength="20"/></td>  
                </tr>     
                    <td>Data de Entrada: </td>   
                    <td><form:input path="dataEntrada"  maxlength="20"/></td>  
                </tr>    
                <tr>    
                    <td>Data de Saída :</td>    
                    <td><form:input path="dataSaida" maxlength="25"/></td>  
                </tr> 
                <tr>    
                    <td>Observação :</td>    
                    <td><form:input path="observacao"  maxlength="15"/></td>  
                </tr>
                <tr>    
                    <td> </td>    
                    <td><input type="submit" value="Salvar Alterações" /></td>    
                </tr>    
            </table>   
       </form:form>    
