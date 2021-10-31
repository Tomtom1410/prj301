/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelController;

import dal.DepartmentDBContext;
import dal.OrderWaitDBContext;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import model.Department;
import model.OrderWait;
import model.Validation;

/**
 *
 * @author Tom
 */
public class BookingController extends HttpServlet {

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
//        DepartmentDBContext ddb = new DepartmentDBContext();
//
//        ArrayList<Department> depts = ddb.getRoomModel();
//        request.setAttribute("depts", depts);
//        String tag = "room";
//        request.setAttribute("tag", tag);
//        request.getRequestDispatcher("view/Hotel/Room.jsp").forward(request, response);
        response.sendRedirect("Room");
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
//        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("customerName");
        String deptName = request.getParameter("roomName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String checkIn = request.getParameter("checkIn");
        String checkOut = request.getParameter("checkOut");
        String noOfRooms = request.getParameter("noOfRoom");

        boolean check = false;
        if (!checkIn.equals("") && !checkOut.equals("")) {
            Date a = Date.valueOf(request.getParameter("checkIn"));
            Date b = Date.valueOf(request.getParameter("checkOut"));
            check = a.after(b);
        }

        if (name.equals("") || email.equals("") || phone.equals("") || checkIn.equals("")
                || checkOut.equals("") || noOfRooms.equals("0")) {
            DepartmentDBContext ddb = new DepartmentDBContext();
            Department d = ddb.getRoomByName(deptName, null).get(0);
            String url_image = d.getUrl().get(0);
            d.getUrl().remove(0);
            request.setAttribute("room", d);
            request.setAttribute("url_image", url_image);
            String tag = "room";
            request.setAttribute("tag", tag);
            boolean flag = false;
            boolean error = true;
            request.setAttribute("error", error);
            request.setAttribute("flag", flag);
            request.getRequestDispatcher("view/Hotel/RoomDetail.jsp").forward(request, response);
        } else if (!Validation.checkName(name) || !Validation.checkEmail(email)
                || !Validation.checkPhone(phone) || check) {
            DepartmentDBContext ddb = new DepartmentDBContext();
            Department d = ddb.getRoomByName(deptName, null).get(0);
            String url_image = d.getUrl().get(0);
            d.getUrl().remove(0);
            request.setAttribute("room", d);
            request.setAttribute("url_image", url_image);
            String tag = "room";
            request.setAttribute("tag", tag);
            boolean error = false;
            request.setAttribute("error", error);
            boolean flag = true;
            request.setAttribute("flag", flag);
            request.getRequestDispatcher("view/Hotel/RoomDetail.jsp").forward(request, response);
        } else {
            Customer customer = new Customer();
            customer.setCustomerName(name);
            customer.setEmail(email);
            customer.setPhone(phone);

            Department d = new Department();
            d.setDeptName(deptName);

            OrderWait o = new OrderWait();
            o.setCheckIn(Date.valueOf(checkIn));
            o.setCheckOut(Date.valueOf(checkOut));
            o.setNoOfRoom(Integer.parseInt(noOfRooms));
            o.setDepartment(d);
            o.setCustomer(customer);
            OrderWaitDBContext odb = new OrderWaitDBContext();

            odb.orderWait(o);
            response.sendRedirect("Room");
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
