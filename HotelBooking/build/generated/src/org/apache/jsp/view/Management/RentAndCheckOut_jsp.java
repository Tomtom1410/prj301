package org.apache.jsp.view.Management;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class RentAndCheckOut_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Del Luna Management</title>\n");
      out.write("        <script src=\"mycode.js\"></script>\n");
      out.write("        <!-- Bootstrap -->\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/CSS/ManagementStyle/RentAndCheckOutStyle.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/CSS/ManagementStyle/MenuStyle.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
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
      out.write("                        <h3><span class=\"glyphicon glyphicon-align-justify\"></span> Rent - Check out</h3>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-4\">\n");
      out.write("                        <span class=\" glyphicon glyphicon-search\"></span> <input type=\"text\" placeholder=\"Search room\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"content\">\n");
      out.write("\n");
      out.write("                    <ul>\n");
      out.write("                        <li class=\"active\"><a href=\"#\">Empty room</a></li>\n");
      out.write("                        <li><a href=\"#\">The room is rented</a></li>\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                    <div class=\"typeRoom\">\n");
      out.write("                        <div class=\"first\">\n");
      out.write("                            <p>Single Room</p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-2 Room\">\n");
      out.write("                                <p>Room Number: xxx</p>\n");
      out.write("                                <p>Check-in: DD/MM/YYYY</p>\n");
      out.write("                                <!-- <p>Check-out: DD/MM/YYYY</p> -->\n");
      out.write("                                <p>Status: aa</p>\n");
      out.write("                                <p><input type=\"button\" value=\"Check-out\"></p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-2 Room\">\n");
      out.write("                                <p>Room Number: xxx</p>\n");
      out.write("                                <p>Check-in: DD/MM/YYYY</p>\n");
      out.write("                                <!-- <p>Check-out: DD/MM/YYYY</p> -->\n");
      out.write("                                <p>Status: aa</p>\n");
      out.write("                                <p><input type=\"button\" value=\"Check-out\"></p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-2 Room\">\n");
      out.write("                                <p>Room Number: xxx</p>\n");
      out.write("                                <p>Check-in: DD/MM/YYYY</p>\n");
      out.write("                                <!-- <p>Check-out: DD/MM/YYYY</p> -->\n");
      out.write("                                <p>Status: aa</p>\n");
      out.write("                                <p><input type=\"button\" value=\"Check-out\"></p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-2 Room\">\n");
      out.write("                                <p>Room Number: xxx</p>\n");
      out.write("                                <p>Check-in: DD/MM/YYYY</p>\n");
      out.write("                                <!-- <p>Check-out: DD/MM/YYYY</p> -->\n");
      out.write("                                <p>Status: aa</p>\n");
      out.write("                                <p><input type=\"button\" value=\"Check-out\"></p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-2 Room\">\n");
      out.write("                                <p>Room Number: xxx</p>\n");
      out.write("                                <p>Check-in: DD/MM/YYYY</p>\n");
      out.write("                                <!-- <p>Check-out: DD/MM/YYYY</p> -->\n");
      out.write("                                <p>Status: aa</p>\n");
      out.write("                                <p><input type=\"button\" value=\"Check-out\"></p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-2 Room\">\n");
      out.write("                                <p>Room Number: xxx</p>\n");
      out.write("                                <p>Check-in: DD/MM/YYYY</p>\n");
      out.write("                                <!-- <p>Check-out: DD/MM/YYYY</p> -->\n");
      out.write("                                <p>Status: aa</p>\n");
      out.write("                                <p><input type=\"button\" value=\"Check-out\"></p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"typeRoom\">\n");
      out.write("                        <div class=\"first\">\n");
      out.write("                            <p>Double Room</p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-2 Room\">\n");
      out.write("                                <p>Room Number: xxx</p>\n");
      out.write("                                <p>Check-in: DD/MM/YYYY</p>\n");
      out.write("                                <!-- <p>Check-out: DD/MM/YYYY</p> -->\n");
      out.write("                                <p>Status: aa</p>\n");
      out.write("                                <p><input type=\"button\" value=\"Check-out\"></p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-2 Room\">\n");
      out.write("                                <p>Room Number: xxx</p>\n");
      out.write("                                <p>Check-in: DD/MM/YYYY</p>\n");
      out.write("                                <!-- <p>Check-out: DD/MM/YYYY</p> -->\n");
      out.write("                                <p>Status: aa</p>\n");
      out.write("                                <p><input type=\"button\" value=\"Check-out\"></p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-2 Room\">\n");
      out.write("                                <p>Room Number: xxx</p>\n");
      out.write("                                <p>Check-in: DD/MM/YYYY</p>\n");
      out.write("                                <!-- <p>Check-out: DD/MM/YYYY</p> -->\n");
      out.write("                                <p>Status: aa</p>\n");
      out.write("                                <p><input type=\"button\" value=\"Check-out\"></p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-2 Room\">\n");
      out.write("                                <p>Room Number: xxx</p>\n");
      out.write("                                <p>Check-in: DD/MM/YYYY</p>\n");
      out.write("                                <!-- <p>Check-out: DD/MM/YYYY</p> -->\n");
      out.write("                                <p>Status: aa</p>\n");
      out.write("                                <p><input type=\"button\" value=\"Check-out\"></p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-2 Room\">\n");
      out.write("                                <p>Room Number: xxx</p>\n");
      out.write("                                <p>Check-in: DD/MM/YYYY</p>\n");
      out.write("                                <!-- <p>Check-out: DD/MM/YYYY</p> -->\n");
      out.write("                                <p>Status: aa</p>\n");
      out.write("                                <p><input type=\"button\" value=\"Check-out\"></p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-2 Room\">\n");
      out.write("                                <p>Room Number: xxx</p>\n");
      out.write("                                <p>Check-in: DD/MM/YYYY</p>\n");
      out.write("                                <!-- <p>Check-out: DD/MM/YYYY</p> -->\n");
      out.write("                                <p>Status: aa</p>\n");
      out.write("                                <p><input type=\"button\" value=\"Check-out\"></p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"typeRoom\">\n");
      out.write("                        <div class=\"first\">\n");
      out.write("                            <p>Family Room</p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-2 Room\">\n");
      out.write("                                <p>Room Number: xxx</p>\n");
      out.write("                                <p>Check-in: DD/MM/YYYY</p>\n");
      out.write("                                <!-- <p>Check-out: DD/MM/YYYY</p> -->\n");
      out.write("                                <p>Status: aa</p>\n");
      out.write("                                <p><input type=\"button\" value=\"Check-out\"></p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-2 Room\">\n");
      out.write("                                <p>Room Number: xxx</p>\n");
      out.write("                                <p>Check-in: DD/MM/YYYY</p>\n");
      out.write("                                <p>Status: aa</p>\n");
      out.write("                                <p><input type=\"button\" value=\"Check-out\"></p>>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-2 Room\">\n");
      out.write("                                <p>Room Number: xxx</p>\n");
      out.write("                                <!-- <p>Check-in: DD/MM/YYYY</p> -->\n");
      out.write("                                <p>Status: aa</p>\n");
      out.write("                                <p><input type=\"button\" value=\"Check-out\"></p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-2 Room\">\n");
      out.write("                                <p>Room Number: xxx</p>\n");
      out.write("                                <p>Check-in: DD/MM/YYYY</p>\n");
      out.write("                                <!-- <p>Check-out: DD/MM/YYYY</p> -->\n");
      out.write("                                <p>Status: aa</p>\n");
      out.write("                                <p><input type=\"button\" value=\"Check-out\"></p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-2 Room\">\n");
      out.write("                                <p>Room Number: xxx</p>\n");
      out.write("                                <p>Check-in: DD/MM/YYYY</p>\n");
      out.write("                                <!-- <p>Check-out: DD/MM/YYYY</p> -->\n");
      out.write("                                <p>Status: aa</p>\n");
      out.write("                                <p><input type=\"button\" value=\"Check-out\"></p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-2 Room\">\n");
      out.write("                                <p>Room Number: xxx</p>\n");
      out.write("                                <p>Check-in: DD/MM/YYYY</p>\n");
      out.write("                                <!-- <p>Check-out: DD/MM/YYYY</p> -->\n");
      out.write("                                <p>Status: aa</p>\n");
      out.write("                                <p><input type=\"button\" value=\"Check-out\"></p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
