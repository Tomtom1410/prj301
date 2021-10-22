/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.DepartmentDBContext;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Department;
import model.Validation;

/**
 *
 * @author Tom
 */
public class RoomDetailController extends HttpServlet {

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
        String name = request.getParameter("deptName");

        DepartmentDBContext ddb = new DepartmentDBContext();
        Department d = ddb.getRoomByName(name);
        String url_image = d.getUrl().get(0);
        d.getUrl().remove(0);
        request.setAttribute("room", d);
        request.setAttribute("url_image", url_image);
        String tag = "room";
        request.setAttribute("tag", tag);
        boolean flag = true;
        request.setAttribute("flag", flag);
        boolean error = true;
        request.setAttribute("error", error);
        request.getRequestDispatcher("view/Hotel/RoomDetail.jsp").forward(request, response);
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
            Department d = ddb.getRoomByName(deptName);
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
            Department d = ddb.getRoomByName(deptName);
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
        }else{
            
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
