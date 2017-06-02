<%-- 
    Document   : viewadmin
    Created on : 01/06/2017, 18:59:20
    Author     : johny
--%>

<%@page import="com.dbproject.systay.beans.Administrador"%>
<%@page import="com.dbproject.systay.beans.Endereco"%>
<%@page import="com.dbproject.systay.beans.Telefone"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SyStay - Administrador</title>
    </head>
    <body>
        <a href="home">Home</a>
        <h1>SyStay</h1>
        <h3>${admin.nome}</h3>
        Número do Documento: ${admin.numeroDocumento}<br/>
        Data de Nascimento: ${admin.data_nascimento}<br/>
        Data de Admissão: ${admin.dataAdmissao}<br/>
        Salário: ${admin.salario}<br/>
        Cargo: ${admin.cargo}<br/>
        <%Administrador adm = (Administrador) request.getAttribute("admin");%>
        <%if(adm.getTelefone()!=null){%>
            <h3>Informações para contato</h3>
            Telefone: (${admin.telefone[0].cod_area}) ${admin.telefone[0].numero}<br/>
            Celular: (${admin.telefone[1].cod_area}) ${admin.telefone[1].numero}<br/>
            Celular 2: (${admin.telefone[2].cod_area}) ${admin.telefone[2].numero}<br/>           
            Comercial: (${admin.telefone[3].cod_area}) ${admin.telefone[3].numero}<br/>
        <%}%>
        
        <%if(adm.getEndereco()!=null){%>
            <h3>Endereço</h3>
            Rua ${admin.endereco.rua}, ${admin.endereco.numero}. ${admin.endereco.complemento}<br/>
            Cidade: ${admin.endereco.cidade}, ${admin.endereco.estado}. CEP: ${admin.endereco.cep}
        <%}%>
        
        <h3>Dados de Login</h3>
        Username: ${admin.login.username}<br/>
        Senha: *****<br/><br/><br/>
        
        <a href="#">Remover</a>
        <a href="#">Atualizar</a>
    </body>
</html>
