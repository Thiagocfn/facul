<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="conexao.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Extintores - Editar</title>
        <style>
            td{
                padding-left: 5px;
                padding-right: 5px;
            }
        </style>
    </head>
    <body>

        <h1>Extintores - Editar</h1>

        <%  
        int id =-1;
        if (request.getParameter("id")!=null)
        {
            try
            {
                id = Integer.parseInt(request.getParameter("id"));
            }
            catch (NumberFormatException ex)
            {
                
            }
        }
        Statement stm = conn.createStatement();
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
