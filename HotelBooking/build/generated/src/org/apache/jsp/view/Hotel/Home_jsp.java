package org.apache.jsp.view.Hotel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>Hotel Del Luna</title>\n");
      out.write("        <!--<script src=\"mycode.js\"></script>-->\n");
      out.write("        <!-- Bootstrap -->\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <!--CSS-->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Dancing+Script\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/CSS/HomeStyle.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/CSS/FooterStyle.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/CSS/HeaderStyle.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("                <!--Slider Content-->\n");
      out.write("                <div class=\"row slide\">\n");
      out.write("                    <div>\n");
      out.write("                        <!--slider start-->\n");
      out.write("                        <div id=\"carousel-example-generic\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("                            <!-- Indicators -->\n");
      out.write("                            <ol class=\"carousel-indicators\">\n");
      out.write("                                <li data-target=\"#carousel-example-generic\" data-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("                                <li data-target=\"#carousel-example-generic\" data-slide-to=\"1\"></li>\n");
      out.write("                                <li data-target=\"#carousel-example-generic\" data-slide-to=\"2\"></li>\n");
      out.write("                            </ol>\n");
      out.write("\n");
      out.write("                            <!-- Wrapper for slides -->\n");
      out.write("                            <div class=\"carousel-inner\">\n");
      out.write("                                <div class=\"item active\">\n");
      out.write("                                    <img src=\"image/slider_1.jpg\" alt=\"#\">\n");
      out.write("                                    <p class=\"descript_slider\">Modern, comfortable rooms</p>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"item\">\n");
      out.write("                                    <img src=\"image/slider_2.jpg\" alt=\"\"/>\n");
      out.write("                                    <p class=\"descript_slider\">Luxury swimming pool</p>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"item\">\n");
      out.write("                                    <img style=\"width: 1519px; height: 600px;\" src=\"image/slider_4.jpg\" alt=\"#\">\n");
      out.write("                                    <p class=\"descript_slider\">Breakfast in the room </p>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <!-- Controls -->\n");
      out.write("                            <a class=\"left carousel-control\" href=\"#carousel-example-generic\" role=\"button\" data-slide=\"prev\">\n");
      out.write("                                <span class=\"glyphicon glyphicon-chevron-left\"></span>\n");
      out.write("                            </a>\n");
      out.write("                            <a class=\"right carousel-control\" href=\"#carousel-example-generic\" role=\"button\" data-slide=\"next\">\n");
      out.write("                                <span class=\"glyphicon glyphicon-chevron-right\"></span>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                        <!--slider end-->\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- main-->\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <form action=\"#\" method=\"\">\n");
      out.write("                        <table class=\"booking\">\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Check-in*:</td>\n");
      out.write("                                <td>Check-out*:</td>\n");
      out.write("                                <td>Choose Room:</td>\n");
      out.write("                                <td>Number of people:</td>\n");
      out.write("                                <td></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><input class=\"infor\" type=\"date\" name=\"checkIn\"></td>\n");
      out.write("                                <td><input class=\"infor\" type=\"date\" name=\"checkOut\"></td>\n");
      out.write("                                <td>\n");
      out.write("                                    <select class=\"infor\" name=\"typeRoom\">\n");
      out.write("                                        <option>Choose room</option>\n");
      out.write("                                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </td>\n");
      out.write("                            <td><input class=\"infor\" type=\"text\" name=\"noOfPeople\" placeholder=\"No of people\"></td>\n");
      out.write("                            <td><input class=\"infor bottom-left\" type=\"submit\" value=\"SEARCH\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"About\">\n");
      out.write("                <h3>Del Luna Hotel</h3>\n");
      out.write("                <h1>WELCOME TO US</h1>\n");
      out.write("                <p class=\"descript\">One of the top factors to make your business and travel trips light and comfortable is choosing a \n");
      out.write("                    high-class hotel to stay during your business trip. Luxury hotels with many high-class services,\n");
      out.write("                    close to the center and the place of business help you relax and enjoy your rest time.</p>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"row room\">\n");
      out.write("                <div class=\"col-md-5 content\">\n");
      out.write("                    <h1>BEAUTIFUL, COOL ROOMS</h1>\n");
      out.write("                    <p class=\"descript2\">Come to Del Luna Hotel, you will experience translation\n");
      out.write("                        High-class spa services, modern fitness center and recreational activities on the sea.\n");
      out.write("                    </p>\n");
      out.write("                    <a style=\"color: #c9ec4d; font-weight: bold; font-size: 23px; text-decoration-line: revert;\" href=\"Room\">Details</a>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"col-md-7 row\">\n");
      out.write("                    <!--line 1-->\n");
      out.write("                    <div class=\"line1\">\n");
      out.write("                        <img class=\"img-responsive img-thumbnail\" src=\"image/PLATINUM DOUBLE ROOM.jpg\" />\n");
      out.write("                    </div>\n");
      out.write("                    <!--line 2-->\n");
      out.write("                    <div class=\"row line2\">\n");
      out.write("                        <div class=\"col-md-6\">\n");
      out.write("                            <img class=\"img-responsive img-thumbnail\" src=\"image/view.jpg\" />\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-6\">\n");
      out.write("                            <img  class=\"img-responsive img-thumbnail\" src=\"image/view1.jpg\" />\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"service\">\n");
      out.write("                <div>\n");
      out.write("                    <h3>Del Luna Hotel</h3>\n");
      out.write("                    <h1>HOT SERVICES</h1>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-3 box\">\n");
      out.write("                        <!-- First dish-->\n");
      out.write("                        <div><img src=\"image/Banh cu cai.jpg\" class=\"img-responsive\" /></div>\n");
      out.write("\n");
      out.write("                        <div>\n");
      out.write("                            <h3>Delicious Meal</h3>\n");
      out.write("                            <p>One of the top factors for you to become light and comfortable</p>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- <div class=\"clearfix\"> </div>-->\n");
      out.write("                        <!--Prevent the next box from running up-->\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"col-md-3 box\">\n");
      out.write("                        <!-- Second dish-->\n");
      out.write("                        <div> <img src=\"image/ho boi.jpg\" class=\"img-responsive\" /></div>\n");
      out.write("\n");
      out.write("                        <div>\n");
      out.write("                            <h3> Luxury Swimming Pool </h3>\n");
      out.write("                            <p>One of the top factors for you to become light and comfortable</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"col-md-3 box\">\n");
      out.write("                        <!-- Third dish-->\n");
      out.write("                        <div> <img src=\"image/LAXURY ROOM.jpg\" class=\"img-responsive\" /></div>\n");
      out.write("\n");
      out.write("                        <div>\n");
      out.write("                            <h3>Modern Room</h3>\n");
      out.write("                            <p>One of the top factors for you to be light and comfortable</p>\n");
      out.write("                        </div>\n");
      out.write("                        <!--<div class=\"clearfix\"> </div>-->\n");
      out.write("                        <!--Prevent the next box from running up-->\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"col-md-3 box\">\n");
      out.write("                        <!-- Fourth dish-->\n");
      out.write("                        <div> <img src=\"image/khu_vui_choi_cho_be.jpg\" class=\"img-responsive\" /></div>\n");
      out.write("                        <div>\n");
      out.write("                            <h3> Children's Playground </h3>\n");
      out.write("                            <p>One of the top factors for you to be light and comfortable</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, false);
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!--contianer end-->\n");
      out.write("            <!--Librabry javascript of Bootstrap-->\n");
      out.write("            <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Bootstrap/js/Jquery.js\"></script>\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Bootstrap/js/bootstrap.min.js\"></script>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${roomType}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("rt");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                        <option>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${rt}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\n");
          out.write("                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
