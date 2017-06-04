<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%
    String name = request.getParameter( "username" );
   
    if(name!=null){
        session.setAttribute( "theName", name );
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SyStay - Início</title>
    </head>

    <body>
        Bem vindo(a) <%= session.getAttribute( "theName" ) %><br/>
        <h1>SyStay</h1>
 
        <a href="listarhospedes">Hóspede</a><br/>
        <a href="listaradmins">Administradores</a><br/>
        <a href="listarhospedagens">Hospedagem</a><br/>
        <a href="cadastrararecepcionista">Cadastrar Recepcionista</a><br/>
        <a href="cadastrarquartocomum">Cadastrar Quarto</a><br/>
    </body>
</html>
