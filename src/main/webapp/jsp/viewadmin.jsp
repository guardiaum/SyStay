<%-- 
    Document   : viewadmin
    Created on : 01/06/2017, 18:59:20
    Author     : johny
--%>

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
        Username: ${admin.login.username}<br/>
        Senha: *****<br/><br/><br/>
        
        <a href="#">Remover</a>
        <a href="#">Atualizar</a>
    </body>
</html>
