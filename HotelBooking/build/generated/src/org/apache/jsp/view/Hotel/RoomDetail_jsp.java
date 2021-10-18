package org.apache.jsp.view.Hotel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class RoomDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>Hotel Del Luna</title>\n");
      out.write("        <script src=\"mycode.js\"></script>\n");
      out.write("        <!-- Bootstrap && CSS-->\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/CSS/RoomDetailStyle.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/CSS/FooterStyle.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("            <div class=\"Banner\">\n");
      out.write("                <p>Room Detail</p>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Slider Content-->\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-7 col-sm-12 slide\">\n");
      out.write("                    <!--B?t ??u slider-->\n");
      out.write("                    <div id=\"carousel-example-generic\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("                        <!-- Indicators -->\n");
      out.write("                        <ol class=\"carousel-indicators\">\n");
      out.write("                            <li data-target=\"#carousel-example-generic\" data-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("                            <li data-target=\"#carousel-example-generic\" data-slide-to=\"1\"></li>\n");
      out.write("                            <li data-target=\"#carousel-example-generic\" data-slide-to=\"2\"></li>\n");
      out.write("                        </ol>\n");
      out.write("\n");
      out.write("                        <!-- Wrapper for slides -->\n");
      out.write("                        <div class=\"carousel-inner\">\n");
      out.write("                            <div class=\"item active\">\n");
      out.write("                                <img src=\"images/slider_1.jpg\" alt=\"#\">\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"item\">\n");
      out.write("                                <img src=\"images/slider_2.jpg\" alt=\"#\">\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"item\">\n");
      out.write("                                <img src=\"images/slider_4.jpg\" alt=\"#\">\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!-- Controls -->\n");
      out.write("                        <a class=\"left carousel-control\" href=\"#carousel-example-generic\" role=\"button\" data-slide=\"prev\">\n");
      out.write("                            <span class=\"glyphicon glyphicon-chevron-left\"></span>\n");
      out.write("                        </a>\n");
      out.write("                        <a class=\"right carousel-control\" href=\"#carousel-example-generic\" role=\"button\" data-slide=\"next\">\n");
      out.write("                            <span class=\"glyphicon glyphicon-chevron-right\"></span>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"content\">\n");
      out.write("                        <h1>ROOM NAME</h1>\n");
      out.write("                        <p class=\"Price\">Price: 50$ / Day</p>\n");
      out.write("                        <p>Khách s?n Del Luna là m?t nhà ngh? khách s?n ???c thành l?p vào n?m 20xx v?i 60 phòng có kích c? khách nhau phù h?p v?i nhi?u nhu c?u c?a khách hàng. H? th?ng thi?t b? hi?n ??i, ?i?u hòa, tivi, bàn gh? ???c làm t? g?, sóng wifi và\n");
      out.write("                            các các d?ch v? ??a ?ón khách tham quan các ?i?m du l?ch. ???c thi?t k? và trang trí theo phong cách Mona r?t sang tr?ng và quý phái. Các trang thi?t b? và phòng ?c c?a nhà ngh? ? khách s?n r?t ti?n nghi và hi?n ??i nh?m mang l?i\n");
      out.write("                            s? hài lòng và tho?i mái cho khách hàng trong su?t th?i gian l?u trú t?i phòng khách s?n.\n");
      out.write("\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!--slider end-->\n");
      out.write("\n");
      out.write("                <div class=\"col-md-3 col-sm-12 booking\">\n");
      out.write("                    <form action=\"\">\n");
      out.write("                        <table>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Booking now</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><input class=\"in\" type=\"text\" placeholder=\"Name\"></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><input class=\"in\" type=\"text\" placeholder=\"Phone Number\"></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><input class=\"in\" type=\"text\" placeholder=\"E-mail:\"></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <select class=\"in\" name=\"\" id=\"\">\n");
      out.write("                                        <option value=\"\">Number of rooms</option>\n");
      out.write("                                        <option value=\"\">1</option>\n");
      out.write("                                        <option value=\"\">2</option>\n");
      out.write("                                        <option value=\"\">3</option>\n");
      out.write("                                        <option value=\"\">4</option>\n");
      out.write("                                    </select>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Check-in:</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <td><input class=\"in\" type=\"date\" placeholder=\"E-mail:\"></td>\n");
      out.write("                            </tr>\n");
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Check-out:</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <td><input class=\"in\" type=\"date\" placeholder=\"E-mail:\"></td>\n");
      out.write("                            </tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td><button type=\"submit\">Booking</button></td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, false);
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!-- contianer end-->\n");
      out.write("\n");
      out.write("        <!--javascript of Bootstrap-->\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Bootstrap/js/Jquery.js\"></script>\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
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
