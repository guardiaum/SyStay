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
                    <td colspan="2"><h4>Dados Pessoais e de Contratação</h4></td>
                </tr>
                <tr>    
                    <td>Numero Documento: </td>   
                    <td><form:input path="numeroDocumento"  /></td>  
                    <td>Nome :</td>    
                    <td><form:input path="nome" /></td>  
                </tr>
                <tr> 
                    <td>Data nascimento :</td>    
                    <td><form:input path="data_nascimento" /></td> 
                    <td>Salario :</td>    
                    <td><form:input path="salario" /></td> 
                </tr>
                <tr>    
                    <td>Cargo :</td>    
                    <td><form:input path="cargo" /></td>  
                    <td>Admissão :</td>    
                    <td><form:input path="dataAdmissao" /></td>
                </tr>
                <tr>    
                    <td colspan="2"><b>Telefone</b></td>
                </tr>
                <tr>
                    <td>DDD</td>
                    <td><form:input path="telefone[0].cod_area" maxlength="2" /></td>
                    <td>Número</td>    
                    <td><form:input path="telefone[0].numero"  maxlength="8"  type="number"/></td> 
                </tr>
                <tr>    
                    <td colspan="2"><b>Celular</b></td>
                </tr>
                <tr>    
                    <td>DDD</td>
                    <td><form:input path="telefone[1].cod_area"  maxlength="2"  type="number"/></td>
                    <td>Número</td>    
                    <td><form:input path="telefone[1].numero" maxlength="8"  type="number"/></td> 
                </tr>  
                <tr>    
                    <td colspan="2"><b>Celular 2</b></td>
                </tr>
                <tr>
                    <td>DDD</td>
                    <td><form:input path="telefone[2].cod_area"  maxlength="2"  type="number"/></td>
                    <td>Número</td>    
                    <td><form:input path="telefone[2].numero" maxlength="8"  type="number"/></td> 
                </tr>   
                <tr>    
                    <td colspan="2"><b>Comercial</b></td>
                </tr>
                <tr> 
                    <td>DDD</td>
                    <td><form:input path="telefone[3].cod_area"  maxlength="2"  type="number"/></td>
                    <td>Número</td>    
                    <td><form:input path="telefone[3].numero" maxlength="8"  type="number"/></td> 
                </tr>
                <tr>    
                    <td colspan="2"><h5>Informações de Endereço</h5></td>
                </tr>
                <tr>    
                    <td>Rua :</td>    
                    <td><form:input path="endereco.rua" maxlength="50"/></td>     
                    <td>Numero :</td>    
                    <td><form:input path="endereco.numero" type="number"/></td>  
                </tr>      
                    <td>Complemento :</td>    
                    <td><form:input path="endereco.complemento" maxlength="25"/></td>   
                    <td>Bairro :</td>    
                    <td><form:input path="endereco.bairro" maxlength="15"/></td>  
                </tr>    
                    <td>Cidade :</td>    
                    <td><form:input path="endereco.cidade" maxlength="25"/></td> 
                    <td>Estado :</td>    
                    <td><form:input path="endereco.estado" maxlength="2"/></td>  
                </tr>    
                    <td>Cep:</td>    
                    <td><form:input path="endereco.cep" type="number" /></td>  
                </tr>
                <tr>    
                    <td colspan="2"><h5>Informações de Login</h5</td>
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
