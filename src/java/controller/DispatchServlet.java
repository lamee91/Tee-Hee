/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name="DispatchServlet", urlPatterns={"/DispatchServlet"})
public class DispatchServlet extends HttpServlet {
   private final String HOME_PAGE = "home.jsp";
   private final String LOGIN_CONTROLLER = "LoginServlet";
   private final String REGISTRATION_CONTROLLER = "RegistrationServlet";
   
   private final String DELETE_CONTROLLER = "DeleteServlet";
   private final String UPDATE_CONTROLLER = "UpdateServlet";
   private final String CREATE_CONTROLLER = "CreateAccountServlet";
   private final String ADD_ITEM_CONTROLLER = "AddItemServlet";
   private final String VIEW_CART_CONTROLLER = "viewCart.jsp";
   private final String REMOVE_ITEM_CONTROLLER = "RemoveItemServlet";
//   private final String NULL_CONTROLLER = "NullServlet";
   /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = HOME_PAGE;
        //which button did user click?
        String button = request.getParameter("btAction");
        try  {
           if (button == null) {
//               url = NULL_CONTROLLER;
           } else if (button.equals("Login")) {
               url = LOGIN_CONTROLLER;
           } else if (button.equals("Registration")) {
               url = REGISTRATION_CONTROLLER;             
           } else if (button.equals("Delete")) {
               url = DELETE_CONTROLLER;
           } else if (button.equals("Update")) {
               url = UPDATE_CONTROLLER;
           } else if (button.equals("Create New Account")) {
               url = CREATE_CONTROLLER;
           } else if (button.equals("Add Book to Your Cart")){
               url = ADD_ITEM_CONTROLLER;
           } else if (button.equals("View Your Cart")){
               url = VIEW_CART_CONTROLLER;
           } else if (button.equals("Remove Selected Items")){
               url = REMOVE_ITEM_CONTROLLER;
           }
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
