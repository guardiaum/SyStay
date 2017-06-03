<%-- 
    Document   : editarhospede
    Created on : Jun 2, 2017, 3:30:03 PM
    Author     : Chaina
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
       <h1>Editar Hóspede</h1>  
       <form:form method="post" action="/SyStay/editsave">    
            <table >      
                <tr>    
                    <td colspan="2"><h4>Dados Pessoais</h4></td>
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
                    <td colspan="2"><h5>Informações de Endereço</h5></td>
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
                    <td>Observação :</td>    
                    <td><form:input path="observacao" /></td>  
                </tr>
                <tr>    
                    <td> </td>    
                    <td><input type="submit" value="Salvar Alterações" /></td>    
                </tr>    
            </table>   
       </form:form>    
