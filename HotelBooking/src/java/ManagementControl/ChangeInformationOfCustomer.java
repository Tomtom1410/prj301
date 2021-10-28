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
        int pageSize = 1;
        String raw_page = request.getParameter("page");
        if (raw_page == null || raw_page.length() == 0) {
            raw_page = "1";
        }
        int pageIndex = Integer.parseInt(raw_page);

        int orderWaitID = Integer.parseInt(request.getParameter("orderWaitID"));
        boolean rented = true;
        OrderWaitDBContext odb = new OrderWaitDBContext();
        ArrayList<OrderWait> OrderWait = odb.getInformationOrderWait(pageIndex, pageSize, rented);
        OrderWait o = new OrderWait();
        for (OrderWait od : OrderWait) {
            if (od.getOrderWaitID() == orderWaitID) {
                o = od;
                break;
            }
        }
        int totalRow = odb.totalRow();
        int totalPage = (totalRow % pageSize == 0) ? totalRow / pageSize : totalRow / pageSize + 1;
        String url = "InformationOfCustomerHadRoom?page=";
        request.setAttribute("url", url);
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("totalPage", totalPage);

        DepartmentDBContext ddb = new DepartmentDBContext();

        ArrayList<Department> roomModel = ddb.getRoomModel();
        request.setAttribute("roomModel", roomModel);

        ArrayList<Department> roomByName = ddb.getRoomByName(o.getDepartment().getDeptName(), null);
        request.setAttribute("roomByName", roomByName);
        request.setAttribute("o", o);
        request.setAttribute("orders", OrderWait);
        String tag = "order";
        request.setAttribute("tagMenu", tag);
        String title = "hadRoom";
        request.setAttribute("title", title);
        response.getWriter().println(url);
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
