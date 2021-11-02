/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagementControl;

import dal.BookingDBContext;
import dal.DepartmentDBContext;
import java.io.IOException;
import java.sql.Date;
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
public class ChangeInformationOfCustomer extends HttpServlet {

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

        BookingDBContext bdb = new BookingDBContext();
        ArrayList<BookingDetail> allBookingDetails = bdb.getAllBookingDetails(pageIndex, pageSize, "false");
        request.setAttribute("allBookingNotCancel", allBookingDetails);
        BookingDetail b = bdb.getBookingDetail(orderWaitID);
        request.setAttribute("bookingDetail", b);

        int totalRow = bdb.totalRowBookingDetail("false");
        int totalPage = (totalRow % pageSize == 0) ? totalRow / pageSize : totalRow / pageSize + 1;
        String url = "InformationOfCustomerHadRoom?page=";
        request.setAttribute("url", url);
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("totalPage", totalPage);

        DepartmentDBContext ddb = new DepartmentDBContext();

        ArrayList<Department> roomModel = ddb.getRoomModel();
        request.setAttribute("roomModel", roomModel);
        ArrayList<Department> roomByName = ddb.getRoomByName(b.getOrderWait().getDepartment().getDeptName(), null);
        request.setAttribute("roomByName", roomByName);
        String tag = "order";
        request.setAttribute("tagMenu", tag);
        String title = "hadRoom";
        request.setAttribute("title", title);
        request.getRequestDispatcher("../view/Management/OrderHaveRoom.jsp").forward(request, response);

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
            OrderWait o = new OrderWait();
            o.setOrderWaitID(Integer.parseInt(request.getParameter("oID")));
            Customer c = new Customer();
            c.setCustomerID(Integer.parseInt(request.getParameter("customerID")));
            o.setCustomer(c);
            bdb.cancelBookingDetail(o);

        } else {
            //get orderWait
            OrderWait o = new OrderWait();
            o.setOrderWaitID(Integer.parseInt(request.getParameter("oID")));
            o.setNoOfRoom(Integer.parseInt(request.getParameter("noOfRoom")));
            o.setCheckIn(Date.valueOf(request.getParameter("checkIn")));
            o.setCheckOut(Date.valueOf(request.getParameter("checkOut")));
            Department d = new Department();
            d.setDeptName(request.getParameter("deptName"));
//            String deptName = (String)request.getAttribute("deptName");
//            d.setDeptName(deptName);
            o.setDepartment(d);
            // get customer
            Customer c = new Customer();
            c.setCustomerID(Integer.parseInt(request.getParameter("customerID")));
            c.setAddress(request.getParameter("address"));
            c.setCustomerName(request.getParameter("customerName"));
            c.setPhone(request.getParameter("phone"));
            c.setEmail(request.getParameter("email"));
            o.setCustomer(c);

            String[] roomIDs = request.getParameterValues("deptID");

            if (roomIDs == null || roomIDs.length != o.getNoOfRoom()) {
                int pageSize = 20;
                String raw_page = request.getParameter("page");
                if (raw_page == null || raw_page.length() == 0) {
                    raw_page = "1";
                }
                int pageIndex = Integer.parseInt(raw_page);

                ArrayList<BookingDetail> allBookingDetails = bdb.getAllBookingDetails(pageIndex, pageSize, "false");
                request.setAttribute("allBookingNotCancel", allBookingDetails);
                BookingDetail b = bdb.getBookingDetail(o.getOrderWaitID());
                request.setAttribute("bookingDetail", b);

                int totalRow = bdb.totalRowBookingDetail("false");
                int totalPage = (totalRow % pageSize == 0) ? totalRow / pageSize : totalRow / pageSize + 1;
                String url = "InformationOfCustomerHadRoom?page=";
                request.setAttribute("url", url);
                request.setAttribute("pageIndex", pageIndex);
                request.setAttribute("totalPage", totalPage);

                DepartmentDBContext ddb = new DepartmentDBContext();
                ArrayList<Department> roomModel = ddb.getRoomModel();
                request.setAttribute("roomModel", roomModel);
                ArrayList<Department> roomByName = ddb.getRoomByName(b.getOrderWait().getDepartment().getDeptName(), null);
                request.setAttribute("roomByName", roomByName);
                // set tag and tagMenu
                String tag = "order";
                request.setAttribute("tagMenu", tag);
                boolean flag = false;
                request.setAttribute("flag", flag);
                String title = "hadRoom";
                request.setAttribute("title", title);
                response.getWriter().println(url);
                request.getRequestDispatcher("../view/Management/OrderHaveRoom.jsp").forward(request, response);
            } else {
                // update bookingDetail
                ArrayList<Department> rooms = new ArrayList<>();
                for (String roomID : roomIDs) {
                    Department r = new Department();
                    r.setDeptID(Integer.parseInt(roomID));
                    rooms.add(r);
                }

                BookingDetail b = new BookingDetail();
                b.setDepartments(rooms);
                b.setOrderWait(o);
                bdb.updateInforBooking(b);
            }
        }

        // forward jsp and notification done
        if (request.getParameter("oID").length() == 0) {
            response.sendRedirect("InformationOfCustomerHadRoom");
        } else {
            int pageSize = 20;
            String raw_page = request.getParameter("page");
            if (raw_page == null || raw_page.length() == 0) {
                raw_page = "1";
            }
            int pageIndex = Integer.parseInt(raw_page);

            ArrayList<BookingDetail> allBookingDetails = bdb.getAllBookingDetails(pageIndex, pageSize, "false");
            request.setAttribute("allBookingNotCancel", allBookingDetails);

            OrderWait o = new OrderWait();
            o.setOrderWaitID(Integer.parseInt(request.getParameter("oID")));
            BookingDetail bo = bdb.getBookingDetail(o.getOrderWaitID());
            request.setAttribute("bookingDetail", bo);

            int totalRow = bdb.totalRowBookingDetail("false");
            int totalPage = (totalRow % pageSize == 0) ? totalRow / pageSize : totalRow / pageSize + 1;
            String url = "InformationOfCustomerHadRoom?page=";
            request.setAttribute("url", url);
            request.setAttribute("pageIndex", pageIndex);
            request.setAttribute("totalPage", totalPage);

            DepartmentDBContext ddb = new DepartmentDBContext();

            ArrayList<Department> roomModel = ddb.getRoomModel();
            request.setAttribute("roomModel", roomModel);
            ArrayList<Department> roomByName = ddb.getRoomByName(bo.getOrderWait().getDepartment().getDeptName(), null);
            request.setAttribute("roomByName", roomByName);
            String tag = "order";
            request.setAttribute("tagMenu", tag);
            boolean notic = true;
            request.setAttribute("notic", notic);
            String title = "hadRoom";
            request.setAttribute("title", title);
            request.getRequestDispatcher("../view/Management/OrderHaveRoom.jsp").forward(request, response);
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
