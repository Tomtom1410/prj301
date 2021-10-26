package org.apache.jsp.view.Management;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class InformationOfCustomer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>Vietnamese Cuisine</title>\n");
      out.write("        <script src=\"mycode.js\"></script>\n");
      out.write("        <!-- Bootstrap -->\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/CSS/ManagementStyle/InformationOfCustomerStyle.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"row main\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Menu.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"col-md-10 right\">\n");
      out.write("                <div class=\"row title\">\n");
      out.write("                    <div class=\"col-md-4\">\n");
      out.write("                        <h3><span class=\"glyphicon glyphicon-align-justify\"></span>Information Of Customer</h3>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-4 Search\">\n");
      out.write("                        <span class=\" glyphicon glyphicon-search\"></span> <input type=\"text\" placeholder=\"Search\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row information\">\n");
      out.write("                    <div class=\"content col-md-8\">\n");
      out.write("                        <table>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Customer Name</td>\n");
      out.write("                                <td>Phone Number</td>\n");
      out.write("                                <td>No Of Rooms</td>\n");
      out.write("                                <td>Room Type</td>\n");
      out.write("                                <td>Check-in</td>\n");
      out.write("                                <td>Check-out</td>\n");
      out.write("                                <td>Details</td>\n");
      out.write("\n");
      out.write("                            </tr>\n");
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Mr A</td>\n");
      out.write("                                <td>01234568</td>\n");
      out.write("                                <td>4</td>\n");
      out.write("                                <td>xxx</td>\n");
      out.write("                                <td>12/12/2012</td>\n");
      out.write("                                <td>14/12/2012</td>\n");
      out.write("                                <td><a href=\"#\">Details</a></td>\n");
      out.write("\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"detail col-md-4\">\n");
      out.write("                        <form action=\"\">\n");
      out.write("                            <table>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Name:</td>\n");
      out.write("                                    <td class=\"up\"><input type=\"text\" value=\"Mr A\"></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Phone:</td>\n");
      out.write("                                    <td class=\"up\"><input type=\"text\" value=\"01234568\"></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Check-in:</td>\n");
      out.write("                                    <td class=\"up\"><input type=\"date\" value=\"12/12/2012\"></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Check-out:</td>\n");
      out.write("                                    <td class=\"up\"><input type=\"date\" value=\"14/12/2012\"></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Room type:</td>\n");
      out.write("                                    <td class=\"up\"><input type=\"text\" value=\"abc\"></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Choose room: </td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <input type=\"checkbox\"> 101\n");
      out.write("                                        <input type=\"checkbox\"> 102\n");
      out.write("                                        <input type=\"checkbox\"> 103\n");
      out.write("                                        <input type=\"checkbox\"> 104\n");
      out.write("                                        <input type=\"checkbox\"> 105\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                            </table>\n");
      out.write("\n");
      out.write("                            <button type=\"submit\">Save</button>\n");
      out.write("                            <button type=\"submit\">Delete</button>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- contianer end-->\n");
      out.write("\n");
      out.write("        <script src=\"js/Jquery.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
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
