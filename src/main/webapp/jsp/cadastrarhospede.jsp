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
                    <td><form:input path="numeroDocumento"  maxlength="20"/></td>  
                </tr>    
                <tr>    
                    <td>Nome :</td>    
                    <td><form:input path="nome" maxlength="25"/></td>  
                </tr>    
                <tr>    
                    <td>Data Nascimento :</td>    
                    <td><form:input path="data_nascimento"/></td>  
                </tr> 
                <tr>    
                    <td>Rua :</td>    
                    <td><form:input path="endereco.rua" maxlength="50"/></td>  
                </tr>    
                    <td>Numero :</td>    
                    <td><form:input path="endereco.numero" type="number"/></td>  
                </tr>      
                    <td>Complemento :</td>    
                    <td><form:input path="endereco.complemento" maxlength="25"/></td>  
                </tr>    
                    <td>Bairro :</td>    
                    <td><form:input path="endereco.bairro" maxlength="15"/></td>  
                </tr>    
                    <td>Cidade :</td>    
                    <td><form:input path="endereco.cidade" maxlength="25"/></td>  
                </tr>    
                    <td>Estado :</td>    
                    <td><form:input path="endereco.estado" maxlength="2"/></td>  
                </tr>    
                    <td>Cep :</td>    
                    <td><form:input path="endereco.cep" maxlength="8" /></td>  
                </tr>
                <tr>    
                    <td>Telefone :</td> 
                    <td>Código</td>
                    <td><form:input path="telefone[0].cod_area" maxlength="2" /></td>
                    <td>Número</td>    
                    <td><form:input path="telefone[0].numero"  maxlength="8"  type="number"/></td> 
                </tr>   
                <tr>    
                    <td>Celular :</td> 
                    <td>Código</td>
                    <td><form:input path="telefone[1].cod_area"  maxlength="2"  type="number"/></td>
                    <td>Número</td>    
                    <td><form:input path="telefone[1].numero" maxlength="8"  type="number"/></td> 
                </tr>   
                <tr>    
                    <td>Celular 2 :</td> 
                    <td>Código</td>
                    <td><form:input path="telefone[2].cod_area"  maxlength="2"  type="number"/></td>
                    <td>Número</td>    
                    <td><form:input path="telefone[2].numero" maxlength="8"  type="number"/></td> 
                </tr>   
                <tr>    
                    <td>Comercial :</td> 
                    <td>Código</td>
                    <td><form:input path="telefone[3].cod_area"  maxlength="2"  type="number"/></td>
                    <td>Número</td>    
                    <td><form:input path="telefone[3].numero" maxlength="8"  type="number"/></td> 
                </tr>               
                <tr>    
                    <td>Observacao :</td>    
                    <td><form:input path="observacao" /></td>  
                </tr>
                <tr>    
                    <td> </td>    
                    <td><input type="submit" value="Save" /></td>    
                </tr>    
            </table>   
       </form:form>    
