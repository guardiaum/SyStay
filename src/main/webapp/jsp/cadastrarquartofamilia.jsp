<%-- 
    Document   : cadastrarquartofamilia
    Created on : Jun 5, 2017, 4:28:32 AM
    Author     : araujomarianna
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
 <a href="home">Home</a>
       <h1>Cadastrar Quarto Familia</h1>
       <form:form method="post" action="salvarquartofamilia">    
            <table >    
                <tr>    
                    <td colspan="2"><h4>Informacoes do Quarto Familia</h4></td>
                </tr>
                <tr>    
                    <td>Numero do Quarto Familia: </td>                  
                    <td><form:input path="numero"  /></td>   
                </tr>
                <tr> 
                    <td>Quantidade de camas adicionais: </td>    
                    <td><form:input path="qtd_camas_adicionais" /></td> 
                </tr>               
                <tr>    
                    <td>Tamanho do quarto :</td>    
                    <td><form:input path="area" /></td>  
                    <tr>
                        <td>Tem varanda?</td>
                         <td>
                             <form:radiobutton path="tem_varanda" value="S" checked="checked"/>Sim
                             <form:radiobutton path="tem_varanda" value="N"/>Nao  
                         </td>
                    </tr>
                </tr>
                <tr>    
                    <td colspan="2">Telefone - Ramal</td>             
                    <td><form:input path="ramal"  /></td> 
                </tr>
                <tr>    
                    <td colspan="2">Valor da diaria</td>
                    <td><form:input path="valor_diaria"  /></td> 
                </tr>
                <tr>
                    <td>Observacao: </td>    
                    <td><form:input path="observacao" /></td> 
                </tr>
<!--                <tr>    
                    <td>Administrador: </td>    
                    <td><form:input path="responsavelGerencia.login.username"   readonly="true" 
                        value='<%= session.getAttribute( "theName" ) %>'  maxlength="15"/></td>  
                </tr>-->
                
                <tr>    
                    <td> </td>    
                    <td><input type="submit" value="Cadastrar" /></td>    
                </tr> 
               
            </table>    
       </form:form>
