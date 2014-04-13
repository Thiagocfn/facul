<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="conexao.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Extintores</title>
        <style>
            td{
                padding-left: 5px;
                padding-right: 5px;
            }
        </style>
    </head>
    <body>
        <%            String message = null;
            if (request.getParameter("action") != null)
            {
                if (request.getParameter("action").equals("add"))
                {
                    message = "Adicionar";
                } else if (request.getParameter("action").equals("edit"))
                {
                    message = "Editar";
                } else if (request.getParameter("action").equals("delete"))
                {
                    message = "Excluir";
                } else
                {

                }

            }
            if (message != null)
            {
        %>
        <div class="alert"><%=message%></div>
        <%
            }
        %>
        <h1>Extintores</h1>
        <table>
            <thead>
                <tr>
                    <td>id</td>
                    <td>agente</td>
                    <td>fabricante</td>
                    <td>descrição</td>
                    <td>peso</td>
                    <td>validade</td>
                    <td>Ações</td>
                </tr>
            </thead>
            <tbody>
                <%                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery("SELECT e.id,a.nome, e.fabricante,e.descricao, e.peso, DATE_FORMAT(e.validade, '%d/%m/%Y') as validade FROM " + db_prefix + "extintor e JOIN " + db_prefix + "agente a ON (e.agente_id = a.id)");
                    while (rs.next())
                    {


                %>
                <tr>
                    <td><%=rs.getObject("id")%></td>
                    <td><%=rs.getObject("nome")%></td>
                    <td><%=rs.getObject("fabricante")%></td>
                    <td><%=rs.getObject("descricao")%></td>
                    <td><%=rs.getObject("peso")%></td>
                    <td><%=rs.getObject("validade")%></td>
                    <td><a href="?action=edit&id=<%=rs.getObject("id")%>">editar</a> | 
                        <a href="?action=delete&id=<%=rs.getObject("id")%>">excluir</a></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
