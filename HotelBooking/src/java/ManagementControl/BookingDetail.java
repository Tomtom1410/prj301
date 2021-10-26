/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagementControl;

import dal.DepartmentDBContext;
import dal.OrderWaitDBContext;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Department;
import model.OrderWait;

/**
 *
 * @author Tom
 */
public class BookingDetail extends HttpServlet {

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
        int orderWaitID = Integer.parseInt(request.getParameter("orderWaitID"));
        
        

        OrderWaitDBContext odb = new OrderWaitDBContext();
        ArrayList<OrderWait> OrderWait = odb.getInformationOrderWait();
        OrderWait o = new OrderWait();
        for (OrderWait od : OrderWait) {
            if (od.getOrderWaitID() == orderWaitID) {
                o = od;
                break;
            }
        }
        
        DepartmentDBContext ddb = new DepartmentDBContext();
        
        ArrayList<Department> roomByName = ddb.getRoomByName(o.getDepartment().getDeptName());
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
//        processRequest(request, response);
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
