/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagementControl;

import dal.BookingDBContext;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BookingDetail;

/**
 *
 * @author Tom
 */
public class BookingHistory extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int pageSize = 40;
        String raw_page = request.getParameter("page");
        if (raw_page == null || raw_page.length() == 0) {
            raw_page = "1";
        }
        int pageIndex = Integer.parseInt(raw_page);
        BookingDBContext bdb = new BookingDBContext();
        ArrayList<BookingDetail> allBookingDetails = bdb.getAllBookingDetails(pageIndex, pageSize, "null");
        request.setAttribute("bookingHistory", allBookingDetails);

        int totalRow = bdb.totalRowBookingDetail("null");
        int totalPage = (totalRow % pageSize == 0) ? totalRow / pageSize : totalRow / pageSize + 1;
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("totalPage", totalPage);
        String url = "BookingHistory?page=";
        request.setAttribute("url", url);

        String tagMenu = "history";
        request.setAttribute("tagMenu", tagMenu);
        request.getRequestDispatcher("../view/Management/BookingHistory.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String value = request.getParameter("sort");
        BookingDBContext bdb = new BookingDBContext();
        if (value.endsWith("all")) {
            response.sendRedirect("BookingHistory");
        } else {
            int pageSize = 40;
            String raw_page = request.getParameter("page");
            if (raw_page == null || raw_page.length() == 0) {
                raw_page = "1";
            }
            int pageIndex = Integer.parseInt(raw_page);
            int totalRow = 0;
            if (value.equals("cancel")) {
                ArrayList<BookingDetail> allBookingDetails = bdb.getAllBookingDetails(pageIndex, pageSize, "true");
                request.setAttribute("bookingHistory", allBookingDetails);
                totalRow = bdb.totalRowBookingDetail("true");
            } else if (value.equals("notCancel")) {
                ArrayList<BookingDetail> allBookingDetails = bdb.getAllBookingDetails(pageIndex, pageSize, "false");
                request.setAttribute("bookingHistory", allBookingDetails);
                totalRow = bdb.totalRowBookingDetail("false");
            }
            
            int totalPage = (totalRow % pageSize == 0) ? totalRow / pageSize : totalRow / pageSize + 1;
            request.setAttribute("pageIndex", pageIndex);
            request.setAttribute("totalPage", totalPage);
            String url = "BookingHistory?page=";
            request.setAttribute("url", url);

            String tagMenu = "history";
            request.setAttribute("tagMenu", tagMenu);
            request.setAttribute("tag", value);
            request.getRequestDispatcher("../view/Management/BookingHistory.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
