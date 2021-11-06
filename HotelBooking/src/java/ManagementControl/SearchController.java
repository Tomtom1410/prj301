/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagementControl;

import dal.BookingDBContext;
import dal.FeedBackDBContext;
import dal.OrderWaitDBContext;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BookingDetail;
import model.Feedback;
import model.OrderWait;

/**
 *
 * @author Tom
 */
public class SearchController extends HttpServlet {

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
        String value = request.getParameter("value");
        String keyName = request.getParameter("keyName");

        value = value.replaceAll("\\s+", " ").trim();
        if (keyName.equals("orderWait")) {
            OrderWaitDBContext odb = new OrderWaitDBContext();
            ArrayList<OrderWait> searchOrder = odb.searchOrder(value);
            if (searchOrder.isEmpty()) {
                response.getWriter().print("Not found customer with name contains " + value);
            } else {
                request.setAttribute("orders", searchOrder);
                String tag = "order";
                request.setAttribute("tagMenu", tag);
                request.setAttribute("value", value);
                String title = "wait";
                request.setAttribute("title", title);
                request.getRequestDispatcher("../view/Management/OrderWait.jsp").forward(request, response);
            }
        } else if (keyName.equals("haveRoom")) {
            BookingDBContext bdb = new BookingDBContext();
            ArrayList<BookingDetail> searchBookingDetails = bdb.searchBookingDetails(value, "0");
            if (searchBookingDetails.isEmpty()) {
                response.getWriter().print("Not found customer with name contains " + value);
            } else {
                String tag = "order";
                request.setAttribute("tagMenu", tag);
                String title = "hadRoom";
                request.setAttribute("title", title);
                request.setAttribute("allBookingNotCancel", searchBookingDetails);
                request.setAttribute("value", value);
                request.getRequestDispatcher("../view/Management/OrderHaveRoom.jsp").forward(request, response);

            }
        } else if (keyName.equals("booking")) {
            BookingDBContext bdb = new BookingDBContext();
            ArrayList<BookingDetail> searchBookingDetails = bdb.searchBookingDetails(value, "all");
            if (searchBookingDetails.isEmpty()) {
                response.getWriter().print("Not found customer with name contains " + value);
            } else {
                String tag = "order";
                request.setAttribute("tagMenu", tag);
                String title = "hadRoom";
                request.setAttribute("title", title);
                request.setAttribute("bookingHistory", searchBookingDetails);
                request.setAttribute("value", value);
                request.getRequestDispatcher("../view/Management/BookingHistory.jsp").forward(request, response);
            }
        } else {
            FeedBackDBContext fdb = new FeedBackDBContext();
            ArrayList<Feedback> searchFeedbacks = fdb.searchFeedbacks(value);
            String tagMenu = "feedback";
            request.setAttribute("tagMenu", tagMenu);
            request.setAttribute("feedbacks", searchFeedbacks);
            request.setAttribute("value", value);

            request.getRequestDispatcher("../view/Management/Feedback.jsp").forward(request, response);
        }
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
