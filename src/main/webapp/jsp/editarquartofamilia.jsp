<%-- 
    Document   : editarquartofamilia
    Created on : Jun 5, 2017, 4:33:38 AM
    Author     : araujomarianna
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1>Editar Quarto Comum</h1>  
<form:form method="POST" action="/SyStay/editsavequartofamilia">    
    <table >      
        <tr>    
            <td colspan="2"><h4>Informacoes do Quarto Familia</h4></td>
        </tr>
        
        <tr>                 
            <td><form:hidden path="id"  /></td>    
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
        </tr>
        <tr>
            <td>Tem varanda?</td>
                <td>
                    <form:radiobutton path="tem_varanda" value="S"/>Sim
                    <form:radiobutton path="tem_varanda" value="N"/>Nao  
                </td>
        </tr>
        <tr>    
            <td colspan="2"><b>Telefone - Ramal</b></td>
            <td><form:input path="ramal"  /></td> 
        </tr>
        <tr>    
            <td colspan="2"><b>Valor da diaria</b></td>
             <td><form:input path="valor_diaria"  /></td> 
        </tr>
        <tr>
            <td>Observacao: </td>    
                <td><form:input path="observacao" /></td>
        </tr>

        <tr>    
            <td> </td>    
            <td><input type="submit" value="Salvar Alterações" /></td>    
        </tr>    
    </table>   
</form:form> 
