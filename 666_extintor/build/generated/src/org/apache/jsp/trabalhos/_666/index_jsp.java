package org.apache.jsp.trabalhos._666;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import com.mysql.jdbc.Driver;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/trabalhos/666/conexao.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    
    Class.forName("com.mysql.jdbc.Driver");
    //Connection conn = DriverManager.getConnection("jdbc:mysql://mysql.divulgando.com.br/divulgando09", "divulgando09", "dsw1401");
    Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.4.4/facul", "root", "webradius");
    String db_prefix = "666_";

      out.write('\n');
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Extintores</title>\n");
      out.write("        <style>\n");
      out.write("            td{\n");
      out.write("                padding-left: 5px;\n");
      out.write("                padding-right: 5px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
            String message = null;
            if (request.getParameter("action") != null)
            {
                out.print("teste");
                if (request.getParameter("action").equals("add"))
                {
                    message = "Adicionar";
                } else if (request.getParameter("action").equals("add"))
                {
                    message = "Editar";
                } else if (request.getParameter("action").equals("add"))
                {
                    message = "Excluir";
                } else
                {

                }

            }
            if (message != null)
            {
        
      out.write("\n");
      out.write("        <div class=\"alert\">");
      out.print(message);
      out.write("</div>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("        <h1>Extintores</h1>\n");
      out.write("        <table>\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <td>id</td>\n");
      out.write("                    <td>agente</td>\n");
      out.write("                    <td>fabricante</td>\n");
      out.write("                    <td>descrição</td>\n");
      out.write("                    <td>peso</td>\n");
      out.write("                    <td>validade</td>\n");
      out.write("                    <td>Ações</td>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery("SELECT e.id,a.nome, e.fabricante,e.descricao, e.peso, DATE_FORMAT(e.validade, '%d/%m/%Y') as validade FROM " + db_prefix + "extintor e JOIN " + db_prefix + "agente a ON (e.agente_id = a.id)");
                    while (rs.next())
                    {


                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print(rs.getObject("id"));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rs.getObject("nome"));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rs.getObject("fabricante"));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rs.getObject("descricao"));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rs.getObject("peso"));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rs.getObject("validade"));
      out.write("</td>\n");
      out.write("                    <td><a href=\"?action=edit&id=");
      out.print(rs.getObject("id"));
      out.write("\">editar</a> | \n");
      out.write("                        <a href=\"?action=delete&id=");
      out.print(rs.getObject("id"));
      out.write("\">excluir</a></td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
