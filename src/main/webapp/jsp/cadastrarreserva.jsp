<%-- 
    Document   : cadastrarreserva
    Created on : Jun 3, 2017, 3:43:16 PM
    Author     : Chaina
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    
       <h1>Cadastrar Reserva</h1>  
       <form:form method="post" action="salvarreserva">    
            <table>     
                <tr>
                    <td colspan="2"><h4>Dados da Reserva</h4></td>
                </tr>
                <tr>    
                    <td>Data de Entrada: </td>   
                    <td><form:input required="true" path="dataEntrada"  maxlength="20"/></td>  
                </tr>    
                <tr>    
                    <td>Data de Saída :</td>    
                    <td><form:input required="true" path="dataSaida" maxlength="25"/></td>  
                </tr> 
                <tr>    
                    <td>Observação :</td>    
                    <td><form:input path="observacao"  maxlength="15"/></td>  
                </tr>           
                <tr>    
                    <td>Número de Documento do Hóspede :</td>    
                    <td><form:input path="hospede.numeroDocumento" maxlength="15"/></td>  
                </tr>
                <tr>    
                    <td colspan="2"><b>Identificador dos quartos a serem reservados</b></td>
                </tr>
                <tr>    
                    <td><form:input path="quarto[0].id" maxlength="2" /></td>
                    <td><form:input path="quarto[1].id" maxlength="2" /></td>>
                </tr>           
                <tr>    
                    <td>Valor da reserva :</td>    
                    <td><form:input path="total_reserva" maxlength="15"/></td>  
                </tr>            
                <tr>    
                    <td><b>Administrador :</b></td>    
                    <td><form:input path="responsavelGerencia.login.username"   readonly="true" 
                        value='<%= session.getAttribute( "theName" ) %>'  maxlength="15"/></td>  
                </tr>
                <tr>    
                    <td> </td>    
                    <td><input type="submit" value="Cadastrar" /></td>    
                </tr>    
            </table>
       </form:form>                
