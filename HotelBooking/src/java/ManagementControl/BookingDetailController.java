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
        int pageSize = 40;
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

        ArrayList<Department> roomByName = ddb.getRoomByName(o.getDepartment().getDeptName(), false);
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

        OrderWait o = new OrderWait();
        o.setOrderWaitID(Integer.parseInt(request.getParameter("oID")));
        o.setNoOfRoom(Integer.parseInt(request.getParameter("noOfRoom")));
        String[] roomIDs = request.getParameterValues("deptID");

        if (roomIDs == null || roomIDs.length != o.getNoOfRoom()) {
            int pageSize = 40;
            String raw_page = request.getParameter("page");
            if (raw_page == null || raw_page.length() == 0) {
                raw_page = "1";
            }
            int pageIndex = Integer.parseInt(raw_page);

            OrderWaitDBContext odb = new OrderWaitDBContext();
            ArrayList<OrderWait> OrderWait = odb.getInformationOrderWait(pageIndex, pageSize, false);
            for (OrderWait od : OrderWait) {
                if (od.getOrderWaitID() == o.getOrderWaitID()) {
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

            ArrayList<Department> roomByName = ddb.getRoomByName(o.getDepartment().getDeptName(), false);
            request.setAttribute("roomByName", roomByName);
            request.setAttribute("o", o);
            request.setAttribute("orders", OrderWait);
            String tag = "order";
            request.setAttribute("tagMenu", tag);
            boolean flag = false;
            request.setAttribute("flag", flag);
            request.getRequestDispatcher("../view/Management/OrderWait.jsp").forward(request, response);
        } else {
            ArrayList<Department> rooms = new ArrayList<>();
            for (String roomID : roomIDs) {
                Department d = new Department();
                d.setDeptID(Integer.parseInt(roomID));
                rooms.add(d);
            }
            BookingDetail b = new BookingDetail();
            b.setOrderWait(o);
            b.setDepartments(rooms);
            BookingDBContext bdb = new BookingDBContext();
            bdb.insertBooking(b);
//             forward to jsp and notic notification done
            boolean notic = true;
            request.setAttribute("notic", notic);

            int pageSize = 40;
            String raw_page = request.getParameter("page");
            if (raw_page == null || raw_page.length() == 0) {
                raw_page = "1";
            }
            int pageIndex = Integer.parseInt(raw_page);

            OrderWaitDBContext odb = new OrderWaitDBContext();
            ArrayList<OrderWait> OrderWait = odb.getInformationOrderWait(pageIndex, pageSize, false);
            for (OrderWait od : OrderWait) {
                if (od.getOrderWaitID() == o.getOrderWaitID()) {
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

            request.setAttribute("o", o);
            request.setAttribute("orders", OrderWait);
            String tag = "order";
            request.setAttribute("tagMenu", tag);
            request.getRequestDispatcher("../view/Management/OrderWait.jsp").forward(request, response);

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
