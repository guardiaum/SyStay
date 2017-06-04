<%-- 
    Document   : cadastrarquartocomum
    Created on : Jun 3, 2017, 12:40:34 PM
    Author     : araujomarianna
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
       <a href="home">Home</a>
       <h1>Cadastrar Quarto Comum</h1>
       <form:form method="post" action="salvarquartocomum">    
            <table >    
                <tr>    
                    <td colspan="2"><h4>Informacoes do Quarto Comum</h4></td>
                </tr>
                <tr>    
                    <td>Numero do Quarto Comum: </td>                  
                    
                    <td><form:input path="numero"  /></td>  
                    <td>Observacao :</td>    
                    <td><form:input path="observacao" /></td>  
                </tr>
                <tr> 
                    <td>Quantidade de camas :</td>    
                    <td><form:input path="qtd_camas" /></td> 
                    <td>Tipo de camas :</td>    
                    <td><form:input path="tipo_camas" /></td> 
                </tr>
               
                <tr>    
                    <td>Tamanho do quarto :</td>    
                    <td><form:input path="area" /></td>  
                    <td>Tem varanda? :</td>
                    <td>
                        <select>
                        <option value="S">Sim</option>
                        <option value="N">Nao</option>
                        </select>
                    </td>
                </tr>
                <tr>    
                    <td colspan="2"><b>Telefone</b></td>
                </tr>
                <tr>
                    <td>Ramal</td>
                     <td><form:input path="ramal"  /></td> 
                </tr>
                <tr>    
                    <td colspan="2"><b>Valor da diaria</b></td>
                </tr>
                <tr>
                    <td>Preco</td>
                    <td><form:input path="valor_diaria"  /></td> 
                </tr>   
                
                <tr>    
                    <td> </td>    
                    <td><input type="submit" value="Cadastrar" /></td>    
                </tr> 
               
            </table>    
       </form:form>    
