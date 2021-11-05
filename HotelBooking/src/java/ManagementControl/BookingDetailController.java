/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagementControl;

import dal.BookingDBContext;
import dal.DepartmentDBContext;
import dal.OrderWaitDBContext;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BookingDetail;
import model.Customer;
import model.Department;
import model.OrderWait;

/**
 *
 * @author Tom
 */
public class BookingDetailController extends HttpServlet {

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
        int pageSize = 20;
        String raw_page = request.getParameter("page");
        if (raw_page == null || raw_page.length() == 0) {
            raw_page = "1";
        }
        int pageIndex = Integer.parseInt(raw_page);

        int orderWaitID = Integer.parseInt(request.getParameter("orderWaitID"));
        OrderWaitDBContext odb = new OrderWaitDBContext();
        ArrayList<OrderWait> OrderWait = odb.getInformationOrderWait(pageIndex, pageSize, false);
        OrderWait o = new OrderWait();
        for (OrderWait od : OrderWait) {
            if (od.getOrderWaitID() == orderWaitID) {
                o = od;
                break;
            }
        }
        String title = "wait";
        request.setAttribute("title", title);
        int totalRow = odb.totalRow(true);
        int totalPage = (totalRow % pageSize == 0) ? totalRow / pageSize : totalRow / pageSize + 1;
        String url = "InformationOfCustomerWait?page=";
        request.setAttribute("urlPage", url);
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("totalPage", totalPage);

        DepartmentDBContext ddb = new DepartmentDBContext();
        
        ArrayList<Department> roomByName = ddb.getRoomForOrder(o.getDepartment().getDeptName());
        request.setAttribute("roomByName", roomByName);
        request.setAttribute("o", o);
        request.setAttribute("orders", OrderWait);
        String tag = "order";
        request.setAttribute("tagMenu", tag);
        request.getRequestDispatcher("../view/Management/OrderWait.jsp").forward(request, response);
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

        String buttonValue = request.getParameter("button");
        BookingDBContext bdb = new BookingDBContext();
        if (buttonValue.equals("delete")) {
            OrderWaitDBContext odb = new OrderWaitDBContext();
            odb.deleteOrder(request.getParameter("oID"));
            response.sendRedirect("InformationOfCustomerWait");
        } else {
            OrderWait o = new OrderWait();
            o.setOrderWaitID(Integer.parseInt(request.getParameter("oID")));
            o.setNoOfRoom(Integer.parseInt(request.getParameter("noOfRoom")));
            Customer c = new  Customer();
            c.setCustomerID(Integer.parseInt(request.getParameter("customerID")));
            o.setCustomer(c);
            String[] roomIDs = request.getParameterValues("deptID");
            
            ArrayList<Department> rooms = new ArrayList<>();
            for (String roomID : roomIDs) {
                Department d = new Department();
                d.setDeptID(Integer.parseInt(roomID));
                rooms.add(d);
            }
            BookingDetail b = new BookingDetail();
            b.setOrderWait(o);
            b.setDepartments(rooms);
            bdb.insertBooking(b);
        }
        response.sendRedirect("InformationOfCustomerWait");
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
