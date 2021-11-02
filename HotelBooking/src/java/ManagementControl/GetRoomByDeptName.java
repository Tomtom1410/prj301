/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagementControl;

import dal.BookingDBContext;
import dal.DepartmentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BookingDetail;
import model.Department;

/**
 *
 * @author Tom
 */
public class GetRoomByDeptName extends HttpServlet {

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
        String page = request.getParameter("page");
        String deptName = request.getParameter("deptName");
        if (page == null) {
            page = "1";
        }
        int pageSize = 20;
        String raw_page = request.getParameter("page");
        if (raw_page == null || raw_page.length() == 0) {
            raw_page = "1";
        }
        int pageIndex = Integer.parseInt(raw_page);

        int orderWaitID = Integer.parseInt(request.getParameter("orderWaitID"));

        BookingDBContext bdb = new BookingDBContext();
        ArrayList<BookingDetail> allBookingDetails = bdb.getAllBookingDetails(pageIndex, pageSize, "false");
        request.setAttribute("allBookingNotCancel", allBookingDetails);
        BookingDetail b = bdb.getBookingDetail(orderWaitID);
        request.setAttribute("bookingDetail", b);
        b.getOrderWait().getDepartment().setDeptName(deptName);
        int totalRow = bdb.totalRowBookingDetail("false");
        int totalPage = (totalRow % pageSize == 0) ? totalRow / pageSize : totalRow / pageSize + 1;
        String url = "InformationOfCustomerHadRoom?page=";
        request.setAttribute("url", url);
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("totalPage", totalPage);

        DepartmentDBContext ddb = new DepartmentDBContext();

        ArrayList<Department> roomModel = ddb.getRoomModel();
        request.setAttribute("roomModel", roomModel);
        ArrayList<Department> roomByName = ddb.getRoomByName(deptName, null);
        request.setAttribute("roomByName", roomByName);
        String tag = "order";
        request.setAttribute("tagMenu", tag);
        String title = "hadRoom";
        request.setAttribute("title", title);
        request.getRequestDispatcher("../view/Management/OrderHaveRoom.jsp").forward(request, response);
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
