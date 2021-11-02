/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagementControl;

import dal.BookingDBContext;
import dal.InvoiceDBContext;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BookingDetail;
import model.Invoice;

/**
 *
 * @author Tom
 */
public class BookingHistoryDetail extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int pageSize = 20;
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
        BookingDetail b = bdb.getBookingDetail(Integer.parseInt(request.getParameter("orderWaitID")));
        request.setAttribute("bookingDetail", b);
        request.setAttribute("tagMenu", tagMenu);
        
        InvoiceDBContext idb = new InvoiceDBContext();
        Invoice invoice = idb.getInvoiceByCustomer(b.getOrderWait().getCustomer().getCustomerID());
        request.setAttribute("invoice", invoice);
        request.getRequestDispatcher("../view/Management/BookingHistory.jsp").forward(request, response);
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
